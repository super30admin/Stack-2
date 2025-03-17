// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Valid Parantheses
// Approach: Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        bool isValid(string s) {
            stack<char> input;
            for(int i = 0; i < s.length(); i++){
                if(s[i] == '(' || s[i] == '{' || s[i] == '['){
                    input.push(s[i]);
                }
                else if(s[i] == ')' || s[i] == '}' || s[i] == ']'){
                    if(input.size() != 0){
                        if(s[i] == ')' && input.top() == '('){
                            input.pop();
                            continue;
                        }
                        if(s[i] == '}' && input.top() == '{'){
                            input.pop();
                            continue;
                        }
                        if(s[i] == ']' && input.top() == '['){
                            input.pop();
                            continue;
                        }
                        else{
                            return false;
                        }   
                    }
                    else{
                        return false;    
                    }
                }    
            }
            
            if(input.size() != 0)
                return false;
            
            return true;
        }
    };