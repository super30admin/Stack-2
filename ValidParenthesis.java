class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public boolean isValid(String s) {
        
        Stack<Character> so = new Stack<>();

        for (int i =0;i < s.length();i++){
            char c = s.charAt(i);
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            so.push(s.charAt(i));
            else {
                if (so.isEmpty())
                return false;
                switch (c){
                case ')':
                if (so.pop() != '(')
                return false;
                break;
                 case ']':
                if (so.pop() != '[')
                return false;
                break;
                 case '}':
                if (so.pop() != '{')
                return false;
                break;
                
                }
            }


        }
        return so.isEmpty();
    }
}                                    
