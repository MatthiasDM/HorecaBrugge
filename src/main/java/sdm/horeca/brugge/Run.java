package sdm.horeca.brugge;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class Run {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
        
        	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {

			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setRepositoryDetectionStrategy(
						RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
			}
		};
	}
        
        
    @Bean
    CommandLineRunner init(ZaakRepository zaakRepository) {

        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Zaak>> typeReference = new TypeReference<List<Zaak>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/horeca.json");
            List<Zaak> zaken = mapper.readValue(inputStream, typeReference);
            for (Zaak zaak : zaken) {
                zaakRepository.save(zaak);
            }
            zaakRepository.findAll().forEach(System.out::println);
        };

    }

}
