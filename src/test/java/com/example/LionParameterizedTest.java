package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedResult;
    @Mock
    private Feline feline;

    public LionParameterizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object [][] getCorrectHasManeValue() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("...", expectedResult, actualResult);
    }

}
