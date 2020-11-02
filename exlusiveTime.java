import java.util.*;

public class exlusiveTime {

	public int[] exlcusiveTimes(int n, List<String> logs) {
		
		Stack<int[]> st = new Stack<>();
		int[] res = new int[n];
		
		for(String log: logs) {
			// split the string such that we can access each values from the String
			String[] details = log.split(":");
			int funcid = Integer.parseInt(details[0]);
			String status = details[1];
			int time = Integer.parseInt(details[2]);
			
			// if the status fo the function id is start, we will push the function Id and time on the stack so that we can
			// update the time for that function and keep on adding values to particular functions
			if(status.contentEquals("start")) {
				st.push(new int[] {funcid, time});
			}
			else{
				
				// calculate the time when the status of the function is end, since the time on stack has start time a
				// current time gives us the end time, we can find the time execution of function
				int val = time - st.pop()[1] + 1;
				//since we know that the function Id represents the index of the result , we can just keep on adding our result 
				// to that function id index
				res[funcid] += val;
				// if the st is not empty, we need to update our previous function with the decreasing the time spend for current function,
				// so we will subtract our previous function with the current time
				if(!st.isEmpty()) {
					res[st.peek()[0]] -= val;
				}
				
				}
			}
		return res;
	}
}
