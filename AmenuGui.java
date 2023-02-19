package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class AmenuGui extends JFrame{



        private JLabel label;
        private JMenuBar menu;
        private JMenu menuFile;
        private JMenu menuEdit;
        private JLabel help1;


        protected HashMap<String, String> ausers = new HashMap<String, String>();
        protected HashMap<String, String> roles = new HashMap<String, String>();
        protected HashMap<String, User> user = new HashMap<String, User>();
        protected HashMap<String, String> rentals = new HashMap<String, String>();
        protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
        protected HashMap<String, String> rented = new HashMap<String, String>();

        protected HashMap<String, String> rentcancel = new HashMap<String, String>();
        protected HashMap<String, String> messages = new HashMap<String, String>();

        protected String usernam;

        private JTextField textuser;
        private JLabel labeluser;
        private JTextField textpass;
        private JLabel labelpass;
        private JTextField textlog;
        private JLabel labellog;

        private JLabel label1;
        private JButton button1;
        private JButton button2;


        /**
         * <p>
         *this is the gui for the admin menu made with java swing
         *<br>
         * @param -
         * @return
         * @see -
         * @author tsig-404
         */

        public AmenuGui(String asvus,HashMap<String, String> aausers, HashMap<String, String> arentals,
                        HashMap<String, User> auser, HashMap<String, String> arented,
                        HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                        HashMap<String, String> msg, HashMap<String, String> aroles) {


                this.usernam=asvus;
                this.ausers=aausers;
                this.rentals=arentals;
                this.user=auser;
                this.rented=arented;
                this.rentalsV2=arentalsV2;
                this.rentcancel=rc;
                this.messages=msg;
                this.roles=aroles;

                setTitle("Admin menu");
                setSize(400, 300);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                menu = new JMenuBar();

                menuFile = new JMenu("Menu");
                menu.add(menuFile);

                help1 = new JLabel("Wellcome admin you can access your menu with the menu button");
                help1.setVerticalTextPosition(JLabel.CENTER);
                help1.setHorizontalTextPosition(JLabel.CENTER);
                add(help1);









                //option1
                String imgName1 = "images/list.png";
                URL imageURL1 = this.getClass().getResource(imgName1);
                ImageIcon icon1 = new ImageIcon(imageURL1);
                //JMenuItem submenu1 = new JMenuItem("Open", icon1);
                JMenu submenu = new JMenu("See users");
                for (String i : ausers.keySet()) {
                        System.out.println(i);

                        JMenuItem submenuItem1 = new JMenuItem("user:  "+i);
                        submenu.add(submenuItem1);
                }


                menuFile.add(submenu);

                menuFile.addSeparator();
                //end of option1


                //option2
                String imgName2 = "images/search2.png";
                URL imageURL2 = this.getClass().getResource(imgName2);
                ImageIcon icon2 = new ImageIcon(imageURL2);
                //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
                //JMenuItem op2 = new JMenuItem("Search a user");
                JMenuItem op2 = new JMenuItem("Search a user",icon2);
                op2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                amOp1Pop kk=new amOp1Pop(ausers);

                                setVisible(true);

                                //label.setText("click on op2");
                        }
                });
                menuFile.add(op2);
                //end of option2



                //option3
                String imgName3 = "images/search2.png";
                URL imageURL3 = this.getClass().getResource(imgName3);
                ImageIcon icon3 = new ImageIcon(imageURL3);
                //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
                JMenuItem op3 = new JMenuItem("Search reservations",icon3);
                //JMenuItem op3 = new JMenuItem("Search reservations");
                op3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                amOp2Pop kk=new amOp2Pop(rented);

                                //label.setText("click on op3");
                        }
                });
                menuFile.add(op3);
                //end of option3

                JMenu submenu2 = new JMenu("See all reservations");
                for (String i : rented.keySet()) {
                        System.out.println(i);

                        JMenuItem submenuItem1 = new JMenuItem("rented key:  "+i);
                        submenu2.add(submenuItem1);
                }


                menuFile.add(submenu2);

                menuFile.addSeparator();
                //option 4
                /*
                JMenuItem op4 = new JMenuItem("Search for a reservation");
                op4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                                label.setText("click on op4");
                        }
                });
                menuFile.add(op4);
                */



                //start of choise with pop up
                String imgName5 = "images/message.png";
                URL imageURL5 = this.getClass().getResource(imgName5);
                ImageIcon icon5 = new ImageIcon(imageURL5);
                //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
                JMenuItem op5 = new JMenuItem("Send a  message",icon5);
                //JMenuItem op5 = new JMenuItem("Send a  message");
                op5.addActionListener(new ActionListener() {

                        //now this works and we can use it for every other pop up hahaha i need a 5 coffee
                        @Override
                        public void actionPerformed(ActionEvent e) {

                                amOp3Pop kk=new amOp3Pop(messages);
                                //boolean mss=kk.send();

                                System.out.println("messages before the pop up");
                                System.out.println(messages);

                                         kk.getMessage();
                                        System.out.println("messages in menu");
                                        System.out.println(messages);


                                        //label.setText("click on op5");
                                        System.out.println("didnt got in");

                                messages = kk.getMessage();
                                System.out.println("messages in menu");
                                System.out.println(messages);
                        }
                });
                //end of choise with pop up
                menuFile.add(op5);




                String imgName6 = "images/closep1.png";
                URL imageURL6 = this.getClass().getResource(imgName6);
                ImageIcon icon6 = new ImageIcon(imageURL6);
                //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
                //JMenuItem op5 = new JMenuItem("Send a  message",icon5);
                JMenuItem menuFileQuit = new JMenuItem("Close program",icon6);

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

//this will be used as a menu tester
public static void main(String[] args) {
        AmenuGui frame = new AmenuGui();
}

                        }
                        */
