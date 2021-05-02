//TC: O(n) where n is elements in the logs list
//SC: O(n/2) since we are only pushing the start elements into the stack

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        //intialize the result array with 0s and of size equal to number of processes
        vector<int> result(n, 0);
        
        stack<int> s;
        
        //the last start time recorded. Initalize to 0
        int last = 0;
        
        //similar to a parentheses question
        for(string log: logs) {
            
            //use stringstream to split up the string into three parts strid, type, strtime
            stringstream ss(log);
            string strid, type, strtime;
            getline(ss, strid, ':');
            getline(ss, type, ':');
            getline(ss, strtime, ':');
                
            //converting the strings to ints
            int intid = stoi(strid);
            int inttime = stoi(strtime);
            
            
            if(type == "start"){
                
                //if type is start, then first check if the stack is empty. If it isnt, then (which means we are interrupting another continuing process), add the current time  - last to the index of that process in the result array.
                
                if(!s.empty()){
                    result[s.top()] += inttime - last;
                }
                
                //push the id of the current process being evaluated on the stack
                s.push(intid);
                //set the last time the process was seen to the inttime
                last = inttime;
                
            } else if(type == "end"){
                //if we have seen an end, get the top element (latest function ID ) and calculate its time
                result[s.top()] += inttime - last + 1;
                //pop this from the stack
                s.pop();
                //since the process has ended, set the last to the next time (since we will be starting a new process/continuing an interrupted process from the next time instance)
                last = inttime + 1;

            }
        
        }
        
        return result;
        
    }
};