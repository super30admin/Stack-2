class Solution:
    
    """
    Description: validate a string with characters "(", "{", "}",")" etc 
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    where n is length of the string
    
    Approach: using a stack
    1. for each character, append opposite bracket to the stack 
       - to ensure when stack.pop is done, the opposing bracket for the last one should match
    2. if stack is empty, return False and when if character falls in closing bracket category (")" or "}" etc) should match with stack.pop
    """
    
    def isValid(self, s: str) -> bool:
        
        stack = []
        for char in s:
            if char == "(": stack.append(")")
            elif char == "{": stack.append("}")
            elif char == "[": stack.append("]")
            elif len(stack) == 0 or char != stack.pop():
                return False
            
        if stack: return False
            
        return True
