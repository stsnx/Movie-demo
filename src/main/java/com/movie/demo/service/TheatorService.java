package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.ClassRequest;
import com.movie.demo.model.TheatorEntity;
import com.movie.demo.repository.TheatorRepository;

import java.util.List;

@Service
public class TheatorService {
    
    @Autowired
    private TheatorRepository theatorRepository;
    
    public TheatorEntity addTheator(TheatorEntity theatorEntity){
        return theatorRepository.save(theatorEntity);
    }
    public List<TheatorEntity> getAllTheators(){
        return theatorRepository.findAll();
    } 
    public String changeNameTheator(Long theator_id, ClassRequest.ChangeNameRequest changeNameRequest){
        if (theatorRepository.existsById(theator_id)){
            TheatorEntity existingTheator = theatorRepository.findById(theator_id).orElse(null);
            String oldName = existingTheator.getTheator_name();
            existingTheator.setTheator_name(changeNameRequest.name);
            theatorRepository.save(existingTheator);
            return String.format("Change name from %1$s to %2$s successfully.", oldName,changeNameRequest.name);
        }
        return "Your movie dosn't exist";
    }
}
