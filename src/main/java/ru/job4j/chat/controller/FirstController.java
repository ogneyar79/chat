package ru.job4j.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.chat.services.IPersonService;

import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/", "index"})
public class FirstController {

    private final IPersonService serviceP;
    private static Logger log = Logger.getLogger(FirstController.class.getName());

    @RequestMapping(value = "/index")
    public String index() {
        log.info("GetMap index method 23");
        return "index";
    }

    @RequestMapping(value = {"/enterRoom1"}, method = RequestMethod.GET)
    public String enterRoom1() {
        log.info("Get Room1 29");
        return "room1";
    }

    @RequestMapping(value = {"/enterRoom2"}, method = RequestMethod.GET)
    public String enterRoom2() {
        log.info("Get Room2 35");
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
