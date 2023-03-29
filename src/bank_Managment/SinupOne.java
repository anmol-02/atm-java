package bank_Managment;
import javax.swing.*;
import  java.awt.*;
import  java.util.*;
import java.awt.event.*;
public class SinupOne extends JFrame implements ActionListener{

    long random;
     JTextField  nameTextField,fathernameTextField,dobTextField,emailTextField,addresTextField,stateTextField, cityTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;ButtonGroup gender,maritels;
    JLabel formNO;
    SinupOne(String forno){
        setLayout(null);
        // random number genrate prsent in java util package
        Random no=new Random();
        random =Math.abs((no.nextLong()%9000L)+1000L);
         formNO =new JLabel("Application Form No :"+random);
        formNO.setFont(new Font("Raleway",Font.BOLD,30));
        formNO.setBounds(170,20,600,40);
        add(formNO);


        JLabel peroDetail =new JLabel("page 1: Personal detail");
        peroDetail.setFont(new Font("Raleway",Font.BOLD,22));
        peroDetail.setBounds(270,80,400,30);
        add(peroDetail);



        JLabel name  =new JLabel("Name :");
        name .setFont(new Font("Raleway",Font.BOLD,20));
        name .setBounds(100,140,150,30);
        add(name );

         nameTextField =new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fatherName  =new JLabel("Father Name :");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(100,190,150,30);
        add( fatherName );

         fathernameTextField =new JTextField();
        fathernameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fathernameTextField.setBounds(300,190,400,30);
        add(fathernameTextField);

        JLabel dob  =new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,150,30);
        add( dob );

         dobTextField =new JTextField();
        dobTextField.setFont(new Font("Raleway",Font.BOLD,14));
        dobTextField.setBounds(300,240,400,30);
        add(dobTextField);

        JLabel gen  =new JLabel("Gender :");
        gen.setFont(new Font("Raleway",Font.BOLD,20));
        gen.setBounds(100,290,150,30);
        add(gen);

//        JTextField genTextField =new JTextField();
//        genTextField.setFont(new Font("Raleway",Font.BOLD,14));
//        genTextField.setBounds(300,290,400,30);
//        add( genTextField);

         male =new JRadioButton("Male ");
        male.setBounds(300,290,90,30);
        male.setBackground(Color.cyan);
        add(male);

         female =new JRadioButton("Female ");
        female.setBounds(420,290,90,30);
        female.setBackground(Color.cyan);
        add(female);

         gender =new ButtonGroup();
        gender.add(male);
        gender.add(female);

        JLabel email  =new JLabel("Email Id :");
        email .setFont(new Font("Raleway",Font.BOLD,20));
        email .setBounds(100,340,150,30);
        add(email );

        emailTextField =new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);


        JLabel maritel  =new JLabel("Marital Status :");
        maritel .setFont(new Font("Raleway",Font.BOLD,20));
        maritel .setBounds(100,390,150,30);
        add(maritel );

         married =new JRadioButton("Married ");
        married.setBounds(300,390,90,30);
        married.setBackground(Color.cyan);
        add( married);

         unmarried =new JRadioButton("Unmarried ");
        unmarried.setBounds(420,390,90,30);
        unmarried.setBackground(Color.cyan);
        add( unmarried);

         other =new JRadioButton("Other ");
        other .setBounds(540,390,90,30);
        other .setBackground(Color.cyan);
        add(  other );

         maritels=new ButtonGroup();
        maritels.add(married);
        maritels.add(unmarried);
        maritels.add(other);

//        JTextField maritelTextField =new JTextField();
//        maritelTextField.setFont(new Font("Raleway",Font.BOLD,14));
//        maritelTextField.setBounds(300,390,400,30);
//        add(maritelTextField);

        JLabel addres  =new JLabel("Address :");
        addres .setFont(new Font("Raleway",Font.BOLD,20));
        addres .setBounds(100,440,150,30);
        add(addres  );

        addresTextField =new JTextField();
        addresTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addresTextField.setBounds(300,440,400,30);
        add( addresTextField);

        JLabel city  =new JLabel("City Name:");
        city .setFont(new Font("Raleway",Font.BOLD,20));
        city .setBounds(100,490,150,30);
        add(city  );

         cityTextField =new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state  =new JLabel("State Name :");
         state.setFont(new Font("Raleway",Font.BOLD,20));
         state.setBounds(100,540,150,30);
        add( state );

         stateTextField =new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode  =new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,150,30);
        add( pincode );

        pinTextField =new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add( pinTextField);


         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,640,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);

        //with the help of this i will create fram
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.pink);

    }

    public static void main(String[] args) {

        new SinupOne("");
    }

    public  void actionPerformed(ActionEvent ae) {
        String forno = "" + random;
        String name = nameTextField.getText();
        String fname=fathernameTextField.getText();
        String dob = dobTextField.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email=emailTextField.getText();
        String maritel=null;
        if(married.isSelected()){
            maritel="Married";
        } else if (unmarried.isSelected()) {
            maritel="Unmarried";
        } else if (other.isSelected()) {
            maritel="Other";
        }


         String adrees=addresTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();



        try{
                if(name.equals("") || fname.equals("")||dob.equals("")||gender.equals("")||email.equals("")||maritel.equals("")||adrees.equals("")||state.equals("")||city.equals("")||pin.equals("")){
            JOptionPane.showMessageDialog(null,"  Fields Are Empty Fill All");}
                else {
                    Connec c =new Connec();
                    String query="insert into signup values('"+forno+ "','"+name+ "','"+fname+ "','"+dob+ "','"+gender+ "','"+email+ "','"+maritel+ "','"+adrees+ "','"+state+ "','"+city+ "','"+pin+ "')";
                    c.s.executeUpdate(query);

                    if(ae.getSource()==next){
                        setVisible(false);
                        new SinupTwo(forno).setVisible(true);
                    }
                }
        }catch (Exception e){}




    }
    }
