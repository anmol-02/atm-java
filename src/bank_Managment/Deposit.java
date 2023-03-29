package bank_Managment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    String pinnum;JTextField amount;
    Deposit(String pinnum){
      this.pinnum=pinnum;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text =new JLabel("Enter the amount you want to deposit");
        text.setBounds(160,270,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
         amount =new JTextField();
        amount.setBounds(150,320,300,22);
        amount.setFont(new Font("System",Font.BOLD,22));
        add(amount);

        deposit =new JButton("Deposit");
        deposit.setBounds(310,430,140,26);
        deposit.addActionListener(this);
        image.add(deposit);

        back =new JButton("Back");
        back.setBounds(310,460,140,26);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number =amount.getText();
            Date date =new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null," Please enter the amount you want to deposit");

            }
            else  {try{


                Connec conn=new Connec();
                String query="insert into bank (pin,date,type,amount) values('"+pinnum+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs  "+number+"  Deposit Succesfully");
                setVisible(false);
                new Transaction(pinnum).setVisible(true);
            }catch (Exception e){}
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
