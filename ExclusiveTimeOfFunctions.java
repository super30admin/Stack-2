/*
 * TC = O(N)
 * SC = O(N)
 */

import java.util.*;
public class ExclusiveTimeOfFunctions
{
    
        public static int[] exclusiveTime(int n, List<String> logs) {
            if(n == 0) return new int[]{};
            
            Stack<Integer> s = new Stack<>();
            int prev = 0;
            int[] result = new int[n];
            
            for(String log: logs)
            {
                String[] splitArray = log.split(":");
                int curr = Integer.parseInt(splitArray[2]);
                
                if(splitArray[1].equals("start"))
                {
                    if(!s.isEmpty()){
                        result[s.peek()] += curr - prev;
                    }
                    s.push(Integer.parseInt(splitArray[0]));
                    prev = curr;
                }
                else
                {
                    result[s.pop()] += (curr+1) - prev;
                    prev = curr + 1;
                }
            }
            
            return result;
        }
    

        public static void main(String args[])
        {
            int n = 2;
            String[] log = {"0:start:0","1:start:2","1:end:5","0:end:6"};
            List<String> logs = Arrays.asList(log);

            int[] ans = exclusiveTime(n, logs);
            for(int i:ans)
            {
                System.out.print(i+" ");
            }
        }
}