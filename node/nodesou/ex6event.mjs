// 이벤트 처리  
// events 모듈 사용 EventEmitter 객체로 이벤트와 핸들러를 연결 - 동기적으로 호출

import { EventEmitter } from 'events';  // ESM 방식 import

const myEvent = new EventEmitter();

myEvent.addListener('event1', () => { // addListener(이벤트명, 콜백). on()과 같은 기능
  console.log('event1 이벤트 발생!'); // 이벤트 발생 시 실행할 동작
});

myEvent.on('event2', () => { 
  console.log('event2 이벤트 발생!'); 
});

myEvent.on('event2', () => { 
  console.log('event2 이벤트 추가'); 
});

myEvent.once('event3', () => {  // 1회만 호출됨
  console.log('event3 이벤트 발생!'); 
});

// 이벤트 발생시키기 (emit)
myEvent.emit('event1'); // event1이라는 이름의 이벤트를 발생시키는 메소드
myEvent.emit('event2'); 
myEvent.emit('event3');  // 1회만 호출되니까 하나만 나온다
myEvent.emit('event3');

console.log('-------------------------------------------')
myEvent.on('event4', () => {  //둘은 같음 myEvent.addListener('event1', () => {
  console.log('event4 이벤트 발생!'); 
});
myEvent.emit('event4');
myEvent.removeAllListeners('event4'); // 이벤트 해제
myEvent.emit('event4'); // 실행 안됨

// 이벤트 등록을 별도 핸드들러 작성 후 등록해도 됨
const hiListener = () => { // 이벤트 핸들러 별도 작성
    console.log("안녕");
}

myEvent.on('event5', hiListener); // 이벤트 등록 방법2 : 이벤트 핸들러 작성 후 등록
myEvent.emit('event5');
console.log('event5 리스너 수:', myEvent.listenerCount('event5'));
myEvent.off('event5', hiListener); // 이벤트 등록 해제
myEvent.emit('event5');

console.log("\n이벤트 호출 시 메개변수 전달");
// const myEvent2 = new EventEmitter();
class myEmitter extends EventEmitter{};
const myEvent2 = new myEmitter();

myEvent2.on('event', () => { 
  console.log("이벤트 만만세");
});
myEvent2.emit("event");

const myEvent3 = new myEmitter();
myEvent3.on("eventok", (a,b) =>{
    console.log(a, '', b);
});
myEvent3.emit("eventok", '이장호', '화이팅');


