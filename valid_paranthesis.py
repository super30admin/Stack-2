# time - O(n)
# space- O(1)
# des- store the corresponding open-close braces in the dictionary, if a closed braces appears first then return false immediately else push the val in stack and check at the end whether the stack is empty

class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        dic={'(':')','{':'}','[':']'}
        # ')':'(','}':'{',']':'['
        for i in range(len(s)):
            if stack and s[i] == stack[len(stack)-1]:
                stack.pop()
            else:
                if s[i] not in dic:
                    return False
                stack.append(dic[s[i]])
            # print(stack)
        if stack==[]:
            return True
        return False