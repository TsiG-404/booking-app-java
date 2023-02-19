package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Files {

    public HashMap<String, String> ausers = new HashMap<String, String>();
    public HashMap<String, String> rented = new HashMap<String, String>();
    public HashMap<String, User> user = new HashMap<String, User>();
    public HashMap<String,String> rentals= new HashMap<String,String>();
    public HashMap<String,Rentable> rentalsV2= new HashMap<String,Rentable>();
    public HashMap<String,String> rentcancel= new HashMap<String,String>();
    public HashMap<String, String> messages = new HashMap<String, String>();
    public HashMap<String, String> roles = new HashMap<String, String>();

    //public ArrayList<String> kuser=new ArrayList<>();
    public ArrayList<Object> vuser=new ArrayList<>();
    public ArrayList<Object> vrentalsv2=new ArrayList<>();


    //import from file
    /**
     * <p>
     *gets hashmaps from a file for the hashmap ausers
     *<br>
     * @param -
     * @return ausers
     * @see -
     * @author tsig-404
     */

    public HashMap<String,String> import1() throws IOException, ClassNotFoundException {
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("ausers.bin"));

        for (String key : properties1.stringPropertyNames()) {
            ausers.put(key, properties1.get(key).toString());
        }
        return ausers;

    }

    /**
     * <p>
     *gets hashmaps from a file for the hashmap rented
     *<br>
     * @param -
     * @return rented
     * @see -
     * @author tsig-404
     */

    public HashMap<String,String> import2() throws IOException, ClassNotFoundException {
        Properties properties2 = new Properties();
        properties2.load(new FileInputStream("rented.bin"));

        for (String key : properties2.stringPropertyNames()) {
            rented.put(key, properties2.get(key).toString());
        }
        return rented;

    }


    /**
     * <p>
     *gets hashmaps from a file for the hashmap users
     *<br>
     * @param -
     * @return users
     * @see -
     * @author tsig-404
     */

    public HashMap<String, User> import3() throws IOException {

        ArrayList<String> kuser=new ArrayList<>();
        //new try method

        //this needs for every hashmap 1
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("ausers.bin"));

        for (String key : properties1.stringPropertyNames()) {
            ausers.put(key, properties1.get(key).toString());
        }
        //end of read for a hashmap 1

        for (Map.Entry<String, String> entry : ausers.entrySet()) {
            kuser.add(entry.getKey());


        }
        //System.out.println(kuser);

        //ArrayList<Object> objects = new ArrayList<Object>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("user.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        User obj = null;

        boolean isExist = true;

        while (isExist) {
            try {
                if (fis.available() != 0) {

                    try {
                        obj = (User) ois.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    vuser.add(obj);
                } else {
                    isExist = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println("ok got in import 2");
            //System.out.println(vuser);
            //System.out.println(kuser);
        }


        for (int i = 0; i < kuser.size(); i++) {
            user.put(kuser.get(i), (User) vuser.get(i));
        }


        //System.out.println("inside import 2");
        for (Map.Entry<String, User> e : user.entrySet()) {
            Client u1 = new Client();
            //u1.profile(e.getValue());
            //System.out.println("");
        }

        //System.out.println(user);
        //System.out.println("out");
        return user;

//end of try
//it works but i need to do a difrrent import for every hashmap
        //spoiler alert yep also you had to change the items from the constructors and make them serializable
        //to work with it and it took you 5 days to find this small bug

    }


    /**
     * <p>
     *gets hashmaps from a file for the hashmap rentals
     *<br>
     * @param -
     * @return rentals
     * @see -
     * @author tsig-404
     */
    public HashMap<String,String> import4() throws IOException, ClassNotFoundException {
        Properties properties4 = new Properties();
        properties4.load(new FileInputStream("rentals.bin"));

        for (String key : properties4.stringPropertyNames()) {
            rentals.put(key, properties4.get(key).toString());
        }
        return rentals;

    }


    /**
     * <p>
     *gets hashmaps from a file for the hashmap rentalsV2
     *<br>
     * @param -
     * @return rentalsV2
     * @see -
     * @author tsig-404
     */
    public HashMap<String, Rentable> import5() throws IOException {

        ArrayList<String> krentalsv2=new ArrayList<>();


        //this needs for every hashmap 5
        Properties properties5 = new Properties();
        properties5.load(new FileInputStream("rentals.bin"));

        for (String key : properties5.stringPropertyNames()) {
            rentals.put(key, properties5.get(key).toString());
        }
        //end of read for a hashmap 1

        for (Map.Entry<String, String> entry : rentals.entrySet()) {
            krentalsv2.add(entry.getKey());


        }
        //System.out.println(krentalsv2);

        //ArrayList<Object> objects = new ArrayList<Object>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("rentalsV2.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rentable obj5 = null;

        boolean isExist = true;

        while (isExist) {
            try {
                if (fis.available() != 0) {
                    try {
                        obj5 = (Rentable) ois.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    vrentalsv2.add(obj5);
                } else {
                    isExist = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println("ok got in import 5");
            //System.out.println(vrentalsv2);
            //System.out.println(krentalsv2);
        }


        for (int i = 0; i < krentalsv2.size(); i++) {
            rentalsV2.put(krentalsv2.get(i), (Rentable) vrentalsv2.get(i));
        }


        //System.out.println("inside import 5");
        for (Map.Entry<String, Rentable> e : rentalsV2.entrySet()) {
            Rentable u1 = new Rentable();
            //u1.display(e.getValue());
            //System.out.println("");
        }

        //System.out.println(rentalsV2);
        //System.out.println("out");
        return rentalsV2;


//it works but i nned to do a difrrent import for every hashmap

    }



    /**
     * <p>
     *gets hashmaps from a file for the hashmap rentcancel
     *<br>
     * @param -
     * @return rentcancel
     * @see -
     * @author tsig-404
     */
    public HashMap<String,String> import6() throws IOException, ClassNotFoundException {
        Properties properties6 = new Properties();
        properties6.load(new FileInputStream("rentcancel.bin"));

        for (String key : properties6.stringPropertyNames()) {
            rentcancel.put(key, properties6.get(key).toString());
        }
        return rentcancel;

    }

    /**
     * <p>
     *gets hashmaps from a file for the hashmap messages
     *<br>
     * @param -
     * @return messages
     * @see -
     * @author tsig-404
     */

    public HashMap<String,String> import7() throws IOException, ClassNotFoundException {
        Properties properties7 = new Properties();
        properties7.load(new FileInputStream("messages.bin"));

        for (String key : properties7.stringPropertyNames()) {
            messages.put(key, properties7.get(key).toString());
        }
        return messages;

    }


    /**
     * <p>
     *gets hashmaps from a file for the hashmap roles
     *<br>
     * @param -
     * @return roles
     * @see -
     * @author tsig-404
     */

    public HashMap<String,String> import8() throws IOException, ClassNotFoundException {
        Properties properties8 = new Properties();
        properties8.load(new FileInputStream("roles.bin"));

        for (String key : properties8.stringPropertyNames()) {
            roles.put(key, properties8.get(key).toString());
        }
        return roles;

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
//this isnt usefull anymore every import has its own class
    public void import111 () throws IOException, ClassNotFoundException {


        //this needs for every hashmap 1
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("ausers.bin"));

        for (String key : properties1.stringPropertyNames()) {
            ausers.put(key, properties1.get(key).toString());
        }
        //end of read for a hashmap 1

        //this needs for every hashmap 2
        Properties properties2 = new Properties();
        properties2.load(new FileInputStream("rented.bin"));

        for (String key : properties2.stringPropertyNames()) {
            rented.put(key, properties2.get(key).toString());
        }
        //end of read for a hashmap 2



        //this needs for every hashmap 4
        Properties properties4 = new Properties();
        properties4.load(new FileInputStream("rentals.bin"));

        for (String key : properties4.stringPropertyNames()) {
            rentals.put(key, properties4.get(key).toString());
        }
        //end of read for a hashmap 4

/*

        //this needs for every hashmap 5
        Rentable e2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("rentalsV2.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Properties properties3 = new Properties();
            properties3.load(new FileInputStream("rentals.bin"));



            for (String key : properties3.stringPropertyNames()) {
                e2 = (Rentable) in.readObject();
                rentalsV2.put(key, e2);
            }
            in.close();
            fileIn.close();


        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        //end of read for a hashmap 5
*/


        //better way to read objected hashmaps 5
        try (ObjectInputStream in = new ObjectInputStream(new
                FileInputStream("rentalsV2.ser"))) {



            for (Map.Entry<String,Rentable> entry : rentalsV2.entrySet()) {
                //properties5.put(entry.getKey(), entry.getValue());
                //in.readObject(entry);
                entry = (Map.Entry<String, Rentable>) in.readObject();
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        //end of hashmap 5
        



        //this needs for every hashmap 6
        Properties properties6 = new Properties();
        properties6.load(new FileInputStream("rentcancel.bin"));

        for (String key : properties6.stringPropertyNames()) {
            rentcancel.put(key, properties6.get(key).toString());
        }
        //end of read for a hashmap 6

        //this needs for every hashmap 7
        Properties properties7 = new Properties();
        properties7.load(new FileInputStream("messages.bin"));

        for (String key : properties7.stringPropertyNames()) {
            messages.put(key, properties7.get(key).toString());
        }
        //System.out.println(messages);
        //end of read for a hashmap 7

        //this needs for every hashmap 8
        Properties properties8 = new Properties();
        properties8.load(new FileInputStream("roles.bin"));

        for (String key : properties8.stringPropertyNames()) {
            roles.put(key, properties8.get(key).toString());
        }
        //end of read for a hashmap 8

    }


    //end of useless import class



    /**
     * <p>
     *this saves the hashmaps to their files and if it doesnt find these files it create them
     * also the user and rentalsV2 get saved in .ser files instead of .bin
     *<br>
     * @param -
     * @return ausers
     * @see -
     * @author tsig-404
     */

    //export to a file

    //DONT ERASE IT DONT!!
    //DONT ERASE IT DONT!!
    //DONT ERASE IT DONT!!
    public void export1(HashMap<String,String> aausers,HashMap<String,String> arented,
    HashMap<String,User> auser,HashMap<String,String> arentals,
                        HashMap<String,Rentable> arV2,HashMap<String,String> rc,
                        HashMap<String,String> msg,HashMap<String,String> aroles
    ) throws FileNotFoundException {
        this.ausers=aausers;
        this.rented=arented;
        this.user=auser;
        this.rentals=arentals;
        this.rentalsV2=arV2;
        this.rentcancel=rc;
        this.messages=msg;
        this.roles=aroles;

        System.out.println("during export");
        System.out.println(ausers);
        System.out.println(roles);


        //this needs for every hashmap 1
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("ausers.bin"))) {



            Properties properties1 = new Properties();
            for (Map.Entry<String,String> entry : ausers.entrySet()) {
                properties1.put(entry.getKey(), entry.getValue());
            }
            properties1.store(new FileOutputStream("ausers.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write hashmap 1


        /*
        //this needs for every hashmap 2
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("user.ser"))) {



            Properties properties2 = new Properties();
            for (Map.Entry<String,User> entry : user.entrySet()) {
                properties2.put(entry.getKey(), entry.getValue());
                //properties2.writeObject(entry);
            }
            properties2.store(new FileOutputStream("user.ser"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 2
        */

        //this needs for every hashmap 2
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("user.ser"))) {

            //vuser.clear();
           // for (Map.Entry<String,User> entry : user.entrySet()) {
                //vuser.add(entry.getValue());
               // out.writeObject(entry.getValue());

           // }

            //out.writeObject(vuser);


            /*
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(user);
            oos.close();
            */


            Properties properties2 = new Properties();
            for (Map.Entry<String,User> entry : user.entrySet()) {
                //properties2.put( entry.getKey(),entry.getValue());
                out.writeObject(entry.getValue());

            }
            //properties2.store(new FileOutputStream("user.ser"), null);



            out.close();
        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 2






        //this needs for every hashmap 3
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("rented.bin"))) {



            Properties properties3 = new Properties();
            for (Map.Entry<String,String> entry : rented.entrySet()) {
                properties3.put(entry.getKey(), entry.getValue());
            }
            properties3.store(new FileOutputStream("rented.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 3

        //this needs for every hashmap 4
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("rentals.bin"))) {



            Properties properties4 = new Properties();
            for (Map.Entry<String,String> entry : rentals.entrySet()) {
                properties4.put(entry.getKey(), entry.getValue());
            }
            properties4.store(new FileOutputStream("rentals.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 4



        //this needs for every hashmap 5
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("rentalsV2.ser"))) {



            Properties properties5 = new Properties();
            for (Map.Entry<String,Rentable> entry : rentalsV2.entrySet()) {
                //properties5.put(entry.getKey(), entry.getValue());

                out.writeObject(entry.getValue());
            }
            //properties5.store(new FileOutputStream("rentalsV2.ser"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 5



        //this needs for every hashmap 6
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("rentcancel.bin"))) {



            Properties properties6 = new Properties();
            for (Map.Entry<String,String> entry : rentcancel.entrySet()) {
                properties6.put(entry.getKey(), entry.getValue());
            }
            properties6.store(new FileOutputStream("rentcancel.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 6

        //this needs for every hashmap 7
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("messages.bin"))) {



            Properties properties7 = new Properties();
            for (Map.Entry<String,String> entry : messages.entrySet()) {
                properties7.put(entry.getKey(), entry.getValue());
            }
            properties7.store(new FileOutputStream("messages.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 7

        //this needs for every hashmap 8
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("roles.bin"))) {



            Properties properties8 = new Properties();
            for (Map.Entry<String,String> entry : roles.entrySet()) {
                properties8.put(entry.getKey(), entry.getValue());
            }
            properties8.store(new FileOutputStream("roles.bin"), null);


        }
        catch (IOException e) {e.printStackTrace();}
        //end of write for hashmap 8

        //end of export class
    }
    //DONT ERASE IT DONT!!
    //DONT ERASE IT DONT!!
    //DONT ERASE IT DONT!!
    //this saves the data to the files




}
