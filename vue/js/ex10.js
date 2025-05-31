const { createApp } = Vue;

createApp({
  data() {
    return {
      name: '',
      java: 0,
      react: 0,
      vue: 0,
      people: [] 
    };
  },
  computed: { //people 배열이 바뀌지 않으면 값을 재계산하지 않음, 화면 최적화에 유리함 (성능 향상) => methods 불가
    totalScore() {
      return this.people.reduce((sum, p) => sum + p.total, 0);
    }
  },
  methods: {
    addScore() {
      if (this.name.trim() === '' || isNaN(this.java) || isNaN(this.react) || isNaN(this.vue)) {
        alert("모든 값을 정확히 입력하세요.");
        return;
      }

      const total = this.java + this.react + this.vue;

      this.people.push({//배열에 새 값을 끝에 추가하는 함수
        name: this.name,
        java: this.java,
        react: this.react,
        vue: this.vue,
        total: total
      });

      
      this.name = '';
      this.java = 0;
      this.react = 0;
      this.vue = 0;
    }
  }
}).mount('#app');
