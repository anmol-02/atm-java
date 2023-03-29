package bank_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit ,withdrawl ,minista ,balanceen ,exit ,fastcash ,pinchange;
    String pinnum;
    FastCash(String pinnum){
        this.pinnum=pinnum;
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);


        JLabel text =new JLabel("Select Withdrawl Amount ");
        text.setBounds(180,290,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit =new JButton("RS 100");
        deposit.setBounds(140,370,140,26);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl =new JButton("RS 500");
        withdrawl.setBounds(310,370,140,26);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        minista =new JButton("RS 1000");
        minista.setBounds(310,400,140,26);
        minista.addActionListener(this);
        image.add(minista);


        balanceen =new JButton("RS 2000");
        balanceen.setBounds(310,430,140,26);
        balanceen.addActionListener(this);
        image.add(balanceen);

        exit =new JButton("Back");
        exit.setBounds(310,460,140,26);
        exit.addActionListener(this);
        image.add(exit);



        fastcash =new JButton("RS 5000");
        fastcash.setBounds(140,400,140,26);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pinchange =new JButton("RS 10000");
        pinchange.setBounds(140,430,140,26);
        pinchange.addActionListener(this);
        image.add(pinchange);

        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        } else {
          String amount =((JButton)ae.getSource()).getText().substring(3);

          try{
              Connec con =new Connec();
              ResultSet rs =con.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
              int balance=0;
              while (rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance+=Integer.parseInt(rs.getString("amount"));
                  }
                  else {
                      balance-=Integer.parseInt(rs.getString("amount"));
                  }
              }
              if(ae.getSource() !=exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null,"Insufficient Balance ");
                  return;
              }
              Date date =new Date();
              String query ="insert into bank (pin,date,type,amount) values('"+pinnum+"','"+date+"','Withdrawl','"+amount+"')";
              con.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null," RS"+amount+"Debited Sucessfully");
              setVisible(false);
              new Transaction(pinnum).setVisible(true);
          }catch (Exception e){
              System.out.println(e);
          }

        }

    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

