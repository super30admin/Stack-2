//Time Compelxity : O(n)
//Space complexity : O(n)
#include<iostream>
#include<vector>
#include<stack>
using namespace std;
#include <vector>
#include <stack>
#include <string>
#include <sstream>
using namespace std;

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> result(n, 0);
        stack<int> st;
        int prev = 0;
        for (string& log : logs) {
            stringstream ss(log);
            string idStr, type, timeStr;
            getline(ss, idStr, ':');
            getline(ss, type, ':');
            getline(ss, timeStr, ':');
            int id = stoi(idStr);
            int time = stoi(timeStr);
            if (type == "start") {
                if (!st.empty()) {
                    result[st.top()] += time - prev;
                }
                st.push(id);
                prev = time;
            } else { 
                result[st.top()] += time - prev + 1;
                st.pop();
                prev = time + 1;
            }
        }
        return result;
    }
};
