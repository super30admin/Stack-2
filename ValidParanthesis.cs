// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 public bool IsValid(string s) {
    if(String.IsNullOrEmpty(s))
        return true;
    
    Stack<char> stack = new Stack<char>();
    
    //Create dictionary of characters
    Dictionary<char, char> dict = new Dictionary<char, char>();
    dict.Add('(', ')');
    dict.Add('{', '}');
    dict.Add('[', ']');
    
    for(int i = 0; i < s.Length; i++)
    {
        char c = s[i];  
        //add in stack opposte of character u find
        if(dict.ContainsKey(c))
            stack.Push(dict[c]);
        //If not in dictionary, look if top of elemnt matches character
        else
        {
            if(stack.Count == 0)
                return false;
            int cPop = stack.Pop();
            if(cPop != c)
                return false;
        }
    }

    //if stack is empty, return true, else false
    if(stack.Count > 0)
        return false;
    
    return true;                  
}