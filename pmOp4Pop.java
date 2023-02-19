package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class pmOp4Pop extends JFrame  {

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

    private JLabel labelkey1;


    private JLabel labelprice1;


    private JLabel labelpark1;


    private JLabel labelwifi1;


    private JLabel labelsize1;


    private JLabel label22;
    private ImageIcon icon5;

    private JLabel label3;

    private JButton buttonqq;
    private JButton buttonrr;
    private JLabel cr;
    private int choicer = 0;


    /**
     * <p>
     *this is the gui and code for the choice to see his rentals in the provider menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public pmOp4Pop(String name, HashMap<String, String> aausers, HashMap<String, String> arentals,
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

        this.username = name;
        //if it doesnt work

        setSize(500, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);

        setTitle("Rentals");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("  ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);
        Rentable ph=new Rentable();
        for (Map.Entry<String, String> e : rentals.entrySet()) {
            for (Map.Entry<String, Rentable> j : rentalsV2.entrySet()) {
                ph=j.getValue();
                if (Objects.equals(e.getValue(), username)&& Objects.equals(e.getKey(), j.getKey())) {
                    //Rentable u3= new getValue();

                    String imgName5 = "images/home2.png";
                    URL imageURL5 = this.getClass().getResource(imgName5);
                    ImageIcon icon5 = new ImageIcon(imageURL5);
                    label22 = new JLabel();
                    label22 = new JLabel("");
                    label22.setIcon(icon5);


                    labelkey=new JLabel(ph.getKey());
                    labelprice=new JLabel(String.valueOf(ph.getPrice()));
                    labelpark=new JLabel(ph.getPark());
                    labelwifi=new JLabel(ph.getWifi());
                    labelsize=new JLabel(String.valueOf(ph.getSize1()));


                    JPanel panel2 = new JPanel();
                    //GridLayout alayout = new GridLayout(10, 10, 10, 10);
                    //TitledBorder border = BorderFactory.createTitledBorder("  ");

                    labelkey1=new JLabel("key:");
                    labelprice1=new JLabel("price:");
                    labelpark1=new JLabel("parking:");
                    labelwifi1=new JLabel("wifi:");
                    labelsize1=new JLabel("size:");

                    panel2.add(label22);

                    panel2.add(labelkey1);
                    panel2.add(labelkey);

                    panel2.add(labelprice1);
                    panel2.add(labelprice);

                    panel2.add(labelpark1);
                    panel2.add(labelpark);

                    panel2.add(labelwifi1);
                    panel2.add(labelwifi);

                    panel2.add(labelsize1);
                    panel2.add(labelsize);
                    //panel2.add(label3);



                    FlowLayout aLayout = new FlowLayout();
                    setLayout(aLayout);
                    setVisible(true);
                    add(panel2, BorderLayout.CENTER);


                    //u3.display(j.getValue());
                }
            }

        }

        /*

        panel1.add(labelkey);
        panel1.add(labelprice);
        panel1.add(labelpark);
        panel1.add(labelwifi);
        panel1.add(labelsize);
        */








        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);




        setVisible(true);


        //add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();


        pack();
        setVisible(true);


    }


}
