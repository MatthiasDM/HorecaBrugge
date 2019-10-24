package sdm.horeca.brugge;

import sdm.horeca.brugge.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource()
public interface ZaakRepository extends PagingAndSortingRepository<Zaak, Long>{

    public Zaak findByNaam(String name);

    public List<Zaak> findBy();

    @RestResource(exported = false)
    void deleteById(Long aLong);
}

