class Solution:
    
    """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(N)
            Passed All The Test Cases in LC : Yes
            
            Approach : Using a stack to track the balance of the parantheesis. Cause, whenever a starting bracket starts, there should be a closing
                       bracket as well. Also, the closing bracket should not come before the starting bracket.
                       
                       # Pushing in stack whenever a opening bracket comes
                       # Whenever a closing bracket comees, checking it with the top value of the stack. If it is not the corrosponding closing bracket
                         then returning False, otherwise popping the bracket
                       # Finally checking the length of the track. If it is positive, returning False
                       # Atlast, returning True
    
    
    """
    
    # Follow Up : What if there is only onee kind of bracket ? - We can optimize the spacee to O(1)
    def singleParenthesis(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            else:
                count -= 1
            
            if count < 0:
                return False
        if count > 0:
            return False
        return True
    
    
    def multipleParenthesis(self, s):
        
        # initializing stack
        track = []
        
        for i in range(len(s)):
            # Pushing when the opening bracket comes in
            if s[i] == '(' or s[i] == '{' or s[i] == '[':
                track.append(s[i])
            
            # If there is anything in stack then only wee can pop
            elif len(track) > 0:
                if s[i] == ')':
                    if track[-1] == '(':
                        track.pop()
                    else:
                        return False
                elif s[i] == '}':
                    if track[-1] == '{':
                        track.pop()
                    else:
                        return False
                elif s[i] == ']':
                    if track[-1] == '[':
                        track.pop()
                    else:
                        return False
            else:
                return False
                
        
        if len(track) > 0:
            return False
        
        return True
                
    
    def isValid(self, s : str) -> bool:
        
        # edge case
        if not s:
            return True
        
        return self.multipleParenthesis(s)
        
        
        
        
        
