/*
 * TC: O(m) where m is the number of logs
 * SC: O(m) for the stack
 */
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    record Record(int fid, int time) {}

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Record> fStack = new Stack<>();
        int[] result = new int[n];
        for(String log: logs) {
            String[] components = log.split(":");
            int fid = Integer.parseInt(components[0]);
            String state = components[1];
            int time = Integer.parseInt(components[2]);
            // if 'start', push a new Record to the stack
            if("start".equals(state)) {
                fStack.push(new Record(fid, time));
            }
            // if 'end', pop from stack
            if("end".equals(state)) {
                Record top = fStack.pop();
                // add the difference to the current fid's time
                result[top.fid()] += time - top.time() + 1;
                if(!fStack.isEmpty()) {
                    // subtract the difference from the previous fid's time
                    // because it will get added again in the next end state
                    result[fStack.peek().fid()] -= time - top.time() + 1;
                }
            }
        }
        return result;
    }
}
