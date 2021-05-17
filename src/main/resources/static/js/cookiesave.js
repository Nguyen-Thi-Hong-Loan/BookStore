$(document).ready(function() {
	$(".btn-like").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url: "/bookstore/shopList/likebook/" + id,
			success: function(response) {
				if (response) {
					alert("Đã cho thích thành công: " + id)
				}else{
					alert("Đã tồn tại: " + id )
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
					alert("Đã thêm thành công: số lượng sản phẩm là " + response[0] + " tổng tiền: " + response[1] )
				
			}
		})
	})
})
$(document).ready(function() {
	$(".btn-down").click(function() {
		var id = $(this).closest("div").attr("data-id");
		var itemcount = "#item-count-";
		var merger =  itemcount.concat(id);
		$.ajax({
			url: "/bookstore/shopList/cart/downUpdatecart/" + id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#total-price").html(response[1]);
				$(merger).html(response[2]);
			alert("Đã giảm thành công: " +  "số lượng sách là " +response[0] + " tổng tiền: "+ response[1])
			}
		})
	})
})
$(document).ready(function() {
	$(".btn-up").click(function() {
		var id = $(this).closest("div").attr("data-id");
		var itemcount = "#item-count-";
		var merger =  itemcount.concat(id);
		$.ajax({
			url: "/bookstore/shopList/cart/updatecart/" + id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#total-price").html(response[1]);
				$(merger).html(response[2]);
			alert("Đã tăng thành công: " + "số lượng sách là: " +response[0] + " tổng tiền: "+ response[1])
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
				}else{
					alert("Xóa thất bại : " + id )
					  location.reload();
				}
			}
		})
	})
})