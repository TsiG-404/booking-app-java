package com.company;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class AdminMenu {

    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> rented = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();

    protected HashMap<String, String> messages = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();




    //see users
    public JMenu guiOp1(HashMap<String,String> us)
    {
        this.ausers=us;
        //this.roles=rl;

        JMenu submenu = new JMenu("See users");
        for (String i : ausers.keySet()) {

            //System.out.println(i);

            JMenuItem submenuItem1 = new JMenuItem(i);
            submenu.add(submenuItem1);
        }
        return submenu;
    }
    //search users
    public void guiOp2()
    {

    }
    //see reservations
    public void guiOp3()
    {

    }
    //search reservation
    public void guiOp4()
    {

    }
    //send message
    public void guiOp5()
    {

    }

    /**
     * <p>
     * This is the main menu/choice menu for the admin it is in a diffrent class
     * from the main to make the ui and the debuging easier it gets all the parameters
     * from the main.java and it prints what it need to in the command line/app
     *<br>
     * @param aausers, arentals, auser, msg
     * @return -
     * @see -
     * @author
     */
    public void adminMenu(HashMap<String,String> aausers,HashMap<String,String>arented,
                          HashMap<String,User>auser, HashMap<String,String>msg) {


        //start of ui

        System.out.println("---------------------");
        System.out.println("press 1 to see all users");
        System.out.println("press 2 to search a user");
        System.out.println("press 3 to see reservations");
        System.out.println("press 4 to search a reservation");
        System.out.println("press 5 to send a message to a user");
        System.out.println("press any other number to close the program");
        System.out.println("---------------------");

        //end of ui


        this.ausers = aausers;
        this.rented = arented;
        this.user = auser;
        this.messages=msg;



        Scanner oo2 = new Scanner(System.in);
        int op2 = oo2.nextInt();
        switch (op2) {
            case 1: { //press 1 to see all users
                for (String i : ausers.keySet()) {
                    System.out.println(i);
                    }

                //oh sorry i forgot my phone 📱

                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                       // "close the program press2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    AdminMenu dummy2 = new AdminMenu();
                    dummy2.adminMenu( this.ausers,  this.rented, this.user, this.messages);
                }
                else
                {
                    System.out.println("Thank you for working on our software ");
                    System.exit(404);
                }
                //end of loop

                //break;
                }

                case 2: { //press 2 to search a user

                    boolean found = false;
                    System.out.println("write the username of the user:");
                    Scanner sc1 = new Scanner(System.in);
                    String ser1 = sc1.nextLine();
                    for (String i : ausers.keySet()) {
                        if (Objects.equals(i, ser1)) {
                            System.out.println("This user exists with the username");
                            System.out.println(i);
                            found = true;
                            break;
                        }
                    }
                    if (found == false)
                        System.out.println("this user doesnt exist");

                    //here
                    //choice for loop to the main menu or exit
                    //System.out.println("If you want to return to the main menu press 1. If you want to " +
                            //"close the program press2");

                    System.out.println("---------------------");
                    System.out.println("If you want to return to the main menu press 1");
                    System.out.println("If you want to close the program press2");
                    System.out.println("---------------------");

                    Scanner e2 = new Scanner(System.in);
                    int ep2 = e2.nextInt();
                    if(ep2==1) {
                        AdminMenu dummy2 = new AdminMenu();
                        dummy2.adminMenu( this.ausers,  this.rented, this.user, this.messages);
                    }
                    else
                    {
                        System.out.println("Thank you for working on our software ");
                        System.exit(404);
                    }
                    //end of loop
                    //break;


                }

                case 3: { //press 3 to see reservations
                    for (String i : rented.keySet()) {
                        if(i=="") // i need to find what it saves in a null hashmap
                        {//who cares if it is null it doesnt return anything if it
                            //has objs it prints them sooo
                            System.out.println("none");
                            break;
                        }
                        System.out.println("");
                        System.out.println(i);
                    }

                    //here
                    //choice for loop to the main menu or exit
                    //System.out.println("If you want to return to the main menu press 1. If you want to" +
                            //"close the program press2");

                    System.out.println("---------------------");
                    System.out.println("If you want to return to the main menu press 1");
                    System.out.println("If you want to close the program press2");
                    System.out.println("---------------------");

                    Scanner e2 = new Scanner(System.in);
                    int ep2 = e2.nextInt();
                    if(ep2==1) {
                        AdminMenu dummy2 = new AdminMenu();
                        dummy2.adminMenu( this.ausers,  this.rented, this.user, this.messages);
                    }
                    else
                    {
                        System.out.println("Thank you for working on our software ");
                        System.exit(404);
                    }
                    //end of loop
                    //break;
                }

                case 4: { //press 4 to search a reservation

                    boolean found = false;
                    System.out.println("write the name of the room:");
                    Scanner sc1 = new Scanner(System.in);
                    String ser1 = sc1.nextLine();
                    for (String i : rented.keySet()) {
                        if (Objects.equals(i, ser1)) {
                            System.out.println("It is rented");

                            found = true;
                            break;
                        }
                    }
                    if (found == false)
                        System.out.println("this room isnt rented or it doesnt exist");

                    //here
                    //choice for loop to the main menu or exit
                   // System.out.println("If you want to return to the main menu press 1. If you want to" +
                           // "close the program press2");

                    System.out.println("---------------------");
                    System.out.println("If you want to return to the main menu press 1");
                    System.out.println("If you want to close the program press2");
                    System.out.println("---------------------");

                    Scanner e2 = new Scanner(System.in);
                    int ep2 = e2.nextInt();
                    if(ep2==1) {
                        AdminMenu dummy2 = new AdminMenu();
                        dummy2.adminMenu( this.ausers,  this.rented, this.user, this.messages);
                    }
                    else
                    {
                        System.out.println("Thank you for working on our software ");
                        System.exit(404);
                    }
                    //end of loop
                    //break;
                }

                case 5: { //press 5 to send a message to a user
                    System.out.println("Receiver:");
                    Scanner rec = new Scanner(System.in);
                    String receive = rec.nextLine();

                    System.out.println("Message:");
                    Scanner mssg = new Scanner(System.in);
                    String message = mssg.nextLine();

                    messages.put(message,receive);
                    System.out.println("Message successfully send to " +receive);

                    //here
                    //choice for loop to the main menu or exit
                   // System.out.println("If you want to return to the main menu press 1. If you want to" +
                           // "close the program press2");

                    System.out.println("---------------------");
                    System.out.println("If you want to return to the main menu press 1");
                    System.out.println("If you want to close the program press2");
                    System.out.println("---------------------");

                    Scanner e2 = new Scanner(System.in);
                    int ep2 = e2.nextInt();
                    if(ep2==1) {
                        AdminMenu dummy2 = new AdminMenu();
                        dummy2.adminMenu( this.ausers,  this.rented, this.user, this.messages);
                    }
                    else
                    {
                        System.out.println("Thank you for working on our software ");
                        System.exit(404);
                    }
                    //end of loop
                    //break;
                }



            default :{ //press any to close the program
                System.out.println("Thank you for working on our software ");
                System.exit(404);
            }



        }

        }
    }
