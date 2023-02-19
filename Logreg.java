package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


import javax.swing.*;
import javax.swing.border.TitledBorder;



public class Logreg extends JFrame{
    protected HashMap<String, String> ausers = new HashMap<String, String>();
    protected HashMap<String, String> roles = new HashMap<String, String>();
    protected HashMap<String, User> user = new HashMap<String, User>();
    protected HashMap<String, String> rentals = new HashMap<String, String>();
    protected HashMap<String, Rentable> rentalsV2 = new HashMap<String, Rentable>();
    protected HashMap<String, String> rented = new HashMap<String, String>();

    protected HashMap<String, String> rentcancel = new HashMap<String, String>();
    protected HashMap<String, String> messages = new HashMap<String, String>();



    protected String gusr;
    protected String gpasw;
    protected String svus2;

//end of gui register values

    //GUI
    //GUI


//nope difrent files for gui


    //GUI
    //GUI


    //CODE
    //CODE
    //setter to set hash maps of login
    /**
     * <p>
     *this sets the login info
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public void setLog(HashMap<String, String> aausers)
    {
        this.ausers=aausers;
    }

    //setter to set hash maps of register
    /**
     * <p>
     *this sets the register info
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public void setReg(HashMap<String, User> auser, HashMap<String, String> aroles, HashMap<String, String> aausers)
    {
        this.user = auser;
        this.roles = aroles;
        this.ausers = aausers;
    }

    public HashMap<String,String> getau()
    {
        return this.ausers;
    }
    /**
     * <p>
     *this sets the menu info
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    //setter to set hash maps of menus
    public void setMenu(HashMap<String, String> aausers, HashMap<String, String> arentals,
                        HashMap<String, User> auser, HashMap<String, String> arented,
                        HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                        HashMap<String, String> msg, HashMap<String, String> aroles)
    {
      this.ausers=aausers;
      this.rentals=arentals;
      this.user=auser;
      this.rented=arented;
      this.rentalsV2=arentalsV2;
      this.rentcancel=rc;
      this.messages=msg;
      this.roles=aroles;
        //System.out.println(ausers);
      //System.out.println(ausers);

    }

   //THIS IS THE GUI TWIN
    //THIS IS THE GUI TWIN
    /**
     * <p>
     *this is sends the info to the register gui
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    public void guiRegister(HashMap<String, String> aausers, HashMap<String, String> arentals,
                            HashMap<String, User> auser, HashMap<String, String> arented,
                            HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                            HashMap<String, String> msg, HashMap<String, String> aroles,
                            String usr,String pass, String fn, String ad, int ch
                                ) throws FileNotFoundException {
        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;
        System.out.println(ausers);

        //this is the register for users/providers

        String usern1 = usr;

        String pass1 = pass;

        String nam1 = fn;

        String add1 = ad;

        int op2 = ch;


        //before ui
        if (op2 == 1) {
            user.put(usern1, new Client(usern1, pass1, nam1, add1));
            roles.put(usern1, "client");
        } else {
            user.put(usern1, new Provider(usern1, pass1, nam1, add1));
            roles.put(usern1, "provider");
        }
        ausers.put(usern1, nam1);
        //before ui

        System.out.println("Account created (^:");

        Files tns= new Files();
        tns.export1(ausers,rented,user,rentals,rentalsV2,rentcancel,messages,roles);
        System.exit(505);



    }

    /**
     * <p>
     *this is sends the info to the login gui and it returns int if the given info is ok or not
     *<br>
     * @param -
     * @return result
     * @see -
     * @author tsig-404
     */

    //this is the login method for the gui program
    public int guiLogin(String un,String ps,HashMap<String,String>au) {
        //print();
        this.ausers=au;
        System.out.println(ausers);

        int result=-1;
        //String s=e.toString();
        String str1=un.toString();
        String str2=ps.toString();


        boolean loged = false;



        //i dont think that it gets in for
        for (Map.Entry<String, String> e : ausers.entrySet()) {

            System.out.println(e.getKey());
            System.out.println(str1);
           if (Objects.equals(str1, e.getKey()) && Objects.equals(str2, e.getValue())) {
            //if(str1.equals(e.getKey())&& str2.equals(e.getValue())){
           // if((str2 == e.getValue()) ){
                loged = true;
                svus2 = str1;
            }
        }


        if (loged != true) {
            //System.out.println("Wrong login information");
            //System.exit(101);
            result=0;
            return result;
        } else {
            result=1;
            return result;
        }

    }

    /**
     * <p>
     *this is sends the info to the menus gui returns int to send them to the correct menu
     *<br>
     * @param -
     * @return type
     * @see -
     * @author tsig-404
     */
    public int guiMenus(HashMap<String, String> aausers, HashMap<String, String> arentals,
                      HashMap<String, User> auser, HashMap<String, String> arented,
                      HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                      HashMap<String, String> msg, HashMap<String, String> aroles, String asvus) {

        this.ausers=aausers;
        this.rentals=arentals;
        this.user=auser;
        this.rented=arented;
        this.rentalsV2=arentalsV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;

        svus2 = asvus;
        int type=0;


        for (Map.Entry<String, String> entry : roles.entrySet()) {
            if ((entry.getValue().contains("admin")) && (Objects.equals(svus2, entry.getKey()))) {
                System.out.println("Wellcome admin " + svus2);
                //AdminMenu dummy1 = new AdminMenu();
                //dummy1.adminMenu(ausers, rented, user, messages);

                type=11;
                break;
                //return 11;
            } else if ((entry.getValue().contains("client")) && (Objects.equals(svus2, entry.getKey()))) {
                System.out.println("Wellcome client " + svus2);
                //ClientMenu dummy2 = new ClientMenu();
                //dummy2.clientMenu(svus2, ausers, rentals, user, rented, rentalsV2, rentcancel, messages);

                type=22;
                break;
                //return 22;
            } else if ((entry.getValue().contains("provider")) && (Objects.equals(svus2, entry.getKey()))) {
                System.out.println("Wellcome provider " + svus2);
                //ProviderMenu dummy3 = new ProviderMenu();
                //dummy3.providerMenu(svus2, ausers, rentals, user, rented, rentalsV2, rentcancel, messages);

                type=33;
                break;
                //return 33;
            }
        }
        return type;
    }
    //END OF GUI TWINS
    //END OF GUI TWINS


    /**
     * <p>
     *this doesnt get used anymore
     *<br>
     * @param -
     * @return svus
     * @see -
     * @author tsig-404
     */
    //this is the login method in class
    public String login(HashMap<String, String> aausers) {
        String svus = "";
        this.ausers = aausers;
        System.out.println("Username:");
        Scanner ua = new Scanner(System.in);
        String str1 = ua.nextLine();
        System.out.println("Password:");
        Scanner pa = new Scanner(System.in);
        String str2 = pa.nextLine();

        boolean loged = false;


        for (Map.Entry<String, String> e : this.ausers.entrySet()) {
            if (Objects.equals(str1, e.getKey()) && Objects.equals(str2, e.getValue())) {
                loged = true;
                svus = str1;
            }
        }


        if (loged != true) {
            System.out.println("Wrong login information");
            System.exit(101);
            return "";
        } else {
            return svus;
        }

    }

    /**
     * <p>
     *this doesnt get used anymore
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */

    //this is the register method in class
    public void register(HashMap<String, User> auser, HashMap<String, String> aroles, HashMap<String, String> aausers) throws FileNotFoundException {
        this.user = auser;
        this.roles = aroles;
        this.ausers = aausers;

        //this is the register for users/providers
        System.out.println("Username:");
        Scanner ss1 = new Scanner(System.in);
        String usern1 = ss1.nextLine();

        System.out.println("Password:");
        Scanner ss2 = new Scanner(System.in);
        String pass1 = ss2.nextLine();

        System.out.println("Full name:");
        Scanner ss3 = new Scanner(System.in);
        String nam1 = ss3.nextLine();

        System.out.println("Address");
        Scanner ss4 = new Scanner(System.in);
        String add1 = ss4.nextLine();


        System.out.println("press 1 for client registration");
        System.out.println("press 2 for provider registration");
        Scanner ss5 = new Scanner(System.in);
        int op2 = ss5.nextInt();


        //before ui
        if (op2 == 1) {
            user.put(usern1, new Client(usern1, pass1, nam1, add1));
            roles.put(usern1, "client");
        } else {
            user.put(usern1, new Provider(usern1, pass1, nam1, add1));
            roles.put(usern1, "provider");
        }
        ausers.put(usern1, nam1);
        //before ui


        System.out.println("Account created (^:");

        //Files ts= new Files();
        //ts.export1(ausers,rented,user,rentals,rentalsV2,rentcancel,messages,roles);

    }


    /**
     * <p>
     *this doesnt get used anymore
     *<br>
     * @param -
     * @return
     * @see -
     * @author tsig-404
     */
    //this is the choose method to send user/admin/client to their menus
    public void menus(HashMap<String, String> aausers, HashMap<String, String> arentals,
                      HashMap<String, User> auser, HashMap<String, String> arented,
                      HashMap<String, Rentable> arentalsV2, HashMap<String, String> rc,
                      HashMap<String, String> msg, HashMap<String, String> aroles, String asvus) {

        this.ausers = aausers;
        this.rentals = arentals;
        this.user = auser;
        this.rented =arented;
        this.roles = aroles;
        String svus = asvus;


        for (Map.Entry<String, String> entry : roles.entrySet()) {
            if ((entry.getValue().contains("admin")) && (Objects.equals(svus, entry.getKey()))) {
                System.out.println("Wellcome admin " + svus);
                AdminMenu dummy1 = new AdminMenu();
                dummy1.adminMenu(ausers, rented, user, messages);
                break;
            } else if ((entry.getValue().contains("client")) && (Objects.equals(svus, entry.getKey()))) {
                System.out.println("Wellcome client " + svus);
                ClientMenu dummy2 = new ClientMenu();
                dummy2.clientMenu(svus, ausers, rentals, user, rented, rentalsV2, rentcancel, messages);
                break;
            } else if ((entry.getValue().contains("provider")) && (Objects.equals(svus, entry.getKey()))) {
                System.out.println("Wellcome provider " + svus);
                ProviderMenu dummy3 = new ProviderMenu();
                dummy3.providerMenu(svus, ausers, rentals, user, rented, rentalsV2, rentcancel, messages);
                break;
            }
        }



    }
    //CODE
    //CODE
}

