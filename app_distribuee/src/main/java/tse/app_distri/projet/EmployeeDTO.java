package tse.app_distri.projet;

import static org.testng.Assert.assertEquals;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class EmployeeDTO {

	private String firstName;
	private String lastName;
	private String departmentName;
	public EmployeeDTO() {
		mapExplicitly();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	static void mapExplicitly() {
	    Employee employee = new Employee();
	    ModelMapper modelMapper = new ModelMapper();
	    modelMapper.addMappings(new PropertyMap<Employee, EmployeeDTO>() {
	      @Override
	      protected void configure() {
	        map().setDepartmentName(source.getDepartment().getDepartmentName());
	        map().setFirstName(source.getFirstName());
	        map().setLastName(source.getLastName());
	      }
	    });

	    EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
	    assertEmployeeEqual(employee, employeeDTO);
	  }
	static void assertEmployeeEqual(Employee employee, EmployeeDTO employeeDTO) {
	    assertEquals(employeeDTO.getFirstName(), employee.getFirstName());
	    assertEquals(employeeDTO.getLastName(), employee.getLastName());
	    assertEquals(employeeDTO.getDepartmentName(), employee.getDepartment().getDepartmentName());
	}
}
