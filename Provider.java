package com.company;

class Provider extends User {

    /**
     * <p>
     * This is a subclass class of user.java and this will be used as a
     * simple constructor for the providers/servers of this program
     *<br>
     * @param -
     * @return -
     * @see -
     * @author
     */
    public Provider()
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
    public Provider (String ausername, String apassword, String aname, String aaddress)
    {
        this.username=ausername;
        this.password=apassword;
        this.role='p';
        this.name=aname;
        this.address=aaddress;
        this.seeUsers=false;
        this.seeReserves=true;
        this.accepts=false;
        this.sendMessages=false;
        this.seeHotels=true;
        this.seeMessages=true;
        this.hasHotel=true;
        this.canReserve=false;

    }


    /**
     * <p>
     * returns the role as string
     *<br>
     * @param -
     * @return provider
     * @see -
     * @author
     */
    public String getRole()
    {
        return "provider";
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
     * This is a void function which prints in the
     * command line or the ui information for a
     * logged provider
     *<br>
     * @param n
     * @return -
     * @see -
     * @author
     */
    public Provider profile(User n)
    {
        this.username=n.username;
        this.password=n.password;
        this.name=n.name;
        this.address=n.address;
        this.name=n.name;

        System.out.println("Name: "+this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Role: Provider" );
        System.out.println("Username: "+this.username);
        System.out.println("Password: " + this.password);

        //nope
        return null;
    }

    /**
     * <p>
     * This is a void function which prints in the
     * command line or the ui information for a
     * logged provider
     *<br>
     * @param -
     * @return -
     * @see -
     * @author
     */
    public void profile()
    {
        System.out.printf("Ονομα:%1$s%n",this.name);
        System.out.printf("Διευθηνση:%1$s%n",this.address);
        System.out.printf("Ρολος:%1$s%n","provider");

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
    public String gusername()
    {
        return this.username;
    }
    public String gfullname()
    {
        return this.name;
    }
    public String gaddress()
    {
        return this.address;
    }
    public char role()
    {
        return this.role;
    }
}
