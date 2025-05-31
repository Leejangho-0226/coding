(function(){
    const { createApp } = Vue;

    createApp({
        data() {
            return {
                ypay: 5000,
                busers: [
                    { bunho: '10', irum: '총무부', junhwa: '111-1111' },
                    { bunho: '20', irum: '축구부', junhwa: '111-2222' },
                    { bunho: '30', irum: '야구부', junhwa: '111-3333' },
                    { bunho: '40', irum: '농구부', junhwa: '111-4444' }
                ],
                cssStyleTest: {
                    color: 'red',
                    fontSize: '10px'
                }
            };
        },
        methods: {
            enlargeFont() {
                this.cssStyleTest.fontSize = '30px'; // 글자 크기 변경
            }
        }
    }).mount("#app2");
})();
