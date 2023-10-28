package com.example.FoodDeliveryApp.Repo;

import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOderRepo extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
