class Solution:
    def isValid(self, s: str) -> bool:
        stack =[]
        exp_dict= {")":"(","}":"{","]":"["}
        for ch in s:
            if ch in exp_dict:
                if stack:
                    top=stack.pop()
                else:
                    top='#'
                
                if exp_dict[ch]!=top:
                    return False
            else:
                stack.append(ch)
        
        return not stack
                