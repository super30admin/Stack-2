# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        if s==None or len(s)==0: return None
        n=len(s)
        stack=[]
        if n%2!=0: return False
        for c in s:
            if c=='(': stack.append(')')
            elif c=='{': stack.append('}')
            elif c=='[': stack.append(']')
            elif len(stack)==0 or stack.pop()!=c: return False
        if len(stack)!=0: return False
        return True
