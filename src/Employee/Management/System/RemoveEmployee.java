package Employee.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton delete, back;
    
    public RemoveEmployee() 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setFont(new Font("serif",Font.PLAIN,15));
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        try {
            Connect con = new Connect();
            String query = "select * from employee";
            ResultSet rs = con.stm.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("Employee_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setFont(new Font("serif",Font.PLAIN,15));
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setFont(new Font("serif",Font.BOLD,15));
        lblname.setBounds(200, 100, 150, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setFont(new Font("serif",Font.PLAIN,15));
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setFont(new Font("serif",Font.BOLD,15));
        lblphone.setBounds(200, 150, 150, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setFont(new Font("serif",Font.PLAIN,15));
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setFont(new Font("serif",Font.BOLD,15));
        lblemail.setBounds(200, 200, 200, 30);
        add(lblemail);
        
        try {
            Connect con = new Connect();
            String query = "select * from Employee where Employee_ID = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = con.stm.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("Name"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect con = new Connect();
                    String query = "select * from Employee where Employee_ID = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = con.stm.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("Name"));
                        lblphone.setText(rs.getString("Phone"));
                        lblemail.setText(rs.getString("Email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connect con = new Connect();
                String query = "delete from Employee where Employee_ID = '"+cEmpId.getSelectedItem()+"'";
                con.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}