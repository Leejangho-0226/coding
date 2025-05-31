// figlet 모듈을 가져옴
import figlet from "figlet";

// figlet 함수로 텍스트를 아스키 아트로 변환
figlet('Node manmanse!', function(err, data) {
  if (err) {
    console.log('❌ something went wrong:', err);  // 에러 발생 시 출력
    return;
  }
  console.log(data); // 성공 시 변환된 아스키 아트 출력
});
