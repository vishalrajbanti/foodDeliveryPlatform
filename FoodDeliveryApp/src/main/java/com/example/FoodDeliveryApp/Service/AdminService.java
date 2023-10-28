package com.example.FoodDeliveryApp.Service;

import com.example.FoodDeliveryApp.Model.Admin;
import com.example.FoodDeliveryApp.Model.FoodItem;
import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Repo.IAdminRepo;
import com.example.FoodDeliveryApp.Repo.IFoodItemRepo;
import com.example.FoodDeliveryApp.Repo.IOderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;

    @Autowired
    IFoodItemRepo iFoodItemRepo;

    @Autowired
    IOderRepo iOderRepo;
    @Autowired
    OrderService orderService;
   @Autowired
   FoodItemService foodItemService;
    public String addAdmin(Admin admin) {
        iAdminRepo.save(admin);
        return "admin added";
    }

    public String addFoodItem(FoodItem foodItem) {
        return foodItemService.createFoodItem(foodItem);
    }

    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    public String updateFoodItem(Long itemId, FoodItem foodItem) {
        return foodItemService.updateFoodItem(itemId,foodItem);
    }

    public String deleteFoodItem(Long itemId) {
        return foodItemService.deleteFoodItem(itemId);
    }
}
