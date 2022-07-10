/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {

        int output[] = new int[n];
        int current = 0;
        int previous = 0;

        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String input[] = log.split(":");

            int currentProcess = Integer.parseInt(input[0]);
            current = Integer.parseInt(input[2]);

            String status = input[1];

            if (status.equals("start")) {
                if (!stack.isEmpty()) {
                    int previousProcess = stack.peek();
                    output[previousProcess] += current - previous;

                }
                stack.push(currentProcess);
                previous = current;
            } else {
                int endedProcess = stack.pop();
                output[endedProcess] += (current - previous) + 1;
                previous = current + 1;
            }

        }

        return output;

    }
}
