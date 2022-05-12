package com.lti.homeloanproductdescription.repository;

import com.lti.homeloanproductdescription.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    Home findByHomeName(String homeName);

    Home findByHomeNameIgnoreCase(String homeName);


}
