/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2Project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Patrick McDonnell & Emma Loughran
 */
public class Hotel
{

    private String name;
    private String address;
    private String phone;
    private int vatNumber;
    private ArrayList<Guest> guests;

    /**
     * basic constructor for the hotel class taking no arguments
     */
    public Hotel()
    {
        this.name = "";
        this.address = "";
        this.phone = "";
        this.vatNumber = 0;
        guests = new ArrayList<>();
    }

    /**
     * constructor for hotel class taking in name and address arguments
     *
     * @param name name of the hotel
     * @param address address where the hotel is located
     */
    public Hotel(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.phone = "";
        this.vatNumber = 0;
        guests = new ArrayList<>();
    }

    /**
     * constructor for hotel class taking in name ,address and phone number as
     * arguments
     *
     * @param name name of hotel
     * @param address address of hotel
     * @param phone phone number of hotel
     */
    public Hotel(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vatNumber = 0;
        guests = new ArrayList<>();
    }

    /**
     * constructor for hotel class taking in name ,address, phone number and vat
     * number as arguments
     *
     * @param name name of hotel
     * @param address address of hotel
     * @param phone phone number of hotel
     * @param vatNumber vat number of hotel
     */
    public Hotel(String name, String address, String phone, int vatNumber)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vatNumber = vatNumber;
        guests = new ArrayList<>();
    }

    /**
     * Get the value of vatNumber
     *
     * @return the value of vatNumber
     */
    public int getVatNumber()
    {
        return vatNumber;
    }

    /**
     * Set the value of vatNumber
     *
     * @param vatNumber new value of vatNumber
     */
    public void setVatNumber(int vatNumber)
    {
        this.vatNumber = vatNumber;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Basic to string method to display data on the hotel
     *
     * @return string of hotel details
     */
    @Override
    public String toString()
    {
        return "Hotel{" + "name=" + name + ", address=" + address + ", phone=" + phone + ", vatNumber=" + vatNumber + ", guests=" + guests + '}';
    }

    /**
     * takes in a Guest object and adds it to the ArrayList guests
     *
     * @param guest Guest object to be added to arrayList
     */
    public void checkIn(Guest guest)
    {
        guests.add(guest);
    }

    /**
     * Takes in a guest object and deletes it from the arrayList guests
     *
     * @param guest
     */
    public void checkOut(Guest guest)
    {
//        int indexLoc = findGuest(guest.getName());
        guests.remove(guest);
    }

    /**
     * removes a guest from the arrayList guests
     *
     * @param indexLoc index location of the guest object you wish to delete
     */
    public void checkOut(int indexLoc)
    {
        guests.remove(indexLoc);
    }

    /**
     * Displays all the Guest objects in the ArrayList guests
     */
    public void displayGuests()
    {
        if (guests.size() > 0)
        {
            int i = 0;
            System.out.println("\n==============================================================================================");
            System.out.println("\t\t\t\tGuests in the " + name + " Hotel");
            System.out.println("==============================================================================================");
            System.out.println("   Name\t\t\t\tPhone\t\t\tBalance(€)\t\tStay Duration");
            for (Guest g : guests)
            {
                //System.out.println(e.getName() + "\t\t" + e.getPhone()+ "\t\t" + e.getBalance() + "\t\t" + e.getStayDuration());
                System.out.printf(i + ") %-18s\t\t%-12s%20.2f\t%12d days\n", g.getName(), g.getPhone(), g.getBalance(), g.getStayDuration());
                i++;
            }
            System.out.println("----------------------------------------------------------------------------------------------");
        } else
        {
            System.out.println("\n==============================================================================================");
            System.out.println("\t\t\t\tGuests in the " + name + " Hotel");
            System.out.println("==============================================================================================");
            System.out.println("\t\t\t    There are curently no guests checked in.");
        }
    }

    /**
     * takes in a index location indexLoc and displays the details of that Guest
     * object from the ArrayList guests
     *
     * @param indexLoc
     */
    public void displayGuest(int indexLoc)
    {
        System.out.println("\n==============================================================================================");
        System.out.println("\t\t\t\tGuest Details of the " + name + " Hotel");
        System.out.println("==============================================================================================");
        System.out.println("Name\t\t\t\tPhone\t\t\tBalance(€)\t\tStay Duration");

        //System.out.println(e.getName() + "\t\t" + e.getPhone()+ "\t\t" + e.getBalance() + "\t\t" + e.getStayDuration());
        System.out.printf("%-18s\t\t%-12s%20.2f\t%12d days\n", guests.get(indexLoc).getName(), guests.get(indexLoc).getPhone(), guests.get(indexLoc).getBalance(), guests.get(indexLoc).getStayDuration());
        System.out.println("----------------------------------------------------------------------------------------------");

    }

    /**
     * displays guest details based on a name and phone number
     *
     * @param name name of the guest you wish to display
     * @param number phone number of guest you wish to display
     */
    public void displayGuest(String name, String number)
    {
        int indexLoc = findGuest(name, number);
        if (indexLoc >= 0)
        {
            System.out.println("\n==============================================================================================");
            System.out.println("\t\t\t\tGuest Details of the " + this.name + " Hotel");
            System.out.println("==============================================================================================");
            System.out.println("Name\t\t\t\tPhone\t\t\tBalance(€)\t\tStay Duration");

            //System.out.println(e.getName() + "\t\t" + e.getPhone()+ "\t\t" + e.getBalance() + "\t\t" + e.getStayDuration());
            System.out.printf("%-18s\t\t%-12s%20.2f\t%12d days\n", guests.get(indexLoc).getName(), guests.get(indexLoc).getPhone(), guests.get(indexLoc).getBalance(), guests.get(indexLoc).getStayDuration());
        } else
        {
            System.out.println("----------------------------------------------------------------------------------------------");

            System.out.println("Guest not found");
        }
        System.out.println("----------------------------------------------------------------------------------------------");

    }

    /**
     * gest the ArrayList of guest objects
     *
     * @return the arrayList guests
     */
    public ArrayList<Guest> getGuests()
    {
        return guests;
    }

    /**
     * points the ArrayList guests to an arrayList ref
     *
     * @param guests arrayList of guest objects
     */
    public void setGuests(ArrayList<Guest> guests)
    {
        this.guests = guests;
    }

    /**
     * determines if there is anyone called a certain name in the arrayList
     * guests
     *
     * @param name String values to be checked
     * @return true or false if name has been found
     */
    public boolean ifAnyGuestCalled(String name)
    {
        boolean isName = false;
        int i = 0;
        while (i < guests.size() && !isName)
        {
            if (guests.get(i).getName().equals(name))
            {
                isName = true;
            }
            i++;
        }

        return isName;
    }
//    public boolean ifAnyGuestCalled(String name) {
//        boolean isName = false;
//        for (int i = 0; i < guests.size(); i++) {
//            if (guests.get(i).getName().equals(name)) {
//                isName = true;
//            }
//
//        }
//        return isName;
//    }

    /**
     * adds up the cumulative amount of all the guests balances tin the
     * arrayList
     *
     * @return double total of the all the balances
     */
    public double findTotalOwed()
    {
        double total = 0;
        for (int i = 0; i < guests.size(); i++)
        {
            total += guests.get(i).getBalance();
        }

        return total;
    }

    //weekend work
    //------------------------------
    /**
     * increae bill of all guests in guests array by a certain percantage
     *
     * @param percantage double percentage by which to increase balance by
     */
    public void increaseBillOfAllGuestsBy(double percantage)
    {
        for (Guest g : guests)
        {
            double raise = g.getBalance() / 100 * percantage;
            g.setBalance(g.getBalance() + raise);
        }
    }

    /**
     * increase bill of individual guest by a certain percentage
     *
     * @param guest guest variable
     * @param percantage amount to be increase bill by
     */
    public void increaseBillOfGuestBy(Guest guest, double percantage)
    {

        double raise = guest.getBalance() / 100 * percantage;
        guest.setBalance(guest.getBalance() + raise);

    }

    /**
     * decrease bill of all guests by a certain amount
     *
     * @param percantage amount to decrease bills by
     */
    public void decreaseBillOfAllGuestsBy(double percantage)
    {
        for (Guest g : guests)
        {
            double raise = g.getBalance() / 100 * percantage;
            g.setBalance(g.getBalance() - raise);
        }
    }

    /**
     * decrease bill of a certain guest by a certain amount
     *
     * @param guest guest object for whose balance is to be decreased
     * @param percantage amount by which to decrease balance by
     */
    public void decreaseBillOfGuestBy(Guest guest, double percantage)
    {

        double raise = guest.getBalance() / 100 * percantage;
        guest.setBalance(guest.getBalance() - raise);

    }

    /**
     * decrease bill by a certain amount if a guest stay exceeds a certain
     * amount
     *
     * @param percantage amount to decrease balance by
     * @param stay the number of nights stayed to be checked against
     */
    public void decreaseBillIfStayExceeds(double percantage, int stay)
    {
        for (Guest g : guests)
        {
            if (g.getStayDuration() > stay)
            {
                double decrease = g.getBalance() / 100 * percantage;
                g.setBalance(g.getBalance() - decrease);
            }
        }
    }

//    public int findGuest(String name) {
//        int indexLoc = -1;
//        for (int i = 0; i < guests.size(); i++) {
//            if (guests.get(i).getName().equals(name)) {
//                indexLoc = i;
//            }
//        }
//        return indexLoc;
//    }
    /**
     * takes a String name and checks the array Guests if there is a match
     *
     * @param name string you want to check
     * @return arrayList of Strings filled with guest indexlocations
     */
    public ArrayList checkGuest(String name)
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < guests.size(); i++)
        {
            if (guests.get(i).getName().equals(name))
            {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * finds the exact guest based on number and name
     *
     * @param guestIndexes array list of guests with same name
     * @param number phoen numebr fo huest
     * @return index location of guest
     */
    public int determineGuest(ArrayList<Integer> guestIndexes, String number)
    {
        int indexLoc = -1;
        for (int i = 0; i < guestIndexes.size(); i++)
        {
            if (number.equals(guests.get(guestIndexes.get(i)).getPhone()))
            {
                indexLoc = guestIndexes.get(i);
            }
        }
        return indexLoc;
    }

    /**
     * finds the guest index location based on name and number
     *
     * @param name name of the guest
     * @param number phone number of the guest
     * @return index location of the guest in the ArrayList
     */
    public int findGuest(String name, String number)
    {
        ArrayList<Integer> guestIndexes = checkGuest(name);
        if (guestIndexes.size() > 1)
        {
            return determineGuest(guestIndexes, number);
        } else if (guestIndexes.size() == 1)
        {
            return guestIndexes.get(0);
        } else
        {
            return -1;
        }

    }

    /**
     * sorts the guests arrayList by name
     */
    public void sortGuests()
    {
        Collections.sort(guests);
    }

    /**
     * determines the guest that has the largest balance owed to the hotel
     *
     * @return index location of the guest
     */
    public int determineMaxBill()
    {
        int indexLoc = 0;
        double bal = 0;
        for (int i = 0; i < guests.size(); i++)
        {
            if (guests.get(i).getBalance() > bal)
            {
                bal = guests.get(i).getBalance();
                indexLoc = i;
            }
        }
        return indexLoc;
    }

    /**
     * decrease bill by a certain amount if a guest stay exceeds a certain
     * amount
     *
     * @param percantage amount to decrease balance by
     * @param stay the number of nights stayed to be checked against
     */
    public void displayAllWhosStayExceeds(int stayLength)
    {
        int count = 0;
        System.out.println("\n==============================================================================================");
        System.out.println("\t\tGuest Details of the " + name + " Hotel whose stay exceeds " + stayLength + " nights");
        System.out.println("==============================================================================================");
        System.out.println("Name\t\t\t\tPhone\t\t\tBalance(€)\t\tStay Duration");
        for (int i = 0; i < guests.size(); i++)
        {
            if (guests.get(i).getStayDuration() > stayLength)
            {
                count++;
                System.out.printf("%-18s\t\t%-12s%20.2f\t%12d days\n", guests.get(i).getName(), guests.get(i).getPhone(), guests.get(i).getBalance(), guests.get(i).getStayDuration());
                if (count == 0)
                {
                    System.out.println("no guests stay exceeds " + stayLength);
                }

            }
        }
    }

    /**
     * calcuates the average number of nights stayed in the hotel
     *
     * @return the int of the average nighst stayed in the hotel
     */
    public int averageNumberOfNightsStayed()
    {
        int total = 0;

        for (int i = 0; i < guests.size(); i++)
        {
            total += guests.get(i).getStayDuration();
        }

        return total / guests.size();
    }

    /**
     * displays hotel details
     */
    public void displayHotelDetails()
    {
        System.out.println("\n=========================================");
        System.out.println("\t     The Hotel " + name);
        System.out.println("=========================================");
        System.out.println("\t   Address:\t " + address);
        System.out.println("\t     Phone:\t" + phone);
        System.out.println("\t VatNumber:\t " + vatNumber);

    }

    /**
     * finds the amount owed by a particular guest by their name
     *
     * @param name name of the guest to find out the bill for
     * @return double amount in the guests balance
     */
//    public double findTotalOwed(String name)
//    {
////        int guestLocation = findGuest(name);
////        return guests.get(guestLocation).getBalance();
//        
////        return guests.get(findGuest(name)).getBalance();
////    }
//
//}
}
