//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
    
    struct Log {
        int id;
        bool isStart;
        int time;
    };
    
    Log getLog(string& s) {
        string id, isStart, time;
        istringstream ss(s);
        getline(ss, id, ':');
        getline(ss, isStart, ':');
        getline(ss, time, ':');

        return {stoi(id), isStart == "start", stoi(time)};
    }
    
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> exclusive(n, 0);
        stack<Log> s;
        
        for(auto& log: logs) {
            Log l = getLog(log);
            if(l.isStart)
                s.push(l);
            else {
                int time = l.time - s.top().time + 1;
                exclusive[l.id] += time;
                
                s.pop();
                if(!s.empty())
                    exclusive[s.top().id] -= time;
            }
        }
        return exclusive;
    }
};