#lEETCODE : pass
#SC - O(1), TC-O(n)
#1) hashmap- key(closing brackets), value(opening)
#2) if opening brackets then push to stack
#3) if closing brackets then check with stack top
#3.1) edge case with only closing brackets
class Solution:
    def isValid(self, s: str) -> bool:
        map ={}
        stack=[]
        #1
        map[')']='('
        map['}']='{'
        map[']']='['
        for sym in s:
            #3
            if sym in map:
                #3.1
                if len(stack) ==0:
                    return False
                if map[sym] != stack.pop():
                    return False
            else:
                #2
                stack.append(sym)
        return len(stack) ==0
obj = Solution()
obj.isValid("()")
