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