package com.company;

class Client extends User{


    /**
     * <p>
     * This is a subclass class of user.java and this will be used as a
     * simple constructor for the clients/renters of this program
     *<br>
     * @param -
     * @return -
     * @see -
     * @author
     */
    public  Client ()
    {

    }

    /**
     * <p>
     * This is a subclass class of user.java and this will be used as a
     * simple constructor for the clients/renters of this program
     *<br>
     * @param ausername, apassword, aname, aaddress
     * @return -
     * @see -
     * @author
     */
    public Client (String ausername, String apassword, String aname, String aaddress)
    {
        this.username=ausername;
        this.password=apassword;
        this.role='c';
        this.name=aname;
        this.address=aaddress;
        this.seeUsers=false;
        this.seeReserves=false;
        this.accepts=false;
        this.sendMessages=false;
        this.seeHotels=true;
        this.seeMessages=true;
        this.hasHotel=false;
        this.canReserve=true;

    }

    /**
     * <p>
     * returns the role as string
     *<br>
     * @param -
     * @return client
     * @see -
     * @author
     */
    public String getRole()
    {
        return "client";
    }

    /**
     * <p>
     * returns the username as string
     *<br>
     * @param -
     * @return this.username
     * @see -
     * @author
     */
    public String getUsername()
    {
        return this.username;
    }


    /**
     * <p>
     * returns the password as string
     *<br>
     * @param -
     * @return this.password
     * @see -
     * @author
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * <p>
     * returns the name as string
     *<br>
     * @param -
     * @return this.name
     * @see -
     * @author
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * <p>
     * returns the address as string
     *<br>
     * @param -
     * @return this.address
     * @see -
     * @author
     */
    public String getAddress()
    {
        return this.address;
    }

    /**
     * <p>
     * This is a void function which prints in the
     * command line or the ui information for a
     * logged client
     *<br>
     * @param n
     * @return null
     * @see -
     * @author
     */
    public Client profile(User n)
    {
        this.username=n.username;
        this.password=n.password;
        this.name=n.name;
        this.address=n.address;

        System.out.println("Name: "+this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Role: client" );
        System.out.println("Username: "+this.username);
        System.out.println("Password: " + this.password);

        //nope
        return null;
    }


    /**
     * <p>
     * This is a char function that returns
     * the role of every user
     *<br>
     * @param -
     * @return role
     * @see -
     * @author
     */
    public char role()
    {
        return this.role;
    }



}
