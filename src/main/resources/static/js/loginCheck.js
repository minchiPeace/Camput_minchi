$(document).ready(function (){
    if(loginCheck!=null){
        console.log("login");
        $('.notLogin').hide();
        $('.Login').show();
    }else{
        console.log("notLogin");
        $('.notLogin').show();
        $('.Login').hide();
    }
});
