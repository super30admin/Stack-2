// Approach :  From the intution of brute force where we can have a count variable for each 
// Character and when you encounter opening increment and decrement when closing bracket and at 
// the end if the count ==0 then string isValid but to optimize we use stack to keep track of 
// last incoming character.
// Time : O(n) // traverse thie given string
// Space : O(n)  // worst case we end up pushing all the characters
class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> stk = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(')');
            } else if(ch =='{'){
                stk.push('}');
            } else if (ch == '['){
                stk.push(']');
            } else if (stk.isEmpty() || stk.pop()!=ch){
                return false;
            }
        }

        return stk.isEmpty();
        
    }
}