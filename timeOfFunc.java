//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0 || n == 0) {
            return new int[] {};
        }

        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        int curr = 0;

        for(int i = 0; i < logs.size(); i++) {
           String log = logs.get(i);
           String[] splitlog = log.split(":");
           curr =  Integer.parseInt(splitlog[2]);
           if(splitlog[1].equals("start")) {
               if(!st.isEmpty()) {
                   result[st.peek()]+= curr - prev;
               }
               prev = curr;
               st.push(Integer.parseInt(splitlog[0]));
           }
           else {
               int polled = st.pop();
               result[polled]+= curr - prev + 1;
               prev = curr + 1;
           }
        }
        return result;
    }
}