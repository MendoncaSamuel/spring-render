package com.entidade.relacional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @Autowired
    private RepositoryAppUser userRepository;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @GetMapping("/users")
    public String usersPage(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("profissoes", profissaoRepository.findAll());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String nome, @RequestParam Long profissaoID){
        AppUser user = new AppUser();
        user.setNome(nome);
        Profissao profissao = profissaoRepository.findById(profissaoID).orElse(null);
        if(profissao != null ){
            user.setProfissao(profissao);
            userRepository.save(user);
        }
        return "redirect:/users";
    }
    @PostMapping("/addProfissao")
    public String addProfissao(@RequestParam String titulo){
        Profissao profissao = new Profissao();

        profissao.setTitulo(titulo);
        profissaoRepository.save(profissao);
        return "redirect:/users";
    }

}
