package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/region")
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("regions", regionRepository.findAll());
		return "region/list";
	}
	
	@GetMapping(path="/update")
	public String update(Model model, @RequestParam long id){
		model.addAttribute("region", regionRepository.findByRegionId(id));
		return "region/update";
	}
	
	@PostMapping(path="/update")
	public String updateAction(@RequestParam long id,  Region newRegion ){
		Region region = regionRepository.findByRegionId(id);
		region.setRegionName(newRegion.getRegionName());
		regionRepository.save(region);
		return "redirect:list";
	}
}
