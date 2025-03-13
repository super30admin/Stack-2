/*
TC : O(N)
SC : O(N)
*/
class Solution
{
public:
    bool isValid(string s)
    {
        if (s.size() == 0 || s.empty())
        {
            return true;
        }

        stack<char> stk;

        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[')
            {
                stk.push(s[i]);
            }
            else if (!stk.empty())
            {
                if (s[i] == ')' && stk.top() == '(')
                {
                    stk.pop();
                }
                else if (s[i] == '}' && stk.top() == '{')
                {
                    stk.pop();
                }
                else if (s[i] == ']' && stk.top() == '[')
                {
                    stk.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return stk.empty();
    }
};