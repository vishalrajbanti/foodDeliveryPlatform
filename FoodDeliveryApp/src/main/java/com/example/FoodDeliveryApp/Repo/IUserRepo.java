package com.example.FoodDeliveryApp.Repo;

import com.example.FoodDeliveryApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByEmail(String newEmail);
}
