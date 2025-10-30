// Time complexity- O(m), where m is the number of log lines
// Space complexity- O(m)
function exclusiveTime(n: number, logs: string[]): number[] {
	const result: number[] = new Array(n).fill(0);
	let prev: number = 0; // time of last processed event
	const stack: number[] = [];

	for (let log of logs) {
		const logArr = log.split(":");
		const logId = Number(logArr[0]);
		const logType = logArr[1];
		const curr = Number(logArr[2]);

		if (logType === "start") {
			if (stack.length > 0) {
				// prev task paused, update the time consumed for last task in result array
				const topStackElement = stack[stack.length - 1];
				result[topStackElement] += curr - prev;
			}
			stack.push(logId);

			// update the prev to curr since curr is processed
			prev = curr;
		} else {
			const topStackElement = stack.pop()!;
			// since this is a log end line, the new task starts at curr + 1 time
			result[topStackElement] += curr + 1 - prev;
			// update the prev
			prev = curr + 1;
		}
	}

	return result;
}
