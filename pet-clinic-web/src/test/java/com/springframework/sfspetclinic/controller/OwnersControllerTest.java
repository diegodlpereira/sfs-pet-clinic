package com.springframework.sfspetclinic.controller;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
public class OwnersControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @InjectMocks
    OwnersController ownersController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {

        ownersController = new OwnersController(ownerService);

        mockMvc = MockMvcBuilders.standaloneSetup(ownersController).build();
    }

    @Test
    public void testMockMVC() throws Exception{

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));

        mockMvc.perform(get("/owners/index"))
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

    @Test
    public void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyZeroInteractions(ownerService);

    }
}