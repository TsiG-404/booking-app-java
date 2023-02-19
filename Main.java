package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.lang.String;
import java.util.Map;
import java.util.HashSet;




public class Main {

    /**
     * <p>
     * This is the main file to make this program work it has some presaved users and rentables for the
     * part one to help with the testing here everything starts also most of the stuff work with
     * hashmaps wow they are practical! but it also uses the sub objects. For the first part it
     * will also have the login/register script but in the second part it will go in a diffrent file
     * like the user menus to help with the ui but other than that it is pretty clean in here 404 ftw!!
     *<br>
     * @param -
     * @return -
     * @see -
     * @author
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //this is for the login username,password
        HashMap<String, String> ausers = new HashMap<String, String>();

        //key,owner it helps with the delete key,renter
        HashMap<String, String> rentals = new HashMap<String, String>();

        //it shows the room key,object
        HashMap<String,Rentable> rentalsV2 = new HashMap<String,Rentable>();

        //key,renter it helps to move it in the rented list
        HashMap<String,String> rented= new HashMap<String,String>();



        // username,role it helps to find the right menu
        HashMap<String,String> roles= new HashMap<String,String>();

        //this helps with the profiles
        HashMap<String,User> user = new HashMap<String,User>();

        //this helps the providers to see total cancels room,owner
        HashMap<String,String> rentcancel= new HashMap<String,String>();

        //this is the message system message,receiver if the message is the same
        //the first one gets deleted
        HashMap<String,String> messages= new HashMap<String,String>();








        //premade users and rooms
        Admin a=new Admin("admin1","1234");
        Admin b=new Admin("admin2", "456");

        Provider c=new Provider
                ("srent","1111","takis pel", "str 404");

        Client d=new Client
                ("user1", "7878", "agamemnon kato", "str 502");

        Client ee=new Client
                ("u1", "22", "gianis papas", "dim 404");
        Home rent1=new Home
                ("1",210,"srent",true,false,
                        34,true,false,true);
        Room rent2=new Room("2",25,"srent",false,false,
                27,true,true,false);




        ausers.put(a.getUsername(),a.getPassword());
        ausers.put(b.getUsername(),b.getPassword());
        ausers.put(c.getUsername(),c.getPassword());
        ausers.put(d.getUsername(),d.getPassword());
        ausers.put(ee.getUsername(),ee.getPassword());

        roles.put(a.getUsername(),"admin");
        roles.put(b.getUsername(),"admin");
        roles.put(c.getUsername(),"provider");
        roles.put(d.getUsername(),"client");
        roles.put(ee.getUsername(),"client");

        rentals.put("1","srent");
        rentalsV2.put("1",rent1);
        rentals.put("2","srent");
        rentalsV2.put("2",rent2);

        user.put(a.getUsername(),a);
        user.put(b.getUsername(),b);
        user.put(c.getUsername(),c);
        user.put(d.getUsername(),d);
        user.put(ee.getUsername(),ee);


        //u1 22

        //messages.put("wellcome you are a client","user1");
        messages.put("wellcome you are a provider","srent");



        //end of premade users and rooms

        //System.out.println("deafult examples");
        //System.out.println(ausers);




        //start of import process of the files
        Files im1=new Files();
        ausers=im1.import1();

        Files im2=new Files();
        rented=im2.import2();

        Files im3=new Files();
        user=im3.import3();

        Files im4=new Files();
        rentals=im4.import4();

        Files im5=new Files();
        rentalsV2=im5.import5();

        Files im6=new Files();
        rentcancel=im6.import6();

        Files im7=new Files();
        messages=im7.import7();

        Files im8=new Files();
        roles=im8.import8();






/*
        //exoprt test
        Files tnq= new Files();
        tnq.export1(ausers,rented,user,rentals,rentalsV2,rentcancel,messages,roles);
        System.exit(12334);
        */


        //end of import process of the files
        System.out.println("after import");
        System.out.println(ausers);
        System.out.println("after import");
        System.out.println(roles);

    //this saves the loged username to send the user to their menu
    String svus="";


    //with the gui we can use the setMenu to send the hashmaps
        Logreg hm= new Logreg();
        hm.setMenu(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);




        //System.out.println(messages);
        //System.out.println(ausers);

        lrGui frame = new lrGui(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles);
        //int op1= frame.ch();
        //System.out.println(op1);

    //this is the first selection menu
    System.out.println("---------------------");
    System.out.println("press 1 for register");
    System.out.println("press 2 for login");
    System.out.println("---------------------");
    Scanner oo1= new Scanner (System.in);
    int op1=oo1.nextInt();

    switch(op1) {

        case 1: {
            //register

            Logreg ap1=new Logreg();
            ap1.register(user,roles,ausers);
            //here we should save to the files but we can do that after we crate the files for save**
            Files tns= new Files();
            tns.export1(ausers,rented,user,rentals,rentalsV2,rentcancel,messages,roles);


            return;
            //end of register
        }

        case 2: {
            //login
            Logreg ap2=new Logreg();
            svus=ap2.login(ausers);

            break;
            //end of login
        }





    }
    //any other option in the first choice
    if(op1!=1 && op1!=2)
    {
        System.out.println("OK error 502");
        System.exit(502);

    }


    //this use the menu method to send the users to their menus
        Logreg ap3=new Logreg();
        ap3.menus(ausers,rentals,user,rented,rentalsV2,rentcancel,messages,roles,svus);


    }
}
