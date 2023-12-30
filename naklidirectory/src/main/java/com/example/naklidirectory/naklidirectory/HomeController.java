package com.example.naklidirectory.naklidirectory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHome(){
        System.out.println("Requesting HomePage!");
        return "index.jsp";
    }
    @RequestMapping("addEmployee")
    public ModelAndView addEmp(@RequestParam("empID") int empID,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone") int phone) throws ClassNotFoundException, SQLException {
        employee emp = new employee(empID, name, email, phone);
        ModelAndView mv = new ModelAndView("addSuccess.jsp");
        mv.addObject("empID", empID);
        mv.addObject("name", name);
        mv.addObject("email", email);
        mv.addObject("phone", phone);
        mv.addObject("employee", emp);
        // DataBase Stuff
        try{Class.forName("org.postgresql.Driver");}
        catch (ClassNotFoundException e) {throw new ClassNotFoundException();}
        String url = "jdbc:postgresql://localhost:5432/employee";
        String uname = "postgres";
        String pass = "root";
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Succesful!");
        String query = "INSERT INTO emp VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, empID);
        ps.setString(2,name);
        ps.setString(3,email);
        ps.setInt(4, phone);
        ps.execute();
        con.close();
        return mv;
    }
    @RequestMapping("fetchEmployeeInfo")
    public ModelAndView fetchEmployeeInfo(@RequestParam("empID") int empID) throws SQLException {
        ModelAndView mv = new ModelAndView("displayDetails.jsp");
        String url = "jdbc:postgresql://localhost:5432/employee";
        String uname = "postgres";
        String pass = "root";
        try (Connection con = DriverManager.getConnection(url, uname, pass)) {
            System.out.println("Connection Successful!");
            String query = "SELECT * FROM emp WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, empID);
                try (ResultSet rs = ps.executeQuery()) {
                    String empName = "", empEmail = "";
                    int empPhone = 0;
                    if (rs.next()) {
                        empName = rs.getString("name"); // Assuming "empName" is column 1
                        empEmail = rs.getString("email"); // Assuming "empEmail" is column 2
                        empPhone = rs.getInt("phone"); // Assuming "empPhone" is column 3
                    }
                    mv.addObject("empID", empID);
                    mv.addObject("name", empName);
                    mv.addObject("email", empEmail);
                    mv.addObject("phone", empPhone);
                    employee emp = new employee(empID, empName, empEmail, empPhone);
                    mv.addObject("employee", emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return mv;
    }
    @RequestMapping("updateEmployee")
    public ModelAndView updateEmp(@RequestParam("empID")int empId,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone") int phone) throws ClassNotFoundException, SQLException {
        ModelAndView mv = new ModelAndView("updateSuccess.jsp");
        // Database Stuff...
        try{Class.forName("org.postgresql.Driver");}
        catch (ClassNotFoundException e) {throw new ClassNotFoundException();}
        String url = "jdbc:postgresql://localhost:5432/employee";
        String uname = "postgres";
        String pass = "root";
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Succesful!");
        String query = "SELECT * FROM emp WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, empId);
        ResultSet rs = ps.executeQuery();
        String oldName = "", oldEmail = "";
        int oldPhone = 0;
        if (rs.next()) {
            oldName = rs.getString("name"); // Assuming "empName" is column 1
            oldEmail = rs.getString("email"); // Assuming "empEmail" is column 2
            oldPhone = rs.getInt("phone"); // Assuming "empPhone" is column 3
        }
        mv.addObject("id", empId);
        mv.addObject("oldName", oldName);
        mv.addObject("oldEmail", oldEmail);
        mv.addObject("oldPhone", oldPhone);
        mv.addObject("newName", name);
        mv.addObject("newEmail", email);
        mv.addObject("newPhone", phone);
        // Update the Data to the one in parameters
        query = "UPDATE emp SET name = ?, email = ?, phone = ? where id = ?";
        PreparedStatement p = con.prepareStatement(query);
        p.setString(1, name);
        p.setString(2, email);
        p.setInt(3, phone);
        p.setInt(4, empId);
        p.execute();
        con.close();
        //Set Model Parameters to have both the old & new Attrib
        return mv;
    }
    @RequestMapping("preDelete")
    public ModelAndView preDel(@RequestParam("empID") int id) throws SQLException {
        ModelAndView mv = new ModelAndView("preDelete.jsp");
        String url = "jdbc:postgresql://localhost:5432/employee";
        String uname = "postgres";
        String pass = "root";
        try (Connection con = DriverManager.getConnection(url, uname, pass)) {
            System.out.println("Connection Successful!");
            String query = "SELECT * FROM emp WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    String empName = "", empEmail = "";
                    int empPhone = 0;
                    if (rs.next()) {
                        empName = rs.getString("name"); // Assuming "empName" is column 1
                        empEmail = rs.getString("email"); // Assuming "empEmail" is column 2
                        empPhone = rs.getInt("phone"); // Assuming "empPhone" is column 3
                    }
                    mv.addObject("empID", id);
                    mv.addObject("name", empName);
                    mv.addObject("email", empEmail);
                    mv.addObject("phone", empPhone);
                    employee emp = new employee(id, empName, empEmail, empPhone);
                    mv.addObject("employee", emp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return mv;
    }
    @RequestMapping("/deleteFinal")
    public ModelAndView delFinal (@RequestParam("empID") int empID) throws SQLException {
        ModelAndView mv = new ModelAndView("delSuccess.jsp");
        String url = "jdbc:postgresql://localhost:5432/employee";
        String uname = "postgres";
        String pass = "root";
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Succesful!");
        String query = "DELETE FROM emp WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, empID);
        ps.execute();
        con.close();
        return mv;
    }

}
