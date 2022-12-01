// ## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
    if (s === null || s.length === 0)
        return true;
    let stack = [];
    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        // If found an opening brace, push its equivalent closing brace to stack 
        if (ch === "{") {
            stack.push("}");
        } else if (ch === "(") {
            stack.push(")");
        } else if (ch === "[") {
            stack.push("]");
        } else {
            // Check if the closing brace is same as the last opening brace
            if (stack.length === 0 || stack.pop() !== ch) {
                return false;
            }
        }
    }
    // If there are still braces which have not been closed, return false
    return stack.length === 0;
};
