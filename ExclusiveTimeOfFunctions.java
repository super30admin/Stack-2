import java.util.List;
import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class ExclusiveTimeOfFunctions {

    class Solution {
        // class to store relevant log details for processing
        class LogLine{
            int id, time;
            boolean isStart;

            public LogLine(String[] logParts){
                this.id = Integer.parseInt(logParts[0]);
                this.isStart = logParts[1].equals("start");
                this.time = Integer.parseInt(logParts[2]);
            }
        }

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] totalTime = new int[n];//array to contain result

            Stack<LogLine> st = new Stack<>();//stack to store start details
            int prevTime = 0;// to keep track of end time that has been popped from stack

            for (String log:logs){
                LogLine l = new LogLine(log.split(":"));//split strings in the list by :
                //if is a start condition and stack is not empty then total time for an id is the current - prev time
                // added to the the total time for that given id
                // when it is an end condition, then update total time by current time - previous time + 1(to account
                //for start of next log time) and then add value to the given id in the total time array
                if(l.isStart){
                    if(!st.isEmpty()){
                        LogLine prevLine = st.peek();
                        totalTime[prevLine.id] += l.time - prevTime;
                    }
                    prevTime = l.time;//update previous time
                    st.push(l);//push value to stack
                }else{
                    totalTime[l.id] += l.time - prevTime + 1;
                    prevTime = l.time + 1;//update previous time
                    st.pop();// pop stack
                }
            }
            return totalTime;
        }
    }

}
