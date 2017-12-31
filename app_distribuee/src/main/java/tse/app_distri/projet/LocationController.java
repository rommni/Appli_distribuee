package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/location")
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("location", locationRepository.findAll());
		return "location/list";
	}
	
	@GetMapping(path="/update")
	public String update(Model model, @RequestParam long id){
		model.addAttribute("location", locationRepository.findByLocationId(id));
		return "location/update";
	}
	
	@PostMapping(path="/update")
	public String updateAction(@RequestParam long id,  Location newLocation ){
		Location location = locationRepository.findByLocationId(id);
		location.setCity(newLocation.getCity());
		location.setPostalCode(newLocation.getPostalCode());
		location.setStreetAddress(newLocation.getStreetAddress());
		location.setStateProvince(newLocation.getStateProvince());
		locationRepository.save(location);
		return "redirect:list";
	}
}
