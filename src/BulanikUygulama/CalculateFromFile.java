/*
Melih Çelenk
info@melihcelenk.com
 */
package BulanikUygulama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class CalculateFromFile {
    private double mape; // MAPE ile hata orani
    /**
     * @param args the command line arguments
     */
    public CalculateFromFile(String location) throws FileNotFoundException, IOException, URISyntaxException {
        
        mape = -1; 
        
        try {
            File file = new File(location);    
            FileReader fr = new FileReader(file);  
            BufferedReader br = new BufferedReader(fr);  
            StringBuffer sb = new StringBuffer();    
            String line;
            List<VertebralColumn> VCRecords = new ArrayList<VertebralColumn>();
            
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                double pelvic_incidence = Double.parseDouble(details[0]);
                double pelvic_tilt = Double.parseDouble(details[1]);
                double lumbar_lordosis_angle = Double.parseDouble(details[2]);
                double sacral_slope = Double.parseDouble(details[3]);
                double pelvic_radius = Double.parseDouble(details[4]);
                double degree_spondylolisthesis = Double.parseDouble(details[5]);
                double result = Double.parseDouble(details[6]);
                
                VertebralColumn sm = new VertebralColumn(pelvic_incidence,pelvic_tilt,lumbar_lordosis_angle,sacral_slope,pelvic_radius,degree_spondylolisthesis,result);
              
                System.out.println(sm+"\n");
                mape +=  Math.abs( result - sm.getCalculatedResult() ) ;
                VCRecords.add(sm);
                
  
            }
             mape =  mape * 100.0 / VCRecords.size();
            System.out.println("MAPE yöntemi ile hata yüzdesi: " + mape);
            fr.close();    

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    

}
