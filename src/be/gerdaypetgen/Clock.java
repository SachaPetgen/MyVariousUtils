/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.gerdaypetgen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author sacha
 */
public class Clock extends Thread{
    
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    
    private LocalDateTime now;
    
    private JLabel jLabel;
    
    public Clock(JLabel jlabel){
        this.jLabel = jlabel;
    }
    
    @Override
    public void run() {
        
        while(true){
            now = LocalDateTime.now();
            jLabel.setText(dtf.format(now));

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public String getDateString(){
        return dtf.format(now);
    }
}
