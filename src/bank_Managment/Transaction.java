package bank_Managment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
     JButton deposit ,withdrawl ,minista ,balanceen ,exit ,fastcash ,pinchange;
     String pinnum;
    Transaction(String pinnum){
        this.pinnum=pinnum;
        setLayout(null);


    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);


        JLabel text =new JLabel("Please Select Your Transaction");
        text.setBounds(180,290,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

         deposit =new JButton("Deposit");
        deposit.setBounds(140,370,140,26);
        deposit.addActionListener(this);
        image.add(deposit);

         withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setBounds(310,370,140,26);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        minista =new JButton("Mini Statement");
        minista.setBounds(310,400,140,26);
        minista.addActionListener(this);
        image.add(minista);


         balanceen =new JButton("Balance Enquery");
        balanceen.setBounds(310,430,140,26);
        balanceen.addActionListener(this);
        image.add(balanceen);

         exit =new JButton("Exit");
        exit.setBounds(310,460,140,26);
        exit.addActionListener(this);
        image.add(exit);



         fastcash =new JButton("Fast Cash ");
        fastcash.setBounds(140,400,140,26);
        fastcash.addActionListener(this);
        image.add(fastcash);

        pinchange =new JButton("Pin Change ");
        pinchange.setBounds(140,430,140,26);
        pinchange.addActionListener(this);
        image.add(pinchange);

        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
     if(ae.getSource()==exit){System.exit(0);
     } else if (ae.getSource()==deposit) {
         setVisible(false);
         new Deposit(pinnum).setVisible(true);
     } else if (ae.getSource()==withdrawl) {
         setVisible(false);
         new Withdrawl(pinnum).setVisible(true);
     } else if (ae.getSource()==fastcash) {
         setVisible(false);
         new FastCash(pinnum).setVisible(true);
     } else if (ae.getSource()==pinchange) {
         setVisible(false);
         new PinChange(pinnum).setVisible(true);
     }
     else if (ae.getSource()==balanceen) {
         setVisible(false);
         new BalanceEnquery(pinnum).setVisible(true);
     }
     else if (ae.getSource()==minista) {

         new MiniStatement(pinnum).setVisible(true);
     }

    }
    public static void main(String[] args) {
    new Transaction("");
    }
}
