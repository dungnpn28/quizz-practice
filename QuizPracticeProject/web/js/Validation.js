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

function ValidateLessonDetail() {
    var type_id = document.getElementsByName('selectedType')[0].value;
    var nameInput = document.getElementById("name");
    var nameValue = nameInput.value.trim();
    var orderInput = document.getElementById("order");
    var orderValue = orderInput.value;

    if (nameValue === "") {
        // Trường "name" không được để trống
        alert("Tên không được để trống");
        return false;
    }
    if (!/^\d+$/.test(orderValue) || parseInt(orderValue) <= 0) {
        // Trường "order" không phải là số nguyên dương
        alert("Số thứ tự phải là số nguyên dương");
        return false;
    }
    if (type_id !== '1' && type_id !== '3') {
        var linkInput = document.getElementById("link");
        var linkValue = linkInput.value.trim();
        if (!/^https?:\/\/.+/.test(linkValue)) {
            // Trường "link" không phải là URL hợp lệ
            alert("Link phải là URL hợp lệ");
            return false;
        }
    }
    alert("thành công!");
}

var selectedType = document.getElementsByName('selectedType')[0];
var linkInput = document.getElementById('linkInput');
var contentInput = document.getElementById('contentInput');
var quizInput = document.getElementById('quizInput');


if (selectedType.value === '1') {
        linkInput.style.display = 'none';
        contentInput.style.display = 'none';
        quizInput.style.display = 'none';
    } else if (selectedType.value === '2') {
        linkInput.style.display = 'block';
        contentInput.style.display = 'block';
        quizInput.style.display = 'none';
    } else {
        linkInput.style.display = 'none';
        contentInput.style.display = 'block';
        quizInput.style.display = 'block';
    }
    
selectedType.addEventListener('change', function () {
    if (selectedType.value === '1') {
        linkInput.style.display = 'none';
        contentInput.style.display = 'none';
        quizInput.style.display = 'none';
    } else if (selectedType.value === '2') {
        linkInput.style.display = 'block';
        contentInput.style.display = 'block';
        quizInput.style.display = 'none';
    } else {
        linkInput.style.display = 'none';
        contentInput.style.display = 'block';
        quizInput.style.display = 'block';
    }
});


