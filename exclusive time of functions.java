//Timecomplexity:- O(N).
//space complexity:- O(n).
//Did it run on leetcode:- Yes.
//Approach with code:- as there are many dependancy relations meaning first completion procees will be on top of the stack
//in for each loop we split the given input into three parts and when there is start and cache is not empty untill then
// it is previoius work which will be updated in output array and current element is pushed into stack,if end occurs 
//computation of work is done by prev and current pointers and that elemet is poped.


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> cache=new Stack<>();
        int prev=0;
        int current=0;
        int[] output=new int[n];
        for(String log:logs){
            String[] split=log.split(":");
            current=Integer.parseInt(split[2]);
            if(split[1].equals("start")){
                if(!cache.isEmpty()){
                    output[cache.peek()]+=current-prev;
                    prev=current;
                    
                }
                cache.push(Integer.parseInt(split[0]));
            }   
                else{
                output[cache.pop()]+=current-prev+1;
                prev=current+1;
            }
            
        }
        return output;
    }
}