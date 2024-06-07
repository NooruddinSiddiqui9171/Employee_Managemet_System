package Employee.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener
{
	JLabel home_img,heading;
	JButton add,remove,view,update;
    public Home()
    {
    	setLayout(null);
    	setSize(1120,630);
    	setLocation(250, 100);
    	
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/office.jpg"));
		Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		
		home_img = new JLabel(i3);
		home_img.setBounds(0, 0, 1120, 630);
		add(home_img);
		
		heading = new JLabel("Employee Management System");
		heading.setBounds(650,20,400,30);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Times New Roman",Font.BOLD,25));
		home_img.add(heading);
		
		add = new JButton("Add Employee");
		add.setBackground(new Color(169,169,169));
		add.setForeground(Color.BLACK);
		add.setFont(new Font("serif",Font.BOLD,16));
		add.setBounds(620,80,180,40);
		add.addActionListener(this);
		home_img.add(add);
		
		view = new JButton("View Employees");
		view.setBackground(new Color(169,169,169));
		view.setForeground(Color.BLACK);
		view.setFont(new Font("serif",Font.BOLD,16));
		view.setBounds(820,80,180,40);
		view.addActionListener(this);
		home_img.add(view);
		
		update = new JButton("Update Employee");
		update.setBackground(new Color(169,169,169));
		update.setForeground(Color.BLACK);
		update.setFont(new Font("serif",Font.BOLD,16));
		update.setBounds(620,140,180,40);
		update.addActionListener(this);
		home_img.add(update);
		
		remove = new JButton("Remove Employee");
		remove.setBackground(new Color(169,169,169));
		remove.setForeground(Color.BLACK);
		remove.setFont(new Font("serif",Font.BOLD,16));
		remove.setBounds(820,140,180,40);
		remove.addActionListener(this);
		home_img.add(remove);
    	
    	setVisible(true);
    }
    @Override
	public void actionPerformed(ActionEvent e)
    {
		if(e.getSource()==add)
		{
			setVisible(false);
			new AddEmployee();
		}
		else if(e.getSource()==view)
		{
			setVisible(false);
			new ViewEmployees();
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new ViewEmployees();
		}
		else 
		{
			setVisible(false);
			new RemoveEmployee();
		}	
	}
	public static void main(String arg[])
	{
		new Home();
		
	}
}
