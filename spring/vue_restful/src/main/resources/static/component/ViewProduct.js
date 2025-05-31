export default {
  data() {
    return {
      products: [],
      error: null
    };
  },
  mounted() {
    this.fetchProducts();
  },
  methods: {
    // 전체 상품 목록 불러오기
    async fetchProducts() {
      try {
        const response = await axios.get("http://localhost/products");
        this.products = response.data;
      } catch (err) {
        this.error = "서버에서 데이터를 불러오지 못했습니다.";
      }
    },
    // 상품 삭제
    deleteProduct(code) {
      if (confirm(`정말 삭제할까요?`)) {
        axios.delete(`http://localhost/products/${code}`).then(() => this.fetchProducts());
      }
    },
    // 수정 버튼 클릭 시 수정 페이지로 이동
    editProduct(code) {
      this.$router.push(`/edit/${code}`);
    }
  },
  template: `
    <div style="padding: 40px;">
      <!-- 에러 메시지 -->
      <div v-if="error" style="color: red; margin-bottom: 20px;">{{ error }}</div>

      <!-- 제품 목록 테이블 -->
      <table class="table" style="width:90%; margin: 50px auto; color: white; border-collapse: collapse;">
        <thead style="background-color: #333;">
          <tr>
            <th style="padding: 10px;">코드</th>
            <th style="padding: 10px;">제품명</th>
            <th style="padding: 10px;">설명</th>
            <th style="padding: 10px;">가격</th>
            <th style="padding: 10px;">이미지</th>
            <th style="padding: 10px;">관리</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="p in products" :key="p.code" style="text-align: center; border-bottom: 1px solid #444;">
            <td>{{ p.code }}</td>
            <td>{{ p.name }}</td>
            <td>{{ p.description }}</td>
            <td>{{ p.price }}원</td>
            <td>
              <img :src="p.image || 'https://source.unsplash.com/80x50/?product'" width="80" />
            </td>
            <td>
              <button @click="editProduct(p.code)" style="margin-right: 5px;">수정</button>
              <button @click="deleteProduct(p.code)">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  `
};
