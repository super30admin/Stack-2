// Time Complexity : O(n) where n is number of logs
// Space Complexity : O(n) for the stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

// Your code here along with comments explaining your approach
//1. Breakdown the given commands
//2. Create stack to store the last index to access for a tid.
//3. Pop the tid when an end is encountered. Add the tid when a start is encountered.
//4. Increase "prev" time to the end of the window i.e., curr if start command is encountered and curr+1 if end command is encountered. 
//5. To handle multiple re-entry add all the start and end values.

class Solution {
public:
    vector<string> delimiter(string& input){
        input.push_back(':');
        int i=0, n = input.length();
        int j=0;
        vector<string> result;
        while(i<n){
           if(input[i]==':'){
               result.push_back(input.substr(j, i-j));
               j=i+1;
           }
           i++;  
        }
        return result;
    }
    
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        //edge
        if(n==0 || logs.size()==NULL){
            vector<int> result;
            return result;
        }
        //logic
        stack<int> index_stack;
        vector<int> result(n,0);
        int tid; string action;
        int curr=0; int prev=0;
        for(int i=0; i<logs.size(); i++){
            //string temp="0";
            vector<string> broken_commands = delimiter(logs[i]); 
            tid = stoi(broken_commands[0]);
            action = broken_commands[1];
            curr=stoi(broken_commands[2]);
            if(action == "start"){
                if(!index_stack.empty()){
                    result[index_stack.top()] += curr-prev;
                }
                prev=curr;
                index_stack.push(tid);
            }else{ //end
                result[index_stack.top()] += curr-prev+1;
                index_stack.pop();
                prev = curr+1;
            }
        }
        return result;
    }
};