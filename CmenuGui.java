package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CmenuGui extends JFrame {


    private JLabel label;
    private JMenuBar menu;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JLabel help1;

    protected String usernam;

    private JLabel bd;

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
     *this is the gui for the client menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public CmenuGui(String asvus, HashMap<String, String> aausers, HashMap<String, String> arentals,
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

        setTitle("Client menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new JMenuBar();

        menuFile = new JMenu("Menu");
        menu.add(menuFile);



        String imgName00 = "images/cub1.png";
        URL imageURL00 = this.getClass().getResource(imgName00);
        ImageIcon icon00 = new ImageIcon(imageURL00);
        bd = new JLabel(icon00 );
        //add(bd);

        help1 = new JLabel("Wellcome customer you can access your menu with the menu button");
        help1.setVerticalTextPosition(JLabel.CENTER);
        help1.setHorizontalTextPosition(JLabel.CENTER);
        add(help1);






        /*
        menuEdit = new JMenu("Διόρθωση");
        menu.add(menuEdit);
        */


        //options for the menu
        //option1
        String imgName1 = "images/user.png";
        URL imageURL1 = this.getClass().getResource(imgName1);
        ImageIcon icon1 = new ImageIcon(imageURL1);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op1 = new JMenuItem("See profile",icon1);

        //JMenuItem op1 = new JMenuItem("See profile");
        op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eeee) {

                //label.setText("click on op1");
                profileGui1 k1=new profileGui1(usernam,ausers,rentals,user,
                rented,rentalsV2,rentcancel,messages,roles);
                //for (Map.Entry<String, User> e : user.entrySet()) {
                 //   if (Objects.equals(usernam, e.getKey())) {
                       // e.getValue().showGui();
                   // }
              //  }
            }
        });
        menuFile.add(op1);
        //end of option1

        //option2

        String imgName2 = "images/key.png";
        URL imageURL2 = this.getClass().getResource(imgName2);
        ImageIcon icon2 = new ImageIcon(imageURL2);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op2 = new JMenuItem("Rent a room",icon2);

        //JMenuItem op2 = new JMenuItem("Rent a room");
        op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmOp1Pop k2=new cmOp1Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);

                //kk.get();
                k2.getRentals();
                k2.getRented();
                rentals = k2.getRentals();
                rented=k2.getRented();

                //label.setText("click on op2");
            }
        });
        menuFile.add(op2);
        //end of option2

        //option3

        String imgName3 = "images/unrent.png";
        URL imageURL3 = this.getClass().getResource(imgName3);
        ImageIcon icon3 = new ImageIcon(imageURL3);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op3 = new JMenuItem("Cancel a rent",icon3);

        //JMenuItem op3 = new JMenuItem("Cancel a rent");
        op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmOp2Pop k3=new cmOp2Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);

                //kk.get();
                k3.getRentals();
                k3.getRented();
                rentals = k3.getRentals();
                rented=k3.getRented();

            }
        });
        menuFile.add(op3);
        //end of option3

        //option4

        String imgName4 = "images/home.png";
        URL imageURL4 = this.getClass().getResource(imgName4);
        ImageIcon icon4 = new ImageIcon(imageURL4);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        JMenuItem op4 = new JMenuItem("See rooms",icon4);

        //JMenuItem op4 = new JMenuItem("see rooms");
        op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //label.setText("click on op4");
                cmOp3Pop k4=new cmOp3Pop(usernam,ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
            }
        });
        menuFile.add(op4);
        //end of option4

        //option5
        JMenu op5 = new JMenu("Incoming messages");

        for (Map.Entry<String, String> eo : messages.entrySet()) {
            if (Objects.equals(usernam, eo.getValue())) {
                //System.out.println("Sender: Admin," + " Receiver: " + eo.getValue()
                // + ", Message: " + eo.getKey());
                // JMenuItem submenuItem1 = new JMenuItem("Sender: Admin," + " Receiver: "
                // + eo.getValue()
                //+ ", Message: " + eo.getKey());
                JMenuItem opp = new JMenuItem("Sender: admin    " +"Message:" +eo.getKey());
                //op8.add(opp);
                //JMenuItem opp = new JMenuItem(eo.getKey());
                op5.add(opp);
            }
        }


        //label.setText("click on op5");

       // });
        menuFile.add(op5);
        //end of option5



        String imgName6 = "images/closep1.png";
        URL imageURL6 = this.getClass().getResource(imgName6);
        ImageIcon icon6 = new ImageIcon(imageURL6);
        //JMenuItem menuFileOpen = new JMenuItem("Open", icon1);
        //JMenuItem op2 = new JMenuItem("Rent a room",icon2);
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
    //tester
    public static void main(String[] args) {
        CmenuGui frame = new CmenuGui();
    }

                }
*/