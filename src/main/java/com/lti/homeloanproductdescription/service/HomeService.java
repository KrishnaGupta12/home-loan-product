package com.lti.homeloanproductdescription.service;

import com.lti.homeloanproductdescription.entity.Home;
import com.lti.homeloanproductdescription.error.HomeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {
    public Home saveHome(Home home);

    public List<Home> fetchHomeList();

    public Home fetchHomeById(Long homeId) throws HomeNotFoundException;

    public void deleteHomeById(Long homeId);

    public Home updateHome(Long homeId, Home home);

    Home fetchHomeByName(String homeName);
}
