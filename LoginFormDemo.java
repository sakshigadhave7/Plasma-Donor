import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;
import java.sql.*;   
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener
{  

   String url = "jdbc:mysql://localhost:3306/plasmaDonor"; 
 	 	String uname = "root"; 
 	 	String pass = "Sakshi@7"; 
 	 	
 	 
 	 	Connection con = null; 

	
    //initialize button, panel, label, and text field  
    JButton b1,b2,b3;  
 
    private Container c;  
    private JLabel userLabel, passLabel,title;  
    private JTextField  textField1, textField2;
   
    //calling constructor  
    CreateLoginForm()  
    {     
    
  
    setTitle("Registration for Plasma Donation");
		setBounds(300, 90, 900, 600);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
		
		title = new JLabel("Login");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(410, 30);
		c.add(title);
		
		userLabel = new JLabel("Aadhar No");
		userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		userLabel.setSize(120, 20);
		userLabel.setLocation(300, 100);
		c.add(userLabel);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField1.setSize(160, 20);
		textField1.setLocation(450, 100);
		c.add(textField1);
		
		
		passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		passLabel.setSize(120, 20);
		passLabel.setLocation(300, 130);
		c.add(passLabel);

		textField2 = new JPasswordField();
		textField2.setFont(new Font("Arial", Font.PLAIN, 15));
		textField2.setSize(160, 20);
		textField2.setLocation(450, 130);
		c.add(textField2);
		
		
		b1 = new JButton("Login");
		b1.setFont(new Font("Arial", Font.PLAIN, 15));
		b1.setSize(120, 20);
		b1.setLocation(200,200);
		c.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Register");
		b2.setFont(new Font("Arial", Font.PLAIN, 15));
		b2.setSize(120, 20);
		b2.setLocation(400, 200);
		c.add(b2);
		b2.addActionListener(this);
		
		
   		b3 = new JButton("View Records");
		b3.setFont(new Font("Arial", Font.PLAIN, 15));
		b3.setSize(160, 20);
		b3.setLocation(570, 200);
		c.add(b3);
		b3.addActionListener(this);

 
  
          
       
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
	    if(ae.getSource() == b1)
	    {
		
		   
		   try
		   {
				Class.forName("com.mysql.jdbc.Driver"); 
				con = DriverManager.getConnection(url,uname,pass);
				System.out.println("Connected");
				
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery("SELECT * FROM donorReg");
				  while(rs.next()) 
				  {
					  String aadharNo = rs.getString("aadharNo");
					  String donorPassword = rs.getString("donorPassword");

				    		if(textField1.getText().equals(aadharNo) && textField2.getText().equals(donorPassword))
				    		{
						  JOptionPane.showMessageDialog(null,"Looged in");
						    //move on to homepage if user is valid
						    //MyFrame myFrane = new MyFrame();  
						    
							  String adhar = rs.getString("aadharNo");
							MyFrame myFrame = new MyFrame("login",adhar);
						     	
							myFrame.setVisible(true); 
						    
						     
						  }else if(!rs.next()){
						  //show error message  
					    		System.out.println("Please enter valid username and password");  
					     		JOptionPane.showMessageDialog(null,"Invalid Credentials");
						  
						  }
						 
			    
					    	
					    		
					 		
					
		   		    }
		   		    
						  
						  
						  
		}
		catch(Exception er)
				{
					System.out.println(er.getMessage()); 
				}  
			
		    } 
		    else if(ae.getSource() == b2)
		    {
		     	    	//MyFrame page = new MyFrame();  
						    
				String text = "Registration";
				MyFrame myFrame = new MyFrame(text,"1");
				myFrame.setLocationRelativeTo(null);		     
				myFrame.setVisible(true); 
		    }
		    else if(ae.getSource() == b3)
		    {
		     	    MyRecords R = new MyRecords();  
			      
			    //make page visible to the user  
			    R.setVisible(true); 
			    
			   setSize(900, 600);
				setLocationRelativeTo(null);  

		    }
		    
		    
		} 
}
//create the main class  
class LoginFormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {    	 	 	
 	 	 	
        try  
        {  
        
       	
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(900,600);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user 
	    form.setResizable(false);
            
            
             
        }  catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
 }
