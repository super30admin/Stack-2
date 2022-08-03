class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> valid = new Stack();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '{' || i == '[')
                valid.push(i);
            else if (i == ')' && !valid.isEmpty() && valid.peek() == '(')
                valid.pop();
            else if (i == '}' && !valid.isEmpty() && valid.peek() == '{')
                valid.pop();
            else if (i == ']' && !valid.isEmpty() && valid.peek() == '[')
                valid.pop();
            else
                valid.push(i);
        }
        return valid.isEmpty();
    }
}
