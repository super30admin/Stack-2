//TC - O(n) - n - no of functions
//SC - O(n) - n - no of functions

class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {

    Stack<Integer> stack = new Stack<>();

    int[] result = new int[n];

    int prevTime = 0;

    for(String log: logs){
      String[] logArr = log.split(":");

      int id = Integer.parseInt(logArr[0]);
      int currTime = Integer.parseInt(logArr[2]);

      if(logArr[1].equals("start")){

        if(!stack.isEmpty()){
          result[stack.peek()] += (currTime - prevTime);
        }
        stack.push(id);
        prevTime = currTime;
      }
      else{
        result[stack.peek()] += (currTime - prevTime +1);

        stack.pop();
        prevTime = currTime+1;
      }

    }

    return result;
  }


  public void print(int[] arr){

    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
  }
}
