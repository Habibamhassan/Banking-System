/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tolan
 */
public class DbManager {
    Connection con;
    private static DbManager db;
    
    private DbManager(){
        //Dummy
    }
    public static DbManager getInstance(){
        if(db == null){
            return new DbManager();
        }else{
            return db;
        }
    }
    private  void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Omar1801246");
           
            System.out.println("Successully Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String validateUser(String username, String password){
        createConnection();
         try {
           
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select name from client where name = '"+username+"'");
            if(rs.next()){
                rs = st.executeQuery("select name,password from client where name = '"+username+"' and password = '"+password+"'");
                
                if(rs.next()){
                    st.close();
                   con.close();
                    return "Login Successfully";

                }
                else{
                    st.close();
                    con.close();
                    return "Incorrect password";

                }

            }
            else{
                st.close();
                con.close();
                return "Incorrect username";
            }   
     
        
        
         }catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
  return "Login Successfully";
    }
    
    public String validateBalance(String username, int amount){
        createConnection();
        try {
           
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select balance from client where name = '"+username+"'");
            
                double balance =rs.getDouble("balance");
                if(balance>=amount){
                    st.close();
                    con.close();
                    return "Sufficient Balance";
                }
                else{
                    st.close();
                    con.close();
                    return "Insufficient Balance";
                }
           
        
         }catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return "Sufficient Balance";
        
    }
    
    public String createClient(Client c){
        createConnection();
        //create client in db insert
        try {
            // TODO add your handling code here:
           
            PreparedStatement st = con.prepareStatement("insert into client values(?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, c.getName());
            st.setInt(2,c.getAge());
            st.setString(3, c.get_password());
            st.setInt(4, c.getPhNo());
            st.setString(5, c.getAddress());
            Account acc = c.getClientAccount();
            st.setDouble(6,acc.getBalance());
            st.setString(7, c.getGender());
            st.setString(8,c.getDob());
            st.setString(9,c.getNationality());
            st.setString(10,acc.getType());
            st.execute();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Created Successfully";
    }
    
    public String deleteClient(String username){
         createConnection();
             try {
           
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select name from client where name = '"+username+"'");
            if(rs.next()){
               st.executeQuery("delete from client where name = '"+username+"'");
               return "deleted successfully";
            }
            else{
                st.close();
                con.close();
                return "username not found";
            }   
     
        
        
         }catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

         
        return "";
    }
    
    public String updateClient(String username, Client c){
        createConnection();
        try {
            PreparedStatement st = con.prepareStatement("UPDATE client SET name = ? ,age = ? , password = ? , phNo = ? , address = ? , balance = ? , gender = ? , dob = ? ,  nationality = ? , type = ?"
                    + " WHERE name = ?;");
            st.setString(1, c.getName());
            st.setInt(2,c.getAge());
            st.setString(3, c.get_password());
            st.setInt(4, c.getPhNo());
            st.setString(5, c.getAddress());
            Account acc = c.getClientAccount();
            st.setDouble(6,acc.getBalance());
            st.setString(7, c.getGender());
            st.setString(8,c.getDob());
            st.setString(9,c.getNationality());
            st.setString(10,acc.getType());
            st.setString(11,username);
            st.executeUpdate();
            st.close();
            con.close();
          
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "updated successfully";
    }
    
    
    public Client getClient(String username){
        createConnection();
        Client c = null ;
            try {
           
                Statement st = con.createStatement();
                ResultSet rs=st.executeQuery("select * from client where name = '"+username+"'");
                int id = 0;
                String name = null;
                int age = 0;
                String password = null;
                int phNo = 0;
                String address = null;
                Double balance = null;
                String gender = null;
                String dob = null;
                String nationality = null;
                String type = null;
                while(rs.next()){
                    id=rs.getInt("accid");
                    name=rs.getString("name");
                    age = rs.getInt("age");
                    password=rs.getString("password");
                    phNo=rs.getInt("phNo");
                    address = rs.getString("address");
                    balance = rs.getDouble("balance");
                    gender = rs.getString("gender");
                    dob = rs.getString("dob");
                    nationality = rs.getString("nationality");
                    type = rs.getString("type");
                }
                Account acc=new Account(id,balance,type);
                c = new Client (name,id,address,phNo,id,acc,gender,nationality,dob,password,age);
            }catch (SQLException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return c;
    }    
}
