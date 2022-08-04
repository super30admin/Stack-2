// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {

    // static map for mapping each open paranthesis to its complementary closed one
    private static final Map<Character, Character> hm = Map.of('(',')','{','}','[',']');

    public boolean isValid(String s) {

        //to remember the last open paranthesis encountered
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {

            //if c is an open one, it will be in the map as a key, we push it into the stack
            if(hm.containsKey(c))
               stack.push(c);

            else //c is a closed one
            {
                //edge case - there are no open ones, stack is empty
                if(stack.isEmpty())
                    return false;

                //get the last seen open one from the stack and try to match it with this closed one
                char open = stack.pop();

                if(c!=hm.get(open)) //did not match
                    return false;
            }

        }
        //if stack is still not empty(return false), there is an unmatched open one left
        //will return true if all open ones are matched
        return stack.isEmpty();

    }
}
