/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbshomework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Map;

/**
 *
 * @author Steve
 */
public class StephenKrugerWordCounterTest {
    
    public StephenKrugerWordCounterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        
        
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        
    }
    
    @Before
    public void setUp() 
    {
        System.out.println("user.dir: " + System.getProperty("user.dir"));
        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter("JUnitTempTestFile.txt"))) {
                out.write("This is a few SaMple words!! \n");
                out.write("SecOND?.. !!line+ SaMple() .,-?*!=+#:;'_$%words!! ");
            }
        } catch (IOException e) {e.printStackTrace();}
    }
    
    @After
    public void tearDown() 
    {
        try{
 
    		File file = new File("JUnitTempTestFile.txt");
                System.out.println("user.dir: " + System.getProperty("user.dir"));
 
    		if(file.delete()){
    			//System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
    	}catch(Exception e){e.printStackTrace();}
    }

    /**
     * Test of WordCount method, of class StephenKrugerWordCounter.
     */
    @Test
    public void testWordCount() throws IOException {
        System.out.println("WordCount");
        
        StephenKrugerWordCounter instance = new StephenKrugerWordCounter("JUnitTempTestFile.txt");
        Map result = instance.WordCount();
        String expResultString = "{is=1, second=1, words=2, a=1, line=1, this=1, sample=2, few=1}";
        //System.out.println(result);
        assertEquals(""+result, expResultString);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of PrintWordCount method, of class StephenKrugerWordCounter.
     */
    @Test
    public void testPrintWordCount() throws IOException {
        System.out.println("PrintWordCount");
        StephenKrugerWordCounter instance = new StephenKrugerWordCounter("JUnitTempTestFile.txt");
        instance.WordCount();
        instance.PrintWordCount();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
