package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittensMale() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int kittens = lion.getKittens();

        assertEquals(1, kittens);
    }

    @Test
    public void testTrueDoesHaveMane() throws Exception {
        Lion lion = new Lion("Самец", new Feline());

        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittensFemale() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        int kittens = lion.getKittens();

        assertEquals(1, kittens);
    }

    @Test
    public void testFalseDoesHaveMane() throws Exception {
        Lion lion = new Lion("Самка", new Feline());

        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testEatMeat() throws Exception {
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mealList);

        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();

        assertEquals(food, mealList);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeIsExceptionTest() throws Exception {
        Lion lion = new Lion("Нет пола", feline);
    }
}

