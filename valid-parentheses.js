// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (s.length % 2 != 0) return false;
    const stack = [];
    const openers = new Map();
    openers.set('(', ')');
    openers.set('{', '}');
    openers.set('[', ']');
    for (const letter of s) {
        if (openers.has(letter)) {
            stack.push(openers.get(letter))
        } else {
            if (letter != stack.pop()) return false;
        }
    }
    return stack.length == 0;
};
