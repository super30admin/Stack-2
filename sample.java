
import java.util.Stack;
import java.util.List;
class Solution {
 
      
    public int[] exclusiveTime(int n, List<String> logs) {

        int prev = 0;

        int curr = 0;

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];

        for(String log:logs){

            String[] record =log.split(":");

            curr = Integer.parseInt(record[2]);

            if(record[1].equals("start")){

                if(!stack.isEmpty()){

                    result[stack.peek()]+= curr - prev;

                }

            stack.push(Integer.parseInt(record[0]));
            prev = curr;

            }
            else{
                result[stack.peek()]+= curr - prev +1;
                stack.pop();

                prev = curr+1;
            }
        }
        return result;

}
}

// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Solution {
    public boolean isValid(String s) {
        
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length;i++){
            char bracket = s.charAt(i);

            if(bracket == '{'){


                stack.push('}');
            }else if(bracket == '['){

                stack.push(']');

            }else if(bracket == '('){

                stack.push(')');

            }else if(stack.isEmpty() || stack.peek()!=bracket) return false;

            else if (stack.peek()==bracket) stack.pop();

        }

        return stack.isEmpty();

    }
}

// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
