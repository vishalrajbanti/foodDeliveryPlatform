package com.example.FoodDeliveryApp.Repo;

import com.example.FoodDeliveryApp.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem,Long> {
}
