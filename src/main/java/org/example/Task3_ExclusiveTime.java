package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Task3_ExclusiveTime {
    public static int[] exclusiveFunctionsTime(ArrayList<String> execLog, int n)
    {
        if (n == 0 || execLog.isEmpty()) {
            return new int[]{};
        }
        int[] result = new int[n];
        int lastActionStamp = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : execLog) {
            int funcId = Integer.parseInt(s.substring(0, s.indexOf(':')));
            String actionType = s.substring(s.indexOf(':') + 1, s.lastIndexOf(':'));
            int timestamp = Integer.parseInt(s.substring(s.lastIndexOf(':') + 1));
            if (!stack.isEmpty()) {
                result[stack.peek()] += timestamp - lastActionStamp;
            }
            lastActionStamp = timestamp;
            if (actionType.equals("start")) {
                stack.push(funcId);
            } else {
                stack.pop();
            }
        }
        return result;
    }
}
