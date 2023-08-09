import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;
public class ExclusiveTimeOfFunctionsStack {

        // Stack of Functions - Execution Time pointers - Time O(n) and Space O(n)

        public int[] exclusiveTime(int n, List<String> logs) {

            // null case
            if(logs == null)      return null;

            // stack of function IDs under process
            Stack<Integer> stkID = new Stack<>();    // O(n)

            int[] exclusiveTime = new int[n];

            // pointers for execution time calculation
            int curr;    int prev = 0;

            // iterate over each log in logs
            for(String log: logs) {                   // O(n)

                // split log message into string array
                String[] msg = log.split(":");

                // current time
                curr = Integer.parseInt(msg[2]);

                // for start
                if(msg[1].equals("start")) {

                    // if stack has any function ID, add recent execution time of top (last in)call in stack to corresponding function ID in exclusive time array
                    if(!stkID.isEmpty()) {

                        exclusiveTime[stkID.peek()] += (curr - prev);
                    }

                    // push start function ID into stack
                    stkID.push(Integer.parseInt(msg[0]));

                    // update previous pointer for further executions
                    prev = curr;
                }

                // for end
                else {

                    // end is at the end of timestamp, so increment by 1 to include the ending timestamp
                    curr = curr + 1;

                    // pop out call function ID from stack which has just ended and update its exclusive time by adding recent execution time
                    exclusiveTime[stkID.pop()] += (curr - prev);

                    // update previous pointer for further executions
                    prev = curr;
                }
            }

            // output exclusive time array
            return exclusiveTime;
        }

        public static void main(String[] args) {

            ExclusiveTimeOfFunctionsStack obj = new ExclusiveTimeOfFunctionsStack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of functions: ");
            int n = scanner.nextInt();

            System.out.println("Number of logs: ");
            int l = scanner.nextInt();
            scanner.nextLine();

            List<String> logs = new LinkedList<>();
            System.out.println("logs: ");

            for (int i = 0; i < l; i++) {

                String log = scanner.nextLine();
                logs.add(log);
            }

            int[] result = obj.exclusiveTime(n, logs);

            System.out.println("Exclusive time array:");
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }

        }


}

/*
TIME COMPLEXITY = O(n)

iteration over logs - O(n)

SPACE COMPLEXITY = O(n)

stack space - O(n)
*/

