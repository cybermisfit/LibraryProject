package com.example.springbootsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService{
    private StudentRepository studentRepository;

    public SSUserDetailsService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException{
        try{
            Student student = studentRepository.findByusername(username);
            if(student==null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(
                    student.getUsername(),
                    student.getPassword(),
                    getAuthorities(student));

        }catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }
    private Set<GrantedAuthority> getAuthorities(Student student){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role : student.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
