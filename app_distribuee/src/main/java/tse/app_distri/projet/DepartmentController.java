package tse.app_distri.projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	private LocationRepository locationRepository;
	
	@GetMapping(path="/list")
	public String list(Model model){
		model.addAttribute("departments", departmentRepository.findAll());
		return "department/list";
	}
	
	@GetMapping(path="/update")
	public String update(Model model, @RequestParam long id){
		model.addAttribute("department", departmentRepository.findByDepartmentId(id));
		model.addAttribute("location", locationRepository.findByLocationId(departmentRepository.findByDepartmentId(id).getLocation().getLocationId()));
		return "department/update";
	}
	
	@PostMapping(path="/update")
	public String updateAction(@RequestParam long id,  Department newDepartment ){
		Department department = departmentRepository.findByDepartmentId(id);
		department.setDepartmentName(newDepartment.getDepartmentName());
		departmentRepository.save(department);
		return "redirect:list";
	}
}
