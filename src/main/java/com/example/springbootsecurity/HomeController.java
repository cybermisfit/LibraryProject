package com.example.springbootsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    LibrarianRepository librarianRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("student", new Student());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model) {
        model.addAttribute("student", student);
        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(student);
            model.addAttribute("student",
                    "User Account Successfully Created");
        }
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/secure")
    public String secure(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "secure";
    }

    @RequestMapping("/catalog")
    public String homeCatalog(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "librarycatalog";
    }

    @RequestMapping("/admincatalog")
    public String adminCatalog(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "admincatalog";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "adminform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Product product, BindingResult result){
        if (result.hasErrors()){
            return "adminform";
        }
        productRepository.save(product);
        return "redirect:/admincatalog";
    }
    @RequestMapping("/detail/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productRepository.findById(id).get());
        return "catalogitem";
    }
    @RequestMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productRepository.findById(id).get());
        return "adminform";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        productRepository.deleteById(id);
        return "redirect:/admincatalog";
    }

    @PostMapping("/process2")
    public String searchtitle(@RequestParam("search") String searchTerm, String genre, Model model) {
        model.addAttribute("process", productRepository.findBySearchTermNative(searchTerm));
//        model.addAttribute("process", productRepository.findByGenre(genre));
        return "search";
    }
//
//    @PostMapping("/searchlibcat")
//    public String searchLibraryCatalog(String category, Model model){
//        model.addAttribute("products",productRepository.findAllByCategory(category));
//
//        return "/";
//    }

}



