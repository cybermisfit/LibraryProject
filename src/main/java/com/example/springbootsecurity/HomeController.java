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



    //////////////REGISTER & LOGIN

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

    ////////////CATALOGS AND SEARCH CATALOG


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

    @PostMapping("/process2")
    public String searchCatalog(@RequestParam("search") String searchTerm, Model model) {
        model.addAttribute("process", productRepository.findBySearchTermNative(searchTerm));
        return "search";
    }


    ///////////ADMIN ADD PRODUCT SECTION

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
        //set boolean value here, set.available as true
        product.setAvailable(true);
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



    ///////CHECKOUT

    @GetMapping("/checkout")
    public String checkoutProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("student", userService.getCurrentUser());
        return "checkout";
    }

    @PostMapping("/processout")
    public String processCheckoutForm(@Valid Product product, BindingResult result){
        if (result.hasErrors()){
            return "checkout";
        }
        //set boolean value here, set.available as false
        String username = userService.getCurrentUser().getUsername();
        product.setUsername(username);
        product.setAvailable(false);
        productRepository.save(product);
        return "redirect:/checkoutinfo";
    }

    @RequestMapping("/checkoutinfo")
    public String checkoutInfo(Model model){
        String username = userService.getCurrentUser().getUsername();
        model.addAttribute("products", productRepository.findByUsername(username));
        return "checkoutinfo";
    }





}



