package com.springframework.sfspetclinic;

import com.springframework.sfspetclinic.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ModelPersonTest {

    Person person;

    @BeforeEach
    public void setUp(){
        person = new Person();
    }

    @Test
    public void getId(){
        final Long idValue = 4L;

        person.setId(idValue);

        assertEquals(idValue, person.getId());
    }
}
