//Time Complexity: O(n) + O(m); where n is the no. of processes and m is the size of logs
//Space Complexity: O(n) + O(m)
//Code run successfully on LeetCode.

public class Problem1 {

    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int prev =0, curr= 0;
        
        for(String log : logs)
        {
            String[] split= log.split(":");
            int id = Integer.parseInt(split[0]);
            curr = Integer.parseInt(split[2]);
            
            if(split[1].equals("start"))
            {
                if(!s.isEmpty())
                {
                    result[s.peek()] += curr - prev;
                }
                s.push(id);
                prev = curr;
            }
            
            else if(split[1].equals("end"))
            {
                s.pop();
                result[id] += curr +1- prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
