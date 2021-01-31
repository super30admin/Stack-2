//Time - O(len(logs))
//Space - O(len(logs))

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        stack<int> st;
        vector<string> splitStr;
        vector<int> time (n,0);
        int prev = 0, curr;
        
        for(auto log:logs){
            splitStr = split(log);
            curr = stoi(splitStr[2]);
            if(splitStr[1] == "start"){
                if(!st.empty()){
                    time[st.top()] += curr-prev;
                    prev = curr;
                }
                st.push(stoi(splitStr[0]));
            }else{
                time[st.top()] += curr-prev+1;
                prev = curr + 1;
                st.pop();
            }
        }
    
            
        return time;
    }
    
    
    vector<string> split(string sentence){
        int beg = 0,end = 0;
        vector<string> split;
        for(end = 0; (end = sentence.find(":",end)) != string::npos; end++){
            split.push_back(sentence.substr(beg,end-beg));
            beg = end+1;
        }
        split.push_back(sentence.substr(beg,end-beg));
        
        return split;
    }
};