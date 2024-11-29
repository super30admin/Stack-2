# Time complexity - O(n)
# Space complexity = O(n)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hmap = {'(': ')', '{':'}','[':']'}
        for each in s:
            if each in ['(', '{', '[']:
                stack.append(hmap[each])
            elif each in [')', '}', ']']:
                if not stack or stack.pop() != each:
                    return False
        return not stack      




