import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class problem1 {

    //Time Complexity: O(1)
    // Space Complexity: O(n)

    class PhoneDirectory {

        HashSet<Integer> set;
        Queue<Integer> queue;
        public PhoneDirectory(int maxNumbers) {
            set = new HashSet<>();
            queue = new LinkedList<>();

            for (int i = 0; i < maxNumbers; i++) {
                set.add(i);
                queue.add(i);
            }
        }
        public int get(){
            if (queue.isEmpty()) {
                return -1;
            }
            int number = queue.poll();
            set.remove(number);
            return number;
        }

        public boolean check(int num)
        {
            return set.contains(num);
        }

        public void release(int num){
            if (set.contains(num)) {
                return;
            }
            set.add(num);
            queue.add(num);
        }

    }
}
