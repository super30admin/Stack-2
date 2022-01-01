class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);

            switch(c){
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='(')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}