import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// TC: O(n) as all the strings in the list is visited
// SC: O(n) as Stack is being used to store the ids based on the start. 
// The height of the stack can be maximum of half of list size. but constants are ignored in computation.
public class ExclusiveTimeofFunctions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exclusiveTime(1, new ArrayList<>(
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))))); // [8]
        System.out.println(Arrays.toString(exclusiveTime(2, new ArrayList<>(
                Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))))); // [3,4]
        System.out.println(Arrays.toString(exclusiveTime(2, new ArrayList<>(
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"))))); // [7,1]
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0)
            return new int[] {};
        int[] resultant = new int[n];
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int prev = 0;
        for (String log : logs) {
            String[] array = log.split(":");
            curr = Integer.parseInt(array[2]);
            if (array[1].equals("start")) {
                if (!stack.isEmpty())
                    resultant[stack.peek()] += curr - prev;
                stack.push(Integer.parseInt(array[0]));
                prev = curr;
            } else {
                resultant[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return resultant;
    }
}