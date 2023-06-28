/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vazha.dbms.supermarketmanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author abhir
 */
public class DataBase {
    Connection connection = null;
    public static DataBase db= new DataBase();
    public DataBase(){
   
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/supermarket",
                "root", "root");
        }catch(Exception e){}
    }
   
    Boolean InsertEmp(String id,String fname,String lname,String email,String pass,String sal,String aid){
       
        try{
            String query="insert into employee(EID,EmpFirstName,EmpLastName,EmpSalary,EmpEmail,EmpPassword,AID) values('"+id+"','"+fname+"','"+lname+"','"+sal+"','"+email+"','"+pass+"','"+aid+"');";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
        Boolean UpdateEmp(String eid,String efnm,String elnm,String eemail,String epas,String esal,String eaid){
       
        try{
            String query="update employee set "+(esal.isEmpty()?"":"EmpSalary='"+esal+"'")+(efnm.isEmpty()?"":",EmpFristName='"+efnm+"'")+(elnm.isEmpty()?"":",EmpLastName='"+elnm+"'")+(eemail.isEmpty()?"":",EmpEmail='"+eemail+"'")+(epas.isEmpty()?"":",EmpPassword='"+epas+"'")+" where EID='"+eid+"';";
            Statement stm= connection.createStatement();
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean DeleteEmp(String id){
       
        try{
            String query="delete from employee where EID='"+id+"';";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
        
        
    Boolean Deletepro(String id){
       
        try{
            String query="delete from products where PID='"+id+"';";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Updatepro(String cid,String pid,String pnm,String cosp,String selp){
       
        try{
            String query="update products set "+(pnm.isEmpty()?"":"ProdName='"+pnm+"'")+(cosp.isEmpty()?"":",ProdCostPrice='"+cosp+"'")+(selp.isEmpty()?"":",ProdSellPrice='"+selp+"'")+" where PID='"+pid+"';";
            Statement stm= connection.createStatement();
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Insertpro(String cid,String pid,String pnm,String cosp,String selp){
       
        try{
            String query="insert into products(PID,ProdName,ProdCostPrice,ProdSalePrice,CID) values('"+pid+"','"+pnm+"','"+cosp+"','"+selp+"','"+cid+"');";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    
    
    Boolean Insertord(String oid,String eid,String dt,String amt){
       
        try{
            String query="insert into orders (OID,EID,OrdDate,OrdTotalAmount) values('"+oid+"','"+eid+"','"+dt+"','"+amt+"');";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Deleteord(String oid){
       
        try{
            String query="delete from orders where OID='"+oid+"';";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Updateord(String oid,String eid,String dt,String amt){
       
        try{
            String query="update orders set "+(eid.isEmpty()?"":"EID='"+eid+"'")+(dt.isEmpty()?"":",OrderDate='"+dt+"'")+(amt.isEmpty()?"":",OrdTotalAmount='"+amt+"'")+" where OID='"+oid+"';";
            Statement stm= connection.createStatement();
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    
    
    Boolean Insertcate(String cid,String cnm){
       
        try{
            String query="insert into category (CID,CatName) values('"+cid+"','"+cnm+"');";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Deletecate(String cid){
       
        try{
            String query="delete from category where CID='"+cid+"';";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Updatecate(String cid,String cnm){
       
        try{
            String query="update category set "+(cnm.isEmpty()?"":"CatName='"+cnm+"'")+" where CID='"+cid+"';";
            Statement stm= connection.createStatement();
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    
    
    Boolean Insertbill(String bino,String pid,String qt,String amt){
       
        try{
            String query="insert into orderproduct (OID,PID,Quantity,SubTotal) values('"+bino+"','"+pid+"','"+qt+"','"+amt+"');";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Deletebill(String bino){
       
        try{
            String query="delete from orderproduct where OID='"+bino+"';";
            Statement stm= connection.createStatement();
       
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Updatebill(String bino,String pid,String qt,String amt){
       
        try{
            String query="update orderproduct set "+(pid.isEmpty()?"":"PID='"+pid+"'")+(qt.isEmpty()?"":",Quantity='"+qt+"'")+(amt.isEmpty()?"":",SubTotal='"+amt+"'")+" where OID='"+bino+"';";
            Statement stm= connection.createStatement();
            stm.executeUpdate(query);
           
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
       
    }
    
    Boolean Login(String name,String password){
        
        String query="select * from employee where EID ='"+name+"' and Emppassword='"+password+"';";
        try{
            ResultSet rs=connection.createStatement().executeQuery(query);
          return rs.next();
        }
        catch(Exception e){e.printStackTrace();}
        return false;
       
    }

   
    
    ArrayList getEmployee(){
        String query="select * from employee ;";
        ArrayList list = new ArrayList();
        try{
            ResultSet res=connection.createStatement().executeQuery(query);
            while(res.next()){
                Object obj[]={
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7)};
                list.add(obj);
            }
            return list;
        }
        catch(Exception e){
             return null;
        }
    }
    
    ArrayList getProduct(){
        String query="select * from products ;";
        ArrayList list = new ArrayList();
        try{
            ResultSet res=connection.createStatement().executeQuery(query);
            while(res.next()){
                Object obj[]={
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),};
                list.add(obj);
            }
            return list;
        }
        catch(Exception e){
             return null;
        }
    }
    
    
        ArrayList getOrder(){
        String query="select * from orders ;";
        ArrayList list = new ArrayList();
        try{
            ResultSet res=connection.createStatement().executeQuery(query);
            while(res.next()){
                Object obj[]={
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4)};
                list.add(obj);
            }
            return list;
        }
        catch(Exception e){
             return null;
        }
    }
        
        
    ArrayList getbill(){
        String query="select * from orderproduct ;";
        ArrayList list = new ArrayList();
        try{
            ResultSet res=connection.createStatement().executeQuery(query);
            while(res.next()){
                Object obj[]={
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4)};
                list.add(obj);
            }
            return list;
        }
        catch(Exception e){
             return null;
        }
    }
    
    ArrayList getcategory(){
        String query="select * from category ;";
        ArrayList list = new ArrayList();
        try{
            ResultSet res=connection.createStatement().executeQuery(query);
            while(res.next()){
                Object obj[]={
                res.getString(1),
                res.getString(2)};
                list.add(obj);
            }
            return list;
        }
        catch(Exception e){
             return null;
        }
    }
}