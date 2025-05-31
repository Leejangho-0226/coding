// ✅ View.js - 부서별 그룹화, 사번순 정렬, 인원수 표시
const View = {
  data() {
    return {
      groupedData: {}, // 부서별 직원 리스트
      counts: {},      // 부서별 인원수
      error: ''
    };
  },
  created() {
    this.fetchGroupedEmployees();
  },
  methods: {
    fetchGroupedEmployees() {
      axios.get('/dept/all-jikwon-grouped')
        .then(res => {
          const raw = res.data;
          const group = {}; // 부서명 기준 그룹화
          const countMap = {}; // 부서명 기준 인원수 계산

          raw.forEach(j => {
            if (!group[j.busername]) {
              group[j.busername] = [];
              countMap[j.busername] = 0;
            }
            group[j.busername].push(j);
            countMap[j.busername]++;
          });

          // 각 부서별 사번순 정렬
          Object.keys(group).forEach(k => {
            group[k].sort((a, b) => a.jikwonno - b.jikwonno);
          });

          this.groupedData = group;
          this.counts = countMap;
          this.error = '';
        })
        .catch(() => {
          this.error = '❌ 전체 직원 조회 실패';
          this.groupedData = {};
          this.counts = {};
        });
    }
  },
  template: `
    <div class="card">
      <div class="card-header">👥 전체 직원 목록 (부서별)</div>
      <div class="card-body">
        <div v-if="error" class="alert alert-danger">{{ error }}</div>
        <div v-else>
          <div v-for="(list, buser) in groupedData" :key="buser" class="mb-4">
            <h5 class="text-primary">📌 {{ buser }} ({{ counts[buser] }}명)</h5>
            <table class="table">
              <thead>
                <tr>
                  <th>사번</th>
                  <th>직원명</th>
                  <th>직급</th>
                  <th>부서</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="j in list" :key="j.jikwonno">
                  <td>{{ j.jikwonno }}</td>
                  <td>{{ j.jikwonname }}</td>
                  <td>{{ j.jikwonjik }}</td>
                  <td>{{ j.busername }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  `
};
