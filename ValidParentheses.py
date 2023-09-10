#Time Complexity: O(n)
#Space Complexity:O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        symbol_map={"(":")","[":"]","{":"}"}
        for i in s:
            if i in ["(","[","{"]:
                stack.append(i)
            else:
                if stack:
                    pop_val=symbol_map[stack.pop()]
                    if pop_val != i:
                        return False
                else:
                    return False
        if len(stack)>0:
            return False
        else:
            return True