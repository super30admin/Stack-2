'''
Accepted on leetcode(20)
time - O(N)
space - O(N)
Approach -
1. create a hashmap and stack. Fill the hashmap with key as closing bracket and value as corresponding opening brace.
2. Iterate over the string and append all opening braces to the stack and if encounter closing brace check if corresponding opening brace exists as last element inserted in the stack. If they are not equal then return False.
3. if only closing braces are in the string return false immediately.
'''


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        map = {}
        map[')'] = '('
        map['}'] = '{'
        map[']'] = '['

        for ch in s:
            if ch in map:  # ch is closing bracket
                if not stack:  # string has only closing brackets '})}}}]]'
                    return False
                # when encounter a closing bracket and stack not empty
                if map[ch] != stack.pop():
                    return False
            else:
                stack.append(ch)

        if not stack:
            return True