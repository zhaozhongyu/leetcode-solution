  /**
   * @param {number[]} g
   * @param {number[]} s
   * @return {number}
   */
  var findContentChildren = function(g, s) {
      g.sort(function(a,b){return a-b});
      s.sort(function(a,b){return a-b});
      var num = 0;
      var index = 0;
      for(var i = 0; i < s.length; i++){
          if(g[index] <= s[i]) {
              index ++;
              num ++;
          }
      }
      return num;
  };
