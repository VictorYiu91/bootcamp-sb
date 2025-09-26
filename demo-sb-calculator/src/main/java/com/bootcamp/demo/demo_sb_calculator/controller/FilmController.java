package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_calculator.model.Database;
import com.bootcamp.demo.demo_sb_calculator.model.ShoppingMall.Cinema.Film;

@RestController
public class FilmController {
  @PostMapping("/film")
  public Film createFilm(@RequestBody Film film) {
    if (film != null) {
      if (!Database.filmDatabase.add(film)) {
        return null;
      }
    }
    return null;
  }

  @GetMapping("/film/{name}")
  public Film getFilm(@PathVariable String name) {
    if (name == null)
      return null;
    for (Film film : Database.filmDatabase) {
      if (name.equals(film.getName())) {
        return film;
      }
    }
    return null;
  }

  @GetMapping("/films")
  public List<Film> getAllFilms() {
    return Database.filmDatabase;
  }

  @DeleteMapping("/film/{name}")
  public Film deleteFilm(@PathVariable String name) {
    if (name == null)
      return null;
    int idx = 0;
    for (Film film : Database.filmDatabase) {
      if (name.equals(film.getName())) {
        break;
      }
      idx++;
    }
    return Database.filmDatabase.remove(idx);
  }


  @GetMapping("/getfilm/{name}")
  public List<Film> getFilmList(@PathVariable String name) {
    if (name == null)
      return Database.filmDatabase;
    List<Film> copy = List.copyOf(Database.filmDatabase);
    return copy.stream().filter(e -> e.getName().contains(name))
        .collect(Collectors.toList());
  }

  // Update: put and patch
  // ! PUT 
}
