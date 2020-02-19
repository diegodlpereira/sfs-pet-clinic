package com.springframework.sfspetclinic.controller;

import com.springframework.sfspetclinic.services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    public void listOwners() {

        String listOwnersResult = ownersController.listOwners(model);

        assertEquals("owners/index", listOwnersResult);
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), anySet());
    }
}