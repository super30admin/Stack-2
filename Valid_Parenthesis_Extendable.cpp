// Time Complexity : O(n) as we are traversing throgh the complete string only once. n is length of string given.
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning
class Solution {
public:
    
    set<char> opening = { '{', '[', '('};
    
    map<char, char> pairs = {{'}','{'}, {']','['}, {')','('}};
    
  
    bool isValid(string s) {
        stack<char> mystack;
        
        for( int i = 0; i < s.size(); i++){
             char ch = s[i];
            
           
            if( opening.find(ch) != opening.end()){
                mystack.push(ch);
           
            } else if( !mystack.empty()){
            
                if(pairs[ch] == mystack.top()){
                    
                    mystack.pop();
                }else{
                    
                    return false;
                }
            
            }else
                return false;
                
            
            
        }
        return mystack.empty();
        
    }
};