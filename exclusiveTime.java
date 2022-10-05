//TC - O(n);
//SC - O(n);
//LC - 636

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0) return new int[] {};
        
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[n];
        int curr=0,prev=0;
        
        for(String log: logs){
            String[] split = log.split(":");
             curr = Integer.parseInt(split[2]);
            if(split[1].equals("start")){
                if(!s.isEmpty()){
                    arr[s.peek()]+=curr-prev;
                }
                s.push(Integer.parseInt(split[0]));
                prev = curr;
                
            }
            else{
                
                arr[s.pop()]+= curr+1-prev;
                prev = curr+1;
                
                
            }
            
        }
        
        return arr;
        
    }
}