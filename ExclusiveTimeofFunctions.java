// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result= new int[n];
		Stack<Integer> st=new Stack<>();
		int prevTime=0;
		
		for (String log : logs) {
			String[] arr=log.split(":");
			
			int curTime= Integer.parseInt(arr[2]);
			
			if(arr[1].equals("start")) {
				if(!st.isEmpty()) {
					result[st.peek()]+=curTime-prevTime;
					prevTime=curTime;
				}
				st.push(Integer.parseInt(arr[0]));
			}else {
				result[st.pop()]+=curTime+1-prevTime;
				prevTime=curTime+1;
			}
		}
		return result;

	}
	
	public static void main(String[] args) {
		List<String> logs=new ArrayList<>();
		logs.add("0:start:0");
		logs.add("0:start:2");
		logs.add("0:end:5");
		logs.add("1:start:6");
		logs.add("1:end:6");
		logs.add("1:end:7");
		System.out.println(Arrays.toString(new ExclusiveTimeofFunctions().exclusiveTime(2, logs)));
	}
}
