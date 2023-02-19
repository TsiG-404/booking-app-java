package com.company;

class Room extends Rentable {


    /**
     * <p>
     * This is a subclass class of rentable.java and this will be used as a
     * simple constructor for the short rent (days) rooms/houses of this program
     *<br>
     * @param -
     * @return -
     * @see -
     * @author
     */
    public Room()
    {

    }

    /**
     * <p>
     * This is a subclass class of rentable.java and this will be used as a
     * simple constructor for the short rent (days) rooms/houses of this program
     *<br>
     * @param akey,  aowner
     * @return -
     * @see -
     * @author
     */
    public Room(String own,String akey)
    {
        this.key=akey;
        this.price=0;
        this.owner=own;
        this.parking=false;
        this.wifi=false;
        this.size1=0;
        this.available=true;
        this.shortRent=false;
        this.longRent=false;
        this.rentDays=0;
        this.rented=false;
    }

/**
 * <p>
 * This is a subclass class of rentable.java and this will be used as a
 * simple constructor for the short rent (days) rooms/houses of this program
 *<br>
 * @param akey, aprice, aowner, aparking, awifi, asize, aavailable, ashortrent, alongrent
 * @return -
 * @see -
 * @author
 */

    public Room (String akey, int aprice, String aowner, boolean aparking, boolean awifi,
                 int asize, boolean aavailable, boolean ashortrent,
                 boolean alongrent)
    {

        this.key=akey;
        this.price=aprice;
        this.owner=aowner;
        this.parking=aparking;
        this.wifi=awifi;
        this.size1=asize;
        this.available=aavailable;
        this.shortRent=ashortrent;
        this.longRent=alongrent;
        this.rentDays=0;
        this.rented=false;




    }


    /**
     * <p>
     * This is a function that let a client (with a role==c )
     * rent a long rent house per days
     *<br>
     * @param  "role,rentDays,client name"
     * @return -
     * @see -
     * @author
     */
    public void rent(char arole, int arentdays, String aname)
    {
        if(arole=='c')
        {
            this.rentDays=arentdays;
            this.rented=true;
            this.rentName=aname;
            System.out.println("rented");

        }
    }


    /**
     * <p>
     * This is a function that let a client (with a role==c )
     * cancel a rent
     *<br>
     * @param  "role,client name"
     * @return -
     * @see -
     * @author
     */
    public void unrent(char arole, String aname)
    {
        if(arole=='c' && aname==this.rentName)
        {
            this.rentDays=0;
            this.rented=false;
            this.rentName="";
            System.out.println("you canceled the rent");

        }
    }


    /**
     * <p>
     * This is a function that let the provider edit
     * rent place information
     *<br>
     * @param  "owner, key"
     * @param "price, parking, wifi, size, sh"
     * @return -
     * @see -
     * @author
     */
    public void editRoom(String akey, int aprice, boolean aparking, boolean awifi,
                                int asize, String aowner, boolean sh)
    {
        if(this.owner==aowner)
        {
            this.price=aprice;
            this.parking=aparking;
            this.wifi=awifi;
            this.size1=asize;

        }
        if(sh==true)
        {
            this.shortRent=true;
            this.longRent=false;
            this.available=true;

        }
        else
        {
            this.shortRent=true;
            this.longRent=false;
            this.available=true;
        }
    }


    /**
     * <p>
     * This is a function that let the provider
     * delete a rental place (thsi will set the
     * owner as null which in main if a obj has
     * the String owner as null the whole obj
     * will be set as null which will let
     * garbage collector delete it
     *<br>
     * @param  "owner, key"
     * @return -
     * @see -
     * @author
     */
    public void delete(String akey, String aowner)
    {
        if(aowner==this.owner)
        {
            this.key="";
            this.owner=null;
            //dont forget to set the whole obj in main as obj=null;
            //this way the garbage collector will delete it
            //ok done now it is a 404 too (^:
        }


    }


    /**
     * <p>
     * returns if it is rented or not
     *<br>
     * @param akey
     * @return rented
     * @see -
     * @author
     */
    public boolean getRent(String akey)
    {
        return rented;
    }

    /**
     * <p>
     * this rents a home
     *<br>
     * @param akey,ap
     * @return -
     * @see -
     * @author
     */
    public void setRent(String akey,boolean ap)
    {
        this.rented=ap;
    }

    /**
     * <p>
     * this makes a room available again
     *<br>
     * @param akey,ap
     * @return -
     * @see -
     * @author
     */
    public void setAvailable(String akey,boolean ap)
    {
        this.available=ap;
    }


    /**
     * <p>
     * this prints all the info for a room because the .toString could do it
     *<br>
     * @param n
     * @return -
     * @see -
     * @author
     */
    public void display(Rentable n)
    {
        this.key=n.key;
        this.price=n.price;
        this.owner=n.owner;
        this.parking=n.parking;
        this.wifi=n.wifi;
        this.size1=n.size1;
        this.available=n.available;

        this.shortRent=n.shortRent;
        this.longRent=n.longRent;

            System.out.println("---------------------");

            System.out.println("Rentable per day(hotel room)");
            System.out.println("price per day: " +this.price);


        System.out.println("Unique key(key to rent): "+this.key);
        System.out.println("Owner: " + this.owner);

        System.out.println("Parking: "+this.parking);
        System.out.println("Wifi: " + this.wifi);
        System.out.println("Size: " + this.size1);
        System.out.println("---------------------");

        //nope just kidding tsig 404 was here too
    }

}
