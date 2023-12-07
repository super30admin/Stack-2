// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach


// ## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)


class Solution {
    private static final Map <Character, Character> map = Map.of('[',']','(',')','{','}');
    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for(char c:s.toCharArray()){
          if(map.containsKey(c)){
              stack.push(c);
          }else{
              if(stack.isEmpty()){
                  return false;
              }
              char open = stack.pop();
              if(c != map.get(open)){
                  return false;
          }
          }
          
      }
      return stack.isEmpty();    
    }
}

// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

// ## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(String log : logs){
            String[] splitLog = log.split(":");
            int currTaskId = Integer.parseInt(splitLog[0]);
            int curr = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(currTaskId);
            }else{
                 result[st.pop()] += curr + 1 - prev;
                 prev = curr + 1;
            }
        }
        return result;
    }
}