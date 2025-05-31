// 키와 몸무게를 입력 받아 BMI계산하기 : 비동기 처리
import readline from "readline";

// BMI 판정 기준 함수
const getBmicategory = (bmi) => {
  if (bmi <= 18.5) return "저체중";
  if (bmi >= 18.5 && bmi <= 23) return "정상";
  if (bmi >= 23 && bmi <= 25) return "비만 전단계";
  if (bmi >= 25 && bmi <= 30) return "1단계 비만";
  if (bmi >= 30 && bmi <= 35) return "2단계 비만만";
  return "3단계 비만";
};

// 표준 입출력 장치 선언
const rdat = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

console.log("비동기 처리 시작 --------------------------------------------");

rdat.question("키(cm)를 입력하세요: ", (height) => {
  rdat.question("몸무게(kg)를 입력하세요: ", (weight) => {
    console.log(`키: ${height}cm, 몸무게: ${weight}kg`);

    const heightMeters = parseFloat(height) / 100; // 키 문자열 → 실수 변환
    const bmi = parseFloat(weight) / heightMeters ** 2; // 몸무게 문자열 → 실수 변환

    const result = getBmicategory(bmi);
    console.log(`BMI 결과는 : ${bmi.toFixed(2)}, 체형: ${result}`);
    rdat.close();  // 입력 인터페이스 닫기
  });
});

console.log('\n비동기 테스트');
