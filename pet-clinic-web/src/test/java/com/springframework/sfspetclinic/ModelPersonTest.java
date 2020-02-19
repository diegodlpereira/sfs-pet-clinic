package com.springframework.sfspetclinic;

import com.springframework.sfspetclinic.model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModelPersonTest {

    Person person;

    @Before
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
