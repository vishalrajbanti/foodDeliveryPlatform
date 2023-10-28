package com.example.FoodDeliveryApp.Model.Dto;

import com.example.FoodDeliveryApp.Model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinedAuthOrderDto {
  private    AuthenticationInputDto authInfo;
  private Order order;

}
