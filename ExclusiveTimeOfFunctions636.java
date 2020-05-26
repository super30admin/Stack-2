import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//time complexity : O(n)
//space complexity : O(n)
//leet code : yes
//steps : implemeted using monotonic stack
public class ExclusiveTimeOfFunctions636 {



    public int[] exclusiveTime(int n, List<String> logs) {

            Stack<Integer> stack = new Stack<>();
            int result[] = new int[n];

            int priorTimeStamp = 0, currentTimeStamp =0;

            for(String log : logs){
                String token[] = log.split(":");

                int functionId = Integer.parseInt(token[0]);
                currentTimeStamp = Integer.parseInt(token[2]);

                if(token[1].equals("start")){
                    if(!stack.isEmpty())
                        result[stack.peek()] += currentTimeStamp - priorTimeStamp;
                    stack.push(functionId);
                    priorTimeStamp = currentTimeStamp;    
                } else {
                    result[functionId] += currentTimeStamp - priorTimeStamp +1;
                    stack.pop();
                    priorTimeStamp = currentTimeStamp +1;
                }

            }
return result;        

    }

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();
        ls.add("0:start:0");
        ls.add("1:start:2");
        ls.add("1:end:5");
        ls.add("0:end:6");
        for(int i : new ExclusiveTimeOfFunctions636().exclusiveTime(2, ls))
            System.out.println(i);
    }

}