class LogInfo {
  id: number;
  timestamp: number;
  isStart: boolean;

  constructor(id: number, timestamp: number, isStart: boolean) {
    this.id = id;
    this.timestamp = timestamp;
    this.isStart = isStart;
  }
}

function parseLog(log: string): LogInfo {
  let parts = log.split(":");
  return new LogInfo(
    Number.parseInt(parts[0]),
    Number.parseInt(parts[2]),
    parts[1] == "start"
  );
}

// Not the optimal one
function exclusiveTime(n: number, logs: string[]): number[] {
  let result: number[] = Array.from({ length: n });
  result.fill(0);
  let stack: LogInfo[] = [];

  for (const log of logs) {
    // o(n)
    let end = parseLog(log);
    if (end.isStart) {
      stack.push(end);
    } else if (stack.length > 0 && stack[stack.length - 1].id == end.id) {
      let start = stack.pop()!;
      let previousDiff = result[start.id];
      let diff = end.timestamp - start.timestamp + 1;
      result[start.id] += diff;

      // if (stack.length > 0) {
      //   stack[stack.length - 1].timestamp += previousDiff;
      //   stack[stack.length - 1].timestamp += diff;
      //   console.log(stack);
      // }
      for (let st of stack) {
        // Worst case this will become (n/2)^2
        st.timestamp += diff;
      }
    }
  }

  return result;
}

function exclusiveTime_optimize(n: number, logs: string[]): number[] {
  let result: number[] = Array.from({ length: n });
  result.fill(0);
  let stack: LogInfo[] = [];
  let prevTime: number = 0;

  for (const log of logs) {
    let info = parseLog(log);
    if (info.isStart) {
      if (stack.length > 0) {
        result[stack[stack.length - 1].id] += info.timestamp - prevTime;
      }
      stack.push(info);
    } else {
      info.timestamp += 1;
      result[info.id] += info.timestamp - prevTime;
      stack.pop();
    }
    prevTime = info.timestamp;
  }

  return result;
}

describe("636. Exclusive Time of Functions", () => {
  it("New Logic - 01", () => {
    expect(
      exclusiveTime(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"])
    ).toStrictEqual([3, 4]);
  });

  it("New Logic - 02", () => {
    expect(
      exclusiveTime(1, [
        "0:start:0",
        "0:start:1",
        "0:start:2",
        "0:end:3",
        "0:end:4",
        "0:end:5",
      ])
    ).toStrictEqual([6]);
  });

  it("Optimized Logic - 03", () => {
    expect(
      exclusiveTime_optimize(1, [
        "0:start:0",
        "0:start:2",
        "0:end:5",
        "0:start:6",
        "0:end:6",
        "0:end:7",
      ])
    ).toStrictEqual([8]);
  });

  it("Optimized Logic - 01", () => {
    expect(
      exclusiveTime_optimize(2, [
        "0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6",
      ])
    ).toStrictEqual([3, 4]);
  });

  it("Optimized Logic - 02", () => {
    expect(
      exclusiveTime_optimize(1, [
        "0:start:0",
        "0:start:1",
        "0:start:2",
        "0:end:3",
        "0:end:4",
        "0:end:5",
      ])
    ).toStrictEqual([6]);
  });

  it("New Logic - 03", () => {
    expect(
      exclusiveTime(1, [
        "0:start:0",
        "0:start:2",
        "0:end:5",
        "0:start:6",
        "0:end:6",
        "0:end:7",
      ])
    ).toStrictEqual([8]);
  });
});
