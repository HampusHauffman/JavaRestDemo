package com.example.demo.controller;

import com.example.demo.Ad;
import com.example.demo.User;
import com.example.demo.repo.AdRepo;
import com.example.demo.repo.UserRepo;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdController {

  @Autowired
  AdRepo adRepo;

  @Autowired
  UserRepo userRepo;

  @GetMapping("/users")
  public List<User> getUsers() {
    return userRepo.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable long id) {
    return userRepo.getById(id);
  }

  @GetMapping("/ads")
  public List<Ad> getAds() {
    return adRepo.findAll();
  }

  @GetMapping("/ads/{id}")
  public Ad getAd(@PathVariable long id) {
    return adRepo.getById(id);
  }

  @GetMapping("/ads/{categories}/{startDate}/{endDate}")
  public List<Ad> getAdsWithDateAndCategory(
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
      @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
      @PathVariable String categories
  ) {
    return adRepo.findAdsByCategoryContainingAndCreationDateBetween(categories,startDate,endDate);
  }

  @GetMapping("/ads/category/{categories}")
  public List<Ad> getAdsWithCategory(
      @PathVariable String categories
  ) {
    return adRepo.findAdsByCategoryContaining(categories);
  }

  @PostMapping("/ads") //Update an ad by including the ID
  public Ad postAds(
      @RequestParam(value = "title") String title,
      @RequestParam(value = "description") String desc,
      @RequestParam(value = "category") String cat,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "email") String email,
      @RequestParam(value = "id") Optional<Long> id
  ) {

    var user = User.builder()
        .name(name)
        .email(email)
        .build();

    var dbUser = userRepo.findByNameAndEmail(name,email);


    var ad = Ad.builder()
        .title(title)
        .category(cat)
        .creationDate(LocalDate.now())
        .description(desc)
        .user(dbUser.isEmpty() ? userRepo.save(user).getId() : dbUser.get(0).getId()) //Sets Id to a new id or the one from db if exists
        .build();

    id.ifPresent(ad::setId); //Sets the id if present

    return adRepo.save(ad);
  }

}
