package com.ofa.ustask.repository;

import com.ofa.ustask.model.RandomNumberResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberResultRepository extends JpaRepository<RandomNumberResult, Long> {
    RandomNumberResult findFirstByOrderByIdDesc();
}
