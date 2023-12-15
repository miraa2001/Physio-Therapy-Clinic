package clinic.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
	String fontType="SansSerif";
	JLabel signupLabel;
	JLabel usernameLabel;
	JLabel passwordLabel;
	JLabel phoneNumber;
	JLabel nameLabel;
	JLabel messageLabel;
	private JTextField usernameTF;
	private JTextField nameTF;
	private JPasswordField passwordTF;
	JSeparator s1;
	JSeparator s2;
	JSeparator s3;
	private JCheckBox showPassword;
	private JButton signUpButton;
	private Boolean res;
	public static Boolean search(String u)
	{
		if(PatientMethods.search(u)!=-1)
			return true;

		for(int i=0;i<AdminMethods.getAdmins().size();i++)
		{
			if(u.equals(AdminMethods.getAdmins().get(i).getUsername()))
			{
				return true;
			}
		}
		return false;
	}
	public Signup()
	{
		setLayout(null);
		signupLabel = new JLabel("Sign Up Portal");
		signupLabel.setLocation(125,20);
		signupLabel.setSize(170,30);
		signupLabel.setFont(new Font(fontType,Font.BOLD+Font.ITALIC,22));
		signupLabel.setBackground(new Color(255,203,230));
		signupLabel.setForeground(new Color(0,0,0));
		add(signupLabel);
		usernameLabel=new JLabel("Username");
		usernameLabel.setFont(new Font(fontType,Font.BOLD,18));
		usernameLabel.setBackground(new Color(255,203,230));
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setLocation(70,90);
		usernameLabel.setSize(90,40);
		add(usernameLabel);
		passwordLabel=new JLabel("Password");
		passwordLabel.setFont(new Font(fontType,Font.BOLD,18));
		passwordLabel.setBackground(new Color(255,203,230));
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setLocation(70,160);
		passwordLabel.setSize(90,40);
		add(passwordLabel);
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font(fontType,Font.BOLD,18));
		nameLabel.setBackground(new Color(255,203,230));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setLocation(70,240);
		nameLabel.setSize(90,40);
		add(nameLabel);
		
		usernameTF=new JTextField();
		usernameTF.setText("");
		usernameTF.setForeground(Color.BLACK);
		usernameTF.setBackground(new Color(255,203,230));
		usernameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		usernameTF.setFont(new Font(fontType,Font.PLAIN,14));
		usernameTF.setSize(170, 20);
		usernameTF.setLocation(170,100);
		add(usernameTF);
		
		s1=new JSeparator();
		s1.setBackground(new Color(0,0,0));
		s1.setForeground(new Color(0,0,0));
		s1.setSize(170, 5);
		s1.setLocation(170, 120);
		add(s1);
		
		passwordTF=new JPasswordField();
		passwordTF.setText("");
		passwordTF.setForeground(Color.BLACK);
		passwordTF.setBackground(new Color(255,203,230));
		passwordTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordTF.setFont(new Font(fontType,Font.PLAIN,14));
		passwordTF.setSize(170, 20);
		passwordTF.setLocation(170,170);
		add(passwordTF);
		
		s2=new JSeparator();
		s2.setBackground(new Color(0,0,0));
		s2.setForeground(new Color(0,0,0));
		s2.setSize(170, 5);
		s2.setLocation(170, 190);
		add(s2);
		
		showPassword=new JCheckBox("Show Password");
		showPassword.setFont(new Font(fontType,Font.BOLD,12));
		showPassword.setBackground(new Color(255,203,230));
		showPassword.setForeground(new Color(0,0,0));
		showPassword.setSize(170,30);
		showPassword.setLocation(170,200);
		showPassword.addActionListener(this);
		add(showPassword);
		
		nameTF=new JTextField();
		nameTF.setText("");
		nameTF.setForeground(Color.BLACK);
		nameTF.setBackground(new Color(255,203,230));
		nameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameTF.setFont(new Font(fontType,Font.PLAIN,14));
		nameTF.setSize(170, 20);
		nameTF.setLocation(170,250);
		add(nameTF);
		
		s3=new JSeparator();
		s3.setBackground(new Color(0,0,0));
		s3.setForeground(new Color(0,0,0));
		s3.setSize(170, 5);
		s3.setLocation(170,270);
		add(s3);
		
		signUpButton=new JButton("Sign Up");
		signUpButton.setFont(new Font(fontType,Font.BOLD,16));
		signUpButton.setBackground(new Color(0,0,0));
		signUpButton.setForeground(new Color(255,203,230));
		signUpButton.setSize(100,35);
		signUpButton.setLocation(145,310);
		add(signUpButton);
		signUpButton.addActionListener(this);
		messageLabel=new JLabel("");
		messageLabel.setBackground(new Color(255,203,230));
		messageLabel.setFont(new Font(fontType,Font.BOLD,12));
		messageLabel.setSize(200,40);
		messageLabel.setLocation(100,340);
		add(messageLabel);
		setSize(400,440);
		setLocation(480,100);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(new Color(255,203,230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
	}
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource()==showPassword)
			{
				if(showPassword.isSelected())
				{
					passwordTF.setFont(new Font(fontType,Font.PLAIN,14));
					passwordTF.setEchoChar((char) 0);
				}
				else
				{	
					passwordTF.setEchoChar('\u26AB');
					passwordTF.setFont(new Font(fontType,Font.PLAIN,12));
				}
			}
			if(e.getSource()==signUpButton)
			{
				if(Boolean.TRUE.equals( search( usernameTF.getText() ) ) )
				{
					res=true;
					messageLabel.setForeground(Color.RED);
					messageLabel.setText("User Already Exists. Try Again");
					messageLabel.setLocation(100,340);
				}
				else
				{
					res=false;
					messageLabel.setForeground(new Color(45,161,37));
					messageLabel.setLocation(100,340);
					messageLabel.setText("User Account has been created");
					Patient p = new Patient(usernameTF.getText(),String.valueOf(passwordTF.getPassword()),nameTF.getText());
					PatientMethods.getPatients().add(p);
					String n=PatientMethods.getPatients().get(PatientMethods.search(usernameTF.getText())).getName();
					int i=PatientMethods.search(usernameTF.getText());
					PatientMethods pm=new PatientMethods(n,i);
					pm.setVisible(true);
				}
			}
	}
	public JTextField getUsernameTF() {
		return usernameTF;
	}
	public JPasswordField getPasswordTF() {
		return passwordTF;
	}
	public JTextField getNameTF() {
		return nameTF;
	}
	public JButton getSignUp() {
		return signUpButton;
	}
	public JCheckBox getShowPassword() {
		return showPassword;
	}
	public Boolean getRes() {
		return res;
	}
}
