export default {
  template: `
    <div class="page-wrapper">
      <h2 class="home-title">도서관 정보</h2>

      <button @click="loadFetch">fetch</button>
      <button @click="loadAxios">axios</button>

      <div v-if="libraries.length > 0">
        <div 
          class="library-card" 
          v-for="(lib, index) in libraries" 
          :key="index"
        >
          <p>도서관 이름 : {{ lib.LBRRY_NAME }}</p>
          <p>도서관 주소 : {{ lib.ADRES }}</p>
          <p :class="{ 'no-phone': !lib.TEL_NO }">
            도서관 전화 : {{ lib.TEL_NO || '정보 없음' }}
          </p>
        </div>
      </div>
    </div>
  `,
  data() {
    return {
      libraries: []
    };
  },
  methods: {
    loadFetch() {
      import('../fetchLibrary.js').then(mod => {
        mod.getLibraryData().then(data => {
          this.libraries = data;
        });
      });
    },
    loadAxios() {
      import('../axiosLibrary.js').then(mod => {
        mod.getLibraryData().then(data => {
          this.libraries = data;
        });
      });
    }
  }
}
