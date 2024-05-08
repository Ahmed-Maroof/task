package com.ofa.ustask.repository;

import com.ofa.ustask.model.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}
