'''
20 Valid Parentheses
https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Example 6:
Input: s = "([]){"
Output: False


Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Solution:
1. Stack
Traverse the string from left to right. For every opening char ('(' or '{' or '[') push the corresponding closing char (')' or '}' or ']'). If the ordering is correct (condition #2 satisified), then we must encounter a closing char that matches the last opening char. The last opening char is at top of the
stack. Hence, pop the stack. Then read the next char in string and compare again with the top of the stack ... and so on.
It is possible that we have found the opening and closing char pairs in the correct order but there is an unmatched opening char at the end. Example: ([]){
The last char { will be pushed into the stack but never popped. Hence, when we are done reading the entire string the stack should be empty.

https://youtu.be/sK5YcQAed5k?t=4072
Time: O(N), Space: O(N)
'''

def isValid_1(s: str) -> bool:
    ''' Time: O(N), Space: O(N)
        (Note: This is a very popular problem)
    '''
    if not s:
        return True
    N = len(s)
    stack = []

    for i in range(N):
        c = s[i]
        if c == "(":
            stack.append(')')
        elif c == "{":
            stack.append('}')
        elif c == "[":
            stack.append(']')
        else:
            if not stack or c != stack[-1]:
                return False
            stack.pop()
    return len(stack) == 0

def isValid_2(s: str) -> bool:
    ''' Time: O(N), Space: O(N)
        (Note: This is a very popular problem)
    '''
    if not s:
        return True
    N = len(s)
    stack = []
    peek = -1
    map = {}
    map[')'] = '('
    map['}'] = '{'
    map[']'] = '['
    for c in s:
        if c not in map:
            stack.append(c)
        else:
            if stack and stack[peek] == map[c]:
                stack.pop()
    return len(stack) == 0

def run_tests():
    tests = [("()", True), ("()[]{}", True), ("(]", False), ("([])", True), ("([)]", False), ("([]){", False)]
    for i, test in enumerate(tests):
        s, ans = test[0], test[1]
        print(f"\n --- Test Case {i+1} --- ")
        print(f"string = {s}")
        for method in [1, 2]:
            if method == 1:
                valid = isValid_1(s)
            elif method == 2:
                valid = isValid_2(s)
            passed = (ans == valid)
            print(f"Method {method}: Has valid parentheses?: {valid}")
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()
