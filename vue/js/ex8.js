document.addEventListener("DOMContentLoaded", function () {
  const { createApp } = Vue;

  createApp({
    data() {
      return {
        list: ['커피', '위스키', '맥주', '소주'],
        objArray: [
          { name: '강릉', taketime: '3시간' },
          { name: '부산', taketime: '4시간' },
          { name: '강원도', taketime: '2시간' },
        ],
        myArr: ['일', '이', '삼', '사', '오'],
        numArr: [1, 2, 3, 4, 5],
      };
    },
    methods: {
      addList() {
        this.myArr.push('추가'); // 맨 뒤에 추가
      },
      addListIndex(para) {
        this.myArr.splice(para, 0, '추가자료'); // 특정 위치(para)에 삽입
      },
      changeList(para) {
        this.myArr.splice(para, 1, '수정'); // 특정 위치 값 변경
      },
      deleteList(para) {
        this.myArr.splice(para, 1); // 마지막 요소 제거
      },
    },
  }).mount("#app");
});
