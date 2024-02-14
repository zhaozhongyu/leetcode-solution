/**
    本质上就是找后面比当前相等/更大的高度, 或者其次找后面的高度中最大的那个
 * @param {number[]} height
 * @return {number}
 */
    var trap = function(height) {
        const right_max = [];
        let res = 0;
        let max = 0;
        // 先找出右侧最大值
        for (let i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right_max[i] = max;
        }
        let left_max = 0;
        for (let i = 0; i < height.length; i++) {
            left_max = Math.max(left_max, height[i]);
            res += Math.min(left_max, right_max[i]) - height[i];
        }
        return res;
    };