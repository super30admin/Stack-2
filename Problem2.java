///Valid Paranthesis
// Time Complexity :O(n)
// Space Complexity :O(n) - stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//using stack to store each bracket and keeping track of opening and closing them
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        System.out.println(p.isValid("(]"));

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() ==0)
            return true;
        if(s.isEmpty())
            return true;
        for(int i = 0;i< s.length(); i++){
            if(s.charAt(i)== '('|| s.charAt(i) == '[' || s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else{
                    if(stack.isEmpty())
                        return false;
                     if(s.charAt(i) == ')'){
                        if(stack.peek()!='(')
                        return false;
                        else{
                        stack.pop();
                    }
                }
                 if(s.charAt(i) == '}'){
                    if(stack.peek()!= '{'){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
            }
                if(s.charAt(i) == ']'){
                
                if( stack.peek() != '['){
                    return false;
                }
                else
                    stack.pop();
            }
       
           
            }
            
            
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    
}
