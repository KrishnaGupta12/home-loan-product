package com.lti.homeloanproductdescription.controller;

import com.lti.homeloanproductdescription.entity.Home;
import com.lti.homeloanproductdescription.error.HomeNotFoundException;
import com.lti.homeloanproductdescription.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Slf4j
@RestController
public class HomeController {

        @Autowired
        private HomeService homeService;

        @PostMapping("/homes")
        public Home saveHome(@Valid @RequestBody Home home) {
            LOGGER.info("Inside saveHome of HomeController");
            return homeService.saveHome(home);
        }

        @GetMapping("/homes")
        public List<Home> fetchHomeList() {
            LOGGER.info("Inside fetchHomeList of HomeController");
            return homeService.fetchHomeList();
        }

        @GetMapping("/homes/{id}")
        public Home fetchHomeById(@PathVariable("id") Long homeId)
                throws HomeNotFoundException {
            return homeService.fetchHomeById(homeId);
        }

        @DeleteMapping("/homes/{id}")
        public String deleteHomeById(@PathVariable("id") Long homeId) {
            homeService.deleteHomeById(homeId);
            return "Home deleted Successfully!!";
        }

        @PutMapping("/homes/{id}")
        public Home updateHome(@PathVariable("id") Long homeId,
                                           @RequestBody Home home) {
            return homeService.updateHome(homeId,home);
        }

        @GetMapping("/homes/name/{name}")
        public Home fetchHomeByName(@PathVariable("name") String homeName) {
            return homeService.fetchHomeByName(homeName);
        }

}
