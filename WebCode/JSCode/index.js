// // Math内置对象的常用属性
// console.log(Math.PI) // 圆周率
// console.log(Math.E) // 自然对数的底数

// Math内置对象的常用方法
// console.log(Math.abs(-5)) // 绝对值
// console.log(Math.ceil(4.1)) // 向上取整
// console.log(Math.floor(4.9)) // 向下取整
// console.log(Math.round(4.5)) // 四舍五入
// console.log(Math.max(1, 2, 3)) // 最大值
// console.log(Math.min(1, 2, 3)) // 最小值
// console.log(Math.random()) // 生成0-1之间的随机数
// console.log(Math.sqrt(16)) // 平方根
// console.log(Math.pow(2, 3)) // 2的3次方


// 生成任意范围的随机数
function getRandomInRange(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

console.log(getRandomInRange(1, 10)) // 生成1到10之间的随机整数

