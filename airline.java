import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.text.*;

public class airline extends JFrame
{
	Container c=getContentPane();
	JPanel Header= new JPanel();
	JPanel Content=new JPanel();
	JLabel LAirline= new JLabel("<html><B><p size=24px>What Do You Want</h1></p></html>");
	JLabel s1=new JLabel( "<html><h1><B><center>Enter</center><br><center> Your</center><br><center> Choice</center></B></h1></html>");
	JButton MantainFlightDetails;
	JButton MantainEmployeeDetails;
	JButton Reservation;
	
	public airline()
	{
		
		WindowUtilities.setNativeLookAndFeel();
		setPreferredSize(new Dimension(300,350));
		//setBounds(0,0,400,400);

		//Header.setBounds(0,0,790,200);
		Content.setBounds(0,200,790,350);

		//Header.setBackground(Color.white);
		Content.setBackground(Color.white);
		

		//LAirline.setBounds(0,0,740,200);
		//Header.add(LAirline);

		MantainFlightDetails=new JButton("Mantain Flight Details");
		MantainEmployeeDetails=new JButton("Mantain Employee Details");
		Reservation=new JButton("Reservation");

		MantainFlightDetails.setBounds(250,300,100,30);
		MantainEmployeeDetails.setBounds(400,300,100,30);
		Reservation.setBounds(300,380,100,30);
		s1.setBounds(0,0,800,150);

		Content.add(s1);
		Content.add(MantainFlightDetails);
		Content.add(MantainEmployeeDetails);
		Content.add(Reservation);
//		c.add(Header);
		c.add(Content);

		pack();
		setVisible(true);

		MantainFlightDetails.addActionListener(new button1());
		MantainEmployeeDetails.addActionListener(new button2());
		Reservation.addActionListener(new button3());

	}

	public static void main(String args[])
	{
		new airline();
	}
}
			
class button1 implements ActionListener
{
	//new flight();
	//System.out.println("bye");	
	public void actionPerformed(ActionEvent e)
    {
     new flight();
    }
}

class button2 implements ActionListener
{
//	System.out.println("bye");
	public void actionPerformed(ActionEvent e)
    {
      new employee();
    }
}

class button3 implements ActionListener
{
//	System.out.println("bye");
	//new LoginPage();
	public void actionPerformed(ActionEvent e)
    {
      new LoginPage();
    }
}		
		