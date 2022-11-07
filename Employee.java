import java.sql.*;
import java.util.Scanner;


    public class Employee {
        public static void main(String args[])
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");

            }
            catch (Exception e) {
                System.out.println(e);
            }
            int choice;
            String empname,designation,cname,email,password,phone;
            int empcode,salary;
             Scanner s = new Scanner(System.in);
            while(true){
                System.out.println("1.select any option");
                System.out.println("1.insert");
                System.out.println("2.select");
                System.out.println("3.search");
                System.out.println("4.update");
                System.out.println("5.delete");
                System.out.println("6.exit");
                System.out.println("enter the choice");
                choice = s.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.println("insertdata");
                        System.out.println("enter employee code");
                        empcode=s.nextInt();
                        System.out.println("enter employee name");
                        empname=s.next();
                        System.out.println("enter employee desigantion");
                        designation=s.next();
                        System.out.println("enter employee salary");
                        salary=s.nextInt();
                        System.out.println("enter company name");
                        cname=s.next();
                        System.out.println("enter phone number");
                        phone=s.next();
                        System.out.println("enter email id");
                        email=s.next();
                        System.out.println("enter password");
                        password=s.next();
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");

                            String sql="INSERT INTO `employees`( `empcode`, `empname`, `designation`, `salary`, `companyname`, `phoneno`, `emailid`, `password`) VALUES (?,?,?,?,?,?,?,?)";
                            PreparedStatement stmt = con.prepareStatement(sql);
                            stmt.setInt(1,empcode);
                            stmt.setString(2,empname);
                            stmt.setString(3,designation);
                            stmt.setString(4,cname );
                            stmt.setString(5,phone);
                            stmt.setString(6,email);
                            stmt.setString(7,password);

                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                    case 2:
                        System.out.println("select data");
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                            String sql="SELECT  `empcode`, `empname`, `designation`, `salary`, `companyname`, `phoneno`, `emailid`, `password` FROM `employees` ";
                            Statement stmt = con.createStatement();
                            ResultSet rs= stmt.executeQuery(sql);
                            while (rs.next()){
                                String getEmpcode=rs.getString("empcode");
                                String getEmpname=rs.getString("empname");
                                String getdesignation=rs.getString("designation");
                                String getsalary=rs.getString("salary");
                                String getcompanyname=rs.getString("companyname");
                                String getphoneno=rs.getString("phoneno");
                                String getemailid=rs.getString("emailid");
                                String getpassword=rs.getString("password");
                                System.out.println("Empcode="+getEmpcode);
                                System.out.println("Empname="+getEmpname);
                                System.out.println("designation="+getdesignation);
                                System.out.println("salary="+getsalary);
                                System.out.println("companyname="+getcompanyname);
                                System.out.println("phoneno="+getphoneno);
                                System.out.println("emialid="+getemailid);
                                System.out.println("password="+getpassword+"\n");

                            }

                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                    case 3:
                        System.out.println("search data");
                        System.out.println("enter employee code:");
                        empcode=s.nextInt();
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                            String sql="SELECT  `empcode`, `empname`, `designation`, `salary`, `companyname`, `phoneno`, `emailid`, `password` FROM `employees` WHERE `empcode`="+String.valueOf(empcode);
                            Statement stmt = con.createStatement();
                            ResultSet rs= stmt.executeQuery(sql);
                            while(rs.next()){
                                String getEmpcode=rs.getString("empcode");
                                String getEmpname=rs.getString("empname");
                                String getdesignation=rs.getString("designation");
                                String getsalary=rs.getString("salary");
                                String getcompanyname=rs.getString("companyname");
                                String getphoneno=rs.getString("phoneno");
                                String getemailid=rs.getString("emailid");
                                String getpassword=rs.getString("password");
                                System.out.println("Empcode="+getEmpcode);
                                System.out.println("Empname="+getEmpname);
                                System.out.println("designation="+getdesignation);
                                System.out.println("salary="+getsalary);
                                System.out.println("companyname="+getcompanyname);
                                System.out.println("phoneno="+getphoneno);
                                System.out.println("emialid="+getemailid);
                                System.out.println("password="+getpassword+"\n");

                            }
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                    case 4:
                        System.out.println("update data");
                        System.out.println("enter employee code to be updated");
                        empcode=s.nextInt();
                        System.out.println("enter employee code to be updated");
                        int empcodes=s.nextInt();
                        System.out.println("enter employee name to be updated");
                        empname=s.next();
                        System.out.println("enter degination to be updated");
                        designation=s.next();
                        System.out.println("enter salary to be updated");
                        salary=s.nextInt();
                        System.out.println("enter company name  to be updated");
                        cname=s.next();
                        System.out.println("enter phone number to be updated");
                        phone=s.next();
                        System.out.println("enter email id to be updated");
                        email=s.next();
                        System.out.println("enter Password to be updated");
                        password=s.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                            String sql="UPDATE `employees` SET `empcode`='"+String.valueOf(empcodes)+"' ,`empname`='"+empname+"',`designation`='"+designation+"',`salary`='"+String.valueOf(salary)+"',`companyname`='"+cname+"',`phoneno`='"+phone+"',`emailid`='"+email+"',`password`='"+password+"' WHERE `empcode`="+String.valueOf(empcode);
                            Statement stmt =con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("update successfully");
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }




                    case 5:
                        System.out.println("delete data");
                        System.out.println("enter employee code:");
                        String code=s.next();
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                            String sql="DELETE FROM `employees` WHERE `empcode`="+code;
                            Statement stmt =con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("deleted successfully");
                        }
                        catch (Exception e){
                            System.out.println((e));
                        }
                    case 6:
                        System.out.println("exit");
                        System.exit(0);
                        break;
                }
            }
        }
    }


