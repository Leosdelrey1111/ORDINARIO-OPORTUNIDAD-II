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
import mx.utng.session26.model.entity.ReservaHotel;
import mx.utng.session26.model.service.IReservaHotelService;

@Controller
@SessionAttributes("reserva")
public class ReservaHotelController {
    
    @Autowired
    private IReservaHotelService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Reservas");
        model.addAttribute("reservas", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Reservas");
        model.addAttribute("reserva", new ReservaHotel());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid ReservaHotel reserva, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Reservas");
            return "form";
        }
        service.save(reserva);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ReservaHotel reserva = null;
        if(id>0){
            reserva = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Reserva");
        model.addAttribute("reserva", reserva);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
