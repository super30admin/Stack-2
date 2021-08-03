class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {

                stack.add(c);

            } else {

                if (stack.isEmpty()) return false;

                char stackTop = stack.pop();

                if (!checkEquality(stackTop, c)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

    private boolean checkEquality(Character open, Character c) {

        if (open == '(' && c == ')') {
            return true;
        }

        if (open == '[' && c == ']') {
            return true;
        }

        if (open == '{' && c == '}') {
            return true;
        }

        return false;

    }
}