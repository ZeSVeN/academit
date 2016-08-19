var a = 2;
var b = 4;
var c = 2;

var discriminant = b * b - 4 * a * c;

if (discriminant < 0) {

    console.log("Нет корней");

} else if (discriminant === 0){

    var x = -b / (2 * a);
    console.log(x);

} else {

    var x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
    var x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
    console.log(x1);
    console.log(x2);

}