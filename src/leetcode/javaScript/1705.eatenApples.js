/**
 * @param {number[]} apples
 * @param {number[]} days
 * @return {number}
 * 每次都吃离腐烂日期最短的那个
 */
var eatenApples = function (apples, days) {
  let eat = 0;
  let current = 0;
  let map = {}; // 第i天过期的苹果数
  let maxDay = 0;
  do {
    let apple = apples[current] || 0;
    let day = days[current] || 0;
    map[current + day] = (map[current + day] || 0) + apple;
    maxDay = Math.max(maxDay, current + day);
    // 当天吃的苹果
    for (let i = current + 1; i <= maxDay; i++) {
      if (map[i]) {
        map[i]--;
        eat++;
        break;
      }
    }
    current++;
    if (current > maxDay && current > apples.length) {
      break;
    }
  } while (true);
  return eat;
};

console.warn(eatenApples([3,0,0,0,0,2], [3,0,0,0,0,2]));