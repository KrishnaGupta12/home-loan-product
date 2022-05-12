package com.lti.homeloanproductdescription.service;

import com.lti.homeloanproductdescription.entity.Home;
import com.lti.homeloanproductdescription.error.HomeNotFoundException;
import com.lti.homeloanproductdescription.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Home saveHome(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public List<Home> fetchHomeList() {
        return homeRepository.findAll();
    }

    @Override
    public Home fetchHomeById(Long homeId) throws HomeNotFoundException {
        Optional<Home> home =
                homeRepository.findById(homeId);

        if (!home.isPresent()) {
            throw new HomeNotFoundException("Home Not Available");
        }

        return home.get();
    }

    @Override
    public void deleteHomeById(Long homeId) {
        homeRepository.deleteById(homeId);
    }

    @Override
    public Home updateHome(Long homeId, Home home) {
        Home homeDB = homeRepository.findById(home.getHomeId()).get();

        if (Objects.nonNull(home.getHomeName()) &&
                !"".equalsIgnoreCase(home.getHomeName())) {
            homeDB.setHomeName(home.getHomeName());
        }

        if (Objects.nonNull(home.getHomeCode()) &&
                !"".equalsIgnoreCase(home.getHomeCode())) {
            homeDB.setHomeCode(home.getHomeCode());
        }

        if (Objects.nonNull(home.getHomeAddress()) &&
                !"".equalsIgnoreCase(home.getHomeAddress())) {
            homeDB.setHomeAddress(home.getHomeAddress());
        }

        return homeRepository.save(homeDB);
    }

    @Override
    public Home fetchHomeByName(String homeName) {
        return homeRepository.findByHomeNameIgnoreCase(homeName);
    }
}