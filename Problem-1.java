//TC:O(n)
//SC:O(n/2)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        int prev = 0;
        int curr = 0;
        
        for(String log : logs)
        {
            String[] split = log.split(":");
            curr = Integer.parseInt(split[2]);
            
            if(split[1].equals("start"))
            {
                if(!stack.isEmpty())
            {
                result[stack.peek()] += curr-prev;
                prev = curr;
            }
            stack.push(Integer.parseInt(split[0]));
            }
            else 
            {
                result[stack.pop()] += curr-prev + 1;
                prev=curr+1;
            }
        }
        return result;
        
    }
}