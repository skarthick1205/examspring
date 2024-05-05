package karthick.loginspringweb.service;
import jakarta.mail.MessagingException;

import karthick.loginspringweb.model.AdminModel;
import karthick.loginspringweb.model.UsersModel;
import karthick.loginspringweb.repository.UsersRepository;

import org.springframework.stereotype.Service;

@Service

public class UsersService {
    private final UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }
    public UsersModel registerUser(String username ,String password,String emailid)
    {
        if(username==null || password==null){
            return null;
        }
        else
        {
            if(usersRepository.findFirstByUsername(username).isPresent()&&usersRepository.findFirstByEmailid(emailid).isPresent()){
                System.out.println("Duplicated users not allowed");
                return null;
            }
            UsersModel usersModel=new UsersModel();

            usersModel.setUsername(username);
            usersModel.setPassword(password);
            usersModel.setEmailid(emailid);

            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String username ,String password)
    {
        return usersRepository.findByUsernameAndPassword(username,password).orElse(null);
    }
    public UsersModel get(Integer id) {
        return usersRepository.findById(id).get();
    }


    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }
}
