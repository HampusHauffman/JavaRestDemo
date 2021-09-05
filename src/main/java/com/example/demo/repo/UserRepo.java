package com.example.demo.repo;

import com.example.demo.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  List<User> findByName(String name);
  List<User> findByEmail(String name);
  List<User> findByNameAndEmail(String name, String email);




}
