// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    if(n == 0) return new int[]{};
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    int prev = 0;
    int cur = 0;
    for(String log: logs) {
      String[] strArray = log.split(":");
      cur = Integer.parseInt(strArray[2]);
      if(strArray[1].equals("start")) {
        if(!stack.isEmpty()) {
          result[stack.peek()] += cur-prev;
        }
        stack.push(Integer.parseInt(strArray[0]));
        prev = cur;
      } else {
        result[stack.pop()] += cur+1-prev;
        prev = cur+1;
      }
    }
    return result;
  }
}