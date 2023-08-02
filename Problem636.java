import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// TC=O(N)
// SC=O(N)
public class Problem636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();

        int prev = 0;
        int current = 0;
        int[] result = new int[n];

        for(String s : logs) {
            String[] parts = s.split(":");
            current = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] +=  current - prev;
                    prev = current;
                }
                stack.push(Integer.parseInt(parts[0]));
            } else {
                result[stack.pop()] += (current+1) - prev;
                prev = current + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem636 problem=new Problem636();
        ArrayList<String> list=new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
        System.out.println(Arrays.toString(problem.exclusiveTime(2,list)));
    }
}
