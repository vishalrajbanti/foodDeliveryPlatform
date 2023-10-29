package com.example.FoodDeliveryApp.Controller;

import com.example.FoodDeliveryApp.Model.Dto.AuthenticationInputDto;
import com.example.FoodDeliveryApp.Model.Dto.CombinedAuthOrderDto;
import com.example.FoodDeliveryApp.Model.Dto.SignInInputDto;
import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Model.User;
import com.example.FoodDeliveryApp.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user/signUp")
    public String userSignUp(@Valid @RequestBody User user) {
        return userService.userSignUp(user);
    }

    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }


    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return userService.userSignOut(authInfo);
    }
   @PostMapping("placeOrder")
    public String placeOrder(@RequestBody CombinedAuthOrderDto combinedAuthOrderDto){
       Order order = combinedAuthOrderDto.getOrder();
       AuthenticationInputDto authInfo = combinedAuthOrderDto.getAuthInfo();
        return userService.placeOrder(authInfo,order);
   }

   @GetMapping("order/user/id/{id}")
    public List<Order> getUserOrders(@PathVariable Long id,@RequestBody AuthenticationInputDto authInfo){
        return userService.getUserOrders(id,authInfo);
   }
  @DeleteMapping("order/id/{id}")
    public String deleteOrderById(@PathVariable Long id,@RequestBody AuthenticationInputDto authInfo){
        return userService.deleteByOrderId(id,authInfo);
  }
}