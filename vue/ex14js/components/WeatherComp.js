export default {
  template: `
    <div class="page-wrapper">
      <h2 class="home-title">날씨 정보</h2>

      <button @click="loadWeather">날씨정보 읽기</button>

      <div v-if="weather">
        <p>예보시간 : {{ weather.time }}</p>
        <p>온도 : {{ weather.temperature }} ℃</p>
        <p>풍속 : {{ weather.windspeed }} m/s</p>
        <p>풍향 : {{ weather.winddirection }} °</p>
      </div>
    </div>
  `,
  data() {
    return {
      weather: null
    };
  },
  methods: {
    loadWeather() {
      import('../weather.js').then(mod => {
        mod.getWeatherData().then(data => {
          this.weather = data;
        });
      });
    }
  }
}
