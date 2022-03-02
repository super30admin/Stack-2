class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        dict_ = {'(' : ')',
                  '{' : '}',
                 '[':']'
        }
        for i in s:
            if i in dict_:
                stack.append(i) # push the opening brackets
            elif i in [')', '}', ']']:
                if stack:
                    curr = stack.pop()  # pop the oepning bracket  
                    if i != dict_[curr] : # check if the current pair is correct
                        return False
                else:                 
                    return False     # If the ip has just one closing bracket, the stack will be empty and there will be no pair so we should return False
        return len(stack) == 0 
