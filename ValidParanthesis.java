//O(n)
//O(n)
class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();
        int i=0;
        if(len%2 !=0) return false;
        Stack<Character> stack = new Stack<Character>();
        
        while(i!=len)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(stack.isEmpty()) return false;
                Character t = stack.peek().charValue();
                if(s.charAt(i)==')' && t!='(') return false;
                if(s.charAt(i)==']' && t!='[') return false;
                if(s.charAt(i)=='}' && t!='{') return false;
                stack.pop();
            }
            i++;
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
        
    }
}
