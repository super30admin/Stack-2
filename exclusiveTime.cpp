/*
Intuition: Use a stack to store all the starting point of the functions.
We can immediately compute how much time a particular function takes by comparing it with the previous function index.

While popping, we can again check how much time it occupies by comparing it with the previous function index.
//////////////////////////////////////////
Time Complexity: O(N), N = Length of logs
Space Complexity: O(N), N = size of stack
//////////////////////////////////////////
*/

class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        stack<int> stack;
        vector<int> result(n, 0);
        int curr, prev = 0;
        
        for ( auto &log: logs){
        
            vector <string> out;

            stringstream check1(log);

            string intermediate;

            while(getline(check1, intermediate, ':'))
            {
                out.push_back(intermediate);
            }
            for ( auto el: out) cout<<el<<" ";
            cout<<endl;
            curr = stoi(out[2]);
            if ( out[1] == "start"){
            
                if ( stack.size() !=0){
                    result[stack.top()] += curr - prev;
                    prev = curr;
                }
                stack.push(stoi(out[0]));
                
            }
            else{ 
                int temp = stack.top();
                stack.pop();
                result[temp] += curr - prev+1;
                prev = curr + 1;
            }           
        
        }

        return result;
            
    }
};