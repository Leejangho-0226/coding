export async function getWeatherData() {
  const url = "https://api.open-meteo.com/v1/forecast?latitude=37.5172&longitude=127.0473&current_weather=true";
  const response = await fetch(url);
  const json = await response.json();
  const data = json.current_weather;

  return {
    time: data.time,
    temperature: data.temperature,
    windspeed: data.windspeed,
    winddirection: data.winddirection
  };
}
