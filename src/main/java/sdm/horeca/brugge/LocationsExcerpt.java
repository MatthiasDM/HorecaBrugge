/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdm.horeca.brugge;

import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author mdm20
 */
@Projection(
        name = "locations",
        types = {Zaak.class})
public interface LocationsExcerpt {
    String getNaam();    

    String getStrnmEnHuisnr();
    
    String getHuisNrToev();
   
    String getPostcode();
    
    String getGemeente();
    
    JsonGeometry getJsonGeometry();

    String getRating();

}
