/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Gokhan
 */
public class CustomersDAO implements DAO<Customers>
{   
    public CustomersDAO() {
        
    }
    List<Customers> customers;
    /**
     * Get a single customer entity as an customer object
     * @param id
     * @return 
     */
    @Override
    public Optional<Customers> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM FP_Customers WHERE customerID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Customers customer = null;
            while (rs.next()) {
                customer = new Customers(rs.getInt("customerID"), rs.getString("customerFirstName"), 
                        rs.getString("customerLastName"), rs.getString("customerPhoneNumber"));
            }
            return Optional.ofNullable(customer);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all customer entities as a List
     * @return 
     */
    @Override
    public List<Customers> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM FP_Customers";
            rs = db.executeQuery(sql);
            Customers customer = null;
            while (rs.next()) {
                 customer = new Customers(rs.getInt("customerID"), rs.getString("customerFirstName"), rs.getString("customerLastName"), rs.getString("customerPhoneNumber"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert an customer object into customer table
     * @param customer 
     */
    @Override
    public void insert(Customers customer)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO FP_Customers(customerID, customerFirstName, customerLastName, customerPhoneNumber) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getcustomerID());
            stmt.setString(2, customer.getcustomerFirstName());
            stmt.setString(3, customer.getcustomerLastName());
            stmt.setString(4, customer.getcustomerPhoneNumber());            
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
        }
    }
    
    /**
     * Update an customer entity in database if it exists using an customer object
     * @param customer
     */
    @Override
    public void update(Customers customer) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE FP_Customers SET customerFirstName=?, customerLastName=?, customerPhoneNumber=? WHERE customerID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, customer.getcustomerFirstName());
            stmt.setString(2, customer.getcustomerLastName());
            stmt.setString(3, customer.getcustomerPhoneNumber());
            stmt.setInt(4, customer.getcustomerID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing customer was updated successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete an customer from customer table if the entity exists
     * @param customer 
     */
    @Override
    public void delete(Customers customer) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM FP_Customers WHERE customerID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getcustomerID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An customer was deleted successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM FP_Customers WHERE customerID = -1";
//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
            return null;
        } 
    }
}
