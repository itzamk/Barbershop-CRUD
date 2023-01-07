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
public class Appointment 
{
    private int appointmentID;
    private int customerID;
    private int barberID;
    private String checkinDateTime;
    
    
    public Appointment(int appointmentID, int customerID, int barberID, String checkinDateTime)
    {
        this.appointmentID = appointmentID;
        this.customerID = customerID;
        this.barberID = barberID;
        this.checkinDateTime = checkinDateTime;
    }

    public int getappointmentID() {
        return appointmentID;
    }
    
    public int getcustomerID() {
        return customerID;
    }
    
    public int getbarberID() {
        return barberID;
    }

    public String getcheckinDateTime() {
        return checkinDateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" + "appointmentID=" + appointmentID + ", customerID=" + customerID + ", barberID=" + barberID + ", checkinDateTime=" + checkinDateTime + '}';
    }

   
}
