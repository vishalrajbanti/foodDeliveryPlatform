package com.example.FoodDeliveryApp.Controller;

import com.example.FoodDeliveryApp.Model.Admin;
import com.example.FoodDeliveryApp.Model.FoodItem;
import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Service.AdminService;
import com.example.FoodDeliveryApp.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
   @Autowired
    FoodItemService foodItemService;
    @PostMapping("admin")
    public String addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }
    @PostMapping("foodItem")
    public String addFoodItem(@RequestBody FoodItem foodItem){
        return adminService.addFoodItem(foodItem);
    }
    @GetMapping("order")
    public List<Order> getAllOrders(){
        return adminService.getAllOrders();
    }

    @PutMapping("foodItem/{itemId}")
    public String updateFoodItem(@PathVariable Long itemId,@RequestBody FoodItem foodItem){
        return adminService.updateFoodItem(itemId,foodItem);
    }
    @DeleteMapping("foodItem/{itemId}")
    public String deleteFoodItem(@PathVariable Long itemId){
        return adminService.deleteFoodItem(itemId);
    }
}
