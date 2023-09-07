# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach

# stack solution for many types of parenthesis
from collections import deque


class Solution:
    def isValid(self, s: str) -> bool:
        l=deque()
        for i in s:
            if( i in ['{','[','(']):
                l.append(i)
            else:
                if len(l)==0:
                    return False
                curr=l.pop()
                if(curr=='(' and i !=')'):
                    return False
                if(curr=='[' and i!=']'):
                    return False
                if(curr=='{' and i!='}'):
                    return False
        if(len(l)):
            return False
        return True

# just use a count variable if there are same type of brackets.