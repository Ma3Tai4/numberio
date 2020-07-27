package com.mwg.numberio.repository;

import com.mwg.numberio.entity.IntegerNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegerNumberRepository extends JpaRepository<IntegerNumber, Long> {
}
