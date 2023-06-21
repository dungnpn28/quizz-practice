function validateForm() {
    // Lấy giá trị từ các trường input
    var name = document.forms["addForm"]["name"].value;
    var description = document.forms["addForm"]["description"].value;
    var duration = parseInt(document.forms["addForm"]["duration"].value);
    var price = parseInt(document.forms["addForm"]["price"].value);
    var sale = parseInt(document.forms["addForm"]["sale"].value);

    // Kiểm tra tính hợp lệ của các trường
    if (name === "") {
        alert("Vui lòng nhập tên");
        return false;
    }
    if (description === "") {
        alert("Vui lòng nhập mô tả");
        return false;
    }
    if (isNaN(duration) || duration < 0) {
        alert("Thời lượng phải là số nguyên không âm");
        return false;
    }
    if (isNaN(price) || price < 100) {
        alert("Giá phải là số nguyên và lớn hơn hoặc bằng 100");
        return false;
    }
    if (isNaN(sale) || sale <= 0 || sale >= price) {
        alert("Giá khuyến mãi phải là số nguyên và nằm trong khoảng từ 0 đến giá gốc");
        return false;
    }
    alert("Bạn đã thêm gói học thành công!");
}

function validateForm1(id) {
    // Lấy giá trị từ các trường input
    var name = document.forms["editForm-" + id]["name"].value;
    var description = document.forms["editForm-" + id]["description"].value;
    var duration = parseInt(document.forms["editForm-" + id]["duration"].value);
    var price = parseInt(document.forms["editForm-" + id]["price"].value);
    var sale = parseInt(document.forms["editForm-" + id]["sale"].value);

    // Kiểm tra tính hợp lệ của các trường
    if (name === "") {
        alert("Vui lòng nhập tên");
        return false;
    }
    if (description === "") {
        alert("Vui lòng nhập mô tả");
        return false;
    }
    if (isNaN(duration) || duration < 0) {
        alert("Thời lượng phải là số nguyên không âm");
        return false;
    }
    if (isNaN(price) || price < 100) {
        alert("Giá phải là số nguyên và lớn hơn hoặc bằng 100");
        return false;
    }
    if (isNaN(sale) || sale <= 0 || sale >= price) {
        alert("Giá khuyến mãi phải là số nguyên và nằm trong khoảng từ 0 đến giá gốc");
        return false;
    }
    alert("Bạn đã sửa gói học thành công!");
}

function ValidateLessonDetail(str) {
    var nameInput = document.getElementById("name");
    var nameValue = nameInput.value.trim();

    if (nameValue === "") {
        // Trường "name" không được để trống
        alert("Tên không được để trống");
        return false;
    }
    var orderInput = document.getElementById("order");
    var orderValue = orderInput.value;

    if (!/^\d+$/.test(orderValue) || parseInt(orderValue) <= 0) {
        // Trường "order" không phải là số nguyên dương
        alert("Số thứ tự phải là số nguyên dương");
        return false;
    }
    var linkInput = document.getElementById("link");
    var linkValue = linkInput.value.trim();

    if (!/^https?:\/\/.+/.test(linkValue)) {
        // Trường "link" không phải là URL hợp lệ
        alert("Link phải là URL hợp lệ");
        return false;
    }
    if (str === "edit") {
        alert("Bạn đã sửa lesson thành công!");
    } else {
        alert("Bạn đã thêm lesson thành công!");
    }
}
