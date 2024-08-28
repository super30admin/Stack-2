import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) { //O(2*n) T.C
        Stack<Integer> st = new Stack<>(); //O(n) S.C
        int[] result = new int[n];
        int prevTime = 0; //to store previous task's time
        for(String logString : logs) { //traverse the input logs
            String[] str = logString.split(":"); //split each log at :
            int currTask = Integer.parseInt(str[0]); //0th index is current taskId
            int currTime = Integer.parseInt(str[2]); //2nd index is either the start or end time
            String currOperation = str[1]; //1st index is the operation start or end
            if(currOperation.equals("start")) { //if the current operation is start
                if(!st.isEmpty()) { //if there is at least one earlier task already started
                    result[st.peek()] += currTime - prevTime; //add the difference between currtime and prevtime
                    //to the most recent started task
                }
                st.push(currTask); //push the current task to stack
                prevTime = currTime; //move prevtime to currtime after processing
            } else { //if current operation is end
                if(!st.isEmpty()) { //if there is at least one earlier task
                    result[st.pop()] += currTime - prevTime + 1; //pop the task as it is being ended
                    //while add this task's value with currtime - prevtime + 1 (as it is end)
                }
                prevTime = currTime + 1; //move prev to curr + 1.
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = List.of(new String[]{"0:start:0", "0:start:2", "0:end:5",
                "1:start:6", "1:end:6", "0:end:7"});

        System.out.println("The exclusive time of " + n + " functions from given logs " +
                logs + " is: " + Arrays.toString(exclusiveTime(n, logs)));
    }
}
