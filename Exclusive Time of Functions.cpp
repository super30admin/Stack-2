//time: O(N)
//space: O(n)
class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<int> stk;
        vector<int> result(n, 0);
        int prev = 0;
        int curr = 0;
        for(int i = 0; i < logs.size(); i++) {
            vector<string> vec;
            istringstream iss(logs[i]);
            string word;
            while(getline(iss, word, ':')) {
                vec.push_back(word);
            }
            for(string s : vec) cout<<s<<" ";
            cout<<endl;
            curr = stoi(vec[2]);
            if(vec[1] == "start") {
                if(!stk.empty()) {
                    result[stk.top()] += (curr - prev);
                }
                stk.push(stoi(vec[0]));
                prev = curr;
            }
            else {
                result[stk.top()] += (curr - prev + 1);
                stk.pop();
                prev = curr + 1;
            }
        }
        return result;
    }
};