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
public class BarberDAO implements DAO<Barber>
{   
    public BarberDAO() {
        
    }
    List<Barber> barbers;
    /**
     * Get a single barber entity as a barber object
     * @param id
     * @return 
     */
    @Override
    public Optional<Barber> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM FP_Barber WHERE barberID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Barber barber = null;
            while (rs.next()) {
                barber = new Barber(rs.getInt("barberID"), rs.getString("barberFirstName"), rs.getString("barberLastName"), rs.getString("barberSSN"));
            }
            return Optional.ofNullable(barber);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all barber entities as a List
     * @return 
     */
    @Override
    public List<Barber> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        barbers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM FP_Barber";
            rs = db.executeQuery(sql);
            Barber barber = null;
            while (rs.next()) {
                barber = new Barber(rs.getInt("barberID"), rs.getString("barberFirstName"), rs.getString("barberLastName"), rs.getString("barberSSN"));
                barbers.add(barber);
            }
            return barbers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a barber object into barber table
     * @param barber 
     */
    @Override
    public void insert(Barber barber)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO FP_Barber(barberID, barberFirstName, barberLastName, barberSSN) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, barber.getbarberID());
            stmt.setString(2, barber.getbarberFirstName());
            stmt.setString(3, barber.getbarberLastName());
            stmt.setString(4, barber.getbarberSSN());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new barber was inserted successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a barber entity in database if it exists using a barber object
     * @param barber
     */
    @Override
    public void update(Barber barber) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE FP_Barber SET barberFirstName=?, barberLastName=?, barberSSN=? WHERE barberID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, barber.getbarberFirstName());
            stmt.setString(2, barber.getbarberLastName());
            stmt.setString(3, barber.getbarberSSN());
            stmt.setInt(4, barber.getbarberID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing barber was updated successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
            //System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a barber from barber table if the entity exists
     * @param barber 
     */
    @Override
    public void delete(Barber barber) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM FP_Barber WHERE barberID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, barber.getbarberID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A barber was deleted successfully!");
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
            String sql = "SELECT * FROM FP_Barber WHERE barberID = -1";
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
