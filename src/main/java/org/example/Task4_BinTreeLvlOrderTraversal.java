package org.example;

import java.util.*;

public class Task4_BinTreeLvlOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            result.add(new ArrayList<>());
            result.get(0).add(root.getVal());
            recurseSolution(root, result, 1);
        }
        return result;
    }

    public static void recurseSolution(TreeNode root, List<List<Integer>> result, int level) {
        if (result.size() <= level && (root.getLeft() != null || root.getRight() != null)) {
            result.add(new ArrayList<>());
        }
        if (root.getLeft() != null) {
            result.get(level).add(root.getLeft().getVal());
            recurseSolution(root.getLeft(), result, level + 1);
        }
        if (root.getRight() != null) {
            result.get(level).add(root.getRight().getVal());
            recurseSolution(root.getRight(), result, level + 1);
        }
    }

    public static List<List<Integer>> levelOrderIter(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();
            int level = 0;
            queue.add(root);
            while (!queue.isEmpty()) {
                while (queue.peek() != null) {
                    if (queue.peek().getLeft() != null) {
                        newQueue.add(queue.peek().getLeft());
                    }
                    if (queue.peek().getRight() != null) {
                        newQueue.add(queue.peek().getRight());
                    }
                    if (result.size() <= level) {
                        result.add(new ArrayList<>());
                    }
                    result.get(level).add(queue.poll().getVal());
                }
                queue.addAll(newQueue);
                newQueue.clear();
                level++;
            }
        }
        return result;
    }

    }
