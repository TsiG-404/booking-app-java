package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class amOp2Pop extends JFrame{
    protected HashMap<String, String> rented = new HashMap<String, String>();

    private JTextField textSearch;
    private JLabel labelSearch;
    private JTextField result;


    /**
     * <p>
     *this is the gui and code for the choice to search a reservation in the admin menu made with java swing
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    public amOp2Pop(HashMap<String,String> rn) {
        this.rented=rn;
        setTitle("Search reservation");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel1 = new JPanel();
        setSize(400, 300);
        GridLayout layout = new GridLayout(4, 2, 2, 2);
        panel1.setLayout(layout);

        labelSearch = new JLabel("write the name of the room:");
        panel1.add(labelSearch);
        textSearch = new JTextField("");
        panel1.add(textSearch);
        result = new JTextField("the room is:");
        result.setEditable(false);
        panel1.add(result);

        add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        JButton search = new JButton("search reservation");
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
        for (String i : rented.keySet()) {
            if (Objects.equals(i, name)) {
                result.setText("The room is rented");
                found = true;
                break;
            }
        }
        if (found == false)
            result.setText("The room isnt rented");


    }
}



