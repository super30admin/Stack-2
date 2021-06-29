/*
Intuition: Use a stack to store all opening brackets.
When we arrive at a closing bracket, check if the current bracket matches with the opening bracket.
//////////////////////////////////////////
Time Complexity: O(N), N = Length of string
Space Complexity: O(N), N = size of stack
//////////////////////////////////////////
*/


class Solution {
public:
    bool isValid(string s) {
        stack<char> stack;
        int i =0;
        map<char, char> mapping;
        
        mapping[']'] = '[';
        mapping['}'] = '{';
        mapping[')'] = '(';
        set<char> openingBrackets;
        set<char> closingBrackets;
        openingBrackets.insert('[');
        openingBrackets.insert('(');
        openingBrackets.insert('{');
        closingBrackets.insert('}');
        closingBrackets.insert(']');
        closingBrackets.insert(')');
        while ( i < s.size()){
            char bracket = s[i];
            if ( openingBrackets.find(bracket) != openingBrackets.end()){
                stack.push(bracket);
            }
            else if(closingBrackets.find(bracket) != closingBrackets.end()){
                if( stack.size() ==0) {
                    return false;
                }
                else if( stack.top() == mapping[bracket]){
                    stack.pop();
                }
                
                else{
                    return false;
                }
            }
            i++;
        }
        return stack.size() == 0;
        
    }
};

//Another simpler way: Store the corresponding closing bracket for every opening bracket.
class Solution {
public:
    bool isValid(string s) {
    
        stack<char>stack;
        for ( auto bracket: s){
        
            if ( bracket == '(') stack.push(')');
            else if ( bracket == '[') stack.push(']');
            else if ( bracket == '{') stack.push('}');
            else{
                
                if ( stack.size() == 0) return false;
                char closingBracket = stack.top();
                stack.pop();
                if ( closingBracket != bracket) return false;
 
            }
        }
        return stack.size() ==0;
    }
};