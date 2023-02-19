package com.company;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class logGui extends JFrame {

    private JTextField textuser;
    private JLabel labeluser;
    private JTextField textpass;
    private JLabel labelpass;
    private JTextField textlog;
    private JLabel labellog;

    public String username;
    public String password;


    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String, String> rentals = new HashMap<String, String>();
    protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
    protected HashMap<String, String> rented = new HashMap<String, String>();

    protected HashMap<String, String> rentcancel = new HashMap<String, String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();


    /**
     * <p>
     *this is the gui for the log in made with java swing and gets info from logreg.java
     *<br>
     * @param -
     * @return ausers
     * @see -
     * @author tsig-404
     */
    public logGui(HashMap<String, String> aausers, HashMap<String, String> arentals,
                  HashMap<String, User> auser, HashMap<String, String> arented,
                  HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                  HashMap<String, String> msg, HashMap<String, String> aroles) {

        //maybe get rid of them later
        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;
        //if it doesnt work

        String imgName = "images/Login2.png";
        URL imageURL = this.getClass().getResource(imgName);
        ImageIcon icon = new ImageIcon(imageURL);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon);
        setTitle("Login Tab");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder(" Login ");
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(4, 2, 2, 2);
        panel1.setLayout(layout);

        labeluser = new JLabel("Username:");
        panel1.add(labeluser);
        textuser = new JTextField("");
        panel1.add(textuser);

        labelpass = new JLabel("password:");
        panel1.add(labelpass);
        textpass = new JTextField("");
        panel1.add(textpass);

        labellog = new JLabel("");
        panel1.add(labellog);

        textlog = new JTextField("");
        textlog.setEditable(false);
        panel1.add(textlog);





        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        JButton buttonCalculate = new JButton("Login");

        buttonCalculate.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                //System.exit(502);

                trlog();
                //textDose.setText(String.valueOf(Math.round(dose)));
            }


        });

        panel2.add(buttonCalculate);
        add(panel2, BorderLayout.PAGE_END);

        //calculateDose();
        pack();
        setVisible(true);
    }


    /**
     * <p>
     *this use the info from logreg and send the users to their menus
     *<br>
     * @param -
     * @return ausers
     * @see -
     * @author tsig-404
     */
    private void trlog() {



        username = new String(textuser.getText());

        password = new String(textpass.getText());
        System.out.println(username);
        System.out.println(password);
        Logreg ii=new Logreg();
        int tri=ii.guiLogin(username,password,ausers);
        if(tri==1)
        {
            textlog.setText("sucessfull login");
            setVisible(false);
            Logreg zz=new Logreg();
            int cm=zz.guiMenus(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles,
                    username);
            if(cm==11)
            {
                System.out.println("admin:"+username);
                AmenuGui aa=new AmenuGui(username,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
            }
            else if(cm==22)
            {
              System.out.println("client:"+username);
              CmenuGui cc=new CmenuGui(username,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
            }
            else if(cm==33)
            {
              System.out.println("provider:"+username);
              PmenuGui pp=new PmenuGui(username,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
            }
            else
            {
             System.out.println("da fuck i dont work here");
            }
            //logGui frame = new logGui(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
        }
        else if (tri==0) {
            textlog.setText("unsucessfull login");
        }
        else
        {
            textlog.setText("da fuck i dont work here");
        }


    }



    public String getUsr()
    {
        return username;
    }

    public String getPasw()
    {
        return password;
    }

}