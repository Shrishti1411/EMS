package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.border.*;

public class login extends JFrame implements ActionListener {

    JTextField input_username;
    JPasswordField input_password;

    JButton Login,Back;


    login(){ //this is constructor

        ImageIcon user_i1 = new ImageIcon(ClassLoader.getSystemResource("icons/usericon.jpg"));
        Image user_i2 = user_i1.getImage().getScaledInstance(350,300,Image.SCALE_SMOOTH);
        ImageIcon user_i3 = new ImageIcon(user_i2);
        JLabel user_img = new JLabel(user_i3);
        user_img.setBounds(325,20,150,170);
        add(user_img);


        JLabel username = new JLabel("Username");
        username.setBounds(250,230,100,30);
        username.setFont(new Font("Verdana", Font.BOLD, 14));
        //username.setFont(new Font("Serif", Font.BOLD, 14));
        add(username);

        input_username = new JTextField();
        input_username.setBounds(360,230,150,30);
        input_username.setBorder(new CompoundBorder(
                new LineBorder(Color.DARK_GRAY, 2, true), // Rounded border
                new EmptyBorder(5, 5, 5, 5) // Padding inside
        ));
        add(input_username);



        JLabel password = new JLabel("Password");
        password.setBounds(250,280,100,30);
        password.setFont(new Font("Verdana",Font.BOLD,14));
        add(password);

        input_password = new JPasswordField();
        input_password.setBounds(360,280,150,30);
        input_password.setBorder(new CompoundBorder(
                new LineBorder(Color.DARK_GRAY, 1, true), // Rounded border
                new EmptyBorder(5, 5, 5, 5) // Padding inside
        ));
        add(input_password);


        Login = new JButton("LOGIN");
        Login.setFont(new Font("Times New Roman",Font.BOLD,15));
        Login.setBounds(200,340,150,40);
        Login.setBackground(new Color(124, 23, 169));
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Back = new JButton("BACK");
        Back.setFont(new Font("Times New Roman",Font.BOLD,15));
        Back.setBounds(450,340,150,40);
        Back.setBackground(new Color(124,23,169));
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);


        ImageIcon bg_i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image bg_i2 = bg_i1.getImage().getScaledInstance(800,500,Image.SCALE_SMOOTH);
        ImageIcon bg_i3 = new ImageIcon(bg_i2);
        JLabel bg_img = new JLabel(bg_i3);
        bg_img.setBounds(0,0,800,500);
        add(bg_img);



        setLayout(null);
        setVisible(true);
        setSize(800,500);
        setLocation(300,150);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Login){

            try {
                String username = input_username.getText();
                char[] passwordChars = input_password.getPassword(); // ✅ Secure way
                String password = new String(passwordChars);

                connectDB connect = new connectDB();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                java.util.Arrays.fill(passwordChars, ' '); // Overwrite password in memory


                if(resultSet.next()){
                    setVisible(false);
                    new MainClass();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username or Password");
                }

            }catch ( Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == Back) {
            System.exit(90);
        }


    }

    public static void main(String [] arg){

        new login(); //the constructor fun is called here
    }
}
