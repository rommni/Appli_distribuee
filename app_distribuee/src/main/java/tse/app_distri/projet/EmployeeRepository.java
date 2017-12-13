package tse.app_distri.projet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
	List<Employee> findByFirstName(String firstName);
}
