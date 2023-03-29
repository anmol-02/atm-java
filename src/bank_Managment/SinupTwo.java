package bank_Managment;
import javax.swing.*;
import  java.awt.*;
import  java.util.*;
import java.awt.event.*;
public class SinupTwo extends JFrame implements ActionListener{


    JTextField  adharTextField,panTextField,emailTextField,addresTextField,stateTextField, cityTextField,pinTextField;
    JRadioButton eyes,eno,sno,syes;
    JButton next;ButtonGroup  existacoo,senior;
    JLabel exist,state,adhar,pan,religion,category,income,edu,quali,occuption;
    JComboBox religio,categry,incomes,EDUQali,Ocuption;
    String forno;
    SinupTwo(String forno){
        this.forno=forno;
        setLayout(null);
        setTitle("New Account Application Form -page 2");//here i can set the title of the page



        JLabel additionalDetail =new JLabel("page 2: Additional Details");// with this i can put a text in gui
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetail.setBounds(270,80,400,30);
        add( additionalDetail);



        religion  =new JLabel("Religion :");
        religion .setFont(new Font("Raleway",Font.BOLD,20));
        religion .setBounds(100,140,150,30);
        add( religion );


         String valReligion []={"Hindu","Muslim","Sikha","Christian","Other"   };religio =new JComboBox(valReligion);
        religio.setBounds(300,140,400,30);
        religio.setBackground(Color.WHITE);
        add(religio);



         category  =new JLabel("Category :");
        category .setFont(new Font("Raleway",Font.BOLD,20));
        category .setBounds(100,190,150,30);
        add( category  );

        String valCategory []={"OBC","SC","ST","Genral","Other"};
        categry=new JComboBox(valCategory);
        categry.setBounds(300,190,400,30);
        categry.setBackground(Color.WHITE);
        add(categry);

        income  =new JLabel("Income  :");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,150,30);
        add( income );


        String valincome []={"Null",">100000",">200000",">300000",">400000","<500000"};
        incomes=new JComboBox(valincome);
        incomes.setBounds(300,240,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);

        edu  =new JLabel("Educational :");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,150,30);
        add(edu);


        quali=new JLabel("Qualification ");
        quali .setFont(new Font("Raleway",Font.BOLD,20));
        quali .setBounds(100,320,150,30);
        add( quali );

        String educat []={"Graduate","Non-Graduate","Post Graduate","10+2"};
        EDUQali =new JComboBox(educat);
        EDUQali.setBounds(300,310,400,30);
        EDUQali.setBackground(Color.WHITE);
        add( EDUQali);


        occuption =new JLabel("Occupation :");
        occuption .setFont(new Font("Raleway",Font.BOLD,20));
        occuption .setBounds(100,390,150,30);
        add(occuption );

        String occup []={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        Ocuption =new JComboBox(occup);

        Ocuption.setBounds(300,390,400,30);
        Ocuption.setBackground(Color.WHITE);
        add( Ocuption);


        pan  =new JLabel("PAN No:");
        pan .setFont(new Font("Raleway",Font.BOLD,20));
        pan .setBounds(100,440,150,30);
        add(pan  );

        panTextField =new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField );

        adhar  =new JLabel("Adhar No:");
        adhar .setFont(new Font("Raleway",Font.BOLD,20));
        adhar .setBounds(100,490,150,30);
        add(adhar  );

        adharTextField =new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);

        state  =new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,150,30);
        add( state );


        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,80,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno =new JRadioButton("No");
        sno.setBounds(400,540,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        senior=new ButtonGroup();
        senior.add(syes);
        senior.add(sno);

        exist  =new JLabel("Existing Account  :");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100,590,190,30);
        add( exist );

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,80,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno =new JRadioButton("No");
        eno.setBounds(400,590,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        existacoo=new ButtonGroup();
        existacoo.add(eyes);
        existacoo.add(eno);


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

        new SinupTwo("");
    }

    public  void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religio.getSelectedItem();
        String scategory=(String) categry.getSelectedItem();
        String sincome = (String) incomes.getSelectedItem();
        String seducation=(String) EDUQali.getSelectedItem();
        String soccup =(String) Ocuption.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen= "No";
        }

        String existaccount=null;
        if(eyes.isSelected()){
            existaccount="Yes";
        } else if (eno.isSelected()) {
            existaccount="No";
        }


        String panno=panTextField.getText();
        String adharno=adharTextField.getText();




        try{
            if(sreligion.equals("") || scategory.equals("")||sincome.equals("")||seducation.equals("")||soccup.equals("")||panno.equals("")||adharno.equals("")||seniorcitizen.equals("")||existaccount.equals("")){
                JOptionPane.showMessageDialog(null,"fields are empty");}
            else {
                Connec c =new Connec();
                String query="insert into signup_two values('"+forno+ "','"+sreligion+ "','"+scategory+ "','"+sincome+ "','"+seducation+ "','"+soccup+ "','"+panno+ "','"+adharno+ "','"+seniorcitizen+ "','"+existaccount+ "')";
                c.s.executeUpdate(query);
            }
            setVisible(false);
            new SinupThree(forno).setVisible(true);
        }catch (Exception e){}

    }
}

