/* for a single type of bracket like just { or [ or ( this below code should pass
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0:
            return False
        
        count = 0
        for i in range(len(s)):
            
            if s[i] == "(":
                count += 1
            
            else:
                count -= 1
                
            if i == 0:
                if count < 0:
                    return False
                
            
        if count != 0:
            return False
        
        return True


class Solution:
    def isValid(self, s: str) -> bool:
        if s is None or len(s) == 0 or len(s) % 2 != 0:
            return False
        
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
                
            elif c == "{":
                stack.append("}")
                
            elif c == "[":
                stack.append("]")
            
            elif len(stack) == 0 or stack.pop() != c:
                return False
            
        if len(stack) != 0:
            return False
        
        return True
*/
// time - O(n)
// space - O(n)
// logic - pushed the bracket onto stack if it was opening and popped out from stack if it is closing
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0)
            return false;
        
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (c == '(')
                stack.push(')');
            
            else if (c == '[')
                stack.push(']');
            
            else if (c == '{')
                stack.push('}');
            
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        
        if (!stack.isEmpty())
            return false;
        
        return true;
    }
}
