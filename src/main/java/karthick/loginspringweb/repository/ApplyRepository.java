package karthick.loginspringweb.repository;

import karthick.loginspringweb.model.ApplyModel;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ApplyRepository extends JpaRepository<ApplyModel, Integer> {
    Optional<ApplyModel> findFirstByname(String name);
    Optional<ApplyModel> findFirstBydob(String dob);

}
