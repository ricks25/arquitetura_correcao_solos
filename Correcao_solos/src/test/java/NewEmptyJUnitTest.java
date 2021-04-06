/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.correcao_solos.EquilibrioCorrecaoCTC;
import com.mycompany.correcao_solos.Nutrientes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rick-
 */
public class NewEmptyJUnitTest {
    
    public static final int ARGILOSO = 1;
    public static final int TEXT_MEDIA = 2;
    
    @Test
    public void testaValoresIdeaisArgiloso() {
        Nutrientes nutrientes = new Nutrientes(ARGILOSO);
        
        assertEquals(nutrientes.getFosforo(), 9.0);
        assertEquals(nutrientes.getPotassio(), 0.35);
        assertEquals(nutrientes.getCalcio(), 6.0);
        assertEquals(nutrientes.getMagnesio(), 1.5);
        assertEquals(nutrientes.getEnxofre(), 9.0);
        assertEquals(nutrientes.getAluminio(), 0.0);
        assertEquals(nutrientes.getAluminioHidrogenio(), 0.0);
    }
    
    @Test
    public void testaValoresIdeaisTexturaMedia() {
        Nutrientes nutrientes = new Nutrientes(TEXT_MEDIA);
        
        assertEquals(nutrientes.getFosforo(), 12.0);
        assertEquals(nutrientes.getPotassio(), 0.25);
        assertEquals(nutrientes.getCalcio(), 4.0);
        assertEquals(nutrientes.getMagnesio(), 1.0);
        assertEquals(nutrientes.getEnxofre(), 6.0);
        assertEquals(nutrientes.getAluminio(), 0.0);
        assertEquals(nutrientes.getAluminioHidrogenio(), 0.0);
    }
    
    @Test
    public void testaCalculaSCmol() {
        assertEquals(7.54, new EquilibrioCorrecaoCTC().calculaSCmol(0.15, 5.76, 1.63));
    }
    
     @Test
    public void testaCalculaCTCCmol() {
        assertEquals(12.89, new EquilibrioCorrecaoCTC().calculaCTCCmol(0.15, 5.76, 1.63, 5.35));
    }

    @Test
    public void testaVPercentual() {
        assertEquals(58.494957331264544, new EquilibrioCorrecaoCTC().calculaVPercentual(
                    new EquilibrioCorrecaoCTC().calculaSCmol(0.15, 5.76, 1.63), new EquilibrioCorrecaoCTC().calculaCTCCmol(0.15, 5.76, 1.63, 5.35)
                )
        );
    }

    @Test
    public void testaMOPercentual() {
        assertEquals(3.07, new EquilibrioCorrecaoCTC().calculaMOPercentual(30.7));
    }
    
    @Test
    public void testaCalculaCarbono() {
        assertEquals(17.848837209302324, new EquilibrioCorrecaoCTC().calculaCarbono(
                    new EquilibrioCorrecaoCTC().calculaMOPercentual(30.7)
                )
        );
    }
}
