package com.example.FoodDeliveryApp.Repo;

import com.example.FoodDeliveryApp.Model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUTokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {
    UserAuthenticationToken findFirstByTokenValue(String tokenValue);
}
