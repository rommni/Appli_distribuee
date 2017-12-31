package tse.app_distri.projet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "", path = "region")
public interface RegionRepository extends PagingAndSortingRepository<Region, Long>{
	Page<Region> findAll(Pageable pageable);
	Region findByRegionId(long regionId);
}
