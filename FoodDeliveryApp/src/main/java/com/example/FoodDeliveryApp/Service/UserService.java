package com.example.FoodDeliveryApp.Service;

import com.example.FoodDeliveryApp.Model.Dto.AuthenticationInputDto;
import com.example.FoodDeliveryApp.Model.Dto.SignInInputDto;
import com.example.FoodDeliveryApp.Model.Order;
import com.example.FoodDeliveryApp.Model.User;
import com.example.FoodDeliveryApp.Model.UserAuthenticationToken;
import com.example.FoodDeliveryApp.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    FoodItemService foodItemService;

    @Autowired
    OrderService orderService;
    @Autowired
    UTokenService uTokenService;

    public String userSignUp(User user) {
        //check if already exist -> Not allowed : try logging in

        String newEmail = user.getEmail();

        User existingUser = iUserRepo.findFirstByEmail(newEmail);

        if (existingUser != null) {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = user.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            user.setPassword(encryptedPassword);


            // user table - save user
            iUserRepo.save(user);
            return "user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String userSignIn(SignInInputDto signInInput) {
        String email = signInInput.getEmail();

        User existingUser = iUserRepo.findFirstByEmail(email);

        if (existingUser == null) {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (existingUser.getPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                UserAuthenticationToken token = new UserAuthenticationToken(existingUser);


                uTokenService.createToken(token);
                return "token created successfully with token value  " + token.getTokenValue();


            } else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String userSignOut(AuthenticationInputDto authInfo) {
        if (uTokenService.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            uTokenService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        } else {
            return "Un Authenticated access!!!";
        }

    }

    public String  placeOrder(AuthenticationInputDto authInfo, Order order) {
        if (uTokenService.authenticate(authInfo)) {
            return orderService.placeOrder(order);
        } else {
            return "Un Authenticated access!!!";
        }
    }



    public List<Order> getUserOrders(Long id,AuthenticationInputDto authInfo) {
        if (uTokenService.authenticate(authInfo)) {
        return orderService.getUserOrders(id);
        }else {
            return null;
        }
    }

    public String deleteByOrderId(Long id,AuthenticationInputDto authInfo) {
        if (uTokenService.authenticate(authInfo)) {
        return orderService.deleteOrderById(id);
        } else {
            return "Un Authenticated access!!!";
        }
    }
}