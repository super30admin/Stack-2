// Time Complexity : O(n), where n is the size of the String
// Space Complexity :O(n), where n is the size of the String (size for the stack, hashmap size is constant space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. Put all the 3 different parentheses in a hashMap with closing parentheses as the key and its corresponding opening parentheses
        //as the value
//2. Maintain a Stack (to only put the opening parentheses). Iterate over the input String and for every charcter check if it is a
        //opening parentheses (if, yes push it in the stack) Else, if stack is empty(it is a closing parentheses without any opening
        //  parentheses) OR  its value in the hashmap doesnot match with the opening parentheses at the stack top Return False
        //Else if it is valid Parentheses pair pop it from the stack
//3. In the end if stack is not Empty (unequal number of opening and closing parentheses) return false.
     //If everything goes well, in the end return TRUE

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        //create a hashMap to store parentheses
        Map<Character, Character> hMap = new HashMap<>();
        //put the 3 types of different parentheses in the map
        hMap.put(')', '(');
        hMap.put('}', '{');
        hMap.put(']', '[');
        
        //stack to maintain the order of the parentheses
        Stack<Character> st = new Stack<>();
        //iterate over the input string
        for(int i=0; i<s.length(); i++){
            //get the current charcter
            char c = s.charAt(i);
            if(hMap.containsKey(c)){//closing parentheses
                if(st.isEmpty() || st.peek() != hMap.get(c)) return false; //invalid
                //opening and closing parenthesis are valid
                st.pop();
            }else{//opening parenthese
                st.push(c);
            }
        }
        //not equal number of closing and opening parentheses
        if(!st.isEmpty()) return false;
        return true;
    }
}