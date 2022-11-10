package com.example;

import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    private Feline feline;

    @Test
    public void getPlaceOfLivingTrue() throws Exception {
        Alex alex = new Alex(feline);
        String truePlaceOfLiving = "Нью-Йоркский зоопарк";

        assertEquals("Ошибка теста мяу", truePlaceOfLiving, alex.getPlaceOfLiving());
    }

    @Test
    public void getFriends() throws Exception {
        Alex alex = new Alex(feline);
        List<String> friendList = Arrays.asList("Марти", "Глория", "Мелман");

        assertEquals("Ошибка теста мяу", friendList, alex.getFriends());
    }

}