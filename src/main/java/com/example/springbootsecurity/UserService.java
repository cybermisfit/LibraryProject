package com.example.springbootsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    LibrarianRepository librarianRepository;

    @Autowired
    public UserService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentusername = authentication.getName();
        Student student = studentRepository.findByusername(currentusername);
        return student;
    }

    public void saveUser(Student student){
        student.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        student.setEnabled(true);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }
    public void saveAdmin(Student student){
        student.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setEnabled(true);
        studentRepository.save(student);
    }

    public void saveLibrarian(Student student){
        student.setRoles(Arrays.asList(roleRepository.findByRole("LIBRARIAN")));
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setEnabled(true);
        studentRepository.save(student);
    }

}
