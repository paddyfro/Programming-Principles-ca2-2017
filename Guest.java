/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2Project;

/**
 *
 * @author Patrick McDonnell & Emma Loughran
 */
public class Guest implements Comparable<Guest>
{

    private String name;
    private String phone;
    private double balance;
    private int stayDuration;
    private double costPerNight;

    public Guest()
    {
        name = "";
        phone = "";
        stayDuration = 0;
        costPerNight = 50.00;
        balance = calculateBalance();

    }

    public Guest(String name, int stayDuration)
    {
        this.name = name;
        this.stayDuration = stayDuration;
        this.costPerNight = 50;
        this.balance = calculateBalance();
    }

    public Guest(String name, String phone, int stayDuration)
    {
        this.name = name;
        this.phone = phone;
        this.stayDuration = stayDuration;
        this.costPerNight = 50;
        this.balance = calculateBalance();
    }

    public Guest(String name, String phone, int stayDuration, double costPerNight)
    {
        this.name = name;
        this.phone = phone;
        this.stayDuration = stayDuration;
        this.costPerNight = costPerNight;
        this.balance = calculateBalance();
    }

    public double calculateBalance()
    {
//        this.costPerNight=50.00;
        this.balance = this.costPerNight * this.stayDuration;
        return balance;
    }

    public double getCostPerNight()
    {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight)
    {
        this.costPerNight = costPerNight;
        calculateBalance();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        if (balance >= 0)
        {
            this.balance = balance;
        }
    }

    public int getStayDuration()
    {
        return stayDuration;
    }

    public void setStayDuration(int stayDuration)
    {
        if (stayDuration > 0)
        {
            this.stayDuration = stayDuration;
            calculateBalance();
        }
    }

    /**
     * toString method overriding basic toString
     * @return basic data about guest class
     */
    @Override
    public String toString()
    {
        return "Guest{" + "name=" + name + ", phone=" + phone + ", balance=" + balance + ", stayDuration=" + stayDuration + '}';
    }

    /**
     * takes away an amount from the guests balance
     * @param deposit double amount you wish to take away
     */
    public void payBill(Double deposit)
    {
        if (deposit <= balance)
        {
            this.balance = balance - deposit;
        }
    }

    /**
     * adds on more nights to the stayDuration
     * @param extraNights number of nights you wish to add on
     */
    public void extendStay(int extraNights)
    {

        this.stayDuration += extraNights;

    }

    /**
     * checks one guest number against anotehr guest
     * @param other guest object to bechecked against
     * @return boolean if the guests numbers are equal
     */
    public boolean hasSamePhoneAs(Guest other)
    {
        return this.phone.equals(other.getPhone());
    }

    /**
     * checks one guest name against anotehr guest 
     * @param other guest object to be checked against
     * @return boolean of whether the names are equal
     */
    public boolean hasSameNameAs(Guest other)
    {
        return this.name.equals(other.getName());
    }

    /**
     * checks to see if a balance is more than guest amount
     * @param amount double value to be checked
     * @return true or false depending if the balance is greater
     */
    public boolean balanceMoreThan(double amount)
    {
        if (this.balance >= amount)
        {
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public int compareTo(Guest other)
    {
        return (this.name.compareTo(other.getName()));  //delegate to compareTo of the String class

    }
}
