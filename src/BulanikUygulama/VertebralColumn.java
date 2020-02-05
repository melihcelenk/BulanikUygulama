/*
Melih Çelenk
info@melihcelenk.com
 */
package BulanikUygulama;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;


public class VertebralColumn {
    private double pelvic_incidence;
    private double pelvic_tilt;
    private double lumbar_lordosis_angle;
    private double sacral_slope;
    private double pelvic_radius;
    private double degree_spondylolisthesis;
    private double result;
    private double calculatedResult;
        
    private FIS fis;
    
    public VertebralColumn(double pelvic_incidence, double pelvic_tilt, double lumbar_lordosis_angle, double sacral_slope, double pelvic_radius, double degree_spondylolisthesis, double result) throws URISyntaxException{
        this.pelvic_incidence = pelvic_incidence;
        this.pelvic_tilt = pelvic_tilt;
        this.lumbar_lordosis_angle = lumbar_lordosis_angle;
        this.sacral_slope = sacral_slope;
        this.pelvic_radius = pelvic_radius;
        this.degree_spondylolisthesis = degree_spondylolisthesis;
        this.result = result;
        
        File dosya = new File(getClass().getResource("model.fcl").toURI()); 
        fis = FIS.load(dosya.getPath(),true);
        fis.setVariable("pelvic_incidence", pelvic_incidence);
        fis.setVariable("pelvic_tilt", pelvic_tilt);
        fis.setVariable("lumbar_lordosis_angle", lumbar_lordosis_angle);
        fis.setVariable("sacral_slope", sacral_slope);
        fis.setVariable("pelvic_radius", pelvic_radius);
        fis.setVariable("degree_spondylolisthesis", degree_spondylolisthesis);
        
        fis.evaluate();
        calculatedResult = fis.getVariable("ctd_result").getValue();
    }
    public FIS getModel(){
        return fis;
    }
    
    @Override
    public String toString(){
        /*
        String output = "Pelvic Incidence: " + pelvic_incidence + 
                "\nPelvic Tilt: " + pelvic_tilt + 
                "\nLumbar Lordosis Angle:" + lumbar_lordosis_angle + 
                "\nSacral Slope:" + sacral_slope +
                "\nPelvic Radius:" + pelvic_radius +
                "\nDegree Spondylolisthesis:" + degree_spondylolisthesis +
                "\nResult:" + (int)result +
                "\nCalculated Result: " + getCalculatedResult();
        */
        String output = pelvic_incidence + " " + 
                 pelvic_tilt + " " + 
                 lumbar_lordosis_angle + " " + 
                 sacral_slope + " " + 
                 pelvic_radius + " " + 
                 degree_spondylolisthesis + " \t" + 
                 (int)result + " \t" +
                 getCalculatedResult();
        return output;
    }
    public int getCalculatedResult(){
        return (int)Math.round(calculatedResult);
    }
    public double getCalculatedResultAbsolute(){
        return calculatedResult;
    }
}
