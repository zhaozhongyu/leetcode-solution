var nthSuperUglyNumber = function(n, primes) {
  const dp = new Array(n + 1).fill(0);
  const m = primes.length;
  const pointers = new Array(m).fill(0);
  const nums = new Array(m).fill(1);
  for (let i = 1; i <= n; i++) {
      let minNum = Math.min(...nums);
      dp[i] = minNum;
      for (let j = 0; j < m; j++) {
        if (nums[j] == minNum) {
          console.warn('# pointers', j, pointers);
            pointers[j]++;
            nums[j] = dp[pointers[j]] * primes[j];
        }
      }
  }
  return dp[n];
};

nthSuperUglyNumber(12, [2,7,13,19])