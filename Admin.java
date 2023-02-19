package com.company;
import java.util.HashMap;

class Admin extends User   {


    /**
     * <p>
     * This is a subclass class of user.java and this will be used as a
     * simple constructor for the admins of this program
     *<br>
     * @param ausername, apassword
     * @return -
     * @see -
     * @author
     */
public Admin (String ausername, String apassword)
{
    this.username=ausername;
    this.password=apassword;
    this.role='a';
    this.seeUsers=true;
    this.seeReserves=true;
    this.accepts=true;
    this.sendMessages=true;
    this.seeHotels=false;
    this.seeMessages=false;
    this.hasHotel=false;
    this.canReserve=false;
}


    /**
     * <p>
     * returns the role as string
     *<br>
     * @param -
     * @return admin
     * @see -
     * @author
     */
public String getRole()
{
    return "admin";
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
