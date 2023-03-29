package bank_Managment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame  implements ActionListener {
    String pinnum;JPasswordField pin ,repin; JButton change,back;
    PinChange(String pinnum){
        this.pinnum=pinnum;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text =new JLabel("CHANGE YOUR PIN  ");
        text.setBounds(190,225,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel pintext =new JLabel("NEW PIN  ");
        pintext.setBounds(150,270,80,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);

        pin =new JPasswordField();
        pin.setBounds(260,270,120,25);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pin);


        JLabel repintext =new JLabel("Re-Enter PIN  ");
        repintext.setBounds(150,310,120,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);


        repin =new JPasswordField();
        repin.setBounds(260,310,120,25);
        repin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(repin);

       change =new JButton("CHANGE");
        change.setBounds(310,405,120,25);
        change.addActionListener(this);
        image.add(change);

        back =new JButton("BCAK");
        back.setBounds(310,440,120,25);
        back.addActionListener(this);
        image.add(back);

        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==change) {


            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re enter new pin");
                }
                Connec c=new Connec();
                String query1="update bank set pin ='"+rpin+"' where pin ='"+pinnum+"'";
                String query2="update logind set pinnumber ='"+rpin+"' where pinnumber ='"+pinnum+"'";
                String query3="update signup_three set pinnumber ='"+rpin+"' where pinnumber ='"+pinnum+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN change Sucessfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);


            } catch (Exception e) {
            }
        }else {
            setVisible(false);
            new  Transaction(pinnum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
