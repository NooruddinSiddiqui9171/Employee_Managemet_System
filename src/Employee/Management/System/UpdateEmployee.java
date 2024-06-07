package Employee.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class UpdateEmployee extends JFrame implements ActionListener
{
	JLabel heading,name,fname,dob,salary,address,phone,email,education,designation,aadhar,empID,labelempID,namelb,aadharlb,datelb;
	JTextField fnameTF,salaryTF,addressTF,phoneTF,emailTF,qualiTF,designationTF;
	JButton add,back;
	String empid;
	public UpdateEmployee(String empid)
	{
		this.empid=empid;
		setSize(900, 700);
		setLocation(300, 50);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("Update Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		name = new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("serif",Font.PLAIN,20));
		add(name);
		
		namelb = new JLabel();
		namelb.setFont(new Font("Ralway",Font.PLAIN,15));
		namelb.setBounds(200,150,150,30);
		add(namelb);
		
		fname = new JLabel("Father's Name");
		fname.setBounds(400,150,150,30);
		fname.setFont(new Font("serif",Font.PLAIN,20));
		add(fname);
		
		fnameTF = new JTextField();
		fnameTF.setFont(new Font("Ralway",Font.PLAIN,15));
		fnameTF.setBounds(600,150,150,30);
		add(fnameTF);
		

		dob = new JLabel("Date Of Birth");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("serif",Font.PLAIN,20));
		add(dob);
		
		datelb=new JLabel();
		datelb.setFont(new Font("Ralway",Font.PLAIN,15));
		datelb.setBounds( 200, 200, 150, 30);
		add(datelb);
		
		salary = new JLabel("Salary");
		salary.setBounds(400,200,150,30);
		salary.setFont(new Font("serif",Font.PLAIN,20));
		add(salary);
		
		salaryTF = new JTextField();
		salaryTF.setFont(new Font("Ralway",Font.PLAIN,15));
		salaryTF.setBounds(600,200,150,30);
		add(salaryTF);
		
		address = new JLabel("Address");
		address.setBounds(50,250,150,30);
		address.setFont(new Font("serif",Font.PLAIN,20));
		add(address);
		
		addressTF = new JTextField();
		addressTF.setFont(new Font("Ralway",Font.PLAIN,15));
		addressTF.setBounds(200,250,150,30);
		add(addressTF);
		
		phone = new JLabel("Phone No");
		phone.setBounds(400,250,150,30);
		phone.setFont(new Font("serif",Font.PLAIN,20));
		add(phone);
		
		phoneTF = new JTextField();
		phoneTF.setFont(new Font("Ralway",Font.PLAIN,15));
		phoneTF.setBounds(600,250,150,30);
		add(phoneTF);
		
		email = new JLabel("Email");
		email.setBounds(50,300,150,30);
		email.setFont(new Font("serif",Font.PLAIN,20));
		add(email);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Ralway",Font.PLAIN,15));
		emailTF.setBounds(200,300,150,30);
		add(emailTF);
		
		education = new JLabel("Highest Education");
		education.setBounds(400,300,150,30);
		education.setFont(new Font("serif",Font.PLAIN,20));
		add(education);
		
		qualiTF = new JTextField();
		qualiTF.setFont(new Font("Ralway",Font.PLAIN,15));
		qualiTF.setBounds(600, 300, 150, 30);
		add(qualiTF);
		
		designation = new JLabel("Designation");
		designation.setBounds(50,350,150,30);
		designation.setFont(new Font("serif",Font.PLAIN,20));
		add(designation);
		
		designationTF = new JTextField();
		designationTF.setFont(new Font("Ralway",Font.PLAIN,15));
		designationTF.setBounds(200, 350, 150, 30);
		add(designationTF);
		
		aadhar = new JLabel("Aadhar No");
		aadhar.setBounds(400,350,150,30);
		aadhar.setFont(new Font("serif",Font.PLAIN,20));
		add(aadhar);
		
		aadharlb = new JLabel();
		aadharlb.setFont(new Font("Ralway",Font.PLAIN,15));
		aadharlb.setBounds(600,350,150,30);
		add(aadharlb);
		
		empID = new JLabel("Employee ID");
		empID.setBounds(50,400,150,30);
		empID.setFont(new Font("serif",Font.PLAIN,20));
		add(empID);
		
		labelempID = new JLabel(empid);
		labelempID.setBounds(200,400,150,30);
		labelempID.setFont(new Font("serif",Font.PLAIN,20));
		add(labelempID);
		
		try
		{
			Connect con=new Connect();
			String query="SELECT * FROM EMPLOYEE WHERE Employee_ID ='"+empid+"'";
			ResultSet rs = con.stm.executeQuery(query);
			while(rs.next())
			{
				namelb.setText(rs.getString("Name"));
				fnameTF.setText(rs.getString("Father_Name"));
				datelb.setText(rs.getString("DOB"));
				salaryTF.setText(rs.getString("Salary"));
				addressTF.setText(rs.getString("Address"));
				phoneTF.setText(rs.getString("Phone"));
				emailTF.setText(rs.getString("Email"));
				qualiTF.setText(rs.getString("Qualification"));
				designationTF.setText(rs.getString("Designation"));
				aadharlb.setText(rs.getString("Aadhar"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		add = new JButton("Update");
		add.setBounds(250,550,150,40);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setFont(new Font("serif",Font.PLAIN,20));
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(450,550,150,40);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setFont(new Font("serif",Font.PLAIN,20));
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add)
		{
			String fatherName= fnameTF.getText();
			String salary = salaryTF.getText();
			String address = addressTF.getText();
			String phone = phoneTF.getText();
			String email = emailTF.getText();
			String qualification = qualiTF.getText();
			String designation = designationTF.getText();
			
			try 
			{
				if(fatherName.equals(""))
					JOptionPane.showMessageDialog(null,"Father Name is Required");
				else if(salary.equals(""))
					JOptionPane.showMessageDialog(null,"Salary is Required");
				else if (!salary.matches("\\d+"))
		  		    JOptionPane.showMessageDialog(null, "Please Enter a Valid Positive Salary");
				else if(address.equals(""))
					JOptionPane.showMessageDialog(null,"Address is Required");
				else if(phone.equals(""))
					JOptionPane.showMessageDialog(null,"Phone no. is Required");
				else if(email.equals(""))
					JOptionPane.showMessageDialog(null,"Email is Required");
				else if(address.equals(""))
					JOptionPane.showMessageDialog(null,"Address is Required");
				else if(qualification.equals(""))
					JOptionPane.showMessageDialog(null,"Qualification is Required");
				else if(designation.equals(""))
					JOptionPane.showMessageDialog(null,"Designation is Required");
				else
				{
					Connect con=new Connect();
					String query="UPDATE Employee SET Father_Name = '"+fatherName+"', Salary = '"+salary+"', Address = '"+address+"',Qualification = '"+qualification+"',Designation = '"+designation+"', Email = '"+email+"',Phone = '"+phone+"' WHERE Employee_ID = '"+empid+"'";
					con.stm.executeUpdate(query);	
					JOptionPane.showMessageDialog(null,"Details Update Successfully");
					setVisible(false);
					new Home();
				}
			}catch(Exception ae)
			{
				System.out.println(ae);
			}				
		}
		else
		{
			setVisible(false);
			new Home();
		}
		
	}
	public static void main(String arg[])
	{
		new UpdateEmployee("");
	}
}
