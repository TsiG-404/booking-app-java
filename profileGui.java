package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class profileGui extends JFrame  {

    protected String usernam;

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
    //private JTextField textuser;
    private JLabel labeluser;
    //private JTextField textpass;
    private JLabel labelpass;
    //private JTextField textfn;
    private JLabel labelfn;
    //private JTextField textad;
    private JLabel labelad;



    private JLabel labelkey1;
    private JLabel labelprice1;
    private JLabel labelpark1;
    private JLabel labelwifi1;


    private JLabel label22;
    private ImageIcon icon5;

    private JButton buttonc;
    private JButton buttonr;
    private JLabel cr;
    private int choicer = 0;

    /**
     * <p>
     *this is the gui and code for the choice to see his profile in the provider menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public profileGui(String us,HashMap<String, String> aausers, HashMap<String, String> arentals,
                 HashMap<String, User> auser, HashMap<String, String> arented,
                 HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                 HashMap<String, String> msg, HashMap<String, String> aroles) {


        //maybe get rid of them later nooo it works dont delete it
        this.username=us;
        this.ausers = aausers;
        this.rentals = arentals;
        this.user = auser;
        this.rented = arented;
        this.rentalsV2 = arentalsV2;
        this.rentcancel = rc;
        this.messages = msg;
        this.roles = aroles;
        //if it doesnt work

        setSize(500, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);

        setTitle("Profile Tab");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("    ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);


        for (Map.Entry<String, User> e : user.entrySet()) {
            if (Objects.equals(username, e.getKey())) {
               // Provider u2 = new Provider();
               // u2.profile(e.getValue());
                //e.getValue().showGui();
                User u2 = e.getValue();

                JPanel panel2 = new JPanel();


                String imgName5 = "images/prof1.png";
                URL imageURL5 = this.getClass().getResource(imgName5);
                ImageIcon icon5 = new ImageIcon(imageURL5);
                label22 = new JLabel();
                label22 = new JLabel("");
                label22.setIcon(icon5);
                panel2.add(label22);



                labelkey1 = new JLabel("Username:");
                labelprice1 = new JLabel("Fullname:");
                labelpark1 = new JLabel("Address:");
                labelwifi1 = new JLabel("Role:");

                //add(button);
                //add(label);
                //setVisible(true);









                labeluser = new JLabel(u2.getUsername());
                panel2.add(labelkey1);
                panel2.add(labeluser);
                //textuser = new JTextField("un");
                //panel1.add(textuser);

                labelpass = new JLabel(u2.getFullname());
                panel2.add(labelprice1);
                panel2.add(labelpass);
                //textpass = new JTextField("ps");
                // panel1.add(textpass);

                labelfn = new JLabel(u2.getAddress());
                panel2.add(labelpark1);
                panel2.add(labelfn);

                //textfn = new JTextField("fn");
                //panel1.add(textfn);

                labelad = new JLabel("Provider");
                panel2.add(labelwifi1);
                panel2.add(labelad);

                FlowLayout aLayout = new FlowLayout();
                setLayout(aLayout);
                setVisible(true);
                add(panel2, BorderLayout.CENTER);

                //textad = new JTextField("ad");
                //textDose.setEditable(false);
                //panel1.add(textad);
            }
        }


        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);


        setVisible(true);


        //add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();


        pack();
        setVisible(true);

    }
}
