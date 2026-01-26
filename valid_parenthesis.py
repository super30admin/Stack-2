class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        helper_dict = { 
            ")" : "(",
            "}" : "{",
            "]" : "["
        }

        for c in s:
            # we only look for corresponding open bracket when we see a 
            # closed bracket and also we only use the stack for pushing open bracket  
            if c not in helper_dict:
                stack.append(c)
            else:
                if stack and stack[-1] == helper_dict[c]:
                    stack.pop()
                else:
                    return False
        
        return len(stack) == 0