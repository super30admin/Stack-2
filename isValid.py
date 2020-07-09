#Time Complexity:O(n)
#Space Complexity:O(n)
#Ran successfully oon Leetcode:yes
#Algo:
# idea is to push closing bracket into stack if corresponding opening bracket in string. and if closing bracket in string then remove it from stack.



class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        flag = 0
        for i in s:
            if i=='(' or i=="{" or i=="[":
                stack.append(i)
            else:
                if len(stack)>0:
                    if (i==")" and stack[-1]=="(") or (i=="}" and stack[-1]=="{") or (i=="]" and stack[-1]=="["):
                        del stack[-1]
                    else:
                        flag=1
                        break
                else:
                    flag=1
                    break
        if len(stack)>0 or flag==1:
            return False
        return True
