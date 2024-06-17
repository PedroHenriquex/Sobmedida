package com.sistemaGestao.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemaGestao.demo.model.Roupa;

// import java.util.Optional;
// import java.util.List;


@Repository
public interface RoupaRepository extends JpaRepository<Roupa, Long> {
    // Optional<Roupa> findBymarca(String marca);
}