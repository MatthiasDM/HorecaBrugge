package sdm.horeca.brugge;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RunTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ZaakRepository zaakRepository;

    @Test
    void contextLoads() {
        assertThat(zaakRepository).isNotNull();
    }

    @Test
    public void shouldAddZaakToDatabase() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Zaak zaak = new Zaak("a", "a", "a", "a", 1, "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", new JsonGeometry("", Arrays.asList(new Double[]{0.0, 0.0})));
        this.mockMvc.perform(post("zaken", zaak)).andDo(print());
        
    }

    @Test
    public void shouldReturnZakenFromDatabase() throws Exception {
     //           this.mockMvc.perform(get("/zaaks")).andDo(print()).andExpect(status().isOk())

        this.mockMvc.perform(get("/zaaks")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Horeca")));
    }

}
