package com.example.FoodDeliveryApp.Service;

import com.example.FoodDeliveryApp.Model.FoodItem;
import com.example.FoodDeliveryApp.Repo.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {
    @Autowired
    IFoodItemRepo iFoodItemRepo;

    public String createFoodItem(FoodItem foodItem) {
        iFoodItemRepo.save(foodItem);
        return "foodItem created or added";
    }

    public String updateFoodItem(Long itemId, FoodItem foodItem) {
       FoodItem foodItem1 = iFoodItemRepo.findById(itemId).orElseThrow();
        foodItem1.setPrice(foodItem.getPrice());
        iFoodItemRepo.save(foodItem1);
        return "foodItem updated";
    }

    public String deleteFoodItem(Long itemId) {
        iFoodItemRepo.deleteById(itemId);
        return "foodItem deleted";
    }
}
