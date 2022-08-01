class Solution {
    public boolean isValid(String s) {

        if(s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack();

       for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '{' || current == '[')
                stack.push(current);

            else if (stack.isEmpty())
                return false;

            else if (current == ')' && stack.pop() != '(')
                return false;

            else if (current == ']' && stack.pop() != '[')
                return false;

            else if (current == '}' && stack.pop() != '{')
                return false;
        }

        return stack.isEmpty();
    }
} 