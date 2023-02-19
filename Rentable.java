package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.Serializable;

/**
 * <p>
 * This is a superclass for home/room.java and this will have almost
 * every parameter that subclasses will use as protected it crates
 * objects as rentable places
 *<br>
 * @param -
 * @return -
 * @see "home.java,room.java"
 * @author
 */
public class Rentable extends JFrame implements Serializable {

    protected String key;
    protected int price;
    protected String owner;
    protected boolean parking;
    protected boolean wifi;
    protected int size1;
    protected boolean available;
    protected boolean shortRent;
    protected boolean longRent;
    protected int rentDays;
    protected boolean rented;
    protected String rentName;



    private Label labelkey;
    private Label labelprice;
    private Label labelpark;
    private Label labelwifi;
    private Label labelsize;



    /**
     * <p>
     * This is choose which of the rentable objects is room and which home
     * and after that it send it to the correct subclass to print the info
     *<br>
     * @param value
     * @return -
     * @see "home.java,room.java"
     * @author
     */

    public void display(Rentable value) {
        this.shortRent= value.shortRent;
        if(shortRent==true) {
            Room it1= new Room();
            it1.display(value);
        }
        else
        {
            Home it2= new Home();
            it2.display(value);
        }
    }
    public String getKey()
    {
        return this.key;
    }
    public int getPrice()
    {
        return this.price;
    }

    public int getSize1()
    {
        return this.size1;
    }


    public String getPark()
    {
        if(this.parking==true)
            return "yes";
        else
            return "no";
    }
    public String getWifi()
    {
        if(this.wifi==true)
            return "yes";
        else
            return "no";
    }


    public void showGui ()
    {
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
        labelkey=new Label(key);
        labelprice=new Label(String.valueOf(price));
        labelsize=new Label(String.valueOf(size1));
        labelpark=new Label(String.valueOf(parking));
        labelwifi=new Label(String.valueOf(wifi));
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
