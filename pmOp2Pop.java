package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class pmOp2Pop extends JFrame implements ActionListener{

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

    private JTextField texttype;
    private JLabel labeltype;

    private JButton buttonqq;
    private JButton buttonrr;

    private JLabel cr;
    private int choicer = 0;

    protected boolean pss=false;



    /**
     * <p>
     *this is the gui and code for the choice to edit a room in the provider menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public pmOp2Pop(String name,HashMap<String, String> aausers, HashMap<String, String> arentals,
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

        setTitle("Edit a room");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("   ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);

        labelkey = new JLabel("key:");
        panel1.add(labelkey);
        textkey = new JTextField("");
        panel1.add(textkey);

        labelprice = new JLabel("price:");
        panel1.add(labelprice);
        textprice = new JTextField("");
        panel1.add(textprice);

        labelpark = new JLabel("parking(yes/no):");
        panel1.add(labelpark);

        textpark = new JTextField("no");
        panel1.add(textpark);

        labelwifi = new JLabel("wifi(yes/no):");
        panel1.add(labelwifi);

        textwifi = new JTextField("no");

        panel1.add(textwifi);

        labelsize = new JLabel("size:");
        panel1.add(labelsize);

        textsize = new JTextField("");
        panel1.add(textsize);

        labeltype = new JLabel("Type of rental(room:1/home:2)");
        panel1.add(labeltype);
        texttype = new JTextField("");
        panel1.add(texttype);


        cr = new JLabel("");

        buttonqq = new JButton("edit");
        //buttonc.setVerticalTextPosition(JButton.BOTTOM);
        //buttonc.setHorizontalTextPosition(JButton.LEFT);
        buttonqq.addActionListener((ActionListener) this);
        //buttonc.setText("Client");

        buttonqq.addActionListener(new ActionListener() {
            //bc.addMouseListener(new MouseAdapter() {

            @Override
            public void actionPerformed(ActionEvent e) {
                key = new String(textkey.getText());
                price = Integer.parseInt(textprice.getText());
                size = Integer.parseInt(textsize.getText());
                if(textwifi.getText()=="yes")
                    wifi=true;
                else
                    wifi=false;
                if(textpark.getText()=="yes")
                    parking=true;
                else
                    parking=false;

                int rent = Integer.parseInt(texttype.getText());

                if(rent==1)
                {
                    for (Map.Entry<String, String> ww : rentals.entrySet()) {
                        if (Objects.equals(username, ww.getValue()) && Objects.equals(key, ww.getKey())) {
                            Room rd1 = new Room(key, price, username, parking, wifi,
                                    size, true, true, false);

                            rentals.put(key, username);
                            rentalsV2.put(key, rd1);
                            cr.setText("Room edited successfully!");
                            //System.out.println("Room edited successfully!");
                        }
                    }

                }
                else if (rent==2)
                {
                    for (Map.Entry<String, String> uu : rentals.entrySet()) {
                        if (Objects.equals(username, uu.getValue()) && Objects.equals(key, uu.getKey())) {
                            Home rent2 = new Home(key, price, username, parking, wifi,
                                    size, true, false, true);
                            rentals.put(key, username);
                            rentalsV2.put(key, rent2);
                            cr.setText("Home edited successfully!");
                            //System.out.println("Home edited successfully!");
                        }
                    }

                }
                else
                {
                    //System.out.println("Sure you crashed it hahaha");
                    cr.setText("stop it!!!!!");
                    System.exit(99);
                    //return ;
                }
                //public void mouseClicked(MouseEvent e) {
                /*

                String sms = new String(textmessage.getText());
                String rec = new String(textreciver.getText());
                message.put(sms, rec);
                System.out.println("2messages:");
                System.out.println(message);


                send();
                */
                change();


            }
        });

        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);

        add(buttonqq);
        //add(buttonrr);
        add(cr);

        setVisible(true);


        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();


        pack();
        setVisible(true);
        /*
        panel2.add(bc);
        add(panel2, BorderLayout.PAGE_END);

        send();
        pack();
        setVisible(true);
        */
        change();

    }
    boolean change() {





        return pss;

    }
    public HashMap<String, Rentable> getRentalsV2()
    {
        //System.out.println("messages:");
        //System.out.println(message);
        return this.rentalsV2;
    }
    public boolean tt()
    {
        return pss;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




