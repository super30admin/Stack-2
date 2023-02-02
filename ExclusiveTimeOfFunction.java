import java.util.List;
import java.util.Stack;

// Time O(N)
//Space O(N)

public class ExclusiveTimeOfFunction {
	 public int[] exclusiveTime(int n, List<String> logs) {

         int[] res = new int[n];
         Stack<Integer> stack = new Stack<>();

         String[] process = logs.get(0).split(":");
         int fnId = Integer.valueOf(process[0]);
         int prev = Integer.valueOf(process[2]);
         stack.push(fnId);
         for(int i=1;i<logs.size();i++){
             process = logs.get(i).split(":");
             fnId = Integer.valueOf(process[0]);
             int curr = Integer.valueOf(process[2]);
             if(process[1].equals("start")){
                 if(!stack.isEmpty())
                   res[stack.peek()] +=curr - prev; 
               prev = curr;
               stack.push(fnId);
             }else{
                 res[stack.pop()] += curr-prev+1;
                 prev = curr+1;
             }

         }

   return res;

}
}
