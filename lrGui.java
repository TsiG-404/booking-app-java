package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import static java.awt.SystemColor.text;
/**
 * <p>
 *this is the start up menu to choose between login and register
 *<br>
 * @param -
 * @return -
 * @see -
 * @author tsig-404
 */

//this is the start of the ui which send to login or register
public class lrGui extends JFrame implements ActionListener {
    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String, String> rentals = new HashMap<String, String>();
    protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
    protected HashMap<String, String> rented = new HashMap<String, String>();

    protected HashMap<String, String> rentcancel = new HashMap<String, String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();


    private JLabel label1;
    private JButton button1;
    private JButton button2;

    private JLabel bd;

    protected int choice=0;
    protected boolean ps=false;

    public void setLabelText(String str) {
        label1.setText(str);
    }




    /**
     * <p>
     *this is the ui of it with jpanels and jframes and jbuttons and jlabels with java swing
     *<br>
     * @param -
     * @return -
     * @see -
     * @author tsig-404
     */


    public lrGui(HashMap<String, String> aausers, HashMap<String, String> arentals,
                 HashMap<String, User> auser, HashMap<String, String> arented,
                 HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                 HashMap<String, String> msg, HashMap<String, String> aroles) {




        super("Login/Register");
        //setTitle("Επίδειξη JButton");
        setSize(270, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setResizable(false);



        //maybe get rid of them later
        // //nooo it works dont delete it
        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;
        //if it doesnt work


        String imgName4 = "images/beflog.png";
        URL imageURL4 = this.getClass().getResource(imgName4);
        ImageIcon icon4 = new ImageIcon(imageURL4);
        bd = new JLabel(icon4 );


        label1 = new JLabel("");
        button1 = new JButton();
        button1.addActionListener(this);
        button1.setText("Login");
        button2 = new JButton("Register");
        button2.addActionListener(this);
        //button2.setEnabled(false);

        //
        JFrame box0 = new JFrame("down");
        JPanel box1 = new JPanel();
        //buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        FlowLayout aLayout = new FlowLayout();
        //BoxLayout bLayout = new BoxLayout();
        //setLayout((LayoutManager) box1);
        setLayout(aLayout);

        //addAButton("Button 1", box0);
        //addAButton("Button 2", box0);
        //addAButton("Button 3", box0);

        box0.add(button1);
        box0.add(button2);
        box0.add(label1);


        box0.pack();
        //box0.setVisible(true);
        //add(bd);
        //add(icon4);

        add(button1);
        add(button2);
        add(label1);


        //createAndShowGUI();

        setVisible(true);
    }

    /**
     * <p>
     *this is activated if the user choose to press one of the buttons to send him to the next
     * window also it set it to non visible
     *<br>
     * @param -
     * @return -
     * @see -
     * @author tsig-404
     */
    @Override
    //*
    public void actionPerformed(ActionEvent e) {
        //label1.setText("Πατήθηκε ένα κουμπί ");
        //*
        if (e.getActionCommand().equals("Login")) {
            label1.setText("Login Selected");
            choice=1;
            ps=true;
            setVisible(false);
            logGui frame = new logGui(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
        } else {
            label1.setText("Register Selected");
            choice=2;
            ps=true;
            setVisible(false);
            Regui frame= new Regui(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);

        }
        //*/
    }

    /**
     * <p>
     *this returns the choice to the main because without it it doesnt wait to get a input
     *<br>
     * @param -
     * @return choice
     * @see -
     * @author tsig-404
     */

    //maybe it doesnt work as it should
    public int ch()
    {
        int sec=0;
        while(ps==false) {
            sec++;
        }
        label1.setText(String.valueOf(choice));
        return choice;
    }


}

