package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employeeDTO")
public class EmployeeDTOController {
	
	@Autowired
	private EmployeeDTORepository employeeDTORepository;

	@GetMapping(path="/list")
	public @ResponseBody Iterable<EmployeeDTO> getAllEmployee(){
		return employeeDTORepository.findAll();
	}
}
