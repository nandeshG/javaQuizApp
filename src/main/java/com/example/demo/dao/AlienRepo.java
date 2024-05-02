package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Alien;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
