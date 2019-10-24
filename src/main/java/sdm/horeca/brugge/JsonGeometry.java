
package sdm.horeca.brugge;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "coordinates"
})
public class JsonGeometry {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    @ElementCollection(targetClass=Double.class)
    private List<Double> coordinates = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public JsonGeometry() {
    }

    /**
     * 
     * @param type
     * @param coordinates
     */
    public JsonGeometry(String type, List<Double> coordinates) {
        super();
        this.type = type;
        this.coordinates = coordinates;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("coordinates")
    public List<Double> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
    

}
