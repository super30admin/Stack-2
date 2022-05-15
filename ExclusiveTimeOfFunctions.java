//TC : O(N) -- TRAVERSING LOGS IN SINGLE PASS
//SC : O(N) --- Creating stack to store the processes

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null)    return new int[0];
        
        Stack<Integer> stack = new Stack();
        int[] result = new int[n];
        
        int prev = 0, curr = 0;
        for(String li : logs){
            String[] arr = li.split(":");    
            curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += (curr - prev);   
                }
                stack.push(Integer.parseInt(arr[0]) );
                prev = curr;
                
            }else if(arr[1].equals("end")){
                result[stack.pop()] += (curr + 1 - prev);
                prev = curr + 1;
            }
        }
        return result;
        
    }
}