package com.example.Tarea2_20206156.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.Tarea2_20206156.model.bean.*;
import com.example.Tarea2_20206156.model.repository.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.Tarea2_20206156.model.bean.*;
import com.example.Tarea2_20206156.model.repository.*;


import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeesController {

    private EmployeeDAO employeesDAO = new EmployeeDAO();
    private JobDAO jobsDAO = new JobDAO();

    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> listaEmpleados = employeesDAO.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employeeList";
    }

    @GetMapping("/employee/info/{id}")
    public String informEmpleado(@PathVariable("id") int id, Model model) {
        Employee employee = employeesDAO.findById(id);
        List<Job> listaTrabajos = jobsDAO.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("listaTrabajos", listaTrabajos);
        return "employeeInfo";
    }


    @GetMapping("/employee/delete/{id}") /* popup hecho */
    public String borrarEmpleado(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        boolean eliminado = employeesDAO.deleteById(id);
        if (eliminado) {
            redirectAttributes.addAttribute("msg", "Se borró el empleado");
        } else {
            redirectAttributes.addAttribute("msg", "No se pudo borrar el empleado");
        }
        return "redirect:/employee";
    }


}
