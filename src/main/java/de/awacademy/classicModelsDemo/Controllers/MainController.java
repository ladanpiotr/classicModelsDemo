package de.awacademy.classicModelsDemo.Controllers;

import de.awacademy.classicModelsDemo.Data.EmployeeService;
import de.awacademy.classicModelsDemo.Data.OfficeService;
import de.awacademy.classicModelsDemo.Models.Employee;
import de.awacademy.classicModelsDemo.Models.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private EmployeeService employeeService;


    // Example to show that everything still works, even when we don't use a DB connection
    @GetMapping("/dummy")
    public String dummyIndex(HttpServletRequest request, Model model) {

        ArrayList<Office> officeList = new ArrayList<>();
        officeList.add(new Office("1", "Porto", "+351 221 123 456", "Street of the Office 123", "PT", "4200-123", "EMCA"));
        officeList.add(new Office("2", "Lisbon", "+351 221 123 789", "Street of the Office 456", "PTPT", "4200-456", "EMCB"));

        model.addAttribute("offices", officeList);

        return "index";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {

        List<Office> officeList = officeService.getAllOffices();

        model.addAttribute("offices", officeList);

        return "index";
    }

    @GetMapping("/office")
    public ModelAndView employees(HttpServletRequest request) {

        String officeCode = request.getParameter("code");
        Office office = officeService.getOfficeById(officeCode);

        List<Employee> employeeList = employeeService.getAllEmployees();


        // Instead of letting Hibernate pick the file automatically by returning a string
        // We can create a ModelAndView of the page and return it
        // Same effect, different way of doing it
        ModelAndView model = new ModelAndView("office");

        model.addObject("office", office);
        model.addObject("employees", employeeList);

        return model;
    }

}
