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
import mx.utng.session26.model.entity.Beca;
import mx.utng.session26.model.service.IBecaService;

@Controller
@SessionAttributes("beca")
public class BecaController {
    
    @Autowired
    private IBecaService service;

    @GetMapping({"/beca", "/beca/", "/beca/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Becas");
        model.addAttribute("becas", service.list());
        return "beca-list";
    }

    @GetMapping("/beca/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Becas");
        model.addAttribute("beca", new Beca());
        return "beca-form";
    }

    @PostMapping("/beca/form")
    public String save(@Valid Beca beca, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Becas");
            return "beca-form";
        }
        service.save(beca);
        return "redirect:/beca/list";
    }

    @GetMapping("/beca/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Beca beca = null;
        if(id>0){
            beca = service.getById(id);
        }else{
            return "redirect:/beca/list";
        }
        model.addAttribute("title", "Editar Beca");
        model.addAttribute("beca", beca);
        return "beca-form";
    }

    @GetMapping("/beca/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/beca/list";
    }

}