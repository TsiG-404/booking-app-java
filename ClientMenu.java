package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Objects;


public class ClientMenu {

    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> rented = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String,User>();
    protected HashMap<String,String> rentals= new HashMap<String,String>();
    protected HashMap<String,Rentable> rentalsV2= new HashMap<String,Rentable>();
    protected String usernam;

    protected String howner;

    protected HashMap<String,String> rentcancel= new HashMap<String,String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();

    /**
     * <p>
     * This is the main menu/choice menu for the client it is in a diffrent class
     * from the main to make the ui and the debuging easier it gets all the parameters
     * from the main.java and it prints what it need to in the command line/app
     *<br>
     * @param asvus, aausers, arentals, auser, arented, arentalsV2,rc,msg
     * @return -
     * @see -
     * @author
     */
    public void clientMenu(String asvus,HashMap<String,String> aausers,HashMap<String,String>arentals,
                           HashMap<String,User>auser,HashMap<String,String>arented,
                            HashMap<String,Rentable>arentalsV2,HashMap<String,String>rc,
                           HashMap<String,String>msg) {



    //start of ui
    System.out.println("---------------------");
    System.out.println("press 1 to search rooms");
    System.out.println("press 2 to reserve a room");
    System.out.println("press 3 to cancel a reservation");
    System.out.println("press 4 to see your profile");
    System.out.println("press 5 to see messages");
    System.out.println("press any other number to close the program");
    System.out.println("---------------------");
    //end of ui

        this.usernam=asvus;
        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;




        Scanner oo2 = new Scanner(System.in);
        int op2 = oo2.nextInt();
        switch (op2) {

            case 4: { //press 1 to see your profile

                for (Map.Entry<String, User> e : user.entrySet()) {
                    if (Objects.equals(usernam, e.getKey())) {
                        Client u1= new Client();
                        u1.profile(e.getValue());


                    }
                }


                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                       // "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ClientMenu dummy1 = new ClientMenu();
                    dummy1.clientMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
                            this.rentalsV2, this.rentcancel, this.messages);
                }
                else
                {
                    System.out.println("Thank you for using our sofware "+usernam);
                    System.exit(404);
                }
                //end of loop
                //break;
            }

            case 2:{ //press 2 to reserve a room
                System.out.println("Rent room/home info:");

                System.out.println("Unique key(numbers/letters):");
                Scanner sc1 = new Scanner(System.in);
                String key = sc1.nextLine();
                rented.put(key,usernam);
                for (Map.Entry<String, String> e : rentals.entrySet()) {
                    if (Objects.equals(key, e.getKey())) {
                        this.howner = e.getValue();
                    }
                }
                rentals.remove(key);
                System.out.println("room successfully rented!");

                //here
                //choice for loop to the main menu or exit
               // System.out.println("If you want to return to the main menu press 1. If you want to" +
                       //"close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ClientMenu dummy1 = new ClientMenu();
                    dummy1.clientMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
                            this.rentalsV2, this.rentcancel, this.messages);
                }
                else
                {
                    System.out.println("Thank you for using our sofware "+usernam);
                    System.exit(404);
                }
                //end of loop
                //break;
            }

            case 3:{ //press 3 to cancel a reservation
                System.out.println("Cancel room info:");

                System.out.println("Unique key(numbers/letters):");
                Scanner sc1 = new Scanner(System.in);
                String key = sc1.nextLine();
                for (Map.Entry<String, String> e : rented.entrySet()) {
                    if (Objects.equals(key, e.getKey()) && Objects.equals(usernam, e.getValue())) {
                        rented.remove(key);                                  //🎮
                        rentcancel.put(key,howner);
                        rentals.put(key,howner);
                    }
                }
                System.out.println("rent canceled successfully");


                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                       // "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ClientMenu dummy1 = new ClientMenu();
                    dummy1.clientMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
                            this.rentalsV2, this.rentcancel, this.messages);
                }
                else
                {
                    System.out.println("Thank you for using our sofware "+usernam);
                    System.exit(404);
                }
                //end of loop
                //break;
            }

            case 1:{ //press 4 to search rooms

                for (Map.Entry<String, Rentable> e : rentalsV2.entrySet()) {

                    for(Map.Entry<String, String> j : rented.entrySet() ) {
                        if (Objects.equals(e.getKey(), j.getKey())) {
                            System.out.println("↓↓ Rented ↓↓");
                            Rentable u3= new Rentable();

                            u3.display(e.getValue());
                        }
                    }
                            System.out.println("↓↓ Available ↓↓");
                        Rentable u3= new Rentable();

                        u3.display(e.getValue());

                }

                //here

                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                        //"close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ClientMenu dummy1 = new ClientMenu();
                    dummy1.clientMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
                            this.rentalsV2, this.rentcancel, this.messages);
                }
                else
                {
                    System.out.println("Thank you for using our sofware "+usernam);
                    System.exit(404);
                }
                //end of loop

            }

            case 5:{ //press 5 to see messages
                System.out.println("Messages:");
                for (Map.Entry<String, String> e : messages.entrySet()) {
                    if (Objects.equals(usernam, e.getValue())) {
                        System.out.println("Sender: Admin," + " Receiver: " + e.getValue()
                                + ", Message: " + e.getKey());
                    }
                }

                //here
                //choice for loop to the main menu or exit
               // System.out.println("If you want to return to the main menu press 1. If you want to" +
                       // "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ClientMenu dummy1 = new ClientMenu();
                    dummy1.clientMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
                            this.rentalsV2, this.rentcancel, this.messages);
                }
                else
                {
                    System.out.println("Thank you for using our sofware "+usernam);
                    System.exit(404);
                }
                //end of loop
                //break;
            }


            default :{ //press any to close the program

                System.out.println("Thank you for using our sofware "+usernam);
                System.exit(404);
            }



        }







}

}
