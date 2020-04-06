package com.ae.exercise307;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person();
        person.setName("Johnny Appleseed");
        person.setAddress("123 Honeycrisp Avenue, New York, NY 45678");
        person.setDob("August 18, 1838");
        Passport passport = new Passport();

        passport.setExpDate("July 4, 1867");
        passport.setIssueDate("July 4, 1877");
        passport.setPassportNum(1234567890);
        person.setPassport(passport);
        personRepository.save(person);

        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }
}
