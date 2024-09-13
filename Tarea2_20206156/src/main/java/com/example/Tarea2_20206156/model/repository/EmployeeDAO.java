package com.example.Tarea2_20206156.model.repository;
import com.example.Tarea2_20206156.model.bean.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO extends BaseDAO {

    public ArrayList<Employee> findAll() {

        ArrayList<Employee> listaEmpleados = new ArrayList<>();

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.phone_number, e.enabled, e.salary "
                + "d.department_name, j.job_title"
                + "FROM employees e "
                + "JOIN departments d ON e.department_id = d.department_id "
                + "JOIN jobs j ON d.jobs_id = j.jobs_id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPhone_number(rs.getString("phone_number"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setEnabled(rs.getInt("enabled"));


                Department department = new Department();
                department.setDepartName(rs.getString("department_name"));
                employee.setDepartment(department);

                Job job = new Job();
                job.setJobTitle(rs.getString("job_title"));
                employee.setJob(job);
                listaEmpleados.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleados;
    }

    public Employee findById(int id) {

        Employee employee = new Employee();

        String sql = "SELECT e.employee_id,  e.first_name, e.last_name, e.phone_number, e.enabled, e.salary , "
                + "d.department_name, j.job_title "
                + "FROM employees e "
                + "JOIN departments d ON e.department_id = d.department_id "
                + "JOIN jobs j ON d.jobs_id = j.jobs_id "
                + "WHERE e.employee_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setPhone_number(rs.getString("phone_number"));
                    employee.setSalary(rs.getDouble("salary"));
                    employee.setEnabled(rs.getInt("enabled"));

                    Department department = new Department();
                    department.setDepartName(rs.getString("department_name"));
                    employee.setDepartment(department);

                    Job job = new Job();
                    job.setJobTitle(rs.getString("job_title"));
                    employee.setJob(job);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employee;
    }

    public boolean deleteById(int id) {
        String sql =  "DELETE FROM employees WHERE employee_id = ?";
        boolean flag = false;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                flag = true;
            }

        }  catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

}
