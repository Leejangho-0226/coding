console.log("vsc에서 실습");

function f1(){
    console.log("hello1");
    f2();
}

function f2(){
    console.log("world");
}

f1();
console.log("end");
