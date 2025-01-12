#Approach
#Push the open brackets in to the stack if close bracked is appreaed and top of stack is not the same return flase else return true




#Complexities
#Time: O(n)
#Space: O(n)



class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if s[i] in ["(", "[", "{"]:
                stack.append(s[i])
            else:
                if len(stack) == 0:
                    return False
                else:
                    if s[i] == "}":
                        if stack[-1] == "{":
                            stack.pop()
                        else:
                            return False
                    if s[i] == ")":
                        if stack[-1] == "(":
                            stack.pop()
                        else:
                            return False
                    if s[i] == "]":
                        if stack[-1] == "[":
                            stack.pop()
                        else:
                            return False
        if len(stack) == 0:
            return True
        else:
            return False


