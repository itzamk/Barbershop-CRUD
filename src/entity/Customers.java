/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;

/**
 *
 * @author Gokhan
 */
public class Customers 
{
    private int customerID;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    
    public Customers(int customerID, String customerFirstName, String customerLastName, String customerPhoneNumber)
    {
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPhoneNumber = customerPhoneNumber;

    }

    public int getcustomerID() {
        return customerID;
    }
    
    public String getcustomerFirstName() {
        return customerFirstName;
    }

    public String getcustomerLastName() {
        return customerLastName;
    }

    public String getcustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName + ", "
                + ", customerPhoneNumber=" + customerPhoneNumber + '}';
    }



    

    
}
