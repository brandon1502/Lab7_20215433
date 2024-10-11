package com.example.clase7gtics.controller;

import com.example.clase7gtics.entity.Funcion;
import com.example.clase7gtics.repository.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/funciones")
public class FuncionController {

    final FuncionRepository funcionRepository;
    final ObraRepository obraRepository;
    final RoomRepository roomRepository;

    public FuncionController(FuncionRepository funcionRepository,
                             ObraRepository obraRepository,
                             RoomRepository roomRepository) {
        this.funcionRepository = funcionRepository;
        this.obraRepository = obraRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {

        model.addAttribute("listaFunciones", funcionRepository.findAll());
        return "funcion/list";
    }

    @GetMapping("/new")
    public String nuevaFuncionFrm(Model model, @ModelAttribute("funcion") Funcion funciom) {
        model.addAttribute("listaobras", obraRepository.findAll());
        model.addAttribute("listarooms", roomRepository.findAll());
        return "funcion/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute("funcion") @Valid Funcion funcion, BindingResult bindingResult,
                                  RedirectAttributes attr, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("listaobras", obraRepository.findAll());
            model.addAttribute("listarooms", roomRepository.findAll());
            return "funcion/editFrm";
        } else {

            if (funcion.getId() == 0) {
                attr.addFlashAttribute("msg", "Funcion creada exitosamente");
            } else {
                attr.addFlashAttribute("msg", "funcion actualizada exitosamente");
            }
            funcionRepository.save(funcion);
            return "redirect:/product";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model, @RequestParam("id") int id,
                                      @ModelAttribute("funcion") Funcion funcion) {

        Optional<Funcion> optFuncion = funcionRepository.findById(id);

        if (optFuncion.isPresent()) {
            funcion = optFuncion.get();
            model.addAttribute("funcion", funcion);
            model.addAttribute("listaobras", obraRepository.findAll());
            model.addAttribute("listarooms", roomRepository.findAll());
            return "funcion/editFrm";
        } else {
            return "redirect:/funciones";
        }
    }


}
