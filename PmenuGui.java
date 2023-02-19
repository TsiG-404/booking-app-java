package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PmenuGui extends JFrame {


    private JLabel label;
    private JMenuBar menu;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JLabel help1;


    protected String usernam;
    protected String key;


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
     *this is the gui for the provider menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public PmenuGui(String asvus, HashMap<String, String> aausers, HashMap<String, String> arentals,
                    HashMap<String, User> auser, HashMap<String, String> arented,
                    HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                    HashMap<String, String> msg, HashMap<String, String> aroles) {

        this.usernam = asvus;
        this.ausers = aausers;
        this.rentals = arentals;
        this.user = auser;
        this.rented = arented;
        this.rentalsV2 = arentalsV2;
        this.rentcancel = rc;
        this.messages = msg;
        this.roles = aroles;


        setTitle("Provider menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new JMenuBar();

        menuFile = new JMenu("Menu");
        menu.add(menuFile);


        help1 = new JLabel("Wellcome provider you can access your menu with the menu button");
        help1.setVerticalTextPosition(JLabel.CENTER);
        help1.setHorizontalTextPosition(JLabel.CENTER);
        add(help1);

        //options for the menu

        //option 1

        String imgName1 = "images/ahome.png";
        URL imageURL1 = this.getClass().getResource(imgName1);
        ImageIcon icon1 = new ImageIcon(imageURL1);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op1 = new JMenuItem("Add a room/home",icon1);

        //JMenuItem op1 = new JMenuItem("Add a room/home");
        op1.addActionListener(new ActionListener() {
            //op1.addMouseListener(new MouseAdapter() {
            @Override
            //public void mouseClicked(MouseEvent e) {
            public void actionPerformed(ActionEvent nn) {
                    //.addMouseListener(new MouseAdapter() {
                pmOp1Pop k1=new pmOp1Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);

                //kk.get();
                rentals = k1.getRentals();
                rentalsV2=k1.getRentalsV2();
                //label.setText("click on op1");
            }
        });
        menuFile.add(op1);
        //end of option1

        //option2

        String imgName2 = "images/ehome.png";
        URL imageURL2 = this.getClass().getResource(imgName2);
        ImageIcon icon2 = new ImageIcon(imageURL2);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op2 = new JMenuItem("Edit a room/home",icon2);

        //JMenuItem op2 = new JMenuItem("Edit a room/home");
        op2.addActionListener(new ActionListener() {
            //op2.addMouseListener(new MouseAdapter() {
            @Override
            //public void mouseClicked(MouseEvent e) {
            public void actionPerformed(ActionEvent g) {
                pmOp2Pop k2=new pmOp2Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
                k2.getRentalsV2();
                rentalsV2=k2.getRentalsV2();

                //label.setText("click on op2");
            }
        });
        menuFile.add(op2);
        //end of option2

        //option3

        String imgName3 = "images/dhome.png";
        URL imageURL3 = this.getClass().getResource(imgName3);
        ImageIcon icon3 = new ImageIcon(imageURL3);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op3 = new JMenuItem("Delete a room/home",icon3);

        //JMenuItem op3 = new JMenuItem("delete a room/home");
        op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent yye) {

                //label.setText("click on op3");
                pmOp3Pop k3=new pmOp3Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);

                //kk.get();
                k3.getRentals();
                k3.getRentalsV2();
                rentals = k3.getRentals();
                rentalsV2=k3.getRentalsV2();

            }
        });
        menuFile.add(op3);
        //end of option3

        //option4

        String imgName4 = "images/user.png";
        URL imageURL4 = this.getClass().getResource(imgName4);
        ImageIcon icon4 = new ImageIcon(imageURL4);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op4 = new JMenuItem("See profile",icon4);

        //JMenuItem op4 = new JMenuItem("See profile");
        op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent u) {
                profileGui k1=new profileGui(usernam,ausers,rentals,user,
                      rented,rentalsV2,rentcancel,messages,roles);
                /*
                for (Map.Entry<String, User> e : user.entrySet()) {
                    if (Objects.equals(usernam, e.getKey())) {
                        e.getValue().showGui();
                    }
                    }


                 */
                //label.setText("click on op4");
            }
        });
        menuFile.add(op4);
        //end of option4

        //option5

        String imgName5 = "images/home.png";
        URL imageURL5 = this.getClass().getResource(imgName5);
        ImageIcon icon5 = new ImageIcon(imageURL5);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op5 = new JMenuItem("See your rentals",icon5);

        //JMenuItem op5 = new JMenuItem("See your rentals");
        op5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent o) {
                /*
                for (Map.Entry<String, String> e : rentals.entrySet()) {
                    for (Map.Entry<String, Rentable> j : rentalsV2.entrySet()) {

                        if (Objects.equals(e.getValue(), usernam) && Objects.equals(e.getKey(), j.getKey())) {
                           //Rentable kk=new Rentable();
                           j.getValue().showGui();

                        }
                        }
                        }
                        */

                //HERE!!!!!!
                pmOp4Pop k4=new pmOp4Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
                //label.setText("click on op5");
            }
        });
        menuFile.add(op5);
        //end of option5



        //option6
        JMenu op6 = new JMenu("See total reservations");

        int reservations = 0;
        for (Map.Entry<String, String> eet : rentals.entrySet()) {
            for (Map.Entry<String, String> j : rented.entrySet()) {
                if (Objects.equals(eet.getValue(), usernam) &&
                        Objects.equals(eet.getKey(), j.getKey()))
                            reservations++;

            }
        }
        JMenuItem tro1 = new JMenuItem("Total reservations:  "+String.valueOf(reservations));
        op6.add(tro1);

                menuFile.add(op6);
                //end of option6



                //option7
                JMenu op7 = new JMenu("See total cancels");
            int cancels=0;

            for(Map.Entry<String, String> j : rentcancel.entrySet() ) {
                if (Objects.equals(j.getValue(), usernam))
                    cancels++;
            }
            JMenuItem tco1 = new JMenuItem("Total cancels:  "+String.valueOf(cancels));
            op7.add(tco1);

                menuFile.add(op7);
                //end of option 7


            //option 8
            JMenu op8 = new JMenu("Incoming messages");
            //menuFile.add(op8);
            for (Map.Entry<String, String> eo : messages.entrySet()) {
                if (Objects.equals(usernam, eo.getValue())) {
                    //System.out.println("Sender: Admin," + " Receiver: " + eo.getValue()
                    // + ", Message: " + eo.getKey());
                    // JMenuItem submenuItem1 = new JMenuItem("Sender: Admin," + " Receiver: "
                    // + eo.getValue()
                    //+ ", Message: " + eo.getKey());
                    JMenuItem opp = new JMenuItem("Sender: admin  Message: "+eo.getKey());
                    op8.add(opp);
                }
            }



            menuFile.add(op8);
            //end of option 8

        String imgName8 = "images/closep1.png";
        URL imageURL8 = this.getClass().getResource(imgName8);
        ImageIcon icon8 = new ImageIcon(imageURL8);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        //JMenuItem op2 = new JMenuItem("Rent a room",icon2);
        JMenuItem menuFileQuit = new JMenuItem("Close program",icon8);

            //JMenuItem menuFileQuit = new JMenuItem("Close program");
            menuFileQuit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Files tns= new Files();
                    try {
                        tns.export1(ausers,rented,user,rentals,rentalsV2,rentcancel,messages,roles);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(53);
                    //dispose();
                    //System.exit(0);
                }
            });


                        menuFile.add(menuFileQuit);

                        setJMenuBar(menu);

                        label = new JLabel("");
                        JPanel panel = new JPanel();
                        panel.add(label);
                        add(panel, BorderLayout.PAGE_END);

                        setVisible(true);
                }



                }
                /*

        public static void main(String[] args) {
                 PmenuGui frame = new PmenuGui();
        }

                        }*/
