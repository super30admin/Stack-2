# Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def isValid(self, s):
        # creating a hashmap for parenthesis of different types
        brackets_hmap = {')': '(', '}': '{', ']': '['}
        # going through each char in s
        # using stack
        st = []
        # default top_element
        top_element = '#'
        for char in s:
            # if closing bracket found
            if char in brackets_hmap:
                if st:
                    top_element = st.pop()
                # stack top_element should match value of hmap
                if top_element != brackets_hmap[char]:
                    return False
            # if opening bracket found
            else:
                st.append(char)
        # stack should be empty for valid parenthesis
        return len(st) == 0


sol = Solution()
print(sol.isValid("()[]{}"))
