/**
Intuition:
Use a stack to track what closing bracket you expect next.
When you see an opening bracket, push its matching closing bracket onto the stack.
When you see a closing bracket, it must match the top of the stack — otherwise it's invalid. If the stack is empty at the end, it's valid.
T.C: O(n)
S.C: O(n)
*/

var isValid = function (s) {
    const stack = [];
    const map = {
        '(': ')',
        '{': '}',
        '[': ']'
    };

    for (const ch of s) {
        if (ch in map) {
            // push expected closing
            stack.push(map[ch]);
        } else if (stack.pop() !== ch) {
            // mismatch
            return false;
        }
    }

    return stack.length === 0;
};