const Add = {
  data() {
    return {
      name: '',
      loc: '',
      tel: '',
      message: '',
      messageType: ''
    };
  },
  methods: {
    addDept() {
      if (!this.name || !this.loc || !this.tel) {
        this.message = '⚠️ 모든 정보를 입력해주세요.';
        this.messageType = 'danger';
        return;
      }
      axios.post('/dept', {
        busername: this.name,
        buserloc: this.loc,
        busertel: this.tel
      })
      .then(() => {
        this.message = '✅ 등록 완료';
        this.messageType = 'success';
        this.name = this.loc = this.tel = '';
      })
      .catch(() => {
        this.message = '❌ 등록 실패';
        this.messageType = 'danger';
      });
    }
  },
  template: `
    <div class="card">
      <div class="card-header">➕ 부서 추가</div>
      <div class="card-body">
        <div class="mb-3">
          <label class="form-label">부서명</label>
          <input v-model="name" class="form-control" />
        </div>
        <div class="mb-3">
          <label class="form-label">지역</label>
          <input v-model="loc" class="form-control" />
        </div>
        <div class="mb-3">
          <label class="form-label">전화</label>
          <input v-model="tel" class="form-control" />
        </div>
        <button @click="addDept" class="btn btn-primary">등록</button>
        <div v-if="message" class="alert mt-3" :class="'alert-' + messageType">
          {{ message }}
        </div>
      </div>
    </div>
  `
};