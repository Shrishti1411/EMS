package employee.management.system;


import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    splash(){  //this is the constructor

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Front.png")); //creating a var of type image and loading it in var
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT); //get image from i1 and scale it then store it in i2
        ImageIcon i3 = new ImageIcon(i2);//back store the scaled image as icon

        //now to add the image on the frame

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);


        //now to make the frame stay for few seconds use try and catch after the frame starts or is visible


        setSize(1170,650);
        setLocation(100,50);//for alignment of the frame
        setLayout(null);
        setVisible(true);//for the frame to be visible



        //here
        try {
            Thread.sleep(2000); //for how long the frame should be open
            setVisible(false); //and what actions should be performed after the time
            new login();


        } catch(Exception e){
            e.printStackTrace();

        }


    }
    public static void main( String [] arg ){

        new splash();
    }
}
