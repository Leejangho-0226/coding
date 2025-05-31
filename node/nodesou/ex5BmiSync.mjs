// 키와 몸무게를 입력 받아 BMI 계산하기 : 동기 처리
// npm install readline-sync
import readlineSync from "readline-sync"; // 동기 입력 라이브러리


// BMI 판정 기준 함수
const getBmicategory = (bmi) => {
  if (bmi <= 18.5) return "저체중";
  if (bmi > 18.5 && bmi <= 23) return "정상";
  if (bmi > 23 && bmi <= 25) return "비만 전단계";
  if (bmi > 25 && bmi <= 30) return "1단계 비만";
  if (bmi > 30 && bmi <= 35) return "2단계 비만";
  return "3단계 비만";
};

console.log("🧮 BMI 계산기 (동기 처리)");
console.log("==================================\n");

// 키(height) 입력
console.log('📏 [키 입력]');
const height = readlineSync.question("▶ 키(cm) 입력 : ");
console.log(`✅ 입력한 키 : ${height} cm\n`);

// 몸무게(weight)입력
console.log('⚖️  [몸무게 입력]');
const weight = readlineSync.question("▶ 몸무게(kg) 입력 : ");
console.log(`✅ 입력한 몸무게 : ${weight} kg\n`);

console.log("📡 BMI 계산 시작 --------------------------------------------");

const heightMeters = parseFloat(height) / 100; // 키 문자열 → 실수 변환
const bmi = parseFloat(weight) / (heightMeters ** 2); // 몸무게 문자열 → 실수 변환

const result = getBmicategory(bmi);
console.log("\n📊 [BMI 결과]");
console.log(`🔢 BMI 수치   : ${bmi.toFixed(2)}`);
console.log(`🧍 체형 판정 : ${result}`);
console.log("----------------------------------------");

console.log("\n✅ 동기 처리 테스트 종료");
