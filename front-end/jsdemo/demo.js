class Polygon {
    constructor(lens) {
        for (var i = 0; i < lens.length; i++) {
            this[i] = lens[i];
        }
    }

    perimeter(){
        var perimeter = 0;
        for(var p in this){
            perimeter += this[p];
        }
        return perimeter;
    }
}

const rectangle = new Polygon([10, 20, 10, 20]);
const square = new Polygon([10, 10, 10, 10]);
const pentagon = new Polygon([10, 20, 30, 40, 43]);

console.log(rectangle.perimeter());
console.log(square.perimeter());
console.log(pentagon.perimeter());