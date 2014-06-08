/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbshomework;
import java.util.Map;

/**
 *
 * @author Steve
 */
public class CBSHomeWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try 
        {
        StephenKrugerWordCounter WC1 = new StephenKrugerWordCounter(args[0]);
        Map results = WC1.WordCount();
        System.out.println(results);
        } catch (Exception e) {System.out.print(e);}
    }
    
}

