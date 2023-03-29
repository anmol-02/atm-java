package bank_Managment;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
     String pinnum;
    MiniStatement(String pinnum){
        setTitle("Mini Statement ");
        setLayout(null);
        JLabel mini =new JLabel();
        add(mini);

        JLabel bank =new JLabel("ANMOL MINI TRANSECTION BANK ");
        bank.setFont(new Font("Raleway",Font.BOLD,22));
        bank.setBounds(70,20,400,30);
        add(bank);

        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance =new JLabel();
        balance.setBounds(20,450,500,20);
        balance.setFont(new Font("Raleway",Font.BOLD,22));
        add(balance);


        try{
            Connec c =new Connec();

            ResultSet cardNo = c.s.executeQuery("select * from logind where pinnumber='"+pinnum+"'");
            cardNo.next();
            card.setText("Card Number :"+cardNo.getString("cardnumber").substring(0,4) +"xxxxxxxx"+ cardNo.getString("cardnumber").substring(12));
            cardNo.close();
        }catch (Exception E){

            System.out.println(E);
        }

        try{
            Connec c =new Connec();
            int bal=0;
            ResultSet rs =c.s.executeQuery("select * from bank where pin ='"+pinnum+"'");

            while (rs.next()){

                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current account balance is RS "+bal);
            rs.close();

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Connec c =new Connec();
            ResultSet rs =c.s.executeQuery("select * from bank where pin  ='"+pinnum+"' order by id desc limit 5" );
            while (rs.next()){
            mini.setText(mini.getText() +"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }

            rs.close();

        }catch (Exception e){
            System.out.println(e);
        }

       mini.setBounds(20,140,400,200);
        setSize(500,800);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
