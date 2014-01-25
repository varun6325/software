import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.text.*;

public class intro extends JFrame
{
	Container c=getContentPane();
	JPanel Header= new JPanel();
	JPanel PLogin = new JPanel(null);
	JLabel LAirline= new JLabel("<html><B><h1><center>Airline</center><br><center> Reservation<center><br><center>System<center</h1></B></html>");
	JLabel LUserName, LPassword;

	JTextField TFUserName;
	JPasswordField TPPassword;

	JButton BLogin;

	public intro()
	{
		//WindowUtilities.setNativeLookAndFeel();
		setPreferredSize(new Dimension(796,572));
		PLogin.setBackground(Color.white);
		Header.setBackground(Color.white);
		Header.setBounds(0,0,600, 200);
		PLogin.setBounds(0,200,600, 400);
		LUserName = new JLabel("         User Name ");
		LPassword = new JLabel("         Password ");
		TFUserName = new JTextField(18);
		TPPassword = new JPasswordField(18);
		BLogin = new JButton("Sign In");

		LAirline.setBounds(150,75,450,175);

		LUserName.setBounds(200, 100, 100, 30);
		LPassword.setBounds(200, 170, 100, 30);
		TFUserName.setBounds(400, 100, 100, 30);
		TPPassword.setBounds(400, 170, 100, 30);
		BLogin.setBounds(300, 240, 100,30);

		c.add(PLogin);
		c.add(Header);

		PLogin.add(LUserName);
		PLogin.add(TFUserName);
		PLogin.add(LPassword);
		PLogin.add(TPPassword);
		PLogin.add(BLogin);

		Header.add(LAirline);

		pack();
		setVisible(true);

		
		BLogin.addActionListener(new button5(this));
	}
	
	public static void main(String args[])
	{
		new intro();
	}
}

class button5 implements ActionListener
{
	intro type;
	char[] cCheck, cPassword={'d','e','m','o','\0'};
	JFrame f;
	String sCheck,sCheck1="demo";

	public button5(intro type)
	{
		this.type = type;
	}
	public void actionPerformed(ActionEvent e)
	{
		cCheck=type.TPPassword.getPassword();
		sCheck = type.TFUserName.getText();
		if ((sCheck1.equals(sCheck)) && check())
		{
			/*type.PLogin.add(type.LDomesticFlight1);
			type.PLogin.add(type.LInternationalFlight1);

			type.PLogin.remove(type.LUserName);
			type.PLogin.remove(type.TFUserName);
			type.PLogin.remove(type.LPassword);
			type.PLogin.remove(type.TPPassword);
			type.PLogin.remove(type.BLogin);

			type.c.repaint();*/
			//new DomesticFlight();
			new airline();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid username or password. Try again");
		}
	}
	public boolean check()
	{
		if (cCheck.length >= 5 || cCheck.length < 4)
			return false;
		for(int i=0;i<4;i++)
		{
			if(cCheck[i]!=cPassword[i])
				return false;
		}
		return true;
	}
}
	