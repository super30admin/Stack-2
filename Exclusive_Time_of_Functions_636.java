//Time Complexity : O(logs.size())
//Space Complexity : O(n) // n : Number of functions
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Exclusive_Time_of_Functions_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0)
            return new int[0];
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs)
        {
            String[] strLogs = log.split(":");
            int curr = Integer.parseInt(strLogs[2]);
            if(strLogs[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(strLogs[0]));
            }
            else
            {
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
    	int n = 2;
    	List<String> list = new ArrayList<>();
    	list.add("0:start:0");
    	list.add("0:start:2");
    	list.add("0:end:5");
    	list.add("1:start:6");
    	list.add("1:end:6");
    	list.add("0:end:7");
    	
    	Exclusive_Time_of_Functions_636 logs = new Exclusive_Time_of_Functions_636();
    	int[] result = new int[n];
    	result = logs.exclusiveTime(n,list);
    	for(int i : result)
    		System.out.print(i + " ");
    }
}
