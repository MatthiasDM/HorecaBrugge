package sdm.horeca.brugge;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel="a", path="a")
//public interface ZaakRepository extends CrudRepository<Zaak, Long>{}
//    //@PreAuthorize("hasRole('ROLE_USER')")
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource()
public interface ZaakRepository extends PagingAndSortingRepository<Zaak, Long>{

    public Zaak findByNaam(String name);

    public List<Zaak> findBy();

    @RestResource(exported = false)
    void deleteById(Long aLong);
}
