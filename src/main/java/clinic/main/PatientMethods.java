package clinic.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JCalendar;

public class PatientMethods extends JFrame implements ActionListener, MouseListener{
	int index=0;
	private static List<Patient> patients=new ArrayList<>();
	private static List<Appointment> appointments=new ArrayList<>();
	JLabel welcomeLabel;
	private JCalendar calendar;
	String fontType="SansSerif";
	private JComboBox<String> servicesChoice;
	private JComboBox<String> times;
	private JButton bookAppointment;
	private JButton showAllAppointments;
	private JButton getInvoice;
	private JTextArea text;
	JLabel calendarLabel;
	JLabel servicesLabel;
	JLabel timeLabel;
	JLabel appsLabel;
	private JLabel errorLabel;
	private List<String> servicesNames=new ArrayList<>();
	private List<String> timesNames=new ArrayList<>();
	public PatientMethods(String name,int index)
	{
		setLayout(null);
		AdminMethods.initServices();
		for(int i=0;i<AdminMethods.getServices().size();i++)
		{
			servicesNames.add(AdminMethods.getServices().get(i).toString()+"NIS");
		}
		for(int i=8;i<18;i++)
		{	
				timesNames.add(i+":00");
		}
		calendarLabel=new JLabel("Pick a date:");
		calendarLabel.setFont(new Font(fontType,Font.BOLD,14));
		calendarLabel.setSize(200,30);
		calendarLabel.setLocation(100,60);
		add(calendarLabel);
		servicesLabel=new JLabel("Select a service:");
		servicesLabel.setFont(new Font(fontType,Font.BOLD,14));
		servicesLabel.setSize(200,30);
		servicesLabel.setLocation(320,70);
		add(servicesLabel);
		timeLabel=new JLabel("Select a time:");
		timeLabel.setFont(new Font(fontType,Font.BOLD,14));
		timeLabel.setSize(200,30);
		timeLabel.setLocation(320,160);
		add(timeLabel);
		appsLabel=new JLabel("Appointments:");
		appsLabel.setFont(new Font(fontType,Font.BOLD,14));
		appsLabel.setSize(200,30);
		appsLabel.setLocation(250,360);
		add(appsLabel);
		errorLabel=new JLabel("");
		errorLabel.setFont(new Font(fontType,Font.BOLD,14));
		errorLabel.setSize(200,30);
		errorLabel.setLocation(320,310);
		add(errorLabel);
		welcomeLabel=new JLabel("Welcome "+name);
		welcomeLabel.setFont(new Font(fontType,Font.BOLD+Font.ITALIC,24));
		welcomeLabel.setSize(300,30);
		welcomeLabel.setLocation(180,15);
		add(welcomeLabel);
		calendar=new JCalendar();
		calendar.setSize(220,220);
		calendar.setLocation(30,90);
		add(calendar);
		servicesChoice=new JComboBox<>(servicesNames.toArray(new String[0]));
		servicesChoice.setSize(210,40);
		servicesChoice.setLocation(320,100);
		add(servicesChoice);
		times=new JComboBox<>(timesNames.toArray(new String[0]));
		times.setSize(100,40);
		times.setLocation(320,190);
		add(times);
		bookAppointment=new JButton("Book Appointment");
		bookAppointment.setFont(new Font(fontType,Font.BOLD,14));
		bookAppointment.setBackground(new Color(0,0,0));
		bookAppointment.setForeground(new Color(255,203,230));
		bookAppointment.setSize(210,40);
		bookAppointment.setLocation(320,270);
		add(bookAppointment);
		bookAppointment.addActionListener(this);
		showAllAppointments = new JButton("Show Appointments");
		showAllAppointments.setFont(new Font(fontType,Font.BOLD,14));
		showAllAppointments.setBackground(new Color(0,0,0));
		showAllAppointments.setForeground(new Color(255,203,230));
		showAllAppointments.setSize(210,40);
		showAllAppointments.setLocation(80,600);
		add(showAllAppointments);
		showAllAppointments.addActionListener(this);
		getInvoice = new JButton("Get a bill");
		getInvoice.setFont(new Font(fontType,Font.BOLD,14));
		getInvoice.setBackground(new Color(0,0,0));
		getInvoice.setForeground(new Color(255,203,230));
		getInvoice.setSize(210,40);
		getInvoice.setLocation(320,600);
		add(getInvoice);
		getInvoice.addActionListener(this);
		text=new JTextArea();
		text.setText("");
		text.setBackground(Color.WHITE);
		text.setForeground(new Color(0,0,0));
		text.setSize(530,180);
		text.setLocation(30,390);
		add(text);
		text.addMouseListener(this);
		setSize(600,700);
		setLocation(400,10);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(new Color(255,203,230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
	}
	public static int checkAvailability(String date, String time) 
	{
		for(int i=0;i<appointments.size();i++)
		{
			if(date.equals(appointments.get(i).getDate()) && time.equals(appointments.get(i).getTime()))
				return -1;
		}
		return 1;
		
	}
	public static int checkRemoveAvailability(String username,String date, String time) {
		int index=search(username);
		List<Appointment> a;
		a=patients.get(index).getAppointments();
		for(int i=0;i<a.size();i++)
		{
			if((date.equals(a.get(i).getDate()))&&(time.equals(a.get(i).getTime())))
				return -1;
		}
		return 1;
		
	}
	public static int search(String u)
	{
		for(int i=0;i<patients.size();i++)
		{
			if(u.equals(patients.get(i).getUsername()))
				return i;
		}
		return -1;
	}
	public static void addAppointment(String u,Appointment a)
	{
		patients.get(search(u)).addToPatientApp(a);
	}
	
	public static void editAppointment(String username,String oldDate,String newDate,String oldTime,String newTime)
	{
		int index=search(username);
		for(int i=0;i<patients.get(index).getAppointments().size();i++)
		{
			if((oldDate.equals(patients.get(index).getAppointments().get(i).getDate()))&&
					(oldTime.equals(patients.get(index).getAppointments().get(i).getTime())))
			{
				patients.get(index).getAppointments().get(i).setDate(newDate);
				patients.get(index).getAppointments().get(i).setTime(newTime);
				break;
			}
		}
	}
	public static int checkIfAppointmentPassed(String date,String time)
	{
		int hour=Integer.parseInt(time.split(":")[0]);
		int minute=Integer.parseInt(time.split(":")[1]);
		/////////////////////////////////////////////////////////
		int day=Integer.parseInt(date.split("/")[0]);
		int month=Integer.parseInt(date.split("/")[1]);
		int year=Integer.parseInt(date.split("/")[2]);
		/////////////////////////////////////////////////////////////////
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		int currentDay=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[0]);
		int currentMonth=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[1]);
		int currentYear=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[2]);
		////////////////////////////////////////////////////////////////////////////////////////////////
		int currentHour=Integer.parseInt(dtf.format(now).split(" ")[1].split(":")[0]);
		int currentMinute=Integer.parseInt(dtf.format(now).split(" ")[1].split(":")[1]);
		//////////////////////////////////////////////////////////////////////////////////////////////
		if((currentDay>day)||(currentMonth>month)||(currentYear>year))
			return 1;
		else if((currentDay<day)||(currentMonth<month)||(currentYear<year))
			return -1;
		else if((currentDay==day)||(currentMonth==month)||(currentYear==year))
		{
			if((currentHour>=hour)&&(currentMinute>=minute))
				return 1;
			else
				return -1;
		}
		return -1;
				
	}
	public static void removeAppointment(String username,String date,String time)
	{
		int index=search(username);
		List<Appointment> a;
		a=patients.get(index).getAppointments();
		for(int i=0;i<a.size();i++)
		{
			if((date.equals(a.get(i).getDate()))&&(time.equals(a.get(i).getTime())))
			{
				patients.get(index).removeAppointment(i);
				break;
			}
		}
	}
	public static void changeAppointmentToVisit(String username,String date,String time)
	{
		for(int i=0;i<appointments.size();i++)
		{
			if( date.equals(appointments.get(i).getDate()) && 
					time.equals(appointments.get(i).getTime())
			   )
			{
				appointments.get(i).setStatus(1);
				break;
			}
		}
		int index=search(username);
		for(int i=0;i<patients.get(index).getAppointments().size();i++)
		{
			if( date.equals(patients.get(index).getAppointments().get(i).getDate()) && 
					time.equals(patients.get(index).getAppointments().get(i).getTime())
			  )
			{	
				patients.get(index).getAppointments().get(i).setStatus(1);
				patients.get(index).resortAppointmentRecords();
				break;
			}
		}
	}
	public static double invoiceForAVisit(String username,String date,String time)
	{
		int index=search(username);
		for(int i=0;i<patients.get(index).getAppointments().size();i++)
		{
			if( date.equals(patients.get(index).getAppointments().get(i).getDate()) && 
					time.equals(patients.get(index).getAppointments().get(i).getTime())
			  )
			{
				if(patients.get(index).getAppointments().get(i).getStatus()==1)
					return patients.get(index).getAppointments().get(i).getService().getPrice();
				else
					return -1;			}
		}
		return -1;
	}
	public static void main(String []args)
	{
		PatientMethods pm=new PatientMethods("Mira",0);
		pm.setVisible(true);
		
	}
	public static List<Patient> getPatients() {
		return patients;
	}
	public static List<Appointment> getAppointments() {
		return appointments;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bookAppointment)
		{
			String []months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			String day = calendar.getDate().toString().split(" ")[2];
			String month = calendar.getDate().toString().split(" ")[1];
			String year = calendar.getDate().toString().split(" ")[5];
			for(int i=0;i<months.length;i++)
			{
				if(months[i].equals(month))
				{
					month=""+(i+1);
					break;
				}
			}
			String date=day+"/"+month+"/"+year;
			String time=((String) times.getSelectedItem());
			int result=checkAvailability(date,time);
			if(result!=-1) 
			{
				Appointment a= new Appointment(date,time,0,AdminMethods.getServices().get(servicesChoice.getSelectedIndex()));
				appointments.add(a);
				patients.get(index).addToPatientApp(a);
				for(int i=0;i<patients.get(index).getAppointments().size();i++)
				{
					int res=checkIfAppointmentPassed(patients.get(index).getAppointments().get(i).getDate(),patients.get(index).getAppointments().get(i).getTime());
					if(res==1)
						patients.get(index).getAppointments().get(i).setStatus(1);
					else
						patients.get(index).getAppointments().get(i).setStatus(0);;
				}
				errorLabel.setForeground(new Color(45,161,37));
				errorLabel.setText("Appointment is added");
			}
			else
			{
				errorLabel.setForeground(Color.RED);
				errorLabel.setText("Appointment is unavailable");
			}
		}
		if(e.getSource()==showAllAppointments)
		{
			text.setText("");
			if(patients.get(index).getAppointments().isEmpty())
			{
				text.setText("No Available Appointments");
			}
			else {
				for(int i=0;i<patients.get(index).getAppointments().size();i++)
				{
					text.append("Appointment #"+(i+1)+"\n");
					text.append(patients.get(index).getAppointments().get(i).toString()+"\n\n");
				}
			}
		}
		if(e.getSource()==getInvoice)
		{
			String email = text.getText();
			String message="";
			Double price=0.0;
			for(int i=0;i<patients.get(index).getAppointments().size();i++)
			{
				message+=new StringBuilder("Appointment #"+(i+1)+"\n");
				message+=new StringBuilder(patients.get(index).getAppointments().get(i).toString()+"\n\n");
				price+=patients.get(index).getAppointments().get(i).getService().getPrice();
			}
			message+="\n\nYour total bill is "+price+" NIS\n\nThank you.";
			try {
				JavaEmailSender.sendMail(email,message);
			} catch (Exception e1) {
			}
			
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		text.setText("");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		text.setText("");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		text.setText("");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	public JCalendar getCalendar() {
		return calendar;
	}
	public JButton getBookAppointment() {
		return bookAppointment;
	}
	public JComboBox<String> getServicesChoice() {
		return servicesChoice;
	}
	public JComboBox<String> getTimes() {
		return times;
	}
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	public JButton getShowAllAppointments() {
		return showAllAppointments;
	}
	public JTextArea getText() {
		return text;
	}
	public JButton getGetInvoice() {
		return getInvoice;
	}
}
