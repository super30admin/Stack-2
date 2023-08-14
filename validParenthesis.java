class Solution {
    public boolean isValid(String s) {
        Stack<Character> set = new Stack<>();
        char[] ch = s.toCharArray();
        
        for(int i=0; i< ch.length;i++){
            if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{'){
                set.push(ch[i]);
            }else{
                 if(ch[i] == ')'){
                    if(set.isEmpty() || set.pop() != '(') return false;
                 }if(ch[i] == ']'){
                    if(set.isEmpty() || set.pop() != '[') return false;
                 }if(ch[i] == '}'){
                    if(set.isEmpty() || set.pop() != '{') return false;
                 }
            }
        }
        return set.isEmpty();
    }
}
