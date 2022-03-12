package com.example.BurgerApp.Data;

import com.example.BurgerApp.Order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long>   {
}
