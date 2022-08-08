package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
   // @Query("FROM Dog d WHERE d.name LIKE %:name%")
   // List<Dog> getDogName(String name);
}

