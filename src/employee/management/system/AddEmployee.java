package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    //for generating random employee id
    Random ran = new Random();
    int num = ran.nextInt(999999);

    JLabel employee_id;

    JTextField t_name,t_f_name,t_salary,t_address,t_mobile_no,t_aadhar_no,t_email;

    JDateChooser t_dob;

    JComboBox box_edu,box_role;

    JButton Add,Back;
    JRadioButton male,female,other;
    ButtonGroup genderGroup;

    AddEmployee(){

        //employee id


        JLabel emp_id = new JLabel("Employee ID");
        emp_id.setBounds(135,150,150,30);
        emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
        emp_id.setForeground(Color.BLACK);
        add(emp_id);

        employee_id = new JLabel(""+num);
        employee_id.setBounds(155,180,150,30);
        employee_id.setFont(new Font("Bernard MT Condensed",Font.PLAIN,20));
        employee_id.setForeground(Color.RED);
        add(employee_id);



        //Name
        JLabel name  = new JLabel("Name");
        name.setBounds(310,60,100,20);
        name.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(name);

        t_name = new JTextField();
        t_name.setBounds(480, 60, 200, 25);
        t_name.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_name);
        t_name.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }

            }
        });


        //Fathers name

        JLabel f_name = new JLabel("Father's Name");
        f_name.setBounds(310,100,150,20);
        f_name.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(f_name);

        t_f_name = new JTextField();
        t_f_name.setBounds(480, 100, 200, 25);
        t_f_name.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_f_name);
        t_f_name.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ') {
                    e.consume();
                }

            }
        });


        //dob
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(310,140,150,20);
        dob.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(dob);

        t_dob = new JDateChooser();
        t_dob.setBounds(480,140,150,25);
        t_dob.setBackground(Color.WHITE);
        add(t_dob);


        //Salary

        JLabel salary = new JLabel("Salary");
        salary.setBounds(310,180,100,20);
        salary.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(salary);

        t_salary = new JTextField();
        t_salary.setBounds(480, 180, 200, 25);
        t_salary.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_salary);
        t_salary.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        //address

        JLabel address  = new JLabel("Address");
        address.setBounds(310,220,100,20);
        address.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(address);

        t_address = new JTextField();
        t_address.setBounds(480, 220, 200, 25);
        t_address.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_address);


        //mobile

        JLabel mobile_no = new JLabel("Mobile No.");
        mobile_no.setBounds(310,260,150,20);
        mobile_no.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(mobile_no);

        t_mobile_no = new JTextField();
        t_mobile_no.setBounds(480, 260, 200, 25);
        t_mobile_no.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_mobile_no);
        t_mobile_no.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || t_mobile_no.getText().length() >= 10) {
                    e.consume();
                }
            }
        });

        //email

        JLabel email = new JLabel("Email");
        email.setBounds(310,300,150,20);
        email.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(email);

        t_email = new JTextField();
        t_email.setBounds(480,300,200,25);
        t_email.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_email);

        //education


        JLabel eduction = new JLabel("Education");
        eduction.setBounds(310,340,150,20);
        eduction.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(eduction);

        String [] items = {"","BTech","B.E","MTech","M.E","MBA","MS","BCA"};
        box_edu = new JComboBox(items);
        box_edu.setBounds(480,340,150,20);
        box_edu.setBackground(Color.WHITE);
        add(box_edu);


        //role
        JLabel role = new JLabel("Role");
        role.setBounds(310,380,150,20);
        role.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(role);

        String [] item = {"","Software Developer","Data Engineer","AI Engineer","ML Engineer","Trainee","Intern","Data Scientist"};
        box_role = new JComboBox(item);
        box_role.setBounds(480,380,150,20);
        box_role.setBackground(Color.WHITE);
        add(box_role);


        //gender

        JLabel gender = new JLabel("Gender");
        gender.setBounds(310,420,150,20);
        gender.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.BOLD,15));
        male.setBounds(480, 420, 70, 25);
        male.setActionCommand("Male");

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial",Font.BOLD,15));
        female.setBounds(550, 420, 80, 25);
        female.setActionCommand("Female");

        other = new JRadioButton("Other");
        other.setFont(new Font("Arial",Font.BOLD,15));
        other.setBounds(630, 420, 80, 25);
        other.setActionCommand("Other");

        //to ensure only one button is selected at a time
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        add(male);
        add(female);
        add(other);


        //Aadhar

        JLabel aadhar = new JLabel("Aadhar No.");
        aadhar.setBounds(310,460,150,20);
        aadhar.setFont(new Font("Times New Roman",Font.BOLD,18));
        add(aadhar);

        t_aadhar_no = new JTextField();
        t_aadhar_no.setBounds(480, 460, 200, 25);
        t_aadhar_no.setFont(new Font("Arial",Font.PLAIN,15));
        add(t_aadhar_no);
        t_aadhar_no.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) || t_aadhar_no.getText().length() >= 12) {
                    e.consume();
                }
            }
        });









        Back = new JButton("Back");
        Back.setFont(new Font("Sans Serif",Font.BOLD,18));
        Back.setBounds(135,450,120,40);
        Back.setBackground(Color.GREEN);
        Back.setForeground(Color.BLACK);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
                new MainClass();
            }
        });
        add(Back);


        Add = new JButton("Add");
        Add.setFont(new Font("Sans Serif",Font.BOLD,18));
        Add.setBounds(135,400,120,40);
        Add.setBackground(Color.GREEN);
        Add.setForeground(Color.BLACK);
        Add.addActionListener(this);
        add(Add);





        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addemp.png"));
        Image i2 = i1.getImage().getScaledInstance(850,600,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Img = new JLabel(i3);
        Img.setBounds(0,0,850,600);
        add(Img);

        setLayout(null);
        setSize(850,600);
        setLocation(420,120);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Add){
            String e_name = t_name.getText();
            String fname = t_f_name.getText();
            String dob = ((JTextField) t_dob.getDateEditor().getUiComponent()).getText();
            String sal = t_salary.getText();
            String address = t_address.getText();
            String mob = t_mobile_no.getText();
            String email = t_email.getText();
            String education = (String) box_edu.getSelectedItem();
            String e_role = (String) box_role.getSelectedItem();
            String empid = employee_id.getText();
            String gen = genderGroup.getSelection().getActionCommand();
            String aadhar = t_aadhar_no.getText();


            try{
                connectDB c = new connectDB();
                String query = "insert into employee values('"+e_name+"','"+fname+"','"+dob+"','"+sal+"', '"+address+"', '"+mob+"', '"+email+"', '"+education+"', '"+e_role+"', '"+empid+"', '"+gen+"', '"+aadhar+"')";
                c.statement.executeUpdate(query); // use executeUpdate for entering a value in database
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
                new MainClass();

            }
            catch (Exception E){
                E.printStackTrace();
            }
        }

    }

    public static void main(String [] arg){

        new AddEmployee();

    }
}
