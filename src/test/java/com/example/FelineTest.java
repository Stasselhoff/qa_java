package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittens() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);

        expected = 10;
        actual = feline.getKittens(10);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException ee = ExpectedException.none();

    @Test
    public void getFood() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = feline.getFood("Травоядное");
        assertEquals(expected, actual);

        expected = List.of("Животные", "Птицы", "Рыба");
        actual = feline.getFood("Хищник");
        assertEquals(expected, actual);

        ee.expect(Exception.class);
        ee.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        feline.getFood("Не хищник");
    }
}
