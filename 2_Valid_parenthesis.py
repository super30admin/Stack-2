// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution:
    def isValid(self, s: str) -> bool:
        
        stack=[]
        
        d= {')':'(',
            ']':'[',
            '}':'{'
           }
                   
        for i in s:
            
            if i in ['(','[','{']:
                stack.append(i)
            else:
                if len(stack)>0 and d[i]== stack[-1]:
                        stack.pop()
                else:
                        return False
        return len(stack)==0
                    
                
        