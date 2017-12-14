package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("countries", countryRepository.findAll());
		return "country/list";
	}
	
	@GetMapping(path="/update")
	public String update(Model model, @RequestParam String id){
		model.addAttribute("country", countryRepository.findByCountryId(id));
		return "country/update";
	}
	
	@PostMapping(path="/update")
	public String updateAction(@RequestParam String id,  Country newCountry ){
		Country country = countryRepository.findByCountryId(id);
		country.setCountryName(newCountry.getCountryName());
		countryRepository.save(country);
		return "redirect:list";
	}
}
