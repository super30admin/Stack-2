class Solution:
    def isValid(self, s: str) -> bool:
        if(len(s)%2!=0):
            return False
        stack = []
        st = 0
        for i in s:
            
            if(i=="(" or i=="[" or i =="{"):
                stack.append(i)
            else:
                if(len(stack)!=0):
                    curr =  stack.pop(-1)+i
                    if(curr=="()" or curr=="{}" or curr=="[]"):
                        st+=2
                    else:
                        return False
        return len(s)==st