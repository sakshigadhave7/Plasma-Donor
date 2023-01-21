import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
class MyFrame
	extends JFrame
	implements ActionListener {
	
	String url = "jdbc:mysql://localhost:3306/plasmaDonor"; 
 	 	String uname = "root"; 
 	 	String pass = "Sakshi@7"; 
 	 	
 	 
 	 	Connection con = null; 	
 	 	 
	String data1="", data2="" , data3="" , data4="", data5="", data6="", data7="", data8="", data9="", data10="";
	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel add;
	private JTextField tadd;
	private JCheckBox term;
	//private JButton sub;
	private JButton reset;
	private JButton update;
	private JButton reg;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;
	
	private JLabel adharNo;
	private JTextField tAdharNo;
	private JLabel bloodGroup;
	private JComboBox tBloodGroup;
	private JLabel recoveredCovid;
	private JRadioButton rcYes;
	private JRadioButton rcNo;
	private ButtonGroup RcGroupBtn;
	private JLabel vaccinated;
	private JRadioButton vacYes;
	private JRadioButton vacNo;
	private ButtonGroup VcGroupBtn;
	private JLabel password;
	private JTextField tPassword;
	private JButton logout;
	private JButton rBack;
	private JTextField tAge;

	/*private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
			
			
			
	
	private String months[]
		= { "Jan", "feb", "Mar", "Apr",
			"May", "Jun", "July", "Aug",
			"Sup", "Oct", "Nov", "Dec" };
	private String years[]
		= { "1995", "1996", "1997", "1998",
			"1999", "2000", "2001", "2002",
			"2003" };
			
			*/
			
			
	private String StringbloodGroup[]
		={"A+","A-","B+","B-","AB+","AB-","O+","O-"};

	// constructor, to initialize the components
	// with default values.
	public MyFrame(String type, String aadhar)
	{	
			
		String Type = type;
		String Aadhar = aadhar;
		
		
		 setDefaultCloseOperation(javax.swing.
 		WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Registration for Plasma Donation");
		setBounds(300, 90, 900, 600);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
		
		

		title = new JLabel("Registration Form");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);
		
		
		rBack = new JButton("Back");
		rBack.setFont(new Font("Arial", Font.PLAIN, 10));
		rBack.setSize(70, 20);
		rBack.setLocation(10, 20);
		rBack.addActionListener(this);
		c.add(rBack);
		
		
		name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(70, 20);
		name.setLocation(70, 70);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(160, 20);
		tname.setLocation(170, 70);
		c.add(tname);

		mno = new JLabel("Mobile");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(70, 20);
		mno.setLocation(70, 100);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setSize(160, 20);
		tmno.setLocation(170, 100);
		c.add(tmno);

		gender = new JLabel("Gender ");
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		gender.setSize(120, 20);
		gender.setLocation(70, 140);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(70, 20);
		male.setLocation(170, 140);
		c.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(240, 140);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		dob = new JLabel("Age");
		dob.setFont(new Font("Arial", Font.PLAIN, 20));
		dob.setSize(70, 20);
		dob.setLocation(70, 180);
		c.add(dob);

		tAge = new JTextField();
		tAge.setFont(new Font("Arial", Font.PLAIN, 15));
		tAge.setSize(160, 20);
		tAge.setLocation(160, 180);
		c.add(tAge);
		
	/*	date = new JComboBox(dates);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setSize(40, 20);
		date.setLocation(160, 180);
		c.add(date);

		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(50, 20);
		month.setLocation(220, 180);
		c.add(month);

		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(70, 20);
		year.setLocation(280, 180);
		c.add(year);
	*/
		add = new JLabel("City");
		add.setFont(new Font("Arial", Font.PLAIN, 20));
		add.setSize(70, 20);
		add.setLocation(70, 220);
		c.add(add);

		tadd = new JTextField();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(160, 20);
		tadd.setLocation(160, 220);
		//tadd.setLineWrap(true);
		c.add(tadd);
		
		adharNo = new JLabel("Aadhar No");
		adharNo.setFont(new Font("Arial", Font.PLAIN, 20));
		adharNo.setSize(120, 20); 
		adharNo.setLocation(40, 250);
		c.add(adharNo);
		
		tAdharNo = new JTextField();
		tAdharNo.setFont(new Font("Arial", Font.PLAIN, 15));
		tAdharNo.setSize(160, 20);
		tAdharNo.setLocation(160, 250);
		c.add(tAdharNo);
		
		bloodGroup = new JLabel("Blood Group");
		bloodGroup.setFont(new Font("Arial", Font.PLAIN, 20));
		bloodGroup.setSize(160, 20);
		bloodGroup.setLocation(30, 280);
		c.add(bloodGroup);
		
		tBloodGroup = new JComboBox(StringbloodGroup);
		tBloodGroup.setFont(new Font("Arial", Font.PLAIN, 15));
		tBloodGroup.setSize(120, 20);
		tBloodGroup.setLocation(160, 280);
		c.add(tBloodGroup);
		
		
		recoveredCovid = new JLabel("Recovered Covid19");
		recoveredCovid.setFont(new Font("Arial", Font.PLAIN, 20));
		recoveredCovid.setSize(200, 20);
		recoveredCovid.setLocation(10, 310);
		c.add(recoveredCovid);

		rcYes = new JRadioButton("Yes");
		rcYes.setFont(new Font("Arial", Font.PLAIN, 15));
		rcYes.setSelected(true);
		rcYes.setSize(70, 20);
		rcYes.setLocation(240, 310);
		c.add(rcYes);

		rcNo = new JRadioButton("No");
		rcNo.setFont(new Font("Arial", Font.PLAIN, 15));
		rcNo.setSelected(false);
		rcNo.setSize(90, 20);
		rcNo.setLocation(310, 310);
		c.add(rcNo);
		
		RcGroupBtn = new ButtonGroup();
		RcGroupBtn.add(rcYes);
		RcGroupBtn.add(rcNo);
		
		
		vaccinated = new JLabel("Vaccinated Covid19");
		vaccinated.setFont(new Font("Arial", Font.PLAIN, 20));
		vaccinated.setSize(240, 20);
		vaccinated.setLocation(10, 340);
		c.add(vaccinated);

		vacYes = new JRadioButton("Yes");
		vacYes.setFont(new Font("Arial", Font.PLAIN, 15));
		vacYes.setSelected(true);
		vacYes.setSize(70, 20);
		vacYes.setLocation(240, 340);
		c.add(vacYes);

		vacNo = new JRadioButton("No");
		vacNo.setFont(new Font("Arial", Font.PLAIN, 15));
		vacNo.setSelected(false);
		vacNo.setSize(90, 20);
		vacNo.setLocation(310, 340);
		c.add(vacNo);
		
		VcGroupBtn = new ButtonGroup();
		VcGroupBtn.add(vacYes);
		VcGroupBtn.add(vacNo);
		

		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(280, 20);
		password.setLocation(40, 370);
		c.add(password);
		
		tPassword = new JTextField();
		tPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tPassword.setSize(160, 20);
		tPassword.setLocation(160, 370);
		c.add(tPassword);
	
		reg = new JButton("Register");
		reg.setFont(new Font("Arial", Font.PLAIN, 20));
		reg.setSize(160, 20);
		reg.setLocation(160, 450);
		reg.addActionListener(this);
		c.add(reg);

		
	

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 500);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);
		
		
		if(Type=="login")
		{
			try{
		Class.forName("com.mysql.jdbc.Driver"); 
		con = DriverManager.getConnection(url,uname,pass);
		System.out.println("Connected from login");
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM donorReg where aadharNo = ?");
		ps.setString(1,Aadhar);
		ResultSet rs = ps.executeQuery();
		 while(rs.next()) 
		 {
		 	String AADHAR = rs.getString("aadharNo");
		 	String NAME = rs.getString("donorName");
		 	String MOBILE = rs.getString("donorMobile");
		 	String DOB = rs.getString("donorDOB");
		 	String CITY = rs.getString("donorCity");
		 	String BLOODGROUP = rs.getString("donorBloodGrp");
		 	String RECOVERED = rs.getString("donorRecovered");
		 	String VACCINATED = rs.getString("donorVaccinated");
		 	String GENDER = rs.getString("donorGeneder");
		 	String PASSWORD = rs.getString("donorPassword");
		 	int AGE = rs.getInt("donorDob");
		 	
		 	System.out.println(AADHAR);
		 	System.out.println(NAME);
		 	System.out.println(MOBILE);
		 	System.out.println(DOB);
		 	System.out.println(CITY);
		 	System.out.println(BLOODGROUP);
		 	System.out.println(RECOVERED);
		 	System.out.println(VACCINATED);
		 	System.out.println(GENDER);
		 	
		 	tname.setText(NAME);
			//tmno.setText(String.valueOf(MOBILE));  
		 	tmno.setText(MOBILE);
		 	if(RECOVERED.equals("Yes"))
		 	{
		 		rcYes.setSelected(true) ;
		 	}
		 	else{
		 	rcNo.setSelected(true);
		 	}
		 	if(VACCINATED.equals("Yes"))
		 	{
			vacYes.setSelected(true) ;
		 	}
		 	else{
		 	vacNo.setSelected(true);
		 	}
		 	if(GENDER.equals("Male"))
		 	{
		 	male.setSelected(true);
		 	}else{
		 	female.setSelected(true);
		 	}
		 	tadd.setText(CITY);
		 	//tAdharNo.setText(String.valueOf(AADHAR));  
		 	tAdharNo.setText(AADHAR);
		 	if(BLOODGROUP.equals("A+"))
		 	{
		 	tBloodGroup.setSelectedItem("A+");
		 	}
		 	else if(BLOODGROUP.equals("A-"))
		 	{
		 	tBloodGroup.setSelectedItem("A-");
		 	}
		 	else if(BLOODGROUP.equals("B+"))
		 	{
		 	tBloodGroup.setSelectedItem("B+");
		 	}else if(BLOODGROUP.equals("B-"))
		 	{
		 	tBloodGroup.setSelectedItem("B-");
		 	}
		 	else if(BLOODGROUP.equals("O+"))
		 	{
		 	tBloodGroup.setSelectedItem("O+");
		 	}else if(BLOODGROUP.equals("O-"))
		 	{
		 	tBloodGroup.setSelectedItem("O-");
		 	}
		 	else if(BLOODGROUP.equals("AB+"))
		 	{
		 	tBloodGroup.setSelectedItem("AB+");
		 	}
		 	else if(BLOODGROUP.equals("AB-"))
		 	{
		 	tBloodGroup.setSelectedItem("AB-");
		 	}
		 	tPassword.setText(PASSWORD);
		 	tAge.setText(String.valueOf(AGE));  
		 	
		 	reset = new JButton("Delete");
			reset.setFont(new Font("Arial", Font.PLAIN, 15));
			reset.setSize(100, 20);
			reset.setLocation(150, 450);
			reset.addActionListener(this);
			c.add(reset);
			
			update = new JButton("Update");
			update.setFont(new Font("Arial", Font.PLAIN, 15));
			update.setSize(100, 20);
			update.setLocation(270, 450);
			update.addActionListener(this);
			c.add(update);
			
			logout = new JButton("Logout");
			logout.setFont(new Font("Arial", Font.PLAIN, 15));
			logout.setSize(100, 20);
			logout.setLocation(30, 450);
			logout.addActionListener(this);
			c.add(logout);
			
			reg.setVisible(false);
			rBack.setVisible(false);
			
			
		 	
		 }
		
		
		}catch(Exception b){System.out.println(b);}
		}

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == reg) 
		{
		try{
		Class.forName("com.mysql.jdbc.Driver"); 
		con = DriverManager.getConnection(url,uname,pass);
		System.out.println("Connected");
		
		String BG = tBloodGroup.getSelectedItem().toString();
		PreparedStatement ps = con.prepareStatement("insert into donorReg values(?,?,?,?,?,?,?,?,?,?)");
		
		
		//ps.setInt(1,Integer.parseInt(tAdharNo.getText()));
		ps.setString(1,tAdharNo.getText());
		ps.setString(2,tname.getText());
		//ps.setInt(3,Integer.parseInt(tmno.getText()));
		ps.setString(3,tmno.getText());
		//ps.setString(4,date.getSelectedItem()+"/"+month.getSelectedItem()+"/"+year.getSelectedItem());
		ps.setInt(4,Integer.parseInt(tAge.getText()));
		ps.setString(5,tadd.getText());
		ps.setString(6,BG);
		if(rcYes.isSelected())
		{
			ps.setString(7,"Yes");
		}
		else
		{
			ps.setString(7,"No");
		}
		if(vacYes.isSelected())
		{
			ps.setString(8,"Yes");
		}
		else
		{
			ps.setString(8,"No");
		}
			ps.setString(9,tPassword.getText());
			
			if(male.isSelected())
			{
			ps.setString(10,"Male");
			}
			else
			{
			ps.setString(10,"Female");
			}
			
			ps.execute();
			JOptionPane.showMessageDialog(null,"You are registered succesfully");
			
			data1 = "Name : " + tname.getText();
			data2 = "Contact No. : " + tmno.getText();
			if(male.isSelected())
			{
			data3 = "Gender : Male";
			}else{
			data3 = "Gender : Female";
			}
			/*data4 = "DOB : "
                      + (String)date.getSelectedItem()
                      + "/" + (String)month.getSelectedItem()
                      + "/" + (String)year.getSelectedItem();*/
                      data4 = "Age : " + tAge.getText();
                      
                      data5 = "City : " + tadd.getText();
                      data6 = "Aadhar Number : " + tAdharNo.getText();
                      data7 = "Blood Group : " + BG;
		      if(rcYes.isSelected())
		      {
		       data8 = "Recovered From Covid-19 : Yes";  
		      }else{
		      data8 = "Recovered From Covid-19 : No";  
		      }   
		      if(vacYes.isSelected())
		      {
		       data9 = "Vaccinated for Covid-19: Yes";  
		      }else{
		      data9 = "Vaccinated for Covid-19 : No";  
		      }  
		      data10 = "Password : " + tPassword.getText();         
			
			tout.setText("\n" + data1 + "\n" + data2 + "\n" + data3 + "\n" + data4 + "\n" + data5 + "\n" + data6 + "\n" + data7 + "\n" + data8 + "\n" + data9 + "\n" + data10);
			
			
		
				
		System.out.println("Succsessful");
				
		}
		
		
		
		catch(Exception ee)
		{
			System.out.println(ee.getMessage()); 
		}
		
		
				
	}

		else if(e.getSource() == reset) {
		String sql = "delete from donorReg where aadharNo=?";
		try (Connection conn = DriverManager.getConnection(url, uname, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);)
			 {
			 stmt.setInt(1, Integer.parseInt(tAdharNo.getText()));
			 stmt.execute();
			 
			  JOptionPane.showMessageDialog(null,"Deleted succesfully");
			  
			  CreateLoginForm log = new CreateLoginForm();
			  log.setVisible(true);
			 
		System.out.println("Deleted successfully");
		}catch (SQLException s) {
		      s.printStackTrace();
		    }
		
		
		
		}
		
		else if(e.getSource() == update)
		{
			//String BG = tBloodGroup.getSelectedItem().toString();
			String sql = "update donorReg set donorName=? ,donorMobile=? ,donorCity=? ,donorBloodGrp=? ,donorRecovered=? ,donorVaccinated=? ,donorPassword=? ,donorGeneder=? ,donorDob=? where aadharNo=?";
			try (Connection conn = DriverManager.getConnection(url, uname, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);)
			 {
		      	stmt.setString(1, tname.getText());
		      	//stmt.setInt(2, Integer.parseInt(tmno.getText()));
		      	stmt.setString(2, tmno.getText());
		      	stmt.setString(3, tadd.getText());
		      	stmt.setString(4, tBloodGroup.getSelectedItem().toString());
		        if(rcYes.isSelected()){
		        stmt.setString(5, "Yes");
		        }else{
		        stmt.setString(5, "No");
		      	}
		      	if(vacYes.isSelected()){
		        stmt.setString(6, "Yes");
		        }else{
		        stmt.setString(6, "No");
		      	}
		      	stmt.setString(7, tPassword.getText());
		      	if(male.isSelected())
		      	{
		      	stmt.setString(8,"Male");
		      	}else{
		      	stmt.setString(8,"Female");
		      	}
		      	stmt.setInt(9, Integer.parseInt(tAge.getText()));
		      //	stmt.setInt(10, Integer.parseInt(tAdharNo.getText()));
			stmt.setString(10, tAdharNo.getText());
		      	stmt.executeUpdate();
		      	
		      	JOptionPane.showMessageDialog(null,"Updated Successfully");
		      	
		      	data1 = "Name : " + tname.getText();
			data2 = "Contact No. : " + tmno.getText();
			if(male.isSelected())
			{
			data3 = "Gender : Male";
			}else{
			data3 = "Gender : Female";
			}
			/*data4 = "DOB : "
                      + (String)date.getSelectedItem()
                      + "/" + (String)month.getSelectedItem()
                      + "/" + (String)year.getSelectedItem();*/
                      data4 = "Age : " + tAge.getText();
                      
                      data5 = "City : " + tadd.getText();
                      data6 = "Aadhar Number : " + tAdharNo.getText();
                      data7 = "Blood Group : " + tBloodGroup.getSelectedItem().toString();
		      if(rcYes.isSelected())
		      {
		       data8 = "Recovered From Covid-19 : Yes";  
		      }else{
		      data8 = "Recovered From Covid-19 : No";  
		      }   
		      if(vacYes.isSelected())
		      {
		       data9 = "Vaccinated for Covid-19: Yes";  
		      }else{
		      data9 = "Vaccinated for Covid-19 : No";  
		      }  
		      data10 = "Password : " + tPassword.getText();         
			
			tout.setText("\n" + data1 + "\n" + data2 + "\n" + data3 + "\n" + data4 + "\n" + data5 + "\n" + data6 + "\n" + data7 + "\n" + data8 + "\n" + data9 + "\n" + data10);
			
		      
		      	System.out.println("Database updated successfully ");
		    } catch (SQLException t) {
		      t.printStackTrace();
		    }
					
				
		}
	
	else if(e.getSource() == logout)
		{
			CreateLoginForm m = new CreateLoginForm();
			m.setVisible(true);
		}
		
	else if(e.getSource() == rBack)
	{
		CreateLoginForm mm = new CreateLoginForm();
		mm.setVisible(true);
	}
		
	}
	
	
}

