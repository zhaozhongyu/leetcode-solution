// 返回一个函数, 根据入队的顺序执行, 支持限制最大并发promise

function getMaxScheduler(max) {
  const run = []
  const scheduler = []
  return async (promiseFunc) => {
    if (run.length >= max) {
      return new Promise((resolve) => {
        scheduler.push(resolve);
      }).then((promiseFunc) => {
        return promiseFunc();
      })
    } else {
      run.push(promiseFunc);
      const ret = await promiseFunc();
      run.splice(run.indexOf(promiseFunc), 1);
      if (scheduler.length) {
        const func = scheduler.shift();
        func && func();
      }
      return ret;
    }
  }
}

// 极简eventEmiter, 使用promise来通知
class eventEmiter {
  
}