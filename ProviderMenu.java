package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Objects;

public class ProviderMenu {

    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> rented = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String,String> rentals= new HashMap<String,String>();
    protected HashMap<String,Rentable> rentalsV2= new HashMap<String,Rentable>();
    protected String usernam;
    protected String key;

    protected HashMap<String,String> rentcancel= new HashMap<String,String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();

    /**
     * <p>
     * This is the main menu/choice menu for the provider it is in a diffrent class
     * from the main to make the ui and the debuging easier it gets all the parameters
     * from the main.java and it prints what it need to in the command line/app
     *<br>
     * @param asvus, aausers, arentals, auser, arented, arentalsV2,rc,msg
     * @return -
     * @see -
     * @author
     */
    public void providerMenu(String asvus,HashMap<String,String> aausers,HashMap<String,String>arentals,
                             HashMap<String,User>auser,HashMap<String,String>arented,
                             HashMap<String,Rentable>arentalsV2,HashMap<String,String>rc,
                             HashMap<String,String>msg)

    {


        //start of ui
        System.out.println("---------------------");
        System.out.println("press 1 to add a room");
        System.out.println("press 2 to edit a room");
        System.out.println("press 3 to delete a room");
        System.out.println("press 4 to see your profile");
        System.out.println("press 5 to see your rooms");
        System.out.println("press 6 to see total reservations");
        System.out.println("press 7 to see total cancels");
        System.out.println("press 8 to see messages");
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

            case 1: { //press 1 to add a room

                System.out.println("Add room/home info:");

                System.out.println("Unique key(numbers/letters):");
                Scanner sc1 = new Scanner(System.in);
                String key = sc1.nextLine();
                this.key=key;

                System.out.println("price:");
                Scanner sc2 = new Scanner(System.in);
                int price = sc2.nextInt();

                System.out.println("Parking(true/false):");
                Scanner sc3 = new Scanner(System.in);
                boolean parking= sc3.nextBoolean();

                System.out.println("wifi(true/false):");
                Scanner sc4 = new Scanner(System.in);
                boolean wifi= sc4.nextBoolean();

                System.out.println("size:");
                Scanner sc5 = new Scanner(System.in);
                int size = sc5.nextInt();

                System.out.println("press 1 to add it as a short rent place eg. hotel room:");
                System.out.println("press 2 to add it as a long rent place eg. " +
                                    "house rentable per months:");
                Scanner sc6 = new Scanner(System.in);
                int rent = sc6.nextInt();

                if(rent==1)
                {
                   Room rent1 =new Room(key,price,usernam,parking,wifi,
                            size,true,true,false);
                   rentals.put(key,usernam);
                   rentalsV2.put(key,rent1);
                    System.out.println("Room crated successfully!");

                }
                else if (rent==2)
                {
                    Home rent2=new Home(key,price,usernam,parking,wifi,
                            size,true,false,true);
                    rentals.put(key,usernam);
                    rentalsV2.put(key,rent2);
                    System.out.println("Home crated successfully!");
                }
                else
                {
                    System.out.println("Stop tring to crash the program");
                    return ;
                }


                //here
                //choice for loop to the main menu or exit
               // System.out.println("If you want to return to the main menu press 1. If you want to" +
                      //  "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 2: { //press 2 to edit a room
                System.out.println("Edit room/home info:");

                System.out.println("Unique key of the room you want to edit:");
                Scanner sc1 = new Scanner(System.in);
                String key = sc1.nextLine();
                this.key=key;

                System.out.println("price:");
                Scanner sc2 = new Scanner(System.in);
                int price = sc2.nextInt();

                System.out.println("Parking(true/false):");
                Scanner sc3 = new Scanner(System.in);
                boolean parking= sc3.nextBoolean();

                System.out.println("wifi(true/false):");
                Scanner sc4 = new Scanner(System.in);
                boolean wifi= sc4.nextBoolean();

                System.out.println("size:");
                Scanner sc5 = new Scanner(System.in);
                int size = sc5.nextInt();

                System.out.println("press 1 to edit a room:");
                System.out.println("press 2 to edit a house:");
                Scanner sc6 = new Scanner(System.in);
                int rent = sc6.nextInt();

                if(rent==1)
                {
                    for (Map.Entry<String, String> e : rentals.entrySet()) {
                        if (Objects.equals(usernam, e.getValue()) && Objects.equals(key, e.getKey())) {
                            Room rd1 = new Room(key, price, usernam, parking, wifi,
                                    size, true, true, false);

                            rentals.put(key, usernam);
                            rentalsV2.put(key, rd1);
                            System.out.println("Room edited successfully!");
                        }
                    }

                }
                else if (rent==2)
                {
                    for (Map.Entry<String, String> e : rentals.entrySet()) {
                        if (Objects.equals(usernam, e.getValue()) && Objects.equals(key, e.getKey())) {
                            Home rent2 = new Home(key, price, usernam, parking, wifi,
                                    size, true, false, true);
                            rentals.put(key, usernam);
                            rentalsV2.put(key, rent2);
                            System.out.println("Home edited successfully!");
                        }
                    }

                }
                else
                {
                    System.out.println("Sure you crashed it hahaha");
                    return ;
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
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 3: { //press 3 to delete a room
                System.out.println("Delete room/home info:");

                System.out.println("Unique key of the room you want to delete:");
                Scanner sc1 = new Scanner(System.in);
                String key = sc1.nextLine();
                this.key=key;
                for (Map.Entry<String, String> e : rentals.entrySet()) {
                    if (Objects.equals(usernam, e.getValue()) && Objects.equals(key, e.getKey())) {
                        rentals.remove(key);
                        rentalsV2.remove(key);
                        System.out.println("Room/Home deleted successfully!");
                    }
                }

                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                     //   "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 4: { //press 4 to see your profile

                for (Map.Entry<String, User> e : user.entrySet()) {
                    if (Objects.equals(usernam, e.getKey())) {
                        Provider u2 = new Provider();
                        u2.profile(e.getValue());
                    }
                }

                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                    //    "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 5: { //press 5 to see your rooms
                for (Map.Entry<String, String> e : rentals.entrySet()) {
                    for (Map.Entry<String, Rentable> j : rentalsV2.entrySet()) {
                        if (Objects.equals(e.getValue(), usernam)&& Objects.equals(e.getKey(), j.getKey())) {
                            Rentable u3= new Rentable();
                            u3.display(j.getValue());
                        }
                    }

                }

                //here
                //choice for loop to the main menu or exit
                //System.out.println("If you want to return to the main menu press 1. If you want to" +
                      //  "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 6:{ //press 6 to see total reservations
                int reservations=0;
                for (Map.Entry<String, String> e : rentals.entrySet()) {
                    for(Map.Entry<String, String> j : rented.entrySet() ) {
                        if (Objects.equals(e.getValue(), usernam) &&
                                Objects.equals(e.getKey(), j.getKey()))
                            reservations ++;
                    }
                } //have you seen my controller?
                System.out.println("total reservations: "+reservations);

                //here
                //choice for loop to the main menu or exit
               // System.out.println("If you want to return to the main menu press 1. If you want to" +
                      //  "close the program press 2");

                System.out.println("---------------------");
                System.out.println("If you want to return to the main menu press 1");
                System.out.println("If you want to close the program press2");
                System.out.println("---------------------");

                Scanner e2 = new Scanner(System.in);
                int ep2 = e2.nextInt();
                if(ep2==1) {
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 7:{ //press 7 to see total cancels
                int cancels=0;

                    for(Map.Entry<String, String> j : rentcancel.entrySet() ) {
                        if (Objects.equals(j.getValue(), usernam))
                            cancels++;
                    }

                System.out.println("total reservations: "+cancels);

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
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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

            case 8:{ //press 8 to see messages
                System.out.println("Messages:");
                for (Map.Entry<String, String> e : messages.entrySet()) {
                    if (Objects.equals(usernam, e.getValue())) {
                        System.out.println("Sender: Admin," + " Receiver: " + e.getValue()
                                + ", Message: " + e.getKey());
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
                    ProviderMenu dummy3 = new ProviderMenu();
                    dummy3.providerMenu(this.usernam, this.ausers, this.rentals, this.user, this.rented,
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
