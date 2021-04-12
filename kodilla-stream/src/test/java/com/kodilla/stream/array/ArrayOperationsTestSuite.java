package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    void ArrayOperationsTestSuite (){
        //Given
        int[] numbers = new int[20];
        numbers[0] = 3;
        numbers[1] = 4;
        numbers[2] = 6;
        numbers[3] = 5;
        numbers[4] = 2;
        numbers[5] = 7;
        numbers[6] = 8;
        numbers[7] = 9;
        numbers[8] = 5;
        numbers[9] = 4;
        numbers[10] = 1;
        numbers[11] = 4;
        numbers[12] = 6;
        numbers[13] = 4;
        numbers[14] = 3;
        numbers[15] = 5;
        numbers[16] = 2;
        numbers[17] = 1;
        numbers[18] = 1;
        numbers[19] = 1;
        //When
        double expected = ArrayOperations.getAverage(numbers);
        //Then
        Assertions.assertEquals(expected, 4.05);
    }
}
