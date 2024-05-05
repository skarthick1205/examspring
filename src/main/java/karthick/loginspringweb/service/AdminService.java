package karthick.loginspringweb.service;

import karthick.loginspringweb.model.AdminModel;
import karthick.loginspringweb.repository.AdminRepository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public List<AdminModel> listAll() {
        return repo.findAll();
    }

    public void save( AdminModel std) {
        repo.save(std);
    }

    public AdminModel get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
