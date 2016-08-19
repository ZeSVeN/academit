var a = 2;
var b = 5;
var c = 2;

var d = b * b - 4 * a * c;

if (d < 0) {
    console.log("Нет корней");
} else {
    var x1 = ( -b - Math.sqrt(d)) / (2 * a);
    var x2 = ( -b + Math.sqrt(d)) / (2 * a);
    console.log(x1);
    console.log(x2);
}