import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
class MyRecords extends JFrame implements ActionListener
{
	private JButton back;
	
	private boolean status;

	public MyRecords() {
	
		setDefaultCloseOperation(javax.swing.
 		WindowConstants.DISPOSE_ON_CLOSE);

		// Creating Window using JFrame
		JFrame frame = new JFrame();
		frame.setTitle("Plasma Donor Details");
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		
		back = new JButton("Back");
		back.setFont(new Font("Arial", Font.PLAIN, 20));
		back.setSize(100, 20);
		back.setLocation(12, 530);
		back.addActionListener(this);
		
		
		frame.add(back);
		// Adding Table View
		frame.add(getTablePanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private JPanel getTablePanel() {

		JPanel tableJPanel = new JPanel();
		
		tableJPanel.setLayout(new BorderLayout());
		
		// Column Header
		String[] columns = {

		" Aadhar No.", "Name", "Contact No.",
				"City", "Blood Group", "Recovered from covid-19", "Vaccinated" };

		// Getting Data for Table from Database
		Object[][] data = MyRecords();

		// Creating JTable object passing data and header
		JTable donorTable = new JTable(data, columns);
		
		
		tableJPanel.add(donorTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(donorTable, BorderLayout.CENTER);
		
		return tableJPanel;
	}

	private Object[][] MyRecords() {

		Object[][] data = null;

		final String DRIVER_NAME = "com.mysql.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/plasmaDonor";
		final String USERNAME = "root";
		final String PASSWORD = "Sakshi@7";

		final String QUERY = "Select aadharNo, donorName, donorMobile, donorCity, donorBloodGrp, donorRecovered, donorVaccinated from donorReg";

		try {

			// Loading the Driver
			Class.forName(DRIVER_NAME);

			// Getting Database Connection Object by Passing URL, Username and Password
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

			System.out.println("connected");
			//Statement statement = connection.createStatement();
			
			PreparedStatement pstat=connection.prepareStatement(QUERY,
                            ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = pstat.executeQuery(QUERY);

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getString("aadharNo");
				data[i][j++] = rs.getString("donorName");
				data[i][j++] = rs.getString("donorMobile");
				data[i][j++] = rs.getString("donorCity");
				data[i][j++] = rs.getString("donorBloodGrp");
				data[i][j++] = rs.getString("donorRecovered");
				data[i][j++] = rs.getString("donorVaccinated");

				i++;
			}

			status = true;
			
			// Closing the Resources;
			pstat.close();
			connection.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

	// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public String toString() {
		
		return (status) ? "Data Listed Successfully" : "Application Error Occured";
	}
	
public void actionPerformed(ActionEvent q)
	{
		if (q.getSource() == back) 
		{
		
			CreateLoginForm cf = new CreateLoginForm();
			cf.setVisible(true); 
			cf.setResizable(false);
			cf.setSize(900,600);	
						
		}
	}
	
}
