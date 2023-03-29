package bank_Managment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,sign;
    JTextField cardTextField;   JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setTitle("Automated Tailor Machine");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(180,20,75,75);


        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("b.jpeg"));
        Image ii2=ii1.getImage().getScaledInstance(518,333,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel image =new JLabel(ii3);
        image.setBounds(40,120,518,333);
        add(image);
//
//        ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("bla.jpeg"));
//        Image iii2=iii1.getImage().getScaledInstance(500,332,Image.SCALE_DEFAULT);
//        ImageIcon iii3=new ImageIcon(iii2);
//        JLabel image1 =new JLabel(iii3);
//        image1.setBounds(590,150,500,232);
//        add(image1);




        // with the help of  this i can write a text "Welcome to ATM"
        JLabel text=new JLabel("Welcome to ATM");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Monospaced", Font.ITALIC, 35));// set font
        text.setBounds(290,30,400,50);// set position
        add(text);// add in gui

         // with the help of this i can write card no in display
        JLabel cardNO=new JLabel("Card NO :");
        cardNO.setForeground(Color.BLACK);
        cardNO.setFont(new Font("Raleway",Font.BOLD,28));// set font
        cardNO.setBounds(600,140,400,40);// set position in display

     add(cardNO);// add in display

         cardTextField = new JTextField();
        cardTextField.setBounds(800,130,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
      add(cardTextField);

        JLabel pin=new JLabel("Pin Code :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(600,190,400,40);

    add(pin);

         pinTextField = new JPasswordField();
        pinTextField.setBounds(800,200,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(pinTextField);


        // i can add sing in button
         login=new JButton("Log In");
        login.setBounds(800,250,90,30);
        login.addActionListener(this);
        add(login);

        // here i write a code for make clear button
         clear=new JButton(" Clear");
        clear.setBounds(900,250,90,30);
        clear.addActionListener(this);
        add(clear);
         // here i will make a sing up button
         sign=new JButton("Sign Up");
        sign.setBounds(800,300,190,30);
        sign.addActionListener(this);
        add(sign);
         // if you  want to change the background
        getContentPane().setBackground(Color.white);
        add(label);
        setSize(700,700);
        setVisible(true);
        setLocation(0,0);
    }
    public static void main(String[] args) {
      new Login();
    }
    public  void actionPerformed(ActionEvent ac){

        if(ac.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ac.getSource()==login) {
            Connec co= null;
            try {
                co = new Connec();
                String cardno=cardTextField.getText();
                        String pinnum=pinTextField.getText();
                        String query="select * from logind where cardnumber ='"+cardno+"' and pinnumber ='"+pinnum+"'";

                               ResultSet data= co.s.executeQuery(query);

                               if(data.next()){
                                   setVisible(false);
                                   new Transaction(pinnum).setVisible(true);
                               }
                               else {
                                   JOptionPane.showMessageDialog(null,"Incorect card no or password");
                               }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else if (ac.getSource()==sign) {
            setVisible(false);
            new SinupOne("").setVisible(true);
        }
    }
}
