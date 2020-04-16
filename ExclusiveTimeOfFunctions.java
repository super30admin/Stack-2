Time Complexity = O(n)
Space Complexity = O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[n];
        int prev = 0;
        int current = 0;
        
        for(String log:logs){
            String[] str = log.split(":");
            int id = Integer.parseInt(str[0]);
            current = Integer.parseInt(str[2]);
            
            if(str[1].charAt(0) == 's'){
                if(!stack.isEmpty()){
                    result[stack.peek()] += current - prev;
                }
                prev = current;
                stack.push(id);
            }else{
                result[stack.pop()] += (current - prev)+1;
                prev = current +1;
            }
        }
        return result;
    }
}