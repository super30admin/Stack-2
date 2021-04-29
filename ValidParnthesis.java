//TC: O(n)
//SC: O(n)
class Solution {
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        if(s.length()%2!=0)
            return false;
        Stack<Character> stack = new Stack<>(); //adding open brackets to the stack.
        for(int i=0;i<s.length();i++)       //If a closing bracket is found checking with the top value of the stack if it is not respective opening returning false.
        {                   //at the end if stack is not empty returning false or no element found in stack when there is a closing bracket return false
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.add(s.charAt(i));                              //If all the scenarios are good return true.
            if(s.charAt(i)==')' && (stack.isEmpty() || stack.pop()!='('))
                return false;
            else if(s.charAt(i)=='}' && (stack.isEmpty() || stack.pop()!='{'))
                return false;
            else if(s.charAt(i)==']' && (stack.isEmpty() || stack.pop()!='['))
                return false;
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}