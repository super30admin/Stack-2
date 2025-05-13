
//TC: O(n)
//Sc: O(n)
class ValidParanthesis {
  public boolean isValid(String s) {
      Stack<Character> ss=new Stack<>();
      int len=s.length();
      for(int i=0;i<len;i++){
          char ch = s.charAt(i);
          if(ch=='('){
              ss.push(')');
          }else if(ch=='{'){
              ss.push('}');
          }else if(ch=='['){
              ss.push(']');
          }else if(ss.isEmpty() ||  ch!=ss.pop()){
              return false;
          }
      }
      if(ss.empty())
          return true;
      return false;
  }
}