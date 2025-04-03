class Solution:
    def isValid(self, s: str) -> bool:
        stack =[]
        mapi ={'[':']','(':')','{':'}'}
        for char in s:
            if char in mapi:
                stack.append(mapi[char])
            elif not stack or stack.pop() != char:
                return False
        return not stack
        