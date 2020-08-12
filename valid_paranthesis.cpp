// Time Complexity : O(n)
// Space Complexity : O(3)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Use hashmap to save the opening end for comparison
//2. Push opening braces on the stack. Compare the closing brace by popping elements from the top of the stack.
//3. return false if there is a mismatch else return true.

class Solution {
public:
    bool isValid(string s) {
        //edge
        if(s.length()==0)
            return true;
        
        //logic
        stack<char> br_st;
        unordered_map<char, char> br_map;
        br_map[')'] = '(';
        br_map['}'] = '{';
        br_map[']'] = '[';
        
        for(int i=0; i<s.length(); i++){
            if(s[i] == '(' || s[i] == '{' || s[i] == '[' ){
                br_st.push(s[i]);
            }else{
                if(br_st.empty())
                    return false;
                
                char compare = br_st.top();
                br_st.pop();
                if(br_map[s[i]] != compare)
                    return false;
            }
        }
        
        if(!br_st.empty()) 
            return false;
        return true;
    }
};
