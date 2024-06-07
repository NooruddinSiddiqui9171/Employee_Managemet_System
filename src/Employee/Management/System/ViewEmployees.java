package Employee.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame implements ActionListener
{
 
	JTable table;
	JScrollPane scroll;
	JLabel select;
	Choice cemp;
	JButton search,print,update,back;
	public ViewEmployees()
	{
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setSize(1200, 700);
		setLocation(180,70);
		
		table = new JTable();
		table.setFont(new Font("System",Font.BOLD,13));
		
		select = new JLabel("Search By Employee ID");
		select.setFont(new Font("serif",Font.BOLD,18));
		select.setBounds(20,20,230,30);
		add(select);
		
		cemp = new Choice();
		cemp.setBounds(250,25,180,30);
		add(cemp);
		try
		{
			Connect con = new Connect();
			ResultSet rs= con.stm.executeQuery("SELECT * FROM EMPLOYEE");
			while(rs.next())
			{
				cemp.add(rs.getString("Employee_ID"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			Connect con = new Connect();
			ResultSet rs= con.stm.executeQuery("SELECT * FROM EMPLOYEE");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		search = new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 100, 1200, 600);
		add(scroll);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==search)
		{
			String query="SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID='"+cemp.getSelectedItem()+"'";
			try {
				Connect con=new Connect();
				ResultSet rs=con.stm.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==print)
		{
			try
			{
				table.print();
			}catch(Exception pex)
			{
				pex.printStackTrace();
			}
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new UpdateEmployee(cemp.getSelectedItem());
		}
		else
		{
			setVisible(false);
			new Home();
		}
		
	}
	public static void main(String[] args) {
		
		new ViewEmployees();

	}
}
