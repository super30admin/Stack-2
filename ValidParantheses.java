// Time complexity : O(n)
// Space complexity : O(n)

import java.util.Stack;

class ValidParantheses {
    public static void main(String[] args) {
        String str = "({[({[]})]})";
        boolean result = isValid(str);
        System.out.println(result);
    }

    private static boolean isValid(String str) {
        if (str == null || str.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.add(c);
            else {
                if (stack.isEmpty())
                    return false;
                else if (!stack.isEmpty() && isMatching(stack.peek(), c) == false)
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char a, char b) {
        if ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'))
            return true;
        else
            return false;
    }
}