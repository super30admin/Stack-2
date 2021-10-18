//TC: O(N), where N is the no. of logs
//SC: O(N), worst case having only one process with multiple start and end times
//running on leetcode: yes
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0) return new int[] {};
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev=0;
        for (String log : logs){
            String[] strArray = log.split(":");
            int curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += curr - prev;
                    prev = curr;
                }
                s.push(Integer.parseInt(strArray[0]));
            }
            else{
                result[s.pop()] += curr + 1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}
