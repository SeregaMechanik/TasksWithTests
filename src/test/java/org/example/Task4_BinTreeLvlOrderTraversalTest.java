package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task4_BinTreeLvlOrderTraversalTest {

    private static Stream<Arguments> provideDataForTest() {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> level2 = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> level3 = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        List<List<Integer>> expected2 = new ArrayList<>();
        List<Integer> level1_2 = new ArrayList<>(Arrays.asList(1));
        List<Integer> level2_2 = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> level3_2 = new ArrayList<>(Arrays.asList(4, 5, 7));
        expected2.add(level1_2);
        expected2.add(level2_2);
        expected2.add(level3_2);

        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(7)));

        return Stream.of(Arguments.of(root, expected), Arguments.of(root2, expected2));
    }

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    public void lvlOrderTraversalRecurse(TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> actual = Task4_BinTreeLvlOrderTraversal.levelOrder(root);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    public void lvlOrderTraversalIter(TreeNode root, List<List<Integer>> expected) {
        List<List<Integer>> actual = Task4_BinTreeLvlOrderTraversal.levelOrderIter(root);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}