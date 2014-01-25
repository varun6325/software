import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class employee extends Frame
{
  Connection cn;
  Statement st;
  ResultSet rs;
  String flag,code;
  TextField txt1,txt2,txt3,txt7,txt8;
  TextArea txta;
  Button bt1,bt2,bt3,bt4,bt5,bt6;
  Label lb1,lb2,lb3,lb5,sp1,sp2,sp3,sp4,lb7,lb8;
  GridBagLayout gl;
  GridBagConstraints gbc;
  employee()
  {
    setTitle("Employee Manager");
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      { 
        dispose();
      }
    });
    try
    {
      cn=DriverManager.getConnection("jdbc:odbc:air");
      st=cn.createStatement();
    }
    catch(Exception e)
    {
    }
    gl=new GridBagLayout();
    gbc=new GridBagConstraints();
    setLayout(gl);
    lb1=new Label("Enter Employee ID        ");
    txt1=new TextField(3);
    lb2=new Label("Enter Name       ");
    txt2=new TextField(30);
    lb3=new Label("Enter Department     ");
    txt3=new TextField(10);
    lb7=new Label("Enter Address     ");
    txt7=new TextField(20);
    lb8=new Label("Enter Phone no.     ");
    txt8=new TextField(10);
    lb5=new Label("Message");
    txta=new TextArea(2,30);
    sp1=new Label(" ");
    sp2=new Label(" ");
    sp3=new Label(" hello");
    sp4=new Label("hi ");
    bt1=new Button("Add");
    bt2=new Button("Modify");
    bt3=new Button("Delete");
    bt4=new Button("Save");
    bt5=new Button("Cancel");
    bt6=new Button("Close");
    gbc.anchor=GridBagConstraints.NORTHWEST;
    gbc.gridx=0;
    gbc.gridy=0;
    gl.setConstraints(lb1,gbc);
    add(lb1,gbc);
    gbc.gridx=1;
    gbc.gridy=0;
    gl.setConstraints(txt1,gbc);
    add(txt1,gbc);
    gbc.gridx=0;
    gbc.gridy=1;
    gl.setConstraints(lb2,gbc);
    add(lb2,gbc);
    gbc.gridx=1;
    gbc.gridy=1;
    gl.setConstraints(txt2,gbc);
    add(txt2,gbc);
    gbc.gridx=0;
    gbc.gridy=2;
    gl.setConstraints(lb3,gbc);
    add(lb3,gbc);
    gbc.gridx=1;
    gbc.gridy=2;
    gl.setConstraints(txt3,gbc);
    add(txt3,gbc);
    gbc.gridx=0;
    gbc.gridy=3;
    gl.setConstraints(lb7,gbc);
    add(lb7,gbc);
    gbc.gridx=1;
    gbc.gridy=3;
    gl.setConstraints(txt7,gbc);
    add(txt7,gbc);
    gbc.gridx=0;
    gbc.gridy=4;
    gl.setConstraints(lb8,gbc);
    add(lb8,gbc);
    gbc.gridx=1;
    gbc.gridy=4;
    gl.setConstraints(txt8,gbc);
    add(txt8,gbc);
//    gbc.gridx=0;
//    gbc.gridy=5;
//    gl.setConstraints(sp1,gbc);
//    add(sp1,gbc);
//    gbc.gridx=1;
//    gbc.gridy=5;
//    gl.setConstraints(sp2,gbc);
//    add(sp2,gbc);
    gbc.gridx=0;
    gbc.gridy=5;
    gl.setConstraints(bt1,gbc);
    add(bt1,gbc);
    gbc.gridx=1;
    gbc.gridy=5;
      gl.setConstraints(bt2,gbc);
    add(bt2,gbc);
    gbc.gridx=0;
    gbc.gridy=6;
    gl.setConstraints(bt3,gbc);
    add(bt3,gbc);
    gbc.gridx=1;
    gbc.gridy=6;
    gl.setConstraints(bt4,gbc);
    add(bt4,gbc);
    gbc.gridx=0;
    gbc.gridy=7;
    gl.setConstraints(bt5,gbc);
    add(bt5,gbc);
    gbc.gridx=1;
    gbc.gridy=7;
    gl.setConstraints(bt6,gbc);
    add(bt6,gbc);
//    gbc.gridx=0;
//    gbc.gridy=8;
//    gl.setConstraints(sp3,gbc);
//    add(sp3,gbc);
//    gbc.gridx=1;
//    gbc.gridy=8;
//    gl.setConstraints(sp4,gbc);
//    add(sp4,gbc);
//    gbc.gridx=0;
//    gbc.gridy=10;
//    gl.setConstraints(lb5,gbc);
//    add(lb5,gbc);
    gbc.gridx=0;
    gbc.gridy=8;
    gl.setConstraints(txta,gbc);
    add(txta,gbc);
    txta.setEditable(false);
    
    bt1.addActionListener(new BUT1());
    bt2.addActionListener(new BUT2());
    bt3.addActionListener(new BUT3());
    bt4.addActionListener(new BUT4());
    bt5.addActionListener(new BUT5());
    bt6.addActionListener(new BUT6());
    setSize(500,400);
    setVisible(true);
  }
  class BUT1 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      flag="add";
      try
        {
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          if(rs.next()==true)
          {
            txta.setText("Flight Code Allready Exists.");
            txt1.requestFocus();
            return;
          }
          else
          {
            st.executeUpdate("insert into flight values('" + txt1.getText() + "','" + txt2.getText() + "'," + Double.parseDouble(txt3.getText()) + ")");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txta.setText("");
            txt1.requestFocus();
          }
        }
        catch(Exception e1)
        {
        }
      
      txt1.setText("");
      txt2.setText("");
      txt3.setText("");
      txta.setText("");
      txt1.requestFocus();
    }
  }
  class BUT2 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      flag="mod";
      String str=txt1.getText();
      str=str.trim();
      if(str.length()<1 || str.length()>3)
      {
        txta.setText("First Enter Flight Code And Must Be Length Of 1 To 3 Character.");
        txt1.requestFocus();
        return;
      }
      try
      {
        rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
        if(rs.next()==false)
        {
          txta.setText("Flight Code Not Found.");
          txt1.requestFocus();
        }
        rs=st.executeQuery("Select * from ticket where fcode='" + txt1.getText() + "'");
        if(rs.next()==true)
        {
          txta.setText("Flight Code Is In Use.");
          txt1.requestFocus();
          return;
        }
        else
        {
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          rs.next();
          txt1.setText(rs.getString(1));
          txt2.setText(rs.getString(2));
          txt3.setText(Double.toString(rs.getDouble(3)));
          txta.setText("");
          txt1.requestFocus();
          code=txt1.getText();
        }
      }
      catch(Exception e1)
      {
      }
    }
  }
  class BUT3 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      flag="del";
      String str=txt1.getText();
      str=str.trim();
      if(str.length()<1 || str.length()>3)
      {
        txta.setText("First Enter Flight Code And Must Be Length Of 1 To 3 Character.");
        txt1.requestFocus();
        return;
      }
      try
      {
        rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
        if(rs.next()==false)
        {
          txta.setText("Flight Code Not Found.");
          txt1.requestFocus();
        }
        rs=st.executeQuery("Select * from ticket where fcode='" + txt1.getText() + "'");
        if(rs.next()==true)
        {
          txta.setText("Flight Code Is In Use.");
          txt1.requestFocus();
          return;
        }
        else
        {
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          rs.next();
          txt1.setText(rs.getString(1));
          txt2.setText(rs.getString(2));
          txt3.setText(Double.toString(rs.getDouble(3)));
          txta.setText("");
          txt1.requestFocus();
          code=txt1.getText();
        }
      }
      catch(Exception e1)
      {
      }
    }
  }
  class BUT4 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String str=txt1.getText();
      str=str.trim();
      if(str.length()<1 || str.length()>3)
      {
        txta.setText("Flight Code Must Be Length Of 1 To 3 Character.");
        txt1.requestFocus();
        return;
      }
      str=txt2.getText();
      str=str.trim();
      if(str.length()<1 || str.length()>30)
      {
        txta.setText("Flight Route Must Be Length Of 1 To 30 Character.");
        txt2.requestFocus();
        return;
      }
      str=txt3.getText();
      str=str.trim();
      if(str.length()<1 || str.length()>10)
      {
        txta.setText("Flight Fare Must Be Length Of 1 To 30 Character.");
        txt3.requestFocus();
        return;
      }
      try
      {
        if(Double.parseDouble(str)<1)
        {
          txta.setText("Flight Fare Must Be Numeric And > 1.");
          txt3.requestFocus();
          return;
        }
      }
      catch(Exception e2)
      {
        txta.setText("Flight Fare Must Be Numeric And > 1.");
        txt3.requestFocus();
        return;
      }
      if(flag=="add")
      {
        try
        {
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          if(rs.next()==true)
          {
            txta.setText("Flight Code Allready Exists.");
            txt1.requestFocus();
            return;
          }
          else
          {
            st.executeUpdate("insert into flight values('" + txt1.getText() + "','" + txt2.getText() + "'," + Double.parseDouble(txt3.getText()) + ")");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txta.setText("");
            txt1.requestFocus();
          }
        }
        catch(Exception e1)
        {
        }
      }
      else if(flag=="mod")
      {
        try
        {
          rs=st.executeQuery("Select * from ticket where fcode='" + code + "'");
          if(rs.next()==true)
          {
            txta.setText("Flight Code Is In Use.");
            txt1.requestFocus();
            return;
          }
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          if(rs.next()==true)
          {
            if(code.compareToIgnoreCase(rs.getString(1))!=0)
            {
              txta.setText("Flight Code Allready Exists.");
              txt1.requestFocus();
              return;
            }
            else
            {
              st.executeUpdate("delete * from flight where code='" + code + "'");
              st.executeUpdate("insert into flight values('" + txt1.getText() + "','" + txt2.getText() + "'," + Double.parseDouble(txt3.getText()) + ")");
              txt1.setText("");
              txt2.setText("");
              txt3.setText("");
              txta.setText("");
              txt1.requestFocus();
              code="";
            }
          }
          else
          {
            st.executeUpdate("delete * from flight where code='" + code + "'");
            st.executeUpdate("insert into flight values('" + txt1.getText() + "','" + txt2.getText() + "'," + Double.parseDouble(txt3.getText()) + ")");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txta.setText("");
            txt1.requestFocus();
            code="";
          }
        }
        catch(Exception e1)
        {
        }
      }
      else if(flag=="del")
      {
        try
        {
          rs=st.executeQuery("Select * from ticket where fcode='" + code + "'");
          if(rs.next()==true)
          {
            txta.setText("Flight Code Is In Use.");
            txt1.requestFocus();
            return;
          }
          rs=st.executeQuery("Select * from flight where code='" + txt1.getText() + "'");
          if(rs.next()==false)
          {
            txta.setText("Flight Code Not Found.");
            txt1.requestFocus();
            return;
          }
          else
          {
            st.executeUpdate("delete * from flight where code='" + code + "'");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txta.setText("");
            txt1.requestFocus();
          }
        }
        catch(Exception e1)
        {
        }
      }
    }
  }
  class BUT5 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      flag="";
      txt1.setText("");
      txt2.setText("");
      txt3.setText("");
      txta.setText("");
      txt1.requestFocus();
      code="";
    }
  }
  class BUT6 implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      dispose();
    }
  }

  public static void main(String args[])
  {
	new employee();
  }
}
