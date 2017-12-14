package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("countries", countryRepository.findAll());
		return "countryList";
	}
}
