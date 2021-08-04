//as taught by sir, jsst with log as structure 

/**
 * Every time end an function, deduce its life span from its parent
 */
class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> times(n, 0);
        stack<pair<int, int>> starters;
        for (int i = 0; i < logs.size(); i++) {
            Line line = getLine(logs[i]);
            if (line.start) {
                starters.push({ line.fid, line.time });
            }
            else {
                pair<int, int> starter = starters.top();
                int lifespan = line.time + 1 - starter.second;
                starters.pop();
                times[line.fid] += lifespan;
                if (!starters.empty()) {
                    times[starters.top().first] -= lifespan;
                }
            }
        }
        return times;
    }

    struct Line {
        int fid;
        bool start;
        int time;
        Line(int fid, bool start, int time) : fid(fid), start(start), time(time) {};
    };

    Line getLine(string s) {
        int colon1 = s.find(":", 0);
        int colon2 = s.find(":", colon1 + 1);
        string fid = s.substr(0, colon1);
        string start = s.substr(colon1 + 1, colon2 - (colon1 + 1));
        string time = s.substr(colon2 + 1);
        return Line(stoi(fid), start == "start", stoi(time));
    }

};
