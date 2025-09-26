package com.bootcamp.demo.demo_sb_calculator.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_calculator.model.ShoppingMall;
import com.bootcamp.demo.demo_sb_calculator.model.ShoppingMall.Cinema;
import com.bootcamp.demo.demo_sb_calculator.model.ShoppingMall.Cinema.Film;

@RestController
public class ShoppingMallController {
  @GetMapping("/shoppingmall")
  public ShoppingMall getShoppingMall() {
     Film film1 = Film.builder() //
     .name("Film A") //
     .releasedDate(LocalDate.of(2022,1,1)) //
     .build();

     Film film2 = Film.builder() //
     .name("Film B") //
     .releasedDate(LocalDate.of(2022,1,2)) //
     .build();

     Cinema cinema1 = Cinema.builder() //
     .name("Cinema A") //
     .openedDate(LocalDate.of(2022,1,1)) //
     .releasedFilm(List.of(film1, film2)) //
     .build();
     
     List<String> shopCatagories = List.of("Sport","Food","Clothing");

     return ShoppingMall.builder() //
     .name("K11") //
     .area(19000) //
     .cinema(cinema1) //
     .shopCategory(shopCatagories) //
     .build();
  }
}
