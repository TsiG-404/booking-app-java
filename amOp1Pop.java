package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class amOp1Pop extends JFrame {

    protected HashMap<String, String> ausers = new HashMap<String, String>();

    private JTextField textSearch;
    private JLabel labelSearch;
    private JTextField result;



    /**
     * <p>
     *this is the gui and code for the choice to search a user in the admin menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public amOp1Pop(HashMap<String,String> us) {
        this.ausers=us;
        setTitle("Search User");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        setSize(400, 300);
        GridLayout layout = new GridLayout(4, 2, 2, 2);
        panel1.setLayout(layout);

        labelSearch = new JLabel("Username of the user:");
        panel1.add(labelSearch);
        textSearch = new JTextField("");
        panel1.add(textSearch);
        result = new JTextField("user:");
        result.setEditable(false);
        panel1.add(result);

        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        JButton search = new JButton("search user");
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                csearch();
            }
        });
        panel2.add(search);
        add(panel2, BorderLayout.PAGE_END);

        csearch();
        pack();
        setVisible(true);
    }

    private void csearch() {
        String name = new String(textSearch.getText());
        boolean found=false;
        for (String i : ausers.keySet()) {
            if (Objects.equals(i, name)) {
                result.setText("This user exist");
                found = true;
                break;
            }
        }
        if (found == false)
            result.setText("This user doesnt exist");


    }
    }



