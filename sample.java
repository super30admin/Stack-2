//Exclusive time of functions
// Time Complexity :0(n)
// Space Complexity :0(n/2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] output= new int[n];
        int prev=0;
        int curr=0;
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<logs.size();i++){
            String[] s=logs.get(i).split(":");
            curr=Integer.parseInt(s[2]);
            if((s[1]).equals("start")){
               if(!stack.isEmpty())
                output[stack.peek()]+=curr-prev;
               
             stack.push(Integer.parseInt(s[0]));
             prev=curr;
            }
            else
            {
                output[stack.pop()]+= curr-prev+1;
                prev=curr+1;
            }
            
        }
        return output;
    }
}
//valid parenthesis
// Time Complexity :0(n)
// Space Complexity :0(n/2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else if(!stack.isEmpty())
            {
                if(c=='}' && stack.pop()!='{')
                    return false;
                else if(c==')' && stack.pop()!='(')
                    return false;
                else if(c==']' && stack.pop()!='[')
                    return false;
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
}
