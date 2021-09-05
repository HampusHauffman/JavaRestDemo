package com.example.demo.repo;

import com.example.demo.Ad;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepo extends JpaRepository<Ad,Long> {

  public List<Ad> findAdsByCategoryContainingAndCreationDateBetween(String category,LocalDate startAge, LocalDate endAge);

  public List<Ad> findAdsByCategoryContaining(String category);

}
