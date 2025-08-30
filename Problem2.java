class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()==0)
        {
            return true;
        }

        Stack<Character> storage = new Stack<>();
        for(int i = 0 ; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='('){
                storage.push(')');
            }

            else if(c == '{'){
                storage.push('}');
            }

            else if(c == '['){
                storage.push(']');
            }

            else {
                if(storage.isEmpty() || c != storage.peek()){
                return false;
            }
            storage.pop();
            }

        }
        return storage.isEmpty();
    }
}
