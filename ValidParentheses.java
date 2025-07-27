// Time complexity - O(n)
// Space - O(n)
// solved on leetcod e- yes
// faced any issues - no
// whne we get open parentesis we add in stack, else we remove an element from stack and check if it's equal or not
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(Character c: s.toCharArray()) {
            if(c == '(' || c== '[' || c== '{') {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && stack.peek() == map.get(c)) 
                    stack.pop();
                else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
