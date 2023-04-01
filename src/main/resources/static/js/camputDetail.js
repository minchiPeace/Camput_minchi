
window.scrollTo({ left: 0, top: 0, behavior: "smooth" });
// 메뉴
$(function(){
    $(".menuBtn>li").mouseover(function(){
        $(this).children(".miniMenu").stop().slideDown();
    });
    $(".menuBtn>li").mouseout(function(){
        $(this).children(".miniMenu").stop().slideUp();
    });
}) // 메뉴

// 화면 슬라이딩 (예약,리뷰)
$(function(){
    // 각각 목록 내려오기
    $(".slideBtn>a").click(function(){
        $(this).children(".openBooking").stop().slideDown();
    });
    $(".slideBtn>a").click(function(){
        $(this).children(".openBooking").stop().slideUp();
    });
    $("#stars").click(function (event) {
        document.querySelector(`.star span`).style.width = `${event.target.value * 20}%`;
    })
}); // 화면슬라이딩(예약,리뷰)

// 모달 창 나오게 만들기 var.4
$( document ).ready(function() {
    $('#open_modal').click(function() {
        $('#modal').show();
    });
    // 모달 창 외의 다른 곳 클릭하면 다시 없어짐.
    $(window).on('click', function() {
        if (event.target == $('#modal').get(0)) {
            $('#modal').hide();
        }
    });
    // x 버튼 클릭하면 삭제됨.
    $('.modal_close').click(function() {
        $('#modal').hide();
    });
});

$(function(){
// 리뷰 쓰기 전송 폼
$(".sub_btn").click(function () {
    console.log("submit")
    $.ajax({
        type: "POST",
        url: "/camput/reviews/insert",
        // contentType: "application/json",
        data: $("#re_postForm").serialize(),
        success: function(data) {
            console.log("성공했습니다.");
            location.reload();
        },
        error: function(error) {
            console.log(error);
        }
    });
});
})



