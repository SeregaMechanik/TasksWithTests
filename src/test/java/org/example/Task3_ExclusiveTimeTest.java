package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class Task3_ExclusiveTimeTest {

    @Test
    public void exclusiveFunctionsTime() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "0:start:0","1:start:5","2:start:8","3:start:12","4:start:15","5:start:19",
                "5:end:22", "4:end:24","3:end:27","2:end:32","1:end:35","0:end:36"));
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 6);
        Assertions.assertArrayEquals(new int[]{6, 6, 9, 6, 6, 3}, result);
    }

    @Test
    public void exclusiveFunctionsTime_OneFunction() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 1);
        Assertions.assertArrayEquals(new int[]{7}, result);
    }

    @Test
    public void exclusiveFunctionsTime_ZeroTime() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"));
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 3);
        Assertions.assertArrayEquals(new int[]{0, 0, 0}, result);
    }

    private static Stream<Arguments> provideDataForTest() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "0:start:0","1:start:5","2:start:8","3:start:12","4:start:15","5:start:19",
                "5:end:22", "4:end:24","3:end:27","2:end:32","1:end:35","0:end:36"));
        int[] expected = new int[]{6, 6, 9, 6, 6, 3};
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(
                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
        int[] expected2 = new int[]{7};
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(
                "0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"));
        int[] expected3 = new int[]{0, 0, 0};
        return Stream.of(
                Arguments.of(list, 6, expected),
                Arguments.of(list2, 1, expected2),
                Arguments.of(list3, 3, expected3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    public void universalExclusiveFunctionsTime(ArrayList<String> testData, int funcCount, int[] expectedResult) {
        int[] actualResult = Task3_ExclusiveTime.exclusiveFunctionsTime(testData, funcCount);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }
}