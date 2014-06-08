/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbshomework;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen Kruger
 */
public class StephenKrugerWordCounter {
    private BufferedReader source;
    private boolean isFileOpen = false;  // if true then last character read was newline
                             // so read in the next line
    private String nextLine;
    private String[] wordArray;
    private Map<String,Integer> countMap;
    
    /**
     * This class has only one constructor for this class, it requires as its argument either a path 
     * filename, or a filename of a file in the working directory. It opens the file and prepares it
     * so WordCount() can run. WordCount() returns a count of all lower case words (not numerics)
     * in a Map object that can be printed.
     * @param programFile
     * @throws IOException
     */
    public StephenKrugerWordCounter(String programFile) throws IOException
    {
        //Debugging
        //System.out.println("Source file: "+programFile);
    	//System.out.println("user.dir: " + System.getProperty("user.dir"));
        //end Debugging
        countMap = new HashMap<>();
        source = new BufferedReader(new FileReader(programFile));
        isFileOpen = true;
    }
    
    /**
     * WordCount() returns a count of all lower case words (not numerics)
     * in a Map object that can be printed.
     */
    public Map WordCount()
    {
        countMap = new HashMap<>();
        try {
            while(isFileOpen)
            {
                ReadLine();
                //System.out.println(Arrays.toString(wordArray)); 
                if(isFileOpen)
                {
                    for(String word : wordArray)
                    {
                        Integer count = countMap.get(word.toLowerCase());
                        if(!"".equals(word))
                        {
                            countMap.put(word.toLowerCase(), count == null ? 1 : count + 1);
                        }
                    }
                    //System.out.println(countMap);
                }
            }
            //System.out.println(countMap);
            return countMap;
        } catch (IOException ex) {
            Logger.getLogger(StephenKrugerWordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * PrintWordCount() Prints the map generated by WordCount() in a more readable form.
     * It requires WordCount() to be run first
     *
     */
    public void PrintWordCount()
    {
    System.out.println("The file had the following words, case insensitive:");    
    for (Map.Entry<String, Integer> entry : countMap.entrySet()) 
    {
        System.out.println(entry.getKey() + ": " + entry.getValue() ) ;  
    }
    }
    
    private void close() {
        try {
            source.close();
            isFileOpen = false;
        } catch (Exception e) {}
    }
    
    private void ReadLine()throws IOException 
    {
        nextLine = null;    
        nextLine = source.readLine();
        //Debugging
        if ((nextLine != null) && (!"".equals(nextLine)) ) {
            //Debugging
            //System.out.println("READLINE:   "+nextLine);
            //This tokenizes the stirng, as string tokenizer is not recommended in SE 6 and beyond
            wordArray = nextLine.split("[ .,-?*!=+#:;'_$%)(\"]+");
            //Need to escape " and add it to delimiters...                          
            }
            
            if (nextLine == null) {  // hit eof or some I/O problem
            close();
            wordArray = "".split("[ ]+");
            }
    }
}