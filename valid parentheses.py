# TC:O(N)
# SC:O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        for i in s:
            if stack:
                prev=stack[-1]
                if i==")" and prev=="(":
                    stack.pop()
                elif i=="}" and prev=="{":
                    stack.pop()
                elif i=="]" and prev=="[":
                    stack.pop()
                else:
                    stack.append(i)
            else:
                stack.append(i)

        return len(stack)==0