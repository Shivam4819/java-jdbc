
package mysql;
import java.sql.*;
import java.util.Scanner;
import java.util.Properties;

public class Mysql {

    public static void main(String[] args){
        
    int roll,phone,opt;
    String name,subject,company,client;
    Scanner sc= new Scanner(System.in);
    
    Student s =new Student();
    Company c =new Company();
    
    do{
        System.out.println("for student table-");
        System.out.println("for company table-");
        System.out.print("enter choice-");
        opt=sc.nextInt();
        
        switch(opt){
            case 1:
                System.out.print("Enter roll no-");
                roll=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name-");
                name=sc.nextLine();
                System.out.print("Enter subject-");
                subject=sc.nextLine();
                System.out.print("Enter phone no-");
                phone=sc.nextInt();
                
                s.storing(name,subject, phone, roll);
                s.display();
                break;
                
            case 2:
                sc.nextLine();
                System.out.print("Enter compayname-");
                company=sc.nextLine();
                
                System.out.print("Enter clientname-");
                client=sc.nextLine();
                
                c.companydata(company, client);
                c.display();
                break;    
        }        
    }while(opt!=3);
  }     
}

class Student{
    private  final String dbClassName = "com.mysql.jdbc.Driver";
    private  final String CONNECTION ="jdbc:mysql://127.0.0.1/student";
    private Connection c,c1 =null;
    private Statement smt,smt1 =null;
     
    public void storing(String var1, String var2 ,int var3, int var4){   //name,sub,phone,roll
    
        try {
            Class.forName(dbClassName);
            Properties p = new Properties();
            p.put("user","root");
            p.put("password","");
            c = DriverManager.getConnection(CONNECTION,p);   
        
            smt = c.createStatement();
            smt.executeUpdate("INSERT INTO `student_info`(roll , name , subject , phone)"+
              "VALUES('"+var4+"','"+var1+"','"+var2+"','"+var3+"')");
            System.out.println("It works !");
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("Driver not istalled"+ e);
        }
        catch(SQLException e){
            System.out.println("Not connected to mysql"+ e);
        }
        catch(Exception e){
            System.out.println("some other exection");
        }
        finally{
            try {
                c.close();
            }
            catch(SQLException e){
                 System.out.println("Not connected to mysql"+ e);
            }
        }
    
    
    }
    
    public void display(){
      
        try {
            Class.forName(dbClassName);
            Properties p = new Properties();
            p.put("user","root");
            p.put("password","");
            c1 = DriverManager.getConnection(CONNECTION,p);  
            smt1 = c1.createStatement();
            String sql = "SELECT * FROM student_info";
            ResultSet re =smt1.executeQuery(sql);
            while (re.next()) {                    

                int id = re.getInt("roll");
                String name = re.getString("name");
                String subject = re.getString("subject");
                int phone = re.getInt("phone");

                System.out.println(id+"   "+name+"    "+subject+"    "+phone);
            }
        }
         catch (ClassNotFoundException e) {
            System.out.println("Driver not istalled"+ e);
        }
        catch(SQLException e){
            System.out.println("Not connected to mysql"+ e);
        }
        catch(Exception e){
            System.out.println("some other exection"+e);
        }
        finally{
            try {
                c1.close();

            }
            catch(SQLException e){
                 System.out.println("Not  to mysql"+ e);
            }
        }
    }
}



class Company{
    private  final String dbClassName = "com.mysql.jdbc.Driver";
    private  final String CONNECTION ="jdbc:mysql://127.0.0.1/student";
    private Connection c,c1 =null;
    private Statement smt,smt1 =null;
     
    public void companydata(String var1, String var2 ){   //CompanyName,ClientName
    
        try {
            Class.forName(dbClassName);
            Properties p = new Properties();
            p.put("user","root");
            p.put("password","");
            c = DriverManager.getConnection(CONNECTION,p);   
        
            smt = c.createStatement();
            smt.executeUpdate("INSERT INTO `company_info`(CompanyName,ClientName)"+
              "VALUES('"+var1+"','"+var2+"')");
            System.out.println("It works !");
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("Driver not istalled"+ e);
        }
        catch(SQLException e){
            System.out.println("Not connected to mysql"+ e);
        }
        catch(Exception e){
            System.out.println("some other exection");
        }
        finally{
            try {
                c.close();
            }
            catch(SQLException e){
                 System.out.println("Not connected to mysql"+ e);
            }
        }
    
    
    }
    
    public void display(){
      
        try {
            Class.forName(dbClassName);
            Properties p = new Properties();
            p.put("user","root");
            p.put("password","");
            c1 = DriverManager.getConnection(CONNECTION,p);  
            smt1 = c1.createStatement();
            String sql = "SELECT * FROM company_info";
            ResultSet re =smt1.executeQuery(sql);
            while (re.next()) {                    

                String company = re.getString("CompanyName");
                String client = re.getString("ClientName");
                
                System.out.println(company+"    "+client);
            }
        }
         catch (ClassNotFoundException e) {
            System.out.println("Driver not istalled"+ e);
        }
        catch(SQLException e){
            System.out.println("Not connected to mysql"+ e);
        }
        catch(Exception e){
            System.out.println("some other exection"+e);
        }
        finally{
            try {
                c1.close();

            }
            catch(SQLException e){
                 System.out.println("Not  to mysql"+ e);
            }
        }
    }
}
