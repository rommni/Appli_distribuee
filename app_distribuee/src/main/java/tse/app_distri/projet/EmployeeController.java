package tse.app_distri.projet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.springframework.ui.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
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
	
	@GetMapping(path="/salaries")
	public String plotSalaries(Model model){
		Iterable<Employee> employees = employeeRepository.findAll();
		Iterator<Employee> it = employees.iterator();
		ArrayList<BigDecimal> salaries = new ArrayList<BigDecimal>();
		ArrayList<String> nameData = new ArrayList<String>();
		while(it.hasNext()){
			Employee e = it.next();
			salaries.add(e.getSalary());
			nameData.add(e.getFirstName()+" "+e.getLastName());
		}
		model.addAttribute("salaries",salaries);
		model.addAttribute("nameData", nameData);
		return "employee/salaries";
		
	}
	
	@GetMapping(path="/decile")
	public String plotSalariesByDecile(Model model){
		Iterable<Employee> employees = employeeRepository.findAll();
		Iterator<Employee> it = employees.iterator();
		ArrayList<BigDecimal> salaries = new ArrayList<BigDecimal>();
		while(it.hasNext()){
			Employee e =it.next();
			salaries.add(e.getSalary());
		}
		Collections.sort(salaries);
		model.addAttribute("salaries",salaries);
		return "employee/salariesDecile";
	}
}
