package com.springframework.sfspetclinic.controller;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class OwnersControllerTest {

    OwnersController ownersController;

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ownersController = new OwnersController(ownerService);
    }

    @Test
    public void testMockMVC() throws Exception{

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownersController).build();

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));

    }

    @Test
    public void listOwners() throws Exception{

        //given
        Set<Owner> owners = new HashSet<>();
        owners.add(new Owner());
        owners.add(new Owner());

        when(ownerService.findAll()).thenReturn(owners);

        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String listOwnersResult = ownersController.listOwners(model);

        //then
        assertEquals("owners/index", listOwnersResult);
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());
        Set<Owner> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());
    }
}