// Time Complexity : O(N)
// Space Complexity : O(log n)(as we store atmost n/2 values)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Unable to find a better way to split a string in c++

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        if(logs.size()==0){
            return {};
        }
        vector<int> result(n);
        stack<int> s;
        int prev = 0;
        for(string log:logs){
            vector <string> tokens; 
            stringstream check1(log); 
            string intermediate;
            while(getline(check1, intermediate, ':')) 
            { 
                tokens.push_back(intermediate); 
            }
            int current = stoi(tokens[2]);
            if(tokens[1]=="start"){
                if(!s.empty()){
                    result[s.top()] = result[s.top()] + current-prev;
                    prev = current;
                }
                s.push(stoi(tokens[0]));
            }
            else{
                result[s.top()] = result[s.top()]+current-prev+1;
                s.pop();
                prev = current+1;
            }
        }
     
        return result;
    }
};
