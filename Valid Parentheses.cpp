//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    bool isValid(string s) {
        
        stack<char>my_stack;
        char x;
        
            for(int i=0;i<s.length();i++)
            {
               if(s[i]=='[' || s[i]=='(' || s[i]=='{')
                   my_stack.push(s[i]);
                
                if(my_stack.empty())
                    return false;
            
                    switch(s[i])
                    {
                        case ')':
                            x=my_stack.top();
                            my_stack.pop();
                            if(x=='{' || x=='[')
                                return false;
                            break;
                        
                        case ']':
                            x=my_stack.top();
                            my_stack.pop();
                            if(x=='(' || x=='{')
                                return false;
                            break;
                        
                        case '}':
                            x=my_stack.top();
                            my_stack.pop();
                            if(x=='[' || x=='(')
                                return false;
                            break;
                    }    
            }
      return(my_stack.empty());
    }
};