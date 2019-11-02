/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
20. Valid Parentheses
Easy

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true



 * Solution 1: using Stack
   Time Complexity : O(n) 
 * Space complexity :O(n) as stack space should also be taken into consideration 
 */

class Solution {
public:
    bool isValid(string s) {
        int len = s.length();
        string paran_start = "({[";
        int idx = 0;
        bool is_valid = false;
        
        /* if len is 0 consider it as true*/
        if (len == 0) {
            return true;
        }
        
        /* initialize stack */
        stack<char> stck;
        /* add first element */
        stck.push(s[0]);
        idx = 1;
        
        while (idx < len) {
            /* Pop element if parantheses matches */
            if (!stck.empty() && 
                (s[idx] == ')' && stck.top() == '(' ||
                   s[idx] == ']' && stck.top() == '[' ||
                   s[idx] == '}' && stck.top() == '{' )) {
                stck.pop();
            } else {
                stck.push(s[idx]);
            }
            idx++;
        }
        
        /* if stack is empty, we have got a valid input */
        if (stck.empty()) {
            is_valid = true;
        }
        return is_valid;
    }
};
/* Execute on leetcode platform */


