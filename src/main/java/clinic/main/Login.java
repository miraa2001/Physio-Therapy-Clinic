package clinic.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JPanel panel;
	JLabel usernameLabel;
	JLabel passwordLabel;
	private JLabel messageLabel;
	JTextField usernameTFF;
	JPasswordField passwordTFF;
	JButton signIn;
	JSeparator s11;
	JSeparator s22;
	private JCheckBox showPasswordd;
	JLabel b;
	JLabel w;
	int res=-1;
	JDialog dialog;
	String fontType="SansSerif";
	static Scanner in=new Scanner(System.in);
	static int index=-1;
	public Login() 
	{
		init();
		setLayout(null);
		
		w=new JLabel("MyClinic's Login portal");
		w.setFont(new Font(fontType,Font.BOLD+Font.ITALIC,24));
		w.setBackground(new Color(0,0,0));
		w.setForeground(new Color(0,0,0));
		w.setSize(280,100);
		w.setLocation(70,20);
		add(w);
		usernameLabel=new JLabel("Username");
		Font f=new Font(fontType,Font.BOLD,18);
		usernameLabel.setForeground(new Color(0,0,0));
		usernameLabel.setFont(f);
		usernameLabel.setLocation(40, 100);
		usernameLabel.setSize(100,100);
		add(usernameLabel);
		usernameTFF=new JTextField();
		usernameTFF.setText("");
		usernameTFF.setForeground(Color.BLACK);
		usernameTFF.setBackground(new Color(255,203,230));
		usernameTFF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		usernameTFF.setFont(new Font(fontType,Font.PLAIN,14));
		usernameTFF.setSize(170, 20);
		usernameTFF.setLocation(145,140);
		add(usernameTFF);
		s11=new JSeparator();
		s11.setBackground(new Color(0,0,0));
		s11.setForeground(new Color(0,0,0));
		s11.setSize(170, 5);
		s11.setLocation(145, 160);
		add(s11);
		
		passwordLabel=new JLabel("Password");
		passwordLabel.setForeground(new Color(0,0,0));
		passwordLabel.setFont(f);
		passwordLabel.setLocation(40, 160);
		passwordLabel.setSize(100,100);
		add(passwordLabel);
		passwordTFF=new JPasswordField(15);
		passwordTFF.setText("");
		passwordTFF.setForeground(Color.BLACK);
		passwordTFF.setBackground(new Color(255,203,230));
		passwordTFF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordTFF.setEchoChar('\u26AB');
		passwordTFF.setSize(170, 20);
		passwordTFF.setLocation(145,200);
		add(passwordTFF);
		s22=new JSeparator();
		s22.setBackground(new Color(0,0,0));
		s22.setForeground(new Color(0,0,0));
		s22.setSize(170, 5);
		s22.setLocation(145, 220);
		add(s22);
		showPasswordd=new JCheckBox("Show Password");
		showPasswordd.setFont(new Font(fontType,Font.BOLD,12));
		showPasswordd.setBackground(new Color(255,203,230));
		showPasswordd.setForeground(new Color(0,0,0));
		showPasswordd.setSize(170,30);
		showPasswordd.setLocation(135,240);
		showPasswordd.addActionListener(this);
		add(showPasswordd);
		signIn=new JButton("Log in");
		signIn.setFont(new Font(fontType,Font.BOLD,16));
		signIn.setBackground(new Color(0,0,0));
		signIn.setForeground(new Color(255,203,230));
		signIn.setSize(100,35);
		signIn.setLocation(145,310);
		add(signIn);
		signIn.addActionListener(this);
		b=new JLabel("");
		b.setSize(100,100);
		b.setLocation(145,350);
		ImageIcon icon=new ImageIcon("C:\\Users\\miraj\\eclipse-workspace\\MyBookStore\\MyBookStore\\src\\book\\store\\book.gif");
		b.setIcon(icon);
		add(b);

		messageLabel=new JLabel("");
		messageLabel.setBackground(new Color(255,203,230));
		messageLabel.setFont(new Font(fontType,Font.PLAIN,13));
		messageLabel.setLocation(135, 350);
		messageLabel.setSize(130,30);
		add(messageLabel);
		messageLabel.addMouseListener(new MouseAdapter()  
		{  
			@Override
		    public void mouseClicked(MouseEvent e)  
		    {  
		       toBack();
		       Signup su=new Signup();
		       su.setVisible(true);
		       su.toFront();
		       dispose();
		    }  
		}); 
		setVisible(true);
		setLocation(480,100);
		setSize(400, 440);
		setResizable(false);
		getContentPane().setBackground(new Color(255,203,230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showPasswordd)
		{
			if(showPasswordd.isSelected())
			{
				passwordTFF.setFont(new Font(fontType,Font.PLAIN,14));
				passwordTFF.setEchoChar((char) 0);
			}
			else
			{	
				passwordTFF.setEchoChar('\u26AB');
				passwordTFF.setFont(new Font(fontType,Font.PLAIN,12));
			}
		}
		if(e.getSource()==signIn)
		{
			res=checkLoginStatus(usernameTFF.getText(),String.valueOf(passwordTFF.getPassword()));
			if(res == -2)
			{
				messageLabel.setForeground(new Color(45,161,37));
				messageLabel.setText("Login Successful");
			}
			else if(res == -1)
			{
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Invalid Credentials");
			}
			else if(res == 2)
			{
				PatientMethods.getPatients().get(index).setLogState(true);
				PatientMethods pm=new PatientMethods(PatientMethods.getPatients().get(index).getName(),index);
				this.toBack();
				pm.setVisible(true);
				pm.toFront();
				dispose();
				messageLabel.setForeground(new Color(45,161,37));
				messageLabel.setText("Login Successful");
			}
			else if(res == 1)
			{
				PatientMethods.getPatients().get(index).setLogState(false);
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Invalid Credentials");
			}
			else if(res == 0)
			{
				messageLabel.setForeground(Color.RED);
				messageLabel.setSize(300,40);
				messageLabel.setLocation(80,350);
				messageLabel.setText("User does not exist,Click Here to Sign Up");
				Signup su=new Signup();
			}
		}
	}
	
	public static int checkLoginStatus(String u,String p)
	{

		for(int i=0;i<PatientMethods.getPatients().size();i++)
		{
			if(u.equals(PatientMethods.getPatients().get(i).getUsername()))
			{	
				index=i;
				if(p.equals(PatientMethods.getPatients().get(i).getPassword()))
					return 2;
				else
					return 1;
			}
		}
		for(int i=0;i<AdminMethods.getAdmins().size();i++)
		{
			if(u.equals(AdminMethods.getAdmins().get(i).getUsername()))
			{	
				index=i;
				if(p.equals(AdminMethods.getAdmins().get(i).getPassword()))
					return -2;
				else
					return -1;
			}
		}
		return 0;
	}
	public static void init()
	{
		if((AdminMethods.getAdmins().size()<3)&&(PatientMethods.getPatients().size()<3))
		{
			Admin a1=new Admin("miraj","1212001","Mira Jamous");
			Admin a2=new Admin("talahamad","tala2001","Tala Hamad");
			Admin a3=new Admin("areenateeq","areen2002","Areen Ateeq");
			AdminMethods.getAdmins().add(a1);
			AdminMethods.getAdmins().add(a2);
			AdminMethods.getAdmins().add(a3);
			Patient c1=new Patient("ayaayman","aya2001","Aya Ayman");		
			Patient c2=new Patient("leenh","leen21","Leen Hodally");
			Patient c3=new Patient("suha2001","suhaa2001","Suha Mansour");
			PatientMethods.getPatients().add(c1);
			PatientMethods.getPatients().add(c2);
			PatientMethods.getPatients().add(c3);
		}
	}
	public void setPasswordField(String p)
	{
		passwordTFF.setText(p);
	}
	public void setUsernameField(String u)
	{
		usernameTFF.setText(u);
	}
	
	public static void main(String[] args)
	{
		Login login=new Login();
		login.setVisible(true);
		login.getContentPane().setBackground(new Color(255,203,230));
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}


	public JButton getSignIn() {
		return signIn;
	}
	public int getResult()
	{
		return res;
	}
	public JCheckBox getShowPassword() {
		return showPasswordd;
	}
	public JLabel getMessageLabel() {
		return messageLabel;
	}
}

