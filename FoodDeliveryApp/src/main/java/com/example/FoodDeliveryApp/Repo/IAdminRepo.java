package com.example.FoodDeliveryApp.Repo;

import com.example.FoodDeliveryApp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
