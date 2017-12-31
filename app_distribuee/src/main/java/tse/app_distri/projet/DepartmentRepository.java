package tse.app_distri.projet;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RepositoryRestResource(collectionResourceRel = "", path = "department")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

	Page<Department> findAll(Pageable pageable);
	Department findByDepartmentId(long departmentId);

	
}