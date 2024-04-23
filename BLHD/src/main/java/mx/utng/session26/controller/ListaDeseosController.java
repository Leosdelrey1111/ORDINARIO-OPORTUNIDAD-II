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
import mx.utng.session26.model.entity.ListaDeseos;
import mx.utng.session26.model.service.IListaDeseosService;

@Controller
@SessionAttributes("deseo")
public class ListaDeseosController {
    
    @Autowired
    private IListaDeseosService service;

    @GetMapping({"/deseo", "/deseo/", "/deseo/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Deseos");
        model.addAttribute("deseos", service.list());
        return "deseo-list";
    }

    @GetMapping("/deseo/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Deseos");
        model.addAttribute("deseo", new ListaDeseos());
        return "deseo-form";
    }

    @PostMapping("/deseo/form")
    public String save(@Valid ListaDeseos deseo, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Deseos");
            return "deseo-form";
        }
        service.save(deseo);
        return "redirect:/deseo/list";
    }

    @GetMapping("/deseo/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ListaDeseos deseo = null;
        if(id>0){
            deseo = service.getById(id);
            System.out.println(deseo);
        }else{
            return "redirect:/deseo/list";
        }
        model.addAttribute("title", "Editar Deseo");
        model.addAttribute("deseo", deseo);
        return "deseo-form";
    }

    @GetMapping("/deseo/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/deseo/list";
    }

}