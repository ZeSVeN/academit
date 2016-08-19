var list = [1, 3, 5, 8, 11, 20, -5, 2];
console.log(list);

list.sort(function(e1,e2){
    return e1 - e2;
});

var firstFiveNumber = list.slice(0,5);

console.log(firstFiveNumber);

var begin = list.length - 5;

var lastFiveNumber = list.slice(begin);

console.log(lastFiveNumber);

var evenSum = 0;

for (var i = 0; i < list.length ; ++i) {
    var even = list[i] % 2;
    if (even === 0) {
        evenSum += list[i];
    }
}
console.log(evenSum);

var numbers = [];
for (i = 1; i <= 100; ++i){
    numbers.push(i);
}

console.log(numbers);