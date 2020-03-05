/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    var num = 0;
    for(var i = 0; i < grid.length; i++){
        for (var j = 0; j < grid[0].length; j++){
            if(grid[i][j] === 1){
                num += 4;
                if(i > 0 && grid[i-1][j] === 1){
                    num --;
                }
                if(i < grid.length-1 && grid[i+1][j] ===1){
                    num--;
                }
                if(j > 0 && grid[i][j-1] ===1){
                    num--;
                }
                if(j < grid[0].length-1 && grid[i][j+1] ===1){
                    num--;
                }
                
            }
        }
    }
    return num;
};
