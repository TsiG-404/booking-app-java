package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class amOp3Pop extends JFrame{
    private JTextField textreciver;
    private JLabel labelreciver;
    private JTextField textmessage;
    private JLabel labelmessage;

    protected HashMap<String,String> message=new HashMap<>();

    private JTextField textInterest;
    private JLabel labelInterest;
    private JTextField textDose;
    private JLabel labelDose;

    protected boolean ps=false;


    /**
     * <p>
     *this is the gui and code for the choice to send a message in the admin menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public amOp3Pop(HashMap<String,String>msg) {
        this.message=msg;
        setTitle("Send message");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder(" message ");
        panel1.setBorder(border);
        GridLayout layout = new GridLayout(4, 2, 2, 2);
        panel1.setLayout(layout);

        labelreciver = new JLabel("Receiver:");
        panel1.add(labelreciver);
        textreciver = new JTextField("");
        panel1.add(textreciver);

        labelmessage = new JLabel("Message:");
        panel1.add(labelmessage);
        textmessage = new JTextField("");
        panel1.add(textmessage);

        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        JButton bc = new JButton("Send");
        bc.addActionListener(new ActionListener() {
        //bc.addMouseListener(new MouseAdapter() {

            @Override
            public void actionPerformed(ActionEvent e) {
            //public void mouseClicked(MouseEvent e) {

                    String sms = new String(textmessage.getText());
                    String rec = new String(textreciver.getText());
                    message.put(sms, rec);
                    System.out.println("2messages:");
                    System.out.println(message);


                send();

            }
        });
        panel2.add(bc);
        add(panel2, BorderLayout.PAGE_END);

        send();
        pack();
        setVisible(true);
    }

    boolean send() {




        //long amount = Integer.parseInt(textAmount.getText());
        /*
       if(ps==true ) {
            String sms = new String(textmessage.getText());
            String rec = new String(textreciver.getText());
            message.put(sms, rec);
           System.out.println("2messages:");
           System.out.println(message);

        }
       else
       {

           System.out.println("nope");
       }

         */
        return ps;

    }
    public HashMap<String,String> getMessage()
    {
        System.out.println("messages:");
        System.out.println(message);
        return this.message;
    }
    public boolean tt()
    {
        return ps;
    }

}
