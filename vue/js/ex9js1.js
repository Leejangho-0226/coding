(function(){

    const {createApp} = Vue;
    
    createApp({
        data() {
            return {
                key1:'값1',
                key2:'값2',
                message:'좀만 버텨',
                htmlString:'<p style="color:blue;">파란 하늘</p>',
                su1:'0',
                su2:'0',
                txtMsg:'',
                daumLogo:'https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F003%2F2025%2F01%2F07%2FNISI20250107_0020653564_web_20250107120342_20250107120628332.jpg&type=a340',
    
            }
        },
        methods:{
            myFunc(){
                console.log("버튼 클릭하면 ", this.message)
            },
            myChange1(){
                this.message = "못 버티겠어";
            },
            myChange2(){
                this.message = "집에 갈래?";
            }
        } 
    }).mount("#app");
})();    