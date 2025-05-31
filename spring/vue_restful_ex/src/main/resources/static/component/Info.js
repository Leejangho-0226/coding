const Info = {
  data() {
    return {
      deptList: [],
      error: ''
    };
  },
  created() {
    axios.get('/dept')
      .then(res => this.deptList = res.data)
      .catch(() => this.error = '❌ 서버 오류');
  },
  template: `
    <div class="card">
      <div class="card-header">📋 부서 목록</div>
      <div class="card-body">
        <div v-if="error" class="alert alert-danger">{{ error }}</div>
        <table class="table" v-else>
          <thead>
            <tr>
              <th>부서번호</th>
              <th>부서명</th>
              <th>지역</th>
              <th>전화</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="d in deptList" :key="d.buserno">
              <td>{{ d.buserno }}</td>
              <td>{{ d.busername }}</td>
              <td>{{ d.buserloc }}</td>
              <td>{{ d.busertel }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  `
};