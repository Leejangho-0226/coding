document.addEventListener("DOMContentLoaded", function () {
  const { createApp } = Vue;

  createApp({
    data() {
      // Vue에서 사용할 정보들을 저장해둠
      return {
        message1: "Hello Vue",
        message2: "안녕!" + "반가워",
        message3: Math.random() * 9,
      };
    },

    methods: {
      updateMessage() {
        this.message1 = "update hello";
        this.message2 = "버튼을 클릭함";
        this.message3 = Math.random() * 9;
      },
    },
    
    // 생명 주기 관련 메소드(Hooks) 확인
    beforeCreate() {
      // 초기화
      console.log("beforeCreate");
    },
    created() {
      // 화면에 반응성 주입입
      console.log("created");
    },
    mounted() {
      // 속성값 대입입
      console.log("mounted");
    },
    beforeUpdate() {
      // 인스턴스의 데이터 변경
      console.log("beforeUpdate");
    },
    updated() {
      // 화면 랜더링 및 데이터 갱신
      console.log("updated");
    },
    beforeUnmount() {
      // 마무리 단계계
      console.log("beforeUnmount");
    },
    // 만약 unmounted() 도 추가하고 싶다면 아래처럼 쓸 수 있어
    // unmounted() {
    //   console.log("unmounted");
    // }

  }).mount("#app2");
});
