package be.gerdaypetgen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 * 
 * @author sacha
 */
public class LogFile {
    
    private String fileName;
    
    /**
     * 
     * @param fileName  The filename for the logs
     */
    public LogFile(String fileName){
        this.fileName = fileName;
    }
    
    
    /**
     * Get the fileName of the logs
     * @return  The fileName
     */
    public String getFileName(){
        return this.fileName;
    }
    
    /**
     * Write a line into the logs
     * 
     * @param   line    The line
     */
    public void writeLog(String line){
        
        try{
            
            FileWriter fw = new FileWriter(fileName, true);
            
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
                
                LocalDateTime now = LocalDateTime.now();  
               
                bw.write("[" + dtf.format(now) + "] " +  line);
                bw.newLine();
            } 
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Get the number of rows into the logs
     * 
     * @return     The number of rows 
     */
    public int getNumberOfRows(){
        
        Path file = Paths.get(fileName);

        int lines = 0;
        
        try {
            
            lines = ( int ) Files.lines(file).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

      return lines;
        
    }
    
    /**
     * Get all the lines from the logs    
     * 
     * @return      A vector containing the lines
     */
    public Vector<String> listRows(){
        
        Vector<String> listRows = new Vector<>();
        
        File file = new File(fileName);
        
        try{
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                listRows.add(sc.nextLine());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        return listRows;
        
    }
    
    
    /**
     * Get the lines from the log containing the target
     * 
     * @param target    The string to check the line with
     * 
     * @return          A vector containing the lines
     */
    public Vector listRows(String target){
        
        Vector<String> listRows = new Vector<>();
        
        File file = new File(fileName);
        
        try{
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                
                if(line.contains(target)){
                    
                    listRows.add(line);
                    
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        return listRows;
    }
    
    
}
