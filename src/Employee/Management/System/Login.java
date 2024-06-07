package Employee.Management.System;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener
{
	JLabel username,password,login_img;
	JTextField userTextField;
	JButton login;
	JPasswordField passTextField;
	public Login()
	{
		setLayout(null);
		setSize(600, 300);
		setLocation(450, 200);
		getContentPane().setBackground(Color.WHITE);
		
		username = new JLabel("Username");
		username.setFont(new Font("Raleway",Font.BOLD,18));
		username.setBounds(40,25,100,30);
		add(username);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Raleway",Font.BOLD,18));
		userTextField.setBounds(150,25,200,30);
		add(userTextField);
		
		password = new JLabel("Password");
		password.setFont(new Font("Raleway",Font.BOLD,18));
		password.setBounds(40,75,100,30);
		add(password);
		
		passTextField = new JPasswordField();
		passTextField.setFont(new Font("Raleway",Font.BOLD,18));
		passTextField.setBounds(150,75,200,30);
		add(passTextField);
		
		login = new JButton("LOGIN");
		login.setBounds(150, 135, 200, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("serif",Font.BOLD,18));
		login.addActionListener(this);
		add(login);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		
		login_img = new JLabel(i3);
		login_img.setBounds(350, 0, 200, 200);
		add(login_img);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String user=userTextField.getText();
		@SuppressWarnings("deprecation")
		String pass=passTextField.getText();
		
		if(user.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter Username");
		}
		else if(pass.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter Password");
		}
		else
		{
		Connect con=new Connect();
		String query="SELECT * FROM LOGIN WHERE username = '"+user+"' AND password = '"+pass+"'";
		try
		{
			ResultSet rs=con.stm.executeQuery(query);
			if(rs.next())
			{
				setVisible(false);
				new Home();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
				userTextField.setText("");
				passTextField.setText("");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
		
	}	
    public static void main(String arg[])
    {
	 new Login();
    }	
}
