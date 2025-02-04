package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class Task3_ExclusiveTimeTest {

    @Test
    public void exclusiveFunctionsTime() {
        ArrayList<String> list = new ArrayList<String>() { };
        list.add("0:start:0");
        list.add("1:start:5");
        list.add("2:start:8");
        list.add("3:start:12");
        list.add("4:start:15");
        list.add("5:start:19");
        list.add("5:end:22");
        list.add("4:end:24");
        list.add("3:end:27");
        list.add("2:end:32");
        list.add("1:end:35");
        list.add("0:end:36");
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 6);
        Assertions.assertArrayEquals(new int[]{6, 6, 9, 6, 6, 3}, result);
    }

    @Test
    public void exclusiveFunctionsTime_OneFunction() {
        ArrayList<String> list = new ArrayList<String>() { };
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("0:start:6");
        list.add("0:end:6");
        list.add("0:end:7");
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 1);
        Assertions.assertArrayEquals(new int[]{7}, result);
    }

    @Test
    public void exclusiveFunctionsTime_ZeroTime() {
        ArrayList<String> list = new ArrayList<String>() { };
        list.add("0:start:0");
        list.add("0:end:0");
        list.add("1:start:1");
        list.add("1:end:1");
        list.add("2:start:2");
        list.add("2:end:2");
        list.add("2:start:3");
        list.add("2:end:3");
        int[] result = Task3_ExclusiveTime.exclusiveFunctionsTime(list, 3);
        Assertions.assertArrayEquals(new int[]{0, 0, 0}, result);
    }

}