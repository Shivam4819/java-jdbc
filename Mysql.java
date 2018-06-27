
package mysql;
import java.sql.*;
import java.util.Scanner;
import java.util.Properties;
public class Mysql {

    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION ="jdbc:mysql://127.0.0.1/student";
    Scanner s= new Scanner(System.in);
    private int roll,phone;
    private String name,subject;
   
    public void studentinfo(){
        
        System.out.print("Enter roll no-");
        roll=s.nextInt();
        s.nextLine();
        System.out.print("Enter name-");
        name=s.nextLine();
        System.out.print("Enter subject-");
        subject=s.nextLine();
        System.out.print("Enter phone no-");
        phone=s.nextInt();
    }
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
    
    int choice;
    Scanner sc = new Scanner(System.in);    
    Mysql my = new Mysql();
    
    System.out.println(dbClassName);
    Class.forName(dbClassName);

    Properties p = new Properties();
    p.put("user","root");
    p.put("password","");

    Connection c = DriverManager.getConnection(CONNECTION,p);
    Statement smt = c.createStatement();
    do{
    System.out.println("menu");
    System.out.println("1)insert");
    System.out.println("2)display");
    System.out.print("enter choice-");
    choice = sc.nextInt();
        switch(choice){
     
            case 1:    
                    my.studentinfo();
                    smt.executeUpdate("INSERT INTO `student_info`(roll , name , subject , phone)"+
                            "VALUES('"+my.roll+"','"+my.name+"','"+my.subject+"','"+my.phone+"')");
    
                    System.out.println("It works !");
                    break;
                    
            case 2:
                    String sql = "SELECT * FROM student_info";
                    ResultSet re =smt.executeQuery(sql);
                    while (re.next()) {                    
                        
                        int id = re.getInt("roll");
                        String name = re.getString("name");
                        String subject = re.getString("subject");
                        int phone = re.getInt("phone");

                        System.out.println(id+"   "+name+"    "+subject+"    "+phone);
                    }
                    break;
            }
  
    }while(choice!=3);
    c.close();
 }
}

















