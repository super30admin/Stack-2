"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(n)
"""


def isValid(s: str) -> bool:
    # null case
    if s is None:
        return True

    # optimization
    if len(s) % 2 != 0:
        return False

    stk = []

    # Dictionary for matching parenthesis
    paren = {"(": ")", "{": "}", "[": "]"}

    for bracket in s:
        if bracket in paren:
            stk.append(paren[bracket])
        else:
            if len(stk) == 0 or bracket != stk.pop():
                return False
    return len(stk) == 0


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(isValid(s="()"))  # returns True
    print(isValid(s="()[]{}"))  # returns True
    print(isValid(s="(]"))  # returns False


if __name__ == "__main__":
    main()
