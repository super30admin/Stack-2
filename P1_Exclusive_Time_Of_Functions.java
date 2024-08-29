// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  yes

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[n];
        int currTime = 0; 
        int prevTime = 0;
        for(int i=0 ; i<logs.size(); i++) {
            String[] words = logs.get(i).split(":");
            int id = Integer.parseInt(words[0]);
            String method = words[1];
            currTime = Integer.parseInt(words[2]);

            if(method.equals("start")) {
                if(!st.empty()) {
                    answer[st.peek()] += currTime - prevTime;
                    st.add(id);
                } else {
                    st.add(id);
                }
                prevTime = currTime;
            }
                
            if(!st.empty() && method.equals("end")) {
                answer[id] += currTime + 1 - prevTime;
                st.pop();
                prevTime = currTime + 1;
            }
           
        }
        return answer;
    }
}