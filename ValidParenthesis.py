"""
// Time Complexity :O(n) Traversing through the input.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
push openingBrackets in stack
if closingBrackets, check if its opposite pair of openingBrackets at the top of the
stack
at the end stack should be empty-> return True else False 
"""
class Solution:
    def isValid(self, s: str) -> bool:
        # edge
        if len(s) == 0: return True

        openingBrackets = "({["
        closingBrackets = ")}]"
        hashMap = {")":"(","}":"{","]":"["}
        stack = []

        for char in s:
            #print(char,stack)
            if char in openingBrackets:
                stack.append(char)
            elif char in closingBrackets:
                if len(stack) == 0 or stack[-1] != hashMap.get(char) :
                    return False
                elif stack[-1] == hashMap.get(char):
                    stack.pop()


        return True if len(stack) == 0 else False
