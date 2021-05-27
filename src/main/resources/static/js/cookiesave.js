$(document).ready(function() {
	$(".btn-like").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url: "/bookstore/shopList/likebook/" + id,
			success: function(response) {
				if (response) {
					alert("Đã cho thích thành công: " + id)
				} else {
					alert("Đã tồn tại: " + id)
				}
			}
		})
	})
})
$(document).ready(function() {
	$(".btn-addcart").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url: "/bookstore/shopList/addcart/" + id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				alert("Đã thêm thành công: số lượng sản phẩm là " + response[0] + " tổng tiền: " + response[1] + " VNĐ")

			}
		})
	})
})
$(document).ready(function() {
	$(".btn-down").click(function() {
		var id = $(this).closest("div").attr("data-id");
		var itemcount = "#item-count-";
		var merger = itemcount.concat(id);
		$.ajax({
			url: "/bookstore/shopList/cart/downUpdatecart/" + id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#total-price").html(response[1]);
				$(merger).html(response[2]);
			}
		})
	})
})
$(document).ready(function() {
	$(".btn-up").click(function() {
		var id = $(this).closest("div").attr("data-id");
		var itemcount = "#item-count-";
		var merger = itemcount.concat(id);
		$.ajax({
			url: "/bookstore/shopList/cart/updatecart/" + id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#total-price").html(response[1]);
				$(merger).html(response[2]);

			}
		})
	})
})




$(document).ready(function() {
	$(".btn-delete").click(function() {
		var id = $(this).attr("data-id");
		$.ajax({
			url: "/hostel/list/deletepostsave/" + id,
			success: function(response) {
				if (response) {
					alert("Đã xóa thành công: " + id)
					location.reload();
				} else {
					alert("Xóa thất bại : " + id)
					location.reload();
				}
			}
		})
	})
})

//var number = document.getElementsById("money").textContent;

/*var number = document.getElementsByClassName("money");
for (i=0; i< munber.lenght; i++) {
   document.write(i + "<br >");
}
var so =  Number(number);
so.toLocaleString('vi-VN')
 document.getElementsById("money").innerHTML = so.toLocaleString('vi-VN');*/


//
  var a = document.getElementsByClassName("money");
  
 
var i;
for (i = 0; i < a.length; i++) {
  let char = a[i].textContent;
          let b = Number(char);
         a[i].innerHTML = 		b.toLocaleString('vi-VN');

}
