package bank_Managment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    String pinnum;JTextField amount;
    Withdrawl(String pinnum){
        this.pinnum=pinnum;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text =new JLabel("Enter the amount you want to withdraw");
        text.setBounds(160,270,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        amount =new JTextField();
        amount.setBounds(150,320,300,22);
        amount.setFont(new Font("System",Font.BOLD,22));
        add(amount);

        withdraw =new JButton("Withdraw");
        withdraw.setBounds(310,430,140,26);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(ae.getSource()==withdraw){
            String number =amount.getText();
            Date date =new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null," Please enter the amount you want to Withdraw");

            }

            else  {try{
                Connec conn=new Connec();
                ResultSet rs =conn.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
                //
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                int withdrawAmountByUser = Integer.valueOf(number);

                if(withdrawAmountByUser <= balance){
                    String query="insert into bank  (pin,date,type,amount) values('"+pinnum+"','"+date+"','Withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs  "+number+"  Withdraw Succesfully");
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Cannot withdraw insuffecient balance");
                }

                //

//                String query="insert into bank values('"+pinnum+"','"+date+"','Withdraw','"+number+"')";
//                conn.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null,"Rs  "+number+"  Withdraw Succesfully");
//                setVisible(false);
//                new Transaction(pinnum).setVisible(true);
            }catch (Exception e){}
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}


