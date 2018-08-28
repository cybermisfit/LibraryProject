//package com.example.springbootsecurity;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... strings) throws Exception{
//        System.out.println("Loading data...");
//
//        roleRepository.save(new Role("STUDENT"));
//        roleRepository.save(new Role("ADMIN"));
////        roleRepository.save(new Role("LIBRARIAN"));
//
//        Role adminRole = roleRepository.findByRole("ADMIN");
//        Role studentRole = roleRepository.findByRole("STUDENT");
////        Role librarianRole = roleRepository.findByRole("LIBRARIAN");
//
//        Student user = new Student("bob@bob.com", "password", "Bob", "Bobberson", true, "bob");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(studentRole));
//        studentRepository.save(user);
//
//        user = new Student("jim@jim.com", "password", "Jim", "Jimmerson", true, "jim");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(studentRole));
//        studentRepository.save(user);
//
//        user = new Student("admin@admin.com", "password", "Admin", "User", true, "admin");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(adminRole));
//        studentRepository.save(user);
//
//        user = new Student("sam@everyman.com","password","Sam","Everyman",true,"sam");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(studentRole, adminRole));
//        studentRepository.save(user);
//
//        user = new Student("sue@everylady.com","password","Sue","Johnson",true,"sue");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Arrays.asList(studentRole));
//        studentRepository.save(user);
//    }
//}