var a = 5;
var b = 10;

function foo(strings, ...values) {
    let a = values[0];
    let b = values[1];

    return `Sum ${a + b}
Product ${a * b} 
Division ${b / a}`;
}

console.log(foo`Num0 ${a + 10}
Num1 ${b * 2} 
Num2 ${b / a}`);