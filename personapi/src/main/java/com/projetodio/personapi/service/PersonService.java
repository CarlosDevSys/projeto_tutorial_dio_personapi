package com.projetodio.personapi.service;

import com.projetodio.personapi.dto.response.MessageResponseDTO;
import com.projetodio.personapi.entity.Person;
import com.projetodio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Criada pessoa com ID:" + savedPerson.getId())
                .build();
    }
}
