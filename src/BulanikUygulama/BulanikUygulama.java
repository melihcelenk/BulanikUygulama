/*
Melih Çelenk
info@melihcelenk.com
 */
package BulanikUygulama;

import java.io.IOException;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;


public class BulanikUygulama {

    /**
     * @param args the command line arguments
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
        
       
        CalculateFromFile dosyadanHesapla = new CalculateFromFile("dosya.txt");
        
        VertebralColumn cm = new VertebralColumn(63.03,22.55,39.61,40.48,98.67,-0.25,1);
        JFuzzyChart.get().chart(cm.getModel());
        
    }
    
}
