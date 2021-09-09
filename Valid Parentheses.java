class Solution {
    public boolean isValid(String st) {

        Stack<Character> s = new Stack<>();

        for(char c : st.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[') s.push(c);

            else if (c == ')' && !s.isEmpty()  && s.peek() == '(') s.pop();

            else if (c == '}' && !s.isEmpty()  && s.peek() == '{') s.pop();

            else if (c == ']' && !s.isEmpty()  && s.peek() == '[') s.pop();

            else return false;
        }

        return s.isEmpty();

    }
}
