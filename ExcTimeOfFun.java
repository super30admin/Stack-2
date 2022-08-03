// Time Complexity : O(n) to iterate over the logs
// Space Complexity : O(n) space for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class ExcTimeOfFun {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int[n];
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        for(String log : logs){
            String [] strArr = log.split(":");
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!stack.isEmpty()){
                    int prevTask = stack.peek();
                    result[prevTask] += curr-prev;
                }
                stack.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }
            //endlog
            else{
                result[stack.pop()] += curr+1-prev;
                prev = curr + 1;
            }
        }

        return result;
    }

    public static void main(String [] args){
        ExcTimeOfFun e = new ExcTimeOfFun();
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
        System.out.println(Arrays.toString(e.exclusiveTime(2, list)));
    }
}