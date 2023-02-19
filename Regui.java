package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Regui extends JFrame implements ActionListener{
    protected String username;
    protected String password;
    protected String fullname;
    protected String address;


    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String, String> rentals = new HashMap<String, String>();
    protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
    protected HashMap<String, String> rented = new HashMap<String, String>();

    protected HashMap<String, String> rentcancel = new HashMap<String, String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();


    //gui register values
    private JTextField textuser;
    private JLabel labeluser;
    private JTextField textpass;
    private JLabel labelpass;
    private JTextField textfn;
    private JLabel labelfn;
    private JTextField textad;
    private JLabel labelad;

    private JButton buttonc;
    private JButton buttonr;
    private JLabel cr;
    private int choicer=0;

    /**
     * <p>
     *this is the gui for register made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public Regui(HashMap<String, String> aausers, HashMap<String, String> arentals,
                 HashMap<String, User> auser, HashMap<String, String> arented,
                 HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                 HashMap<String, String> msg, HashMap<String, String> aroles) {



        //maybe get rid of them later nooo it works dont delete it
        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;
        //if it doesnt work

            setSize(500, 500);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLocationRelativeTo(null);
            //setResizable(false);

        setTitle("Register Tab");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder(" Register  ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);

        labeluser = new JLabel("Username:");
        panel1.add(labeluser);
        textuser = new JTextField("un");
        panel1.add(textuser);

        labelpass = new JLabel("Password:");
        panel1.add(labelpass);
        textpass = new JTextField("ps");
        panel1.add(textpass);

        labelfn = new JLabel("Full Name:");
        panel1.add(labelfn);

        textfn = new JTextField("fn");
        panel1.add(textfn);

        labelad = new JLabel("Address:");
        panel1.add(labelad);

        textad = new JTextField("ad");
        //textDose.setEditable(false);
        panel1.add(textad);



        cr = new JLabel("");

        buttonc = new JButton("Client");
        buttonc.setVerticalTextPosition(JButton.BOTTOM);
        buttonc.setHorizontalTextPosition(JButton.LEFT);
        buttonc.addActionListener((ActionListener) this);
        //buttonc.setText("Client");

        buttonr = new JButton("Provider");
        buttonr.addActionListener((ActionListener) this);
        //button2.setEnabled(false);

        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);

        add(buttonc);
        add(buttonr);
        add(cr);

        setVisible(true);




        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();




            pack();
            setVisible(true);


    }


    /**
     * <p>
     *this checks which button got pressed and save the user as client or provider
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    //@Override
    //*
    public void actionPerformed(ActionEvent e) {
        //label1.setText("Πατήθηκε ένα κουμπί ");
        //*
        username = new String(textuser.getText());
        password = new String(textpass.getText());
        fullname= new String(textfn.getText());
        address= new String(textad.getText());


        if (e.getActionCommand().equals("Client")) {
            cr.setText("Client register selected");
            choicer=1;
            Logreg ii=new Logreg();
            try {
                ii.guiRegister(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles,
                                username,fullname,password,address,choicer);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        else {
            cr.setText("Provider register Selected");
            choicer=2;
            Logreg ii=new Logreg();
            try {
                ii.guiRegister(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles,
                        username,fullname,password,address,choicer);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //ps=true;
        }



    }




}
