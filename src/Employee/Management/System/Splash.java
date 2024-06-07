package Employee.Management.System;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Splash extends JFrame implements ActionListener
{
	JLabel heading,front_img;
	JButton click;
	public Splash()
	{
		setSize(1170, 650);
		getContentPane().setBackground(Color.WHITE);
		setLocation(200, 50);
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		
		front_img = new JLabel(i3);
		front_img.setBounds(50, 100, 1050, 500);
		add(front_img);
		
		heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(80, 30, 1200, 60);
		heading.setFont(new Font("serif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		add(heading);
		
		click = new JButton("CLICK HERE TO CONTINUE");
		click.setBounds(400, 520, 300, 50);
		click.setBackground(Color.BLACK);
		click.setForeground(Color.WHITE);
		click.setFont(new Font("Raleway",Font.ITALIC,18));
		click.addActionListener(this);
		add(click);
		
		setVisible(true);
		while(true)
		{
			heading.setVisible(false);
			try
			{
				Thread.sleep(500);
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			heading.setVisible(true);
			try
			{
				Thread.sleep(500);
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Login();
		
	}
	public static void main(String arg[])
	{
		new Splash();
	}
}
