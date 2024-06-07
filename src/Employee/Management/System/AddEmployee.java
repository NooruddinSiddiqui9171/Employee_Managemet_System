package Employee.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.util.Random;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AddEmployee extends JFrame implements ActionListener
{
	JLabel heading,name,fname,dob,salary,address,phone,email,education,designation,aadhar,empID,labelempID;
	JTextField nameTF,fnameTF,salaryTF,addressTF,phoneTF,emailTF,aadharTF;
	JDateChooser date;
	JComboBox<Object> qualicombobox,occucombobox;
	JButton add,back;
	Random ran = new Random();
	int number = 100000 + ran.nextInt(900000);
	public AddEmployee()
	{
		setSize(900, 700);
		setLocation(300, 50);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("Add Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		name = new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("serif",Font.PLAIN,20));
		add(name);
		
		nameTF = new JTextField();
		nameTF.setBounds(200,150,150,30);
		add(nameTF);
		
		fname = new JLabel("Father's Name");
		fname.setBounds(400,150,150,30);
		fname.setFont(new Font("serif",Font.PLAIN,20));
		add(fname);
		
		fnameTF = new JTextField();
		fnameTF.setBounds(600,150,150,30);
		add(fnameTF);
		

		dob = new JLabel("Date Of Birth");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("serif",Font.PLAIN,20));
		add(dob);
		
		date=new JDateChooser();
		date.setFont(new Font("Ralway",Font.BOLD,15));
		date.setForeground(new Color(105,105,105));
		date.setBounds( 200, 200, 150, 30);
		add(date);
		
		salary = new JLabel("Salary");
		salary.setBounds(400,200,150,30);
		salary.setFont(new Font("serif",Font.PLAIN,20));
		add(salary);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(600,200,150,30);
		add(salaryTF);
		
		address = new JLabel("Address");
		address.setBounds(50,250,150,30);
		address.setFont(new Font("serif",Font.PLAIN,20));
		add(address);
		
		addressTF = new JTextField();
		addressTF.setBounds(200,250,150,30);
		add(addressTF);
		
		phone = new JLabel("Phone No");
		phone.setBounds(400,250,150,30);
		phone.setFont(new Font("serif",Font.PLAIN,20));
		add(phone);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(600,250,150,30);
		add(phoneTF);
		
		email = new JLabel("Email");
		email.setBounds(50,300,150,30);
		email.setFont(new Font("serif",Font.PLAIN,20));
		add(email);
		
		emailTF = new JTextField();
		emailTF.setBounds(200,300,150,30);
		add(emailTF);
		
		education = new JLabel("Highest Education");
		education.setBounds(400,300,150,30);
		education.setFont(new Font("serif",Font.PLAIN,20));
		add(education);
		
		String valquali[]= {"BBA","BCA","BA","B.COM","B.TECH","MBA","MCA","DIPLOMA","M.TECH","Other"};
		qualicombobox = new JComboBox<Object>(valquali);
		qualicombobox.setFont(new Font("Ralway",Font.BOLD,14));
		qualicombobox.setBackground(Color.WHITE);
		qualicombobox.setBounds(600, 300, 150, 30);
		add(qualicombobox);
		
		designation = new JLabel("Designation");
		designation.setBounds(50,350,150,30);
		designation.setFont(new Font("serif",Font.PLAIN,20));
		add(designation);
		
		String valoccu[]= {"Software Engineer","Web Developer","Analyst","Chief Architect","IT Manager","Director","DB Administrator"};
		occucombobox = new JComboBox<Object>(valoccu);
		occucombobox.setFont(new Font("Ralway",Font.BOLD,14));
		occucombobox.setBackground(Color.WHITE);
		occucombobox.setBounds(200, 350, 150, 30);
		add(occucombobox);
		
		aadhar = new JLabel("Aadhar No");
		aadhar.setBounds(400,350,150,30);
		aadhar.setFont(new Font("serif",Font.PLAIN,20));
		add(aadhar);
		
		aadharTF = new JTextField();
		aadharTF.setBounds(600,350,150,30);
		add(aadharTF);
		
		empID = new JLabel("Employee ID");
		empID.setBounds(50,400,150,30);
		empID.setFont(new Font("serif",Font.PLAIN,20));
		add(empID);
		
		labelempID = new JLabel(""+number);
		labelempID.setBounds(200,400,150,30);
		labelempID.setFont(new Font("serif",Font.PLAIN,20));
		add(labelempID);
		
		add = new JButton("Add Details");
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
			String name = nameTF.getText();
			String fatherName= fnameTF.getText();
			String salary = salaryTF.getText();
			String address = addressTF.getText();
			String phone = phoneTF.getText();
			String email = emailTF.getText();
			String aadhar = aadharTF.getText();
			String id = ""+number;
			String dob= ((JTextField) date.getDateEditor().getUiComponent()).getText();
			String qualification = (String)qualicombobox.getSelectedItem();
			String designation = (String)occucombobox.getSelectedItem();
			
			try 
			{
				if(name.equals(""))
					JOptionPane.showMessageDialog(null,"Name is Required");
				else if(fatherName.equals(""))
					JOptionPane.showMessageDialog(null,"Father Name is Required");
				else if(dob.equals(""))
					JOptionPane.showMessageDialog(null,"Date of birth is Required");
				else if(salary.equals(""))
					JOptionPane.showMessageDialog(null,"Salary is Required");
				else if(address.equals(""))
					JOptionPane.showMessageDialog(null,"Address is Required");
				else if(phone.equals(""))
					JOptionPane.showMessageDialog(null,"Phone no. is Required");
				else if(email.equals(""))
					JOptionPane.showMessageDialog(null,"Email is Required");
				else if(aadhar.equals(""))
					JOptionPane.showMessageDialog(null,"Aadhar is Required");
				else if(address.equals(""))
					JOptionPane.showMessageDialog(null,"Address is Required");
				else if(qualification.equals(""))
					JOptionPane.showMessageDialog(null,"Qualification is Required");
				else if(designation.equals(""))
					JOptionPane.showMessageDialog(null,"Designation is Required");
				else
				{
					Connect con=new Connect();
					String query="INSERT INTO Employee VALUES('"+id+"','"+name+"','"+fatherName+"','"+salary+"','"+address+"','"+aadhar+"','"+qualification+"','"+designation+"','"+email+"','"+phone+"', '"+dob+"')";
					con.stm.executeUpdate(query);	
					JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
		new AddEmployee();
	}
}
