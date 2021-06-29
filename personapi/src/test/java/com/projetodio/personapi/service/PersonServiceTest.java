package com.projetodio.personapi.service;


import com.projetodio.personapi.dto.request.PersonDTO;
import com.projetodio.personapi.dto.response.MessageResponseDTO;
import com.projetodio.personapi.entity.Person;
import com.projetodio.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.projetodio.personapi.Utils.PersonUtils.createFakeDTO;
import static com.projetodio.personapi.Utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    PersonDTO personDTO = createFakeDTO();
    Person expectedSavedPerson = createFakeEntity();
    @Test
    void TestGivenPersonDtoThenReturnSavedMessage() {


        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + expectedSavedPerson.getId())
                .build();
    }
}
