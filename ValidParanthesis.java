//TC - O(N) - N is the length of string
//SC - O(N) - Size of stack - N is the length of string

class Solution {
  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();


    for(int i=0; i<s.length(); i++){
      char ch = s.charAt(i);


      if(ch == '('){
        stack.push(')');
      }
      else if(ch == '{'){
        stack.push('}');
      }
      else if(ch == '['){
        stack.push(']');
      }
      else{
        if(stack.isEmpty()){
          return false;
        }

        char closed = stack.pop();

        if(closed != ch){
          return false;
        }
      }
    }

    return (stack.isEmpty());

  }
}
