package karthick.loginspringweb.service;

import karthick.loginspringweb.model.ApplyModel;
import karthick.loginspringweb.model.UsersModel;
import karthick.loginspringweb.repository.ApplyRepository;

import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final ApplyRepository applyRepository;
    public ApplyService(ApplyRepository applyRepository)
    {
        this.applyRepository=applyRepository;
    }
    public ApplyModel applyUser(String name , String dob ,String gender,String address,String examcode,String centre,String language)
    {
        if(name==null || dob==null||address==null||examcode==null||centre==null||language==null){
            return null;
        }
        else
        {
            if(applyRepository.findFirstByname(name).isPresent()&&applyRepository.findFirstBydob(dob).isPresent()){
                System.out.println("Duplicated application not allowed");
                return null;
            }

            ApplyModel applyModel = new ApplyModel(); // Create an instance of ApplyModel
            applyModel.setName(name);
            applyModel.setDob(dob);
            applyModel.setGender(gender);
            applyModel.setAddress(address);
            applyModel.setExamcode(examcode);
            applyModel.setCentre(centre);
            applyModel.setLanguage(language);
            return applyRepository.save(applyModel);
        }
    }
}
