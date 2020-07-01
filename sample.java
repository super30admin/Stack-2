
import java.util.*;

class Sample {

    // Time Complexity : O(N) N is size of string
    // Space Complexity : O(N) N is size of string
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Yes


    /**
     * Approach:
     * 1. Add respective closing bracket into stack for every opening bracekt.
     * 2. for every closing bracket compare it with top element of stack, if it is not same it is not valid string
     * */

    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0)
            return true;
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        
        for(int c=0; c<s.length(); c++) {
            
            if(map.containsKey(s.charAt(c))) {
                
                if(stack.isEmpty())
                    return false;
                
                char topElement = stack.pop();
                if(map.get(s.charAt(c)) != topElement){
                    return false;
                }
                
            }
            else {
                stack.push(s.charAt(c));
            }
        }
        
        return stack.isEmpty();
        
    }

    // Time Complexity : O(M) M is number of logs
    // Space Complexity : O(N) given n
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Yes


    /**
     * Approach:
     * 1. Add log number to the stack when it is marked with the start. Maintain prev pointer marking the start 
     * of the previous log if any. Add the difference between current value and previous as the time elapsed
     * for the previous log.
     * 2. At the end of each log, pop the topmost element from the start and add the difference between current 
     * value and previous as the time elapsed for the previous log.
     * */

    public int[] exclusiveTime(int n, List<String> logs) {
        
        if(logs == null || logs.size() == 0)
            return new int[0];
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String s: logs) {
            String[] strArr = s.split(":");
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(strArr[0]));
                prev = curr;
                
            }
            else {
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        
        return result;
    }
    
}
