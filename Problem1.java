// Time Complexity : O(n)
// Space Complexity : O(n)
// This Solution worked on LeetCode

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() ==0)   return result;
        Stack<Integer> st = new Stack<>();
        int prev =0;
        for(String log : logs){
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){     // if the function starts
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev = curr;
            }
            else{                               // if the function ends pop the function from the stack top
                result[st.pop()] += curr - prev + 1;    // and add the difference interval between the curr and prev value + 1 to the result array
                prev = curr + 1;        //update the prev to curr + 1
            }
        }
        return result;
    }
}
