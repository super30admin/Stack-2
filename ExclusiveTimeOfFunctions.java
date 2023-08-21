import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    //Time complexity: O(N)
    //Space Complexity: O(N)
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<String> stack = new Stack<>();

        int[] arr = new int[n];
        int prev = 0;

        for(int i =0; i< logs.size(); i++){
            String[] s = logs.get(i).split(":");
            if(s[1].equals("start")){
                if(!stack.isEmpty()){
                    arr[Integer.parseInt(stack.peek())]+= Integer.parseInt(s[2])- prev-1;
                }
                stack.push(s[0]);
                prev = Integer.parseInt(s[2]);
            }else{
                arr[Integer.parseInt(stack.peek())]+= Integer.parseInt(s[2])-prev+1;
                stack.pop();
                prev = Integer.parseInt(s[2]);
            }
        }

        return arr;

    }
}
