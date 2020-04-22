// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<>();
        if(s.length()==1) return false;
     for(int i=0;i<s.length();i++){
         if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' ){
             stack.push(s.charAt(i));
         }
         else{
             if(s.charAt(i)==')' && (stack.isEmpty() || stack.pop()!='(')) return false;
             else if(s.charAt(i)==']' && (stack.isEmpty() || stack.pop()!='[')) return false;
             else if(s.charAt(i)=='}' && (stack.isEmpty() || stack.pop()!='{')) return false;
                 
             
         }
     }
        return stack.isEmpty();
    }
}