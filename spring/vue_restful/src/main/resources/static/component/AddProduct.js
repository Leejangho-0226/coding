export default {
  data() {
    return {
      newProduct: {
        code: '',
        name: '',
        description: '',
        price: '',
        image: ''
      },
      error: null
    };
  },
  methods: {
    async insertProduct() {
      if (!this.newProduct.code || !this.newProduct.name) {
        alert("제품 코드와 이름은 필수입니다.");
        return;
      }

      try {
        await axios.post("http://localhost/products", this.newProduct);
        alert("등록 성공!");
        this.$router.push('/products');
      } catch (err) {
        this.error = "등록 실패! 서버 오류가 발생했습니다.";
      }
    },
    resetForm() {
      this.newProduct = { code: '', name: '', description: '', price: '', image: '' };
      this.$router.push('/products');
    }
  },
  template: `
    <div style="padding: 40px;">
      <h2 style="text-align: center; color: #f0c674;">➕ 제품 등록</h2>

      <div v-if="error" style="color: red; text-align: center; margin-bottom: 20px;">{{ error }}</div>

      <div style="background-color: #2a2a2a; padding: 20px; border-radius: 8px; max-width: 800px; margin: auto;">
        <div style="display: flex; flex-wrap: wrap; gap: 10px; justify-content: center;">
          <input v-model="newProduct.code" placeholder="제품 코드" style="padding: 10px; width: 48%; border-radius: 5px; border: none;" />
          <input v-model="newProduct.name" placeholder="제품명" style="padding: 10px; width: 48%; border-radius: 5px; border: none;" />
          <input v-model="newProduct.description" placeholder="제품 설명" style="padding: 10px; width: 48%; border-radius: 5px; border: none;" />
          <input v-model="newProduct.price" placeholder="가격 (숫자만)" style="padding: 10px; width: 48%; border-radius: 5px; border: none;" />
          <input v-model="newProduct.image" placeholder="이미지 URL" style="padding: 10px; width: 48%; border-radius: 5px; border: none;" />
        </div>

        <div style="text-align: center; margin-top: 20px;">
          <button @click="insertProduct" style="padding: 10px 20px; background-color: #28a745; color: white; border: none; border-radius: 5px;">등록</button>
          <button @click="resetForm" style="padding: 10px 20px; margin-left: 10px; background-color: #6c757d; color: white; border: none; border-radius: 5px;">취소</button>
        </div>
      </div>
    </div>
  `
};
