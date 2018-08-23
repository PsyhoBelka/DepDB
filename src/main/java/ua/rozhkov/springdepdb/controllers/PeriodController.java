package ua.rozhkov.springdepdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.core.Period;
import ua.rozhkov.springdepdb.service.PeriodService;

@Controller
@RequestMapping("/period")
public class PeriodController {
    private PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @RequestMapping("/list")
    public String showListPeriodsPage(Model model) {
        model.addAttribute("periods", periodService.findAll());
        return "period/listPeriod";
    }

    @RequestMapping("/add")
    public String showAddPeriodPage(Model model) {
        Period newPeriod = new Period();
        model.addAttribute("newPeriod", newPeriod);
        return "period/addPeriod";
    }

    @RequestMapping("/addNewPeriod")
    public String addNewPeriod(@ModelAttribute Period newPeriod) {
        periodService.add(newPeriod);
        return "redirect:/period/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Period periodToUpdate = periodService.findById(id);
        model.addAttribute("periodToUpdate", periodToUpdate);
        return "period/editPeriod";
    }

    @RequestMapping("/updatePeriod")
    public String updatePeriod(@ModelAttribute Period periodToUpdate) {
        periodService.update(periodToUpdate);
        return "redirect:/period/list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePeriod(@PathVariable long id) {
        periodService.deleteById(id);
        return "redirect:/period/list";
    }
}
