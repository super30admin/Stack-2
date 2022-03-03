/**
 * @Time complexity:
 * O(N) where N is the size of the string
 * 
 */

/**
 * @Space complexity:
 * O(N) where N is the size of the string
 * and in worst case we have to push all
 * the parenthesis in the stack
 * 
 */

/**
 * @Approach:
 * We need to maintain the order as we have different types
 * of brackets, so we need to use stack. Otherwise
 * we could have solved this problem just by
 * maintaining a count where if we encounter
 * open bracket we increase the count by 1 and
 * decrease by 1 in case of close bracket.
 * 
 * So, in this case when we encounter a open
 * bracket we push close bracket in the stack
 * and compare the top of the stack with the 
 * current bracket in the string. If they match
 * we pop the top element of the stack and try to
 * resolve the next bracket in the stack.
 * 
 * At the end if our stack is empty, the parenthesis
 * are valid. But if we have not reached the 
 * end of the string and we encounter a closed
 * bracket and stack is empty, then it is
 * sure shot not valid.
 * 
 */

// The code ran perfectly on leetcode

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(auto x : s){
            if(x == '[') st.push(']');
            else if (x == '(') st.push(')');
            else if (x == '{') st.push('}');
            else {
                if(st.empty() || x != st.top()) return false;
                st.pop();
            }
        }
        return st.empty();
    }
};