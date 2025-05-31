// 키보드로 단을 입력 받아 구구단 출력 (이벤트 방식)

import { EventEmitter } from "events"; // 이벤트 시스템을 위한 모듈
import readline from "readline";       // 키보드 입력을 받기 위한 모듈

const myEvent = new EventEmitter();    // EventEmitter 인스턴스 생성

// readline 인터페이스 생성 (키보드 입력)
const inout = readline.createInterface({
  input: process.stdin,    // 표준 입력
  output: process.stdout   // 표준 출력
});

//  구구단 출력 함수 (입력 받은 단을 받아서 출력함)
const printGugudan = (dan) => {
  console.log(`\n 구구단 ${dan}단`);
  console.log("======================");
  for (let i = 1; i <= 9; i++) {
    console.log(`${dan} x ${i} = ${dan * i}`);
  }
  console.log("======================");
};

//  이벤트 등록: 'guguevent' 이벤트 발생 시 printGugudan 실행
myEvent.on("guguevent", (dan) => {
  printGugudan(dan);   // 구구단 출력 함수 호출
  inout.close();        // 입력 종료
});

// 사용자로부터 단 입력받기
inout.question("출력할 단은 : ", (input) => {
  const dan = parseInt(input, 10); // 입력값을 정수로 변환
  if (!isNaN(dan) && dan >= 1 && dan <= 9) {
      myEvent.emit("guguevent", dan); // 이벤트 발생 → 'guguevent' 이벤트 핸들러 실행
    } else {
        console.log("숫자만 입력 가능합니당");
        inout.close();
  }
});
