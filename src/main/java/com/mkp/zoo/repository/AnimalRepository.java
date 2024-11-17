package com.mkp.zoo.repository;

import com.mkp.zoo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
