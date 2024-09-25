import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> para = new Stack<>();
        Map<Character,Character> reverse = new HashMap<>();
        reverse.put(')','(');
        reverse.put('}','{');
        reverse.put(']','[');
        for(int i=0;i<s.length();i++){
        if(!reverse.keySet().contains(s.charAt(i))){
              para.push(s.charAt(i));

        }else{  if(para.isEmpty() || (para.pop() != reverse.get(s.charAt(i)))){
                       return false;
                }
        }
        }
        
        if(para.size() == 0){
            return true;
        }
        return false;
    }
}