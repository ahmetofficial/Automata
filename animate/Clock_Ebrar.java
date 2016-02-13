package animate;

import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Date;

public class Clock_Ebrar implements Animator {
    final JPanel pan = new JPanel();
    final JLabel lab = new JLabel();
    Clock_Ebrar() {
        Thread t=new Thread(new renkDegistir());
        t.start();
        lab.setHorizontalAlignment(0);
        pan.setPreferredSize(new Dimension(100, 100));
        pan.setSize(400, 400);
        lab.setFont(new Font("Gill Sans", Font.BOLD, 45));
        doTick(); //initial call fills the label
    }
    public class renkDegistir implements Runnable {
        
        public void run() {
            for(int i=255; i>50; i--) {
                for(int j=155; j>50; j--){
                    for(int k=0; k<255; k++){
                        lab.setForeground(new Color(i, j ,k));
                        pan.setBackground(new Color(k, j, i));
                        try{
                            Thread.sleep(10);
                        }
                        catch(Exception ex){
                            
                        }
                    }
                }
            }
        }
    }
    
    public int doTick() {
        lab.setText(new Date().toString());
        return 1000;
    }
    public Container container() {
        return lab;
    }
    public String description() {
        return "A simple clock that changes color.";
    }
    public String author() {
        return "A.Ebrar Yalcin";
    }
}
