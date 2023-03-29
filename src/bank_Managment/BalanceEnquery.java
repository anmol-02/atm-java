package bank_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquery extends JFrame implements ActionListener {
    JButton back;
    String pinnum;
     BalanceEnquery(String pinnum){
         this.pinnum=pinnum;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0,0,800,800);
         add(image);

         back =new JButton("BCAK");
         back.setBounds(310,440,120,25);
         back.addActionListener(this);
         image.add(back);
         int balance=0;
         try{
             Connec con =new Connec();
             ResultSet rs =con.s.executeQuery("select * from bank where pin = '"+pinnum+"'");

             while (rs.next()){
                 if(rs.getString("type").equals("Deposit")){
                     balance+=Integer.parseInt(rs.getString("amount"));
                 }
                 else {
                     balance-=Integer.parseInt(rs.getString("amount"));
                 }
             }}catch (Exception e){
             System.out.println(e);
         }
         JLabel text =new JLabel("Your Current Account Balance is RS "+balance);
         text.setBounds(140,260,300,35);
         text.setFont(new Font("System",Font.BOLD,12));
         text.setForeground(Color.WHITE);
         image.add(text);

         setSize(800,800);
         setLocation(300,0);
         //setUndecorated(true);
         setVisible(true);

     }
     public  void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Transaction(pinnum).setVisible(true);
     }
    public static void main(String[] args) {
      new BalanceEnquery("");
    }
}
