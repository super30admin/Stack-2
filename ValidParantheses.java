// without hashmap
// TC: O(N)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for ( char c : s.toCharArray())
        {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c =='[')
                 stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;  
        }
        return stack.isEmpty();
    }
}

// with hashmap
// TC: O(N)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public boolean isValid(String s) {
//       HashMap<Character, Character> map = new HashMap<Character, Character>();
//       map.put(']', '[');
//       map.put('}', '{');
//       map.put(')', '(');
//       Stack<Character> stack = new Stack<Character>();
//       for ( char c : s.toCharArray())
//       {
//           if ( map.containsKey(c) && !stack.empty())
//           {
//               if (map.get(c) != stack.pop())
//                   return false;
//           }
//           else
//           {
//              stack.push(c);
//           }
//       }
//      return stack.isEmpty();
//     }
// }


// without stack - when only one type of brackets are given (Ex: round brackets only)
// TC: O(N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public boolean isValid(String s) {
        int openCount = 0;
        for ( char c : s.toCharArray())
        {
            if (c == '(')
              openCount++;
            else if (openCount == 0 && c == ')')
                return false;
            else
                openCount--;
        }
        return openCount == 0;
    }
}





