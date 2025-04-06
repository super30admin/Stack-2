// Time Complexity: O(n)
// Space Complexity: O(n)
// Does this code run on Leetcode: Yes

// Approach: 
// 1. Create a stack to store the closing brackets
// 2. Traverse the string and push the closing brackets into the stack
// 3. Traverse the string again and check if the opening brackets match with the closing brackets in the stack
// 4. If they match, pop the closing bracket from the stack and continue
// 5. If they don't match, return false

class Solution {
    public:
        bool isValid(string s) {
            stack <char> close;
            for(int i = 0; i < s.size(); i++){
                if(s[i] == ')' || s[i] == ']' || s[i] == '}'){
                    close.push(s[i]);
                }
            }
            // for(int i = s.size() - 1, j = stack.top(); i >=0 && !s.empty(); i--)
            int i = 0; 
            while(!close.empty()){
                if(i >= s.size()){break;}
                if(s[i] == '(' && close.top() != ')' || s[i] == '{' && close.top() != '}' || s[i] == '[' && close.top() != ']'){
                    return false;
                }
                else{
                close.pop();
                i++;
                continue;
                }           
                
            }
            return true;
        }
    };