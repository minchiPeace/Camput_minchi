
console.log(noPoint)

$(document).ready(function (){
    console.log('start!')
    if(noPoint==null){
        $('.errorPage').show();
    }
})
async function booking(){
    var reservation=$('.finalReservation').val();

    console.log(reservation)
    var check =await fetch("/camput/reservationPage/init", {
        method:'POST',
        body:JSON.stringify({
            "startReservationDay": startReservationDay,
            "endReservationDay":endReservationDay,
            "campName":campName,
            "price":price
        })
    }).then(re=>re.text()).catch(err=>console.log('err'));
    if(check=='complete'){
    $('.successReservation').show();
    }else{
    $('.cancelReservation').show();
    }
}