# Time Complexity : O(n), Where n is number of elements in the s input string
# Space Complexity : O(n), Where n is number of elements in the s input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        stack=deque()
        hashmap={")":"(","}":"{","]":"["}
        for i in s:
            if(i in ("(","{","[")):
                #This is the case for opening brackets
                stack.append(i)
            else:
                #This is the case for closing brackets
                if(len(stack)!=0 and hashmap.get(i)==stack[-1]):#check do we have counter brackets at the top of stack
                    stack.pop()
                    continue
                else:
                    return False
        return (len(stack)==0)
        