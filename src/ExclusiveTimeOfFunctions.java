// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    
    int start = 0;
    Stack<Integer> stack = new Stack<>();
    int[] res;
    
    public int[] exclusiveTime(int n, List<String> logs) {
        
        res = new int[n];
        
        for(String log : logs) {
            
            String[] strArr = log.split(":");
            int id = Integer.parseInt(strArr[0]);
            int time = Integer.parseInt(strArr[2]);
           
            if(strArr[1].equals("start")) {
                if(!stack.isEmpty())
                    res[stack.peek()] += time - start;
                stack.push(id);
                start = time;
            }
            else {
                res[stack.pop()] += time - start + 1;
                start = time+1;
            }

        }

        return res;
        
    }
}
