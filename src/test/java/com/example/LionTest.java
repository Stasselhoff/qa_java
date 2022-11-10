package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException ee = ExpectedException.none();

    @Test
    public void doesHaveMane() throws Exception {
        Lion lionMale = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lionMale.hasMane;
        assertEquals(expected, actual);

        Lion lionFemale = new Lion("Самка", feline);
        expected = false;
        actual = lionFemale.hasMane;
        assertEquals(expected, actual);

        ee.expect(Exception.class);
        ee.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lionOther = new Lion("Test", feline);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

}
