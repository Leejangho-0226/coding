// Gugudan.js

export default {
  data() {
    return {
      inputNumber: '', // 사용자 입력 숫자
      result: ''       // 구구단 결과 문자열
    };
  },
  methods: {
    // 구구단 계산 메서드
    calcGugudan() {
      const num = parseInt(this.inputNumber);
      if (!isNaN(num) && num > 0) {
        // 1부터 9까지 반복하며 문자열 생성, 줄바꿈은 <br> 태그로 처리
        this.result = Array.from({ length: 9 }, (_, i) =>
          `${num} x ${i + 1} = ${num * (i + 1)}`
        ).join('<br>');
      } else {
        this.result = "정확하게 숫자를 입력하세요";
      }
    }
  },
  // ✅ 템플릿 정의 (백틱 사용)
  template: `
    <div>
      <h2>📐 구구단</h2>
      단 입력 후 버튼 클릭<br/>
      <input v-model="inputNumber" type="number" min="2" placeholder="단 입력" />
      <button @click="calcGugudan">확인</button>
      <br>
      <div v-html="result" style="margin-top:10px;"></div>
    </div>
  `
};
