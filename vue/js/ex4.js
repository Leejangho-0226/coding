document.addEventListener("DOMContentLoaded", function () {
  const { createApp, ref } = Vue; // ref : 반응형(지능형) 데이터 생성을 위한 함수
  // ref()는 Vue 3의 Composition API에서 기본형 데이터(String, Number, Array 등)에 반응성을 부여함
  // 즉, 값이 바뀌면 화면도 자동으로 다시 렌더링됨 (반응형)

  createApp({
    setup() {
      // 컴포넌트의 초기 상태와 로직을 설정
      // setup()은 Composition API에서 사용되는 함수로, 컴포넌트가 생성될 때 가장 먼저 실행됨
      // 이 안에서 변수(ref, reactive), 함수, 계산된 속성(computed) 등을 선언하고 리턴함

      const bookList = ref([
        // ref로 감싸져 있으면 반응형 데이터로 동작함
        // ref([])는 배열을 감싼 반응형 객체가 되어 화면과 자동으로 연결됨
        // bookList.value로 실제 배열에 접근/수정 가능 (JS 내부에서는 .value 필요)
        { name: "자바 뽀개버리기", price: 25000 },
        { name: "MariaDB 찢어버리기", price: 36000 },
        { name: "코뿔소 JS 뿔 부셔버리기", price: 45000 },
        { name: "React 완전 정복", price: 20000 },
        { name: "Vue 박살내기", price: 22000 },
      ]);

      const selectedBooks = ref([]); // 사용자가 선택한 책목록을 저장하는 배열
      // 예: 체크박스로 선택한 책을 이 배열에 push 하거나 제거할 수 있음
      // ref([])로 선언했으므로 반응형이고, .value를 통해 조작 가능

      return {
        bookList, // 전체 책 목록 (template 쪽에서 v-for 등으로 접근할 수 있게 반환)
        selectedBooks, // 선택된 책 목록 (template에서 출력하거나 합계 계산 등에 사용 가능)
      };
    },
  }).mount("#app"); // 해당 Vue 앱을 HTML 문서 내 id="app" 요소에 연결하여 작동시킴
});
