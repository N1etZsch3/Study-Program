const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let min = 1;
let max = 10;

function main() {
    const randomNumber = getRandomNumber(min, max);
    askQuestion(randomNumber);
}

function getRandomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}


function askQuestion(randomNumber) {
    rl.question(`请输入一个${min}-${max}之间的数字: `, (userInput) => {
        // 将输入转换为数字
        const num = parseInt(userInput);

        if (isNaN(num)) {
            console.log('请输入有效的数字！');
            askQuestion(randomNumber); // 重新提问
            return;
        }

        if (num > randomNumber) {
            console.log("猜大了");
            askQuestion(randomNumber); // 继续猜
        } else if (num < randomNumber) {
            console.log("猜小了");
            askQuestion(randomNumber); // 继续猜
        } else {
            console.log("猜对了");
            rl.close(); // 关闭readline接口
        }
    });
}

main();