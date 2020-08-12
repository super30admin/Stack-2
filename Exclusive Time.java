//Time Complexity: O(n) 
//Space Complexity: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;

        for(String log : logs){
            String[] s = log.split(":");
            int pid = Integer.valueOf(s[0]);
            String state = s[1];
            int curr = Integer.valueOf(s[2]);

            if(state.equals("start")){                
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                st.push(pid);
                prev = curr;
            }else{                
                result[st.pop()] += curr-prev+1;                
                prev= curr+1;
            }
        }

        return result;
    }
} 