package ua.rozhkov.springdepdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.FormDTO.PeriodFormDTO;
import ua.rozhkov.springdepdb.service.PeriodService;

@Controller
@RequestMapping("/period")
public class PeriodController {
    @Autowired
    private PeriodService periodService;

    @RequestMapping("/list")
    public String showListPeriodsPage(Model model) {
        model.addAttribute("periods", periodService.findAll());
        return "period/listPeriod";
    }

    @RequestMapping("/add")
    public String showAddPeriodPage(Model model) {
        model.addAttribute("periodFormDTOToAdd", periodService.preparePeriodFormDTOToAdd());
        return "period/addPeriod";
    }

    @RequestMapping("/addPeriod")
    public String addPeriod(@ModelAttribute PeriodFormDTO periodFormDTOToAdd) {
        periodService.perfomPeriodFormDTOAdd(periodFormDTOToAdd);
        return "redirect:/period/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Period periodToUpdate = periodService.findById(id);
        model.addAttribute("periodFormDTOToEdit", periodService.preparePeriodFormDTOToEdit(periodToUpdate));
        return "period/editPeriod";
    }

    @RequestMapping("/editPeriod")
    public String editPeriod(@ModelAttribute PeriodFormDTO periodFormDTOToEdit) {
        periodService.perfomPeriodFormDTOEdit(periodFormDTOToEdit);
        return "redirect:/period/list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePeriod(@PathVariable long id) {
        periodService.deleteById(id);
        return "redirect:/period/list";
    }
}
