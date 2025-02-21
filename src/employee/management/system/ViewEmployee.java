package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener{


    Choice emp_choice;
    JTable table;

    JButton find,print,back,update;



    ViewEmployee(){

        getContentPane().setBackground(new Color(0x578FCA));

        JLabel search = new JLabel("Search Employee with ID: ");
        search.setBounds(40,30,230,25);
        search.setFont(new Font("Times New Roman", Font.BOLD,20));
        search.setForeground(Color.WHITE);
        add(search);


        emp_choice = new Choice();
        emp_choice.setBounds(270,32,150,20);
        emp_choice.setForeground(Color.BLACK);
        emp_choice.setBackground(Color.WHITE);
        add(emp_choice);

        try {

            connectDB c = new connectDB();
            ResultSet resultSet = c.statement.executeQuery("select emp_id from employee");//use executeQuery for fetching some value from the database
            while (resultSet.next()){
                emp_choice.add(resultSet.getString("emp_id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        table = new JTable();
        table.setBounds(40,70,1000,350);
        table.setBackground(new Color(0xA1E3F9));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Times New Roman", Font.BOLD,15));
        add(table);

        try {
            connectDB c = new connectDB();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        JScrollPane jb = new JScrollPane(table);
        jb.setBounds(40,70,1000,350);
        add(jb);


        find= new JButton("Search");
        find.setFont(new Font("Times New Roman",Font.BOLD,16));
        find.setBounds(450,30,100,30);
        find.setBackground(Color.WHITE);
        find.setForeground(Color.BLACK);
        find.addActionListener(this);
        add(find);

        print = new JButton("Print");
        print.setFont(new Font("Times New Roman",Font.BOLD,16));
        print.setBounds(40,450,100,40);
        print.setForeground(Color.BLACK);
        print.setBackground(Color.white);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setFont(new Font("Times New Roman",Font.BOLD,16));
        update.setBounds(180,450,100,40);
        update.setBackground(Color.white);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(320,450,100,40);
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainClass();
            }
        });
        add(back);




        setLayout(null);
        setVisible(true);
        setSize(1100,550);
        setLocation(250,150);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == find){
            String query = "select * from employee where emp_id = '"+emp_choice.getSelectedItem()+"' ";
            try {
                connectDB c = new connectDB();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        else if(e.getSource() == print){
            try{
                table.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        else if(e.getSource() == update){

            setVisible(false);
            new UpdateEmployee(emp_choice.getSelectedItem());

        }
    }

    public static void main(String [] arg){
        new ViewEmployee();

    }
}
