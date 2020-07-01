// ## Problem2 Valid Parentheses 
// (https://leetcode.com/problems/valid-parentheses/)

// time: O(n)
// space: O(n)

const isValid = function(s) {
    if(s.length === 0) return true;
    let st = [];
    for(let i = 0; i < s.length; i++) {
        if(s[i] === '(' || s[i] === '{' || s[i] === '[') st.push(s[i]);
        else if(s[i] === ')' && st.pop() !== '(') return false;
        else if(s[i] === '}' && st.pop() !== '{') return false;
        else if(s[i] === ']' && st.pop() !== '[') return false;
    }
    if(st.length === 0) return true;
    else return false;
};