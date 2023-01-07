/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Barber 
{
    private int barberID;
    private String barberFirstName;
    private String barberLastName;
    private String barberSSN;
    
    public Barber(int barberID, String barberFirstName, String barberLastName, String barberSSN)
    {
        this.barberID = barberID;
        this.barberFirstName = barberFirstName;
        this.barberLastName = barberLastName;
        this.barberSSN = barberSSN;
    }

    public int getbarberID() {
        return barberID;
    }

    public String getbarberFirstName() {
        return barberFirstName;
    }

    public String getbarberLastName() {
        return barberLastName;
    }

    public String getbarberSSN() {
        return barberSSN;
    }

    @Override
    public String toString() {
        return "Barber{" + "barberID=" + barberID + ", barberFirstName=" + barberFirstName + ", barberLastName=" + barberLastName + ", barberSSN=" + barberSSN + '}';
    }

   
}
