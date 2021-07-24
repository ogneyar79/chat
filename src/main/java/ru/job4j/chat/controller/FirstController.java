package ru.job4j.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.model.User;
import ru.job4j.chat.services.IPersonService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class FirstController {

    @Autowired
    private final IPersonService serviceP;
    private static Logger log = Logger.getLogger(FirstController.class.getName());

    @RequestMapping(value = "/")
    public String index(Model model) {
        log.info("GetMap index method 23");
        User user1= new User();
        user1.setFirstName("Zlata");
        user1.setLastName("Ivanova");
        user1.setEmail( "z@mail.ru");
        user1.setPassword("12345");
        model.addAttribute("zlata", user1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        model.addAttribute("serverTime", dateString);
        User user = (User) model.getAttribute("zlata");
        log.info("GetMap ipersonzlata 35 :" + user.getFirstName());
        //   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }

    @RequestMapping(value = {"/enterRoom1"}, method = RequestMethod.GET)
    public String enterRoom1(Model model) {
        //   model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        // Data about user
        log.info("Get Room1 29");
        return "room1";
    }

    @RequestMapping(value = {"/enterRoom2"}, method = RequestMethod.GET)
    public String enterRoom2(Model model) {
        //  model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user1= new User();
        user1.setFirstName("Robert");
        user1.setLastName("Ivanov");
        user1.setEmail( "r@mail.ru");
        user1.setPassword("12345");
        model.addAttribute("user", user1);
        model.addAttribute("message", new Message());
        return "room2";
    }

//    @GetMapping("/")
//    public List<Person> findAll() {
//        return StreamSupport.stream(this.serviceP.getAll().spliterator(), false)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Person> findById(@PathVariable long id) {
//        var person = this.serviceP.getById(id);
//        return new ResponseEntity<>(person.orElse(new Person())
//                , person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//    }

}
