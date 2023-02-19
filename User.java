package com.company;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serializable;

/**
 * <p>
 * This is a Superclass for provider/client/admin.java and
 * this will have almost every parameter that subclasses
 * will use as protected it crates objects as users
 *<br>
 * @param -
 * @return -
 * @see "admin.java,provider.java,client.java"
 * @author
 */
public class User extends JFrame implements Serializable {

    protected String username;
    protected String password;
    protected char role;
    protected String name;
    protected String address;
    protected boolean seeUsers;
    protected boolean seeReserves;
    protected boolean accepts;
    protected boolean sendMessages;
    protected boolean seeHotels;
    protected boolean seeMessages;
    protected boolean hasHotel;
    protected boolean canReserve;


    private Label labelkey;
    private Label labelprice;
    private Label labelpark;
    private Label labelwifi;
    private Label labelsize;

    public String getUsername()
    {

        return username;
    }
    public String getFullname()
    {

        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public String getRole()
    {
        if(this.role=='c')
            return "client";
        else
            return "provider";
    }


    public void showGui ()
    {
        setSize(500, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        //setResizable(false);

        setTitle("Add a room");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("  ");
        //panel1.setVerticalTextPosition(JPanel.BOTTOM);
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(10, 10, 10, 10);
        //panel1.setLayout(layout);
        labelkey=new Label(username);
        labelprice=new Label(String.valueOf(name));
        labelsize=new Label(String.valueOf(address));
        labelpark=new Label(String.valueOf(role));
        //labelwifi=new Label(String.valueOf(wifi));
        panel1.add(labelkey);
        panel1.add(labelprice);
        panel1.add(labelsize);
        panel1.add(labelpark);
        panel1.add(labelwifi);

        FlowLayout aLayout = new FlowLayout();
        setLayout(aLayout);
        setVisible(true);


    }


}
