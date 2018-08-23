package ua.rozhkov.springdepdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.OwnerShip;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.service.CollegeService;
import ua.rozhkov.springdepdb.service.SpecialtyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    private CollegeService collegeService;
    private List<OwnerShip> collegeOwnerShips;
    private SpecialtyService specialtyService;

    public CollegeController(CollegeService collegeService, SpecialtyService specialtyService) {
        this.collegeService = collegeService;
        collegeOwnerShips = Arrays.asList(OwnerShip.values());
        this.specialtyService = specialtyService;
    }

    @RequestMapping("/list")
    public String showListCollegesPage(Model model) {
        model.addAttribute("colleges", collegeService.findAll());
        return "college/listColleges";
    }

    @RequestMapping("/add")
    public String showAddCollegePage(Model model) {
        College newCollege = new College();
        model.addAttribute("ownerShips", collegeOwnerShips);
        model.addAttribute("newCollege", newCollege);
        List<Specialty> specialties = specialtyService.findAll();
        model.addAttribute("specialties", specialties);
        return "college/addCollege";
    }

    @RequestMapping("/addNewCollege")
    public String addNewCollege(@ModelAttribute College newCollege,
                                @RequestParam("checkedSpecialties") List<String> checkedSpecialities) {
        List<Specialty> checkedSpecialtyList = new ArrayList<>();
        for (String id :
                checkedSpecialities) {
            checkedSpecialtyList.add(specialtyService.findById(Long.parseLong(id)));
        }
        return "redirect:/college/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        model.addAttribute("ownerShips", collegeOwnerShips);
        College collegeToUpdate = collegeService.findById(id);
        model.addAttribute("collegeToUpdate", collegeToUpdate);
        return "college/editCollege";
    }

    @RequestMapping("/updateCollege")
    public String updateCollege(@ModelAttribute College collegeToUpdate) {
        collegeService.save(collegeToUpdate);
        return "redirect:/college/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCollege(@PathVariable long id) {
        collegeService.deleteById(id);
        return "redirect:/college/list";
    }


}
