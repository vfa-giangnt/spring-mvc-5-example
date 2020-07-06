package gau.nau.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gau.nau.springmvc.model.SignUpForm;

@Controller
public class SignUpController {

    /**
     * Create new signUpForm object for empty form
     *
     * @return
     */
    @ModelAttribute("signUpForm")
    public SignUpForm setSignUpForm() {
        return new SignUpForm();
    }

    /**
     * Method to show the initial HTML form
     *
     * @return
     */
    @GetMapping("/showSignUpForm")
    public String showForm() {
        return "signup-form";
    }

    @PostMapping("/saveSignUpForm")
    public String saveUser(@ModelAttribute("signUpForm") SignUpForm signUpForm, Model model) {

        // Implement business logic to save user details into a database
        // .....

        System.out.println("First name: " + signUpForm.getFirstName());
        System.out.println("Last name: " + signUpForm.getLastName());
        System.out.println("Username: " + signUpForm.getUsername());
        System.out.println("Password: " + signUpForm.getPassword());
        System.out.println("Email: " + signUpForm.getEmail());

        model.addAttribute("message", "User Signup Successfully");
        model.addAttribute("user", signUpForm);

        return "signup-success";
    }
}
