package com.example.BurgerApp.Data;

import com.example.BurgerApp.Burger.Burger;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BurgerRepo extends CrudRepository<Burger, Long> {
}
