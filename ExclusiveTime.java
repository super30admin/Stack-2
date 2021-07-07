import java.util.*;

// Time Complexity : O(N) for Stack
// Space Complexity : O(N) for Stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
// Your code here along with comments explaining your approach
 

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size() == 0 ){
            return new int[]{};
        }
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        int prev = 0;
        for(String log : logs){
            String arr[] = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            //case1
            if("start".equals(arr[1])){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            }
            //end
            else {
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }

        }
        return result;
    }

    public static void main(String args[]){
        String time[] = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        ArrayList<Integer> logs = new ArrayList<>(Arrays.asList(time));
        int n =2;
        System.out.print(new ExclusiveTime().exclusiveTime(n, logs));


    }
}