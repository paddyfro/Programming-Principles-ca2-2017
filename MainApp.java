package ca2Project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Patrick McDonnell & Emma Loughran
 */
//ask about invalid entrys as in a string inpyt when wanted a int
/**
 * Provides a starting point for a menu-driven project. Please modify as you
 * wish - updating Javadoc comments accordingly
 *
 * @author Patrick McDonnell & Emma Loughran
 * @version 1.0
 */
public class MainApp
{

    // keyboard is declared as static so that keyboard is available to all the methods below
    // DO NOT declare other variables as static unless discuss first with your lecturer
    static Scanner keyboard = new Scanner(System.in);
    static Hotel h = new Hotel();
    static final int END = 0;
//container class as global too

    /**
     * Main program for our hotel system
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {

//        System.out.println("---------------------------");
//        System.out.println("Welcome to our system");
//        System.out.println("Please enter Hotel Details");
//        System.out.println("---------------------------");
//
//        System.out.print("name: ");
//        h.setName(keyboard.nextLine());
//        //System.out.println("hotel name: " + h.getName());
//        System.out.print("Address: ");
//        h.setAddress(keyboard.nextLine());
//        System.out.println("Phone number: ");
//        h.setPhone(keyboard.nextLine());
//        System.out.println("VatNumber:");
//        h.setVatNumber(keyboard.nextInt());
        setUpHotel();
//        h.displayHotelDetails();
       // h.displayGuests();

        printMainMenu();
        int option = getInt("Enter Option:", 0, 3);
        while (option != END)
        {
            if (option == 1)
            {
                doGuestFacilities();
            } else if (option == 2)
            {
                doStaffOptions();
            } else if (option == 3)
            {
                doHotelStats();
            } else
            {
                System.out.println("Please enter valid option [0,3]");
            }
            printMainMenu();
            option = getInt("Enter Option:", 0, 3);
        }

        System.out.println("\nGoodbye and thank you for staying at the Hotel " + h.getName() + ".");
    }

    /**
     * Display the main menu of options
     */
    public static void printMainMenu()
    {

        System.out.println("\nHotel " + h.getName() + " Menu");
        System.out.println("0. Exit this menu");
        System.out.println("1. Guest Facalities");
        System.out.println("2. Staff Tasks");
        System.out.println("3. Hotel Stats");
    }

    /**
     * doGuestFacilities - provides usability for guests to interact with the
     * system
     */
    public static void doGuestFacilities()
    {

        printGuestOptions();

        int option = getInt("Enter Option please:", 0, 6);
        while (option != END)
        {
            if (option == 1)
            {
                h.displayGuests();

            } else if (option == 2)
            {
                System.out.println("please enter a name");
                String name = keyboard.nextLine();
                System.out.println("please enter a phone number");
                String number = keyboard.nextLine();
                h.displayGuest(name, number);

            } else if (option == 3)
            {
                h.displayHotelDetails();
            } else if (option == 4)
            {
                h.sortGuests();
                h.displayGuests();
            } else if (option == 5)
            {
                System.out.println("Enter name to check");
                String name = keyboard.nextLine();
                if (h.ifAnyGuestCalled(name))
                {

                    System.out.println(name + " has checked in");
                } else
                {
                    System.out.println(name + " has not checked in");
                }
            } else if (option == 6)
            {
                h.displayGuests();
                System.out.println("Enter the index of the guest you want to pay");
                option = keyboard.nextInt();

                //if(h.getGuests().get(option).payBill(amount)> )
                h.displayGuest(option);

                System.out.println("Please enter the amount you want to pay. Your balacne is: " + h.getGuests().get(option).getBalance());
                double amount = keyboard.nextDouble();
                int i = 0;

                {
                    if (h.getGuests().get(option).getBalance() >= amount)
                    {
                        h.getGuests().get(option).payBill(amount);
                        System.out.println("New balance : " + h.getGuests().get(option).getBalance());
                    } else
                    {
                        System.out.println("payment must be less than or equal to the balance. ");
                    }
                }

            }
            printGuestOptions();
            option = getInt("Enter Option please:", 0, 6);

//        System.out.print("\nPlease press enter to return to menu ");
//        String temp = keyboard.nextLine();
        }
    }

    /**
     * displays options for the guest menu
     */
    public static void printGuestOptions()
    {
        System.out.println("\nGuest Menu");
        System.out.println("0. Exit this menu");
        System.out.println("1. Display all guests");
        System.out.println("2. find guest by name");
        System.out.println("3. display hotel details");
        System.out.println("4. sort guest by name");
        System.out.println("5. check if a guest has checked in");
        System.out.println("6. pay Bill");

    }

    /**
     * doStaffOptions - runs code for the staff tasks in the hotel system
     */
    public static void doStaffOptions()
    {
        System.out.println("\n\tStaff Options");
        displayStaffOptions();
        int option = getInt("Enter Option:", 0, 6);
        while (option != END)
        {
            if (option == 1)
            {
                checkInGuest();
            } else if (option == 2)
            {
                checkOutGuest();
            } else if (option == 3)
            {
                changeGuestDetails();
            } else if (option == 4)
            {
                increaseBalance();
            } else if (option == 5)
            {
                decreaseBalance();
            } else if (option == 6)
            {
                alterGuestStay();
            } else
            {
                System.out.println("Please enter valid option [0,3]");
            }
            displayStaffOptions();
            option = getInt("Enter Option:", 0, 6);
        }

        System.out.print("\nPlease press enter to return to Main menu ");
        String temp = keyboard.nextLine();
    }

    /**
     * displays the options for staff members
     */
    public static void displayStaffOptions()
    {
        System.out.println("\nStaff Menu");
        System.out.println("0. Exit this menu");
        System.out.println("1. Check in guest");
        System.out.println("2. Check out guest");
        System.out.println("3. change guest details");  //sub menu
        System.out.println("4. increase Balance");  //sub menu
        System.out.println("5. decrease balance");  //sub menu
        System.out.println("6. extend guest stay");

    }

    /**
     * hotel stats - runs code for analysing data on the guests in the hotel
     * such as total owed and largest bill
     */
    public static void doHotelStats()
    {

        displayHotelStats();

        int option = getInt("Enter Option please:", 0, 6);
        while (option != END)
        {
            if (option == 1)
            {
                System.out.println("\n==================================");
                System.out.println("total owed by all guests: €" + h.findTotalOwed());
                System.out.println("==================================");

            } else if (option == 2)
            {
                System.out.println("Guest with the largest bill is: ");
                //h.displayGuests();
                //System.out.println("index: " + h.determineMaxBill() + " has the highest bill");
                //displays the geust details with teh max bill, using teh display guest and the indexlocation determined from dertermineMaxBill
                h.displayGuest(h.determineMaxBill());

            } else if (option == 3)
            {
                System.out.println("\n==================================");
                System.out.println("average number of nights stayed: " + h.averageNumberOfNightsStayed());
                System.out.println("==================================");

            } else if (option == 4)
            {
                System.out.println("enter how many nights you want to check for guests who are staying longer than");

                int nights = keyboard.nextInt();

                h.displayAllWhosStayExceeds(nights);

//       
//           }
//           
            }

            displayHotelStats();

            option = getInt("Enter Option please:", 0, 6);

//        Place code for option 3 here
//        
//        
        }
    }

    /**
     * displays menu for hotel stats
     */
    public static void displayHotelStats()
    {
        System.out.println("\nHotel stats");
        System.out.println("0. Exit this menu");
        System.out.println("1. Display total owed by all guests");
        System.out.println("2. Display guest with largest bill");
        System.out.println("3. Calcuate average nights stayed");
        System.out.println("4. whose stay exceeds..");

    }

    /**
     * adds a guest to the arrayList in the hotel class
     */
    public static void checkInGuest()
    {
        String checkInMsg = "Congratulations you have checked in";
        System.out.println("=======================");
        System.out.println("\t Check in guest");
        System.out.println("=======================");
//        System.out.print("Name: ");
//        String name = keyboard.nextLine();
        String name = getString("Name: ");
//        System.out.print("Phone: ");
//        String phone = keyboard.nextLine();
        String phone = getString("Phone: ");
//        System.out.print("StayDuration: ");
//        int stayDuration = keyboard.nextInt();
        int stayDuration = getInt("StayDuration: ");
//        System.out.println("Special rate 1)yes 2)no");
//        int choice = keyboard.nextInt();
        int choice = getInt("Special rate 1)yes 2)no", 1, 2);
        if (choice == 1)
        {
//            System.out.print("Rate: ");
//            double rate = keyboard.nextDouble();
            double rate = getDouble("Rate: ");
            h.checkIn(new Guest(name, phone, stayDuration, rate));
            System.out.println(checkInMsg);
        } else
        {
            h.checkIn(new Guest(name, phone, stayDuration));
            System.out.println(checkInMsg);
        }
        h.displayGuests();
    }

    /**
     * removes a guest from the hotel class guest arrayList based on name and
     * number
     */
    public static void checkOutGuest()
    {
        int guestLoc;
        System.out.println("=======================");
        System.out.println("\t Check out guest");
        System.out.println("=======================");
//        System.out.print("Name of guest you would like to check out: ");
//        String name = keyboard.nextLine();
        String name = getString("Name of guest you would like to check out: ");

        //System.out.println("is anyone called " + name + " in the array: " + h.ifAnyGuestCalled(name));
        if (h.ifAnyGuestCalled(name))
        {
            guestLoc = findGuestIndexLocation(name);
//            ArrayList<Integer> guestNames = h.checkGuest(name);
            // System.out.println(guestNames.size());
            if (guestLoc != -1)
            {
                while (h.getGuests().get(guestLoc).getBalance() > 0)
                {
                    System.out.println("Please pay your bill of €" + h.getGuests().get(guestLoc).getBalance() + " to check out.");
                    payBill(guestLoc);

                }
                System.out.println("");
                h.checkOut(guestLoc);
                System.out.println("Guest " + name + " has been checked out successfully");
                h.displayGuests();

            } else if (guestLoc == -1)
            {
                System.out.println("No guest found with that number");
            } else
            {
                h.checkOut(guestLoc);
                System.out.println("Guest " + name + " has been checked out successfully");
                h.displayGuests();
                //System.out.println("index location is: " + guestNames.get(0));
            }
        } else
        {
            System.out.println("No guest by that name checked in to " + h.getName());

        }
    }

    /**
     * takes in a guest index and then alters that guests bill based on input
     * from the user
     *
     * @param guestLoc index location for the guest we wish to alter
     */
    public static void payBill(int guestLoc)
    {
        double payment = getDouble("Payment Amount:");
        if (h.getGuests().get(guestLoc).getBalance() - payment < 0)
        {
            System.out.println("That is too much please reduce payment amount");
        } else
        {
            h.getGuests().get(guestLoc).setBalance(h.getGuests().get(guestLoc).getBalance() - payment);
        }
    }

    /**
     * selects a guest and then allows the user to alter details relating to
     * that guest
     */
    public static void changeGuestDetails()
    {
        String confirmMsg = "Altered guest details successfully";
        int guestIndex = selectGuest();
        h.displayGuest(guestIndex);
        guestDeetsMenu();
        int selection = getInt("What do you wish to edit:", 0, 5);
        while (selection != END)
        {
            if (selection == 1)
            {
//                System.out.print("Enter new name:");
//                h.getGuests().get(guestIndex).setName(keyboard.nextLine());
                String newName = getString("Enter new name:");
                h.getGuests().get(guestIndex).setName(newName);
                System.out.println(confirmMsg);
                h.displayGuest(guestIndex);
            } else if (selection == 2)
            {
//                System.out.print("Enter new Phone number:");
//                h.getGuests().get(guestIndex).setPhone(keyboard.nextLine());
//                System.out.println(confirmMsg);
//                h.displayGuest(guestIndex);

                String newPhone = getString("Enter new Phone number:");
                h.getGuests().get(guestIndex).setPhone(newPhone);
                System.out.println(confirmMsg);
                h.displayGuest(guestIndex);

            } else if (selection == 3)
            {

                double newBalance = getDouble("Enter new balance");

                h.getGuests().get(guestIndex).setBalance(newBalance);
                System.out.println(confirmMsg);
                h.displayGuest(guestIndex);

            } else if (selection == 4)
            {
                int stay = getInt("what is their new stay duration: ");
                h.getGuests().get(guestIndex).setStayDuration(stay);
                System.out.println(confirmMsg);
                h.displayGuest(guestIndex);
            } else if (selection == 5)
            {
                double newCostPerNight = getDouble("What is the new cost per night:");
                h.getGuests().get(guestIndex).setCostPerNight(newCostPerNight);
                System.out.println(confirmMsg);
                h.displayGuest(guestIndex);
            }

            guestDeetsMenu();
            selection = getInt("What do you wish to edit:", 0, 5);
        }

    }

    /**
     * displays a list of options for altering guest details
     */
    public static void guestDeetsMenu()
    {
        System.out.println("0) back to Staff menu");
        System.out.println("1) Name");
        System.out.println("2) Phone");
        System.out.println("3) Balance");
        System.out.println("4) Stay Duration");
        System.out.println("5) Cost per night");
    }

    /**
     * displays a list of guests and then asks the user to select one from the
     * list and returns the index location fo that guest
     *
     * @return index location for the guest you have selected
     */
    public static int selectGuest()
    {
        h.displayGuests();
        return getInt("Please select the number of the guest you wish to alter: ", 0, h.getGuests().size() - 1);

    }

    /**
     * raises either a individual or all guests balance by a certain percentage
     */
    public static void increaseBalance()
    {
        System.out.println("\nIncrease balance of:");
        changeBalanceMenu();
        int selection = getInt("Increase balance of:", 1, 2);
        if (selection == 1)
        {
            int guestIndex = selectGuest();
//            System.out.println("How much do you wish to increase their bill by (%):");
            double raise = getDouble("How much do you wish to increase " + h.getGuests().get(guestIndex).getName() + "'s bill by (%):");
            h.increaseBillOfGuestBy(h.getGuests().get(guestIndex), raise);
            h.displayGuest(guestIndex);
        } else
        {

            double raise = getDouble("How much do you wish to increase their bill by (%):");
            h.increaseBillOfAllGuestsBy(raise);
            h.displayGuests();
        }
    }

    /**
     * displays a menu related to increase and decrease balance
     */
    public static void changeBalanceMenu()
    {

        System.out.println("1) indvidual guest ");
        System.out.println("2) all guests");
    }

    /**
     * decreases either a individual or all guests balance by a certain
     * percentage
     */
    public static void decreaseBalance()
    {
        System.out.println("\nDecrease balance of:");
        changeBalanceMenu();
        int selection = getInt("Decrease balance of:", 1, 2);
        if (selection == 1)
        {
            int guestIndex = selectGuest();
//            System.out.println("How much do you wish to increase their bill by (%):");
            double raise = getDouble("How much do you wish to decrease " + h.getGuests().get(guestIndex).getName() + "'s bill by (%):");
            h.decreaseBillOfGuestBy(h.getGuests().get(guestIndex), raise);
            h.displayGuest(guestIndex);
        } else
        {

            double raise = getDouble("How much do you wish to decrease their bill by (%):");
            h.decreaseBillOfAllGuestsBy(raise);
            h.displayGuests();
        }
    }

    /**
     * adds on user inputed values to a certain guests stayDuration
     */
    public static void alterGuestStay()
    {
        String confirmMsg = "Altered guest details successfully";
        int guestIndex = selectGuest();
        h.displayGuest(guestIndex);

        int extraNights = getInt("How many extra nights shall be added on:");
        h.getGuests().get(guestIndex).setStayDuration(h.getGuests().get(guestIndex).getStayDuration() + extraNights);
        System.out.println(confirmMsg);
        h.displayGuest(guestIndex);
    }

    /**
     * determines a guests index location in the hotel classes guests arrayList
     *
     * @param name String you wish to check for
     * @return index location of the String if found, -1 if not found
     */
    public static int findGuestIndexLocation(String name)
    {

        ArrayList<Integer> guestNames = h.checkGuest(name);
        // System.out.println(guestNames.size());
        if (guestNames.size() > 1)
        {
            System.out.println("There appears to be more than one guest called " + name);
            System.out.println("Please enter guests's phone number to verify:");
            String number = keyboard.nextLine();

            return h.determineGuest(guestNames, number);

        } else
        {
            return guestNames.get(0);
        }

    }

    /**
     * sets up the hotel object with data from a text File
     *
     * @throws IOException
     */
    public static void setUpHotel() throws IOException
    {
        // link File object with a file on disk
        File inputFile = new File("hotel.txt");

        //link Scanner object with the File
        Scanner input = new Scanner(inputFile);

        String hotelName = input.next();
        String hotelAddress = input.next();
        String hotelPhone = input.next();
        int hotelVatNumber = input.nextInt();

        h.setName(hotelName);
        h.setAddress(hotelAddress);
        h.setPhone(hotelPhone);
        h.setVatNumber(hotelVatNumber);
        while (input.hasNext())
        {
            String name = input.next();
            String phone = input.next();
            int stay = input.nextInt();
            h.checkIn(new Guest(name, phone, stay));
        }
        h.displayHotelDetails();
    }

    /**
     * Returns an int entered from the keyboard, limited to range [min - max]
     *
     * @param prompt String to prompt the user
     * @param min Minimum accepted input value
     * @param max Maximum accepted input value
     * @return user-entered integer value
     */
    public static int getInt(String prompt, int min, int max)
    {
        System.out.print(prompt);
        int value = keyboard.nextInt();
        while ((value < min) || (value > max))  // while outside range, re-enter
        {
            System.out.println("Invalid - [" + min + "," + max + "] only");
            System.out.print(prompt);
            value = keyboard.nextInt();
        }
        keyboard.nextLine();
        return value;
    }

    /**
     * Returns an int entered from the keyboard, value cant be lower than 0]
     *
     * @param prompt String to prompt the user
     * @return user-entered integer value
     */
    public static int getInt(String prompt)
    {
        System.out.print(prompt);
        int value = keyboard.nextInt();
        while (value <= 0)  // while outside range, re-enter
        {
//            System.out.println("Invalid - [" + min + "," + max + "] only");
            System.out.print("Invalid - needs to be greater than 0 - " + prompt);
            value = keyboard.nextInt();
        }
        keyboard.nextLine();
        return value;
    }

    /**
     * Returns an double entered from the keyboard, value greater than 0
     *
     * @param prompt String to prompt the user
     * @return user-entered integer value
     */
    public static double getDouble(String prompt)
    {
        System.out.print(prompt);
        double value = keyboard.nextDouble();
        while (value <= 0)  // while outside range, re-enter
        {
//            System.out.println("Invalid - [" + min + "," + max + "] only");
            System.out.print("Invalid - needs to be greater than 0 - " + prompt);
            value = keyboard.nextDouble();
        }
        keyboard.nextLine();
        return value;
    }

    /**
     * Returns an string entered from the keyboard, cant be a blank entry
     *
     * @param prompt String to prompt the user
     * @return user-entered integer value
     */
    public static String getString(String prompt)
    {
        System.out.print(prompt);
        String value = keyboard.nextLine();
        while (value.equals(""))  // while outside range, re-enter
        {
//            System.out.println("Invalid - [" + min + "," + max + "] only");
            System.out.print("Invalid - cant be a blank entry - " + prompt);
            value = keyboard.nextLine();
        }
        return value;
    }

}
