package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class cmOp1Pop extends JFrame implements ActionListener {

    protected String username;

    protected String key;
    protected int price;
    protected boolean parking;
    protected boolean wifi;
    protected int size;


    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String, String> rentals = new HashMap<String, String>();
    protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
    protected HashMap<String, String> rented = new HashMap<String, String>();

    protected HashMap<String, String> rentcancel = new HashMap<String, String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();


    //gui register values
    private JTextField textkey;
    private JLabel labelkey;

    private JTextField textprice;
    private JLabel labelprice;

    private JTextField textpark;
    private JLabel labelpark;

    private JTextField textwifi;
    private JLabel labelwifi;

    private JTextField textsize;
    private JLabel labelsize;

    private JButton buttonqq;

    private JLabel cr;
    private int choicer = 0;

    protected String howner;


    /**
     * <p>
     *this is the gui and code for the choice to rent aroom in the client menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public cmOp1Pop(String name,HashMap<String, String> aausers, HashMap<String, String> arentals,
                    HashMap<String, User> auser, HashMap<String, String> arented,
                    HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                    HashMap<String, String> msg, HashMap<String, String> aroles) {


        //maybe get rid of them later nooo it works dont delete it
        this.ausers = aausers;
        this.rentals = arentals;
        this.user = auser;
        this.rented = arented;
        this.rentalsV2 = arentalsV2;
        this.rentcancel = rc;
        this.messages = msg;
        this.roles = aroles;

        this.username=name;
        //if it doesnt work

        setSize(500, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);

        setTitle("rent a room");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("  ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);

        labelkey = new JLabel("key:");
        panel1.add(labelkey);
        textkey = new JTextField("");
        panel1.add(textkey);



        cr = new JLabel("");

        buttonqq = new JButton("rent");

        buttonqq.addActionListener((ActionListener) this);
        //buttonc.setText("Client");

        JPanel panel2 = new JPanel();
        buttonqq.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //csearch();
            }
        });

        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);

        add(buttonqq);
        //add(buttonrr);
        add(cr);

        setVisible(true);


        add(panel1, BorderLayout.CENTER);




        pack();
        setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        key = new String(textkey.getText());



        if (e.getActionCommand().equals("rent")) {

            //rented.put(key,username);
            for (Map.Entry<String, String> uu : rentals.entrySet()) {
                if (Objects.equals(key, uu.getKey())) {
                    this.howner = uu.getValue();
                    rented.put(key,username);

                }
            }
            rentals.remove(key);
            cr.setText("The room is rented");
        }


    }
    public HashMap<String,String> getRentals()
    {
        //System.out.println("messages:");
        System.out.println(rentals);
        return this.rentals;
    }
    public HashMap<String,String> getRented()
    {
        //System.out.println("messages:");
        System.out.println(rented);
        return this.rented;
    }


}
