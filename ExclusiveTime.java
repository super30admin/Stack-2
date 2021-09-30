/*
Time: O(n) Need to traverse the logs
Space: O(n) Stack will have n elements
*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        //Base case:
        if(logs.size() == 0 ){
            return new int[]{};
        }
        
        //Logic
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for(String log: logs){
            String[] strArr = log.split(":");
            // System.out.println(strArr[0]+" "+ strArr[1]+ " " + strArr[2]);
            int curr = Integer.parseInt(strArr[2]);
            System.out.println(curr);
            if(strArr[1].equals("start")){
                if(!s.isEmpty()){
                    //Update prev's idx in result
                    result[s.peek()] += curr - prev;
                    prev = curr; 
                }
                s.push(Integer.parseInt(strArr[0]));
            }else{
                result[s.pop()] += curr+1 - prev;
                prev = curr + 1;
            }
             
        }         
        return result;
    }
}
