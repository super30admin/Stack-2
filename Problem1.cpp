// Problem Name: Exclusive time of functions
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We use a stack here to keep a track of start and end logs
// 2. If we get a start, we check the top of the stack and add the time spent in
// the final result , push the new start and move our prev to curr
// 3. If we hit a end log, we pop from the stack, total time will be added curr
// - prev + 1, cause
// it includes the curr as well therefore + 1, pop from stack, move to prev =
// curr+1

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> exclusiveTime(int n, vector<string> &logs) {
    stack<int> st;
    int prev = 0;
    vector<int> res(n, 0);
    for (auto log : logs) {
      istringstream iss(log);
      string word;
      vector<string> words;
      while (getline(iss, word, ':')) {
        words.push_back(word);
      }
      int start = stoi(words[0]);
      int curr = stoi(words[2]);
      string type = words[1];

      if (type == "start") {
        // prev task paused
        if (!st.empty()) {
          res[st.top()] += curr - prev;
        }
        st.push(start);
        prev = curr;
      } else {
        // task ended;
        int top = st.top();
        res[top] += curr - prev + 1;
        st.pop();
        prev = curr + 1;
      }
    }

    return res;
  }
};
