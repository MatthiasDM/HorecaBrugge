/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdm.horeca.brugge;

import sdm.horeca.brugge.*;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author mdm20
 */
@Projection(
        name = "filtered",
        types = {Zaak.class})
public interface ZaakExcerpt1 {

    String getNaam();

    String getBranche();

    String getWinkelgebied();

    JsonGeometry getJsonGeometry();

    String getRating();

}
