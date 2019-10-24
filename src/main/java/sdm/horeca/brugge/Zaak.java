package sdm.horeca.brugge;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.rest.core.config.Projection;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "json_featuretype",
    "naam",
    "formule",
    "straat",
    "huisNr",
    "postcode",
    "deelgemeente",
    "gemeente",
    "branche",
    "check_dat",
    "winkelgebied",
    "subcentrum",
    "strnmEnHuisnr",
    "aangemaakt op",
    "json_ogc_wkt_crs",
    "json_geometry"
})
public class Zaak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;
    @JsonProperty("json_featuretype")
    private String jsonFeaturetype;
    @JsonProperty("Naam")
    private String naam;
    @JsonProperty("Formule")
    private String formule;
    @JsonProperty("Straat")
    private String straat;
    @JsonProperty("HuisNr")
    private Integer huisNr;
    @JsonProperty("HuisNrToev")
    private String huisNrToev;
    @JsonProperty("Postcode")
    private String postcode;
    @JsonProperty("Deelgemeente")
    private String deelgemeente;
    @JsonProperty("Gemeente")
    private String gemeente;
    @JsonProperty("Branche")
    private String branche;
    @JsonProperty("Check_dat")
    private String checkDat;
    @JsonProperty("Winkelgebied")
    private String winkelgebied;
    @JsonProperty("Subcentrum")
    private String subcentrum;
    @JsonProperty("StrnmEnHuisnr")
    private String strnmEnHuisnr;
    @JsonProperty("Aangemaakt op")
    private String aangemaaktOp;
    @JsonProperty("json_ogc_wkt_crs")
    private String jsonOgcWktCrs;
    @OneToOne(cascade = {CascadeType.ALL})
    @JsonProperty("json_geometry")
    private JsonGeometry jsonGeometry;
    @JsonProperty("rating")
    private int rating;

    /**
     * No args constructor for use in serialization
     *
     */
    public Zaak() {
    }

    /**
     *
     * @param gemeente
     * @param checkDat
     * @param jsonOgcWktCrs
     * @param winkelgebied
     * @param jsonFeaturetype
     * @param postcode
     * @param branche
     * @param straat
     * @param formule
     * @param jsonGeometry
     * @param huisNr
     * @param subcentrum
     * @param naam
     * @param aangemaaktOp
     * @param strnmEnHuisnr
     * @param deelgemeente
     */
    public Zaak(String jsonFeaturetype, String naam, String formule, String straat, Integer huisNr, String huisNrToev,
            String postcode, String deelgemeente, String gemeente, String branche, String checkDat, String winkelgebied,
            String subcentrum, String strnmEnHuisnr, String aangemaaktOp, String jsonOgcWktCrs,
            JsonGeometry jsonGeometry) {
        this.jsonFeaturetype = jsonFeaturetype;
        this.naam = naam;
        this.formule = formule;
        this.straat = straat;
        this.huisNr = huisNr;
        this.huisNrToev = huisNrToev;
        this.postcode = postcode;
        this.deelgemeente = deelgemeente;
        this.gemeente = gemeente;
        this.branche = branche;
        this.checkDat = checkDat;
        this.winkelgebied = winkelgebied;
        this.subcentrum = subcentrum;
        this.strnmEnHuisnr = strnmEnHuisnr;
        this.aangemaaktOp = aangemaaktOp;
        this.jsonOgcWktCrs = jsonOgcWktCrs;
        this.jsonGeometry = jsonGeometry;
    }

    public Zaak(long id, String jsonFeaturetype, String naam, String formule, String straat, Integer huisNr, String huisNrToev, String postcode, String deelgemeente, String gemeente, String branche, String checkDat, String winkelgebied, String subcentrum, String strnmEnHuisnr, String aangemaaktOp, String jsonOgcWktCrs, JsonGeometry jsonGeometry, int rating) {
        this.id = id;
        this.jsonFeaturetype = jsonFeaturetype;
        this.naam = naam;
        this.formule = formule;
        this.straat = straat;
        this.huisNr = huisNr;
        this.huisNrToev = huisNrToev;
        this.postcode = postcode;
        this.deelgemeente = deelgemeente;
        this.gemeente = gemeente;
        this.branche = branche;
        this.checkDat = checkDat;
        this.winkelgebied = winkelgebied;
        this.subcentrum = subcentrum;
        this.strnmEnHuisnr = strnmEnHuisnr;
        this.aangemaaktOp = aangemaaktOp;
        this.jsonOgcWktCrs = jsonOgcWktCrs;
        this.jsonGeometry = jsonGeometry;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @JsonProperty("json_featuretype")
    public String getJsonFeaturetype() {
        return jsonFeaturetype;
    }

    @JsonProperty("json_featuretype")
    public void setJsonFeaturetype(String jsonFeaturetype) {
        this.jsonFeaturetype = jsonFeaturetype;
    }

    @JsonProperty("Naam")
    public String getNaam() {
        return naam;
    }

    @JsonProperty("Naam")
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @JsonProperty("Formule")
    public String getFormule() {
        return formule;
    }

    @JsonProperty("Formule")
    public void setFormule(String formule) {
        this.formule = formule;
    }

    @JsonProperty("Straat")
    public String getStraat() {
        return straat;
    }

    @JsonProperty("Straat")
    public void setStraat(String straat) {
        this.straat = straat;
    }

    @JsonProperty("HuisNr")
    public Integer getHuisNr() {
        return huisNr;
    }

    @JsonProperty("HuisNr")
    public void setHuisNr(Integer huisNr) {
        this.huisNr = huisNr;
    }

    @JsonProperty("Postcode")
    public String getPostcode() {
        return postcode;
    }

    @JsonProperty("Postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @JsonProperty("Deelgemeente")
    public String getDeelgemeente() {
        return deelgemeente;
    }

    @JsonProperty("Deelgemeente")
    public void setDeelgemeente(String deelgemeente) {
        this.deelgemeente = deelgemeente;
    }

    @JsonProperty("Gemeente")
    public String getGemeente() {
        return gemeente;
    }

    @JsonProperty("Gemeente")
    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    @JsonProperty("Branche")
    public String getBranche() {
        return branche;
    }

    @JsonProperty("Branche")
    public void setBranche(String branche) {
        this.branche = branche;
    }

    @JsonProperty("Check_dat")
    public String getCheckDat() {
        return checkDat;
    }

    @JsonProperty("Check_dat")
    public void setCheckDat(String checkDat) {
        this.checkDat = checkDat;
    }

    @JsonProperty("Winkelgebied")
    public String getWinkelgebied() {
        return winkelgebied;
    }

    @JsonProperty("Winkelgebied")
    public void setWinkelgebied(String winkelgebied) {
        this.winkelgebied = winkelgebied;
    }

    @JsonProperty("Subcentrum")
    public String getSubcentrum() {
        return subcentrum;
    }

    @JsonProperty("Subcentrum")
    public void setSubcentrum(String subcentrum) {
        this.subcentrum = subcentrum;
    }

    @JsonProperty("StrnmEnHuisnr")
    public String getStrnmEnHuisnr() {
        return strnmEnHuisnr;
    }

    @JsonProperty("StrnmEnHuisnr")
    public void setStrnmEnHuisnr(String strnmEnHuisnr) {
        this.strnmEnHuisnr = strnmEnHuisnr;
    }

    @JsonProperty("Aangemaakt op")
    public String getAangemaaktOp() {
        return aangemaaktOp;
    }

    @JsonProperty("Aangemaakt op")
    public void setAangemaaktOp(String aangemaaktOp) {
        this.aangemaaktOp = aangemaaktOp;
    }

    @JsonProperty("json_ogc_wkt_crs")
    public String getJsonOgcWktCrs() {
        return jsonOgcWktCrs;
    }

    @JsonProperty("json_ogc_wkt_crs")
    public void setJsonOgcWktCrs(String jsonOgcWktCrs) {
        this.jsonOgcWktCrs = jsonOgcWktCrs;
    }

    @JsonProperty("json_geometry")
    public JsonGeometry getJsonGeometry() {
        return jsonGeometry;
    }

    @JsonProperty("json_geometry")
    public void setJsonGeometry(JsonGeometry jsonGeometry) {
        this.jsonGeometry = jsonGeometry;
    }

    public String getHuisNrToev() {
        return huisNrToev;
    }

    public void setHuisNrToev(String huisNrToev) {
        this.huisNrToev = huisNrToev;
    }

}

@Projection(
        name = "view",
        types = {Zaak.class})
interface ZaakFiltered {

    String getNaam();

    String getFormule();
}
