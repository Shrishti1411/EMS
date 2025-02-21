package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class RemoveEmployee extends JFrame {


    Choice selectID;

    JButton delete,back;


    RemoveEmployee(){

        getContentPane().setBackground(new Color(0x000000));

        JLabel emp = new JLabel("Employee ID");
        emp.setBounds(40,30,120,25);
        emp.setFont(new Font("Times New Roman", Font.BOLD,20));
        emp.setForeground(Color.WHITE);
        add(emp);

        selectID = new Choice();
        selectID.setBounds(180,30,150,30);
        selectID.setBackground(Color.WHITE);
        selectID.setForeground(Color.BLACK);
        add(selectID);

        try {
           connectDB c = new connectDB();
           ResultSet resultSet = c.statement.executeQuery( "select * from employee");
           while (resultSet.next()){
               selectID.add(resultSet.getString("emp_id"));

           }


        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel LabelName = new JLabel("Name : ");
        LabelName.setBounds(40,100,100,30);
        LabelName.setFont(new Font("Times New Roman",Font.BOLD,20));
        LabelName.setForeground(Color.WHITE);
        add(LabelName);

        JLabel name = new JLabel();
        name.setBounds(200,100,250,30);
        name.setFont(new Font("Times new Roman",Font.BOLD,20));
        name.setForeground(Color.WHITE);
        add(name);



        JLabel LabelMobile = new JLabel("Mobile no : ");
        LabelMobile.setBounds(40,150,150,30);
        LabelMobile.setFont(new Font("Times New Roman",Font.BOLD,20));
        LabelMobile.setForeground(Color.WHITE);
        add(LabelMobile);

        JLabel mob = new JLabel();
        mob.setBounds(200,150,200,30);
        mob.setFont(new Font("Times new Roman",Font.BOLD,20));
        mob.setForeground(Color.WHITE);
        add(mob);


        JLabel LabelEmail = new JLabel("Email : ");
        LabelEmail.setBounds(40,200,100,30);
        LabelEmail.setFont(new Font("Times New Roman",Font.BOLD,20));
        LabelEmail.setForeground(Color.WHITE);
        add(LabelEmail);

        JLabel email = new JLabel();
        email.setBounds(200,200,250,30);
        email.setFont(new Font("Times new Roman",Font.BOLD,20));
        email.setForeground(Color.WHITE);
        add(email);


        try {
            connectDB c = new connectDB();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where emp_id = '" + selectID.getSelectedItem() + "'");
            while (resultSet.next()) {
                name.setText(resultSet.getString("e_name"));
                mob.setText(resultSet.getString("mob"));
                email.setText(resultSet.getString("email"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }





        selectID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {


                    //setting the fields
                    try {
                        connectDB c = new connectDB();
                        ResultSet resultSet = c.statement.executeQuery("select * from employee where emp_id = '" + selectID.getSelectedItem() + "'");
                        while (resultSet.next()) {
                            name.setText(resultSet.getString("e_name"));
                            mob.setText(resultSet.getString("mob"));
                            email.setText(resultSet.getString("email"));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();


                }


            }
        });


//        if (selectID.getItemCount() > 0) {
//            selectID.select(0); // Select the first item in the dropdown
//            selectID.dispatchEvent(new ItemEvent(
//                    selectID, ItemEvent.ITEM_STATE_CHANGED, selectID.getSelectedItem(), ItemEvent.SELECTED
//            ));
//        }



        delete = new JButton("Delete");
        delete.setBounds(180,280,100,30);
        delete.setFont(new Font("Times New Roman",Font.BOLD,20));
        delete.setBackground(Color.WHITE);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connectDB c = new connectDB();
                    c.statement.executeUpdate("delete from employee where emp_id = '"+selectID.getSelectedItem()+"'");
                    JOptionPane.showMessageDialog(null,"Deleted Successfully");
                    setVisible(false);
                    new MainClass();


                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back = new JButton("Back");
        back.setBounds(350,280,100,30);
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MainClass();
            }
        });
        add(back);

        setSize(650,400);
        setLocation(450,150);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String [] arg){


        new RemoveEmployee();


    }
}
