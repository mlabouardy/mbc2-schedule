package com.labouardy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labouardy.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{

}
