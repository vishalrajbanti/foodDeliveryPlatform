package com.example.FoodDeliveryApp.Service;

import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Model.User;
import com.example.FoodDeliveryApp.Repo.IOderRepo;
import com.example.FoodDeliveryApp.Repo.IUTokenRepo;
import com.example.FoodDeliveryApp.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOderRepo iOderRepo;
@Autowired
    IUserRepo iUserRepo;
    public List<Order> getAllOrders() {
       List<Order> orders = iOderRepo.findAll();
        for (Order order : orders ) {
          User user = order.getUser();
          user.setPassword(null);
        }
        return orders;
    }

    public String placeOrder(Order order) {
      iOderRepo.save(order);
        return "order placed";
    }

    public List<Order> getUserOrders(Long id) {
        User user = iUserRepo.findById(id).orElseThrow();
        user.setPassword(null);
        return iOderRepo.findByUser(user);
    }

    public String deleteOrderById(Long id) {
        iOderRepo.deleteById(id);
        return "order deleted";
    }
}
