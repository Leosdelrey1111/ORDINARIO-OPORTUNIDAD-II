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
import mx.utng.session26.model.entity.GaleriaArte;
import mx.utng.session26.model.service.IGaleriaArteService;

@Controller
@SessionAttributes("galeria")
public class GaleriaArteController {
    
    @Autowired
    private IGaleriaArteService service;

    @GetMapping({"/galeria", "/galeria/", "/galeria/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Galerias");
        model.addAttribute("galerias", service.list());
        return "galeria-list";
    }

    @GetMapping("/galeria/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Galerias");
        model.addAttribute("galeria", new GaleriaArte());
        return "galeria-form";
    }

    @PostMapping("/galeria/form")
    public String save(@Valid GaleriaArte galeria, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Galeria");
            return "galeria-form";
        }
        service.save(galeria);
        return "redirect:/galeria/list";
    }

    @GetMapping("/galeria/form/{id}")
    public String update(@PathVariable Long id, Model model){
        GaleriaArte galeria = null;
        if(id>0){
            galeria = service.getById(id);
        }else{
            return "redirect:/galeria/list";
        }
        model.addAttribute("title", "Editar Galeria");
        model.addAttribute("galeria", galeria);
        return "galeria-form";
    }

    @GetMapping("/galeria/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/galeria/list";
    }



}
