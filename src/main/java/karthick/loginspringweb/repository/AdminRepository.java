package karthick.loginspringweb.repository;

import karthick.loginspringweb.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {


}
