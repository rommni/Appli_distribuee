package tse.app_distri.projet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path="/search")
	public @ResponseBody Iterable<EmployeeDTO> getAllEmployee(@RequestParam String firstName){
		ModelMapper modelMapper = new ModelMapper();
		ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		for (Iterator<Employee> i = employeeRepository.findByFirstName(firstName).iterator(); i.hasNext();) {
		    Employee employee = i.next();
		    EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		    employees.add(employeeDto);
		}
		
		return employees;
	}
}
