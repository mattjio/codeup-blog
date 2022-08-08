package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Long> {
    //@Query("FROM Toy t WHERE t.name LIKE %:name%")
    //List<Toy> getToyName(String name);
}
