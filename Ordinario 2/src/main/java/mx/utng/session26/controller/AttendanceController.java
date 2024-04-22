package mx.utng.session26.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.Attendance;
import mx.utng.session26.model.service.IAttendanceService;

@Controller
@SessionAttributes("attendance")
public class AttendanceController {
    @Autowired
    private IAttendanceService service;

    @GetMapping({"/attendance", "/attendance/", "/attendance/list"})
    public String list(Model model) {
        model.addAttribute("title", "Listado de Asistencias");
        model.addAttribute("attendances", service.list());
        return "attendance-list";
    }

    @GetMapping("/attendance/form")
    public String create(Model model) {
        model.addAttribute("title", "Formulario de Asistencias");
        model.addAttribute("attendance", new Attendance());
        return "attendance-form";
    }

    @PostMapping("/attendance/form")
    public String save(@Valid Attendance attendance, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Asistencias");
            return "attendance-form";
        }
        service.save(attendance);
        return "redirect:/attendance/list";
    }

    @GetMapping("/attendance/form/{id}")
    public String update(@PathVariable Long id, Model model) {
        Attendance attendance = null;
        if (id > 0) {
            attendance = service.getById(id);
        } else {
            return "redirect:/attendance/list";
        }
        model.addAttribute("title", "Editar Asistencia");
        model.addAttribute("attendance", attendance);
        return "attendance-form";
    }

    @GetMapping("/attendance/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/attendance/list";
    }
}