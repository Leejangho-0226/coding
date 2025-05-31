const Edit = {
  data() {
    return {
      id: '', name: '', loc: '', tel: '',
      message: '', messageType: ''
    };
  },
  methods: {
    fetchDept() {
      if (!this.id) {
        this.message = '⚠️ 부서번호를 입력해주세요.';
        this.messageType = 'danger';
        return;
      }
      axios.get(`/dept/${this.id}`)
        .then(res => {
          const d = res.data;
          this.name = d.busername;
          this.loc = d.buserloc;
          this.tel = d.busertel;
          this.message = '';
        })
        .catch(() => {
          this.message = '❌ 해당 부서를 찾을 수 없습니다.';
          this.messageType = 'danger';
        });
    },
    updateDept() {
      if (!this.name || !this.loc || !this.tel) {
        this.message = '⚠️ 모든 정보를 입력해주세요.';
        this.messageType = 'danger';
        return;
      }
      if (!confirm('정말 수정할까요?')) return;
      axios.put(`/dept/${this.id}`, {
        busername: this.name,
        buserloc: this.loc,
        busertel: this.tel
      })
      .then(() => {
        this.message = '✅ 수정 완료';
        this.messageType = 'success';
      })
      .catch(() => {
        this.message = '❌ 수정 실패';
        this.messageType = 'danger';
      });
    },
    deleteDept() {
      if (!this.id) {
        this.message = '⚠️ 부서번호를 입력해주세요.';
        this.messageType = 'danger';
        return;
      }
      if (!confirm('정말 삭제할까요?')) return;
      axios.delete(`/dept/${this.id}`)
        .then(() => {
          this.message = '✅ 삭제 완료';
          this.messageType = 'success';
          this.id = this.name = this.loc = this.tel = '';
        })
        .catch(() => {
          this.message = '❌ 삭제 실패';
          this.messageType = 'danger';
        });
    }
  },
  template: `
    <div class="card">
      <div class="card-header">✏️ 부서 수정/삭제</div>
      <div class="card-body">
        <div class="mb-3">
          <label class="form-label">부서번호</label>
          <input v-model="id" class="form-control" />
          <button @click="fetchDept" class="btn btn-secondary mt-2">조회</button>
        </div>
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
        <button @click="updateDept" class="btn btn-primary me-2">수정</button>
        <button @click="deleteDept" class="btn btn-danger">삭제</button>
        <div v-if="message" class="alert mt-3" :class="'alert-' + messageType">
          {{ message }}
        </div>
      </div>
    </div>
  `
};