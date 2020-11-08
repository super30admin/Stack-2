import java.util.*;

/*
TC: O(N) - length of log
SC: O(N/2) - stack can have max of N/2 as every start has end. 

1. Create a stack a keep pushing the function id when it starts.
2. Store the start of previous function as prev.
3. When a new function starts, mark the duration currently running to cur - previous.
4. When the function ends, pop the function id out of stack. 
5. Duration would be cur - prev - 1 as 


*/

public class TimeOfFunctions {

	    public int[] exclusiveTime(int n, List<String> logs) {

            if(n == 0 || logs == null || logs.size() == 0){
                return new int[0];
            }

            int prev = 0, cur = 0;
            Stack<Integer> stk = new Stack<>();
            int[] res = new int[n];

            for(String str : logs){

                String[] arr = str.split(":");
                cur = Integer.parseInt(arr[2]);

                if(arr[1].equals("start")){
                    if(!stk.isEmpty()){
                        res[stk.peek()] += cur - prev;
                    }
                    stk.push(Integer.parseInt(arr[0]));
                    prev = cur;
                }else{
                    res[stk.peek()] += cur - prev + 1;
                    prev = cur + 1;
                    stk.pop();
                }
            }
            return res;
        }

        public static void main(String[] args){
            List<String> logs = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
            TimeOfFunctions func = new TimeOfFunctions();
            int[] res = func.exclusiveTime(1, logs);
            for(int num : res)
                System.out.println(num);
        }
}