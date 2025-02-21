package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {

    MainClass(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,400);
        add(img);

        JLabel heading = new JLabel("WELCOME ADMIN!");
        heading.setBounds(80,40,300,20);
        heading.setFont(new Font("Times New Roman",Font.BOLD,25));
        img.add(heading);

        JButton add_button = new JButton("Add Employee");
        add_button.setBounds(100,100,200,40);
        add_button.setFont(new Font("Times New Roman",Font.BOLD,15));
        add_button.setBackground(new Color(124,23,169));
        add_button.setForeground(Color.white);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddEmployee();

            }
        });
        img.add(add_button);

        JButton view_button = new JButton("View Employee");
        view_button.setBounds(100,150,200,40);
        view_button.setFont(new Font("Times New Roman",Font.BOLD,15));
        view_button.setBackground(new Color(124,23,169));
        view_button.setForeground(Color.white);
        view_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee();

            }
        });
        img.add(view_button);

        JButton remove_button = new JButton("Remove Employee");
        remove_button.setBounds(100,200,200,40);
        remove_button.setFont(new Font("Times New Roman",Font.BOLD,15));
        remove_button.setBackground(new Color(124,23,169));
        remove_button.setForeground(Color.WHITE);
        remove_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();

            }
        });
        img.add(remove_button);

        JButton logout_button = new JButton("Logout");
        logout_button.setBounds(100,250,200,40);
        logout_button.setFont(new Font("Times New Roman",Font.BOLD,15));
        logout_button.setBackground(new Color(124,23,169));
        logout_button.setForeground(Color.WHITE);
        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new login();
            }
        } );
        img.add(logout_button);







        setSize(600,400);
        setLocation(450,200);
        setVisible(true);
        setLayout(null);
    }
    public static void main(String [] arg){
        new MainClass();
    }
}
