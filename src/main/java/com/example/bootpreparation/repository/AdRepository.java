package com.example.bootpreparation.repository;

import com.example.bootpreparation.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Advertisement, Long> {
}
