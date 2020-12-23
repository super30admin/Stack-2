import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
	public int[] exclusiveTime(int n, List<String> logs) {

		if (logs == null || logs.size() == 0)
			return new int[0];

		int prev = 0;
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		for (String str : logs) {

			String[] arrSplit = str.split(":");
			int curr = Integer.parseInt(arrSplit[2]);

			if (arrSplit[1].equals("start")) {
				if (!st.isEmpty()) {
					result[st.peek()] += curr - prev;
					prev = curr;

				}
				st.push(Integer.parseInt(arrSplit[0]));

			} else {
				// end case
				result[st.pop()] += curr - prev + 1;
				prev = curr + 1;

			}

		}

		return result;

	}

	public static void main(String[] args) {
		ExclusiveTime tme = new ExclusiveTime();
		List<String> logs = new ArrayList<String>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");

		tme.exclusiveTime(2, logs);

	}
}
