// Problem Name: Valid Parantheses
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we use a stack to keep track of characters
// 2. If it is a openig bracket, we push to the stack
// 3. If it is a closing bracket, we first check if stack is empty or the top of
// the stack is not mapped to correct char, if either of them return true, we
// return false, otherwise we pop from the stack
// 4. In the end, we return true if stack is empty or false otherwise

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool isValid(string s) {
    stack<char> st;
    unordered_map<char, char> u = {
        {'{', '}'},
        {'[', ']'},
        {'(', ')'},
    };

    for (auto ch : s) {
      if (ch == '{' || ch == '(' || ch == '[') {
        st.push(ch);
      } else {
        if (st.empty() || u[st.top()] != ch)
          return false;
        else
          st.pop();
      }
    }

    return st.empty();
  }
};
