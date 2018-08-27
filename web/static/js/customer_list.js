$(document).ready(function () {
    var page_data = {"pageNum": 1, "pageSize": 10};

    // 用户列表渲染
    getCustomerList(page_data);
    // 编辑--模态框--请求发送
    getModifyModel();

    // 首页
    $(document).on("click", "#first_page", function () {
        var first_page_data = {"pageNum": 1, "pageSize": 10};
        getCustomerList(first_page_data);
    });

    // 尾页
    $(document).on("click", "#last_page", function () {
        var last_page = $("#total_page").text();
        last_page_data = {"pageNum": last_page, "pageSize": 10};
        getCustomerList(last_page_data);
    });

    // 点击左侧Customer 管理
    $(document).on("click", "#customer_manage_btn", function () {
        var page_data = {"pageNum": 1, "pageSize": 10};
        getCustomerList(page_data);
    });

    // 点击左侧Film 管理
    $(document).on("click", "#film_manage_btn", function () {
        alert("小哥哥正火速开发中...");
    });

    // 点击删除
    $(document).on("click", ".delete", function modifyCustomer() {
        var customerId = $(this).parent().next().text();
        var confirm_delete = confirm("确定删除用户:  " + customerId);
        if (confirm_delete == true) {
            var pageNum = $("#current_page").text();
            var delete_data = {"pageNum": pageNum, "pageSize": 10, "customerId": customerId};
            // 发送delete请求
            $.ajax({
                url: "/doDelete",
                data: delete_data,
                type: 'POST',
                dataType: "json",
                success: function (result) {
                    if (result.data > 0) {
                        var page_data = {"pageNum": result.pageNum, "pageSize": result.pageSize};
                        alert("成功删除用户: " + customerId);
                        getCustomerList(page_data);
                    } else {
                        alert("删除失败: " + result.data);
                    }

                },
                error: function (result) {
                    alert("删除失败");
                }
            });
        }
    });

    // 新增点击
    $(document).on("click", "#add", function addCustomer() {
        // 修改原来编辑模态框的内容
        $("#myModalLabel").text("新增客户");
        $("#modify_customer_id").val("");
        $("#modify_first_name").val("");
        $("#modify_last_name").val("");
        $("#modify_email").val("");
        $("#modify_address_id").val("");

        $("#notice").html("填写新客户信息");

        // 获取用户输入的新用户信息
        $("#confirm_modify").click(function () {
            var firstName = $("#modify_first_name").val();
            var lastName = $("#modify_last_name").val();
            var email = $("#modify_email").val();
            var address = $("#address_select").val();
            var pageNum = $("#current_page").html();

            var data = {
                "firstName": firstName,
                "lastName": lastName,
                "email": email,
                "address": address,
                "pageNum": pageNum,
                "pageSize": 10
            };

            // 发送insert请求
            $.ajax({
                url: "/doInsert",
                data: data,
                type: 'POST',
                dataType: "json",
                success: function (result) {
                    page_data = {"pageNum": result.currentPage, "pageSize": 10};
                    alert("成功");
                    getCustomerList(page_data);
                },

            });
        })
    });


    // 上一页请求
    $("#pre_page").click(function () {
        page_data = {};
        var current_page = $("#current_page").text();
        if (current_page == 1) {
            alert("已经是第1页");
        } else {
            page_data = {"pageNum": current_page - 1, "pageSize": 10};
            getCustomerList(page_data);
        }
    });

    // 下一页请求
    $("#next_page").click(function () {
        page_data = {};
        var current_page = $("#current_page").text();
        var total_page = $("#total_page").text();
        if (current_page == total_page) {
            alert("已经是最后1页");
        } else {
            current_page = parseInt(current_page) + 1;
            page_data = {"pageNum": current_page, "pageSize": 10};
            getCustomerList(page_data);
        }
    });

    // 编辑请求
    $("#confirm_modify").click(function () {
        var customerId = $('#modify_customer_id').val();
        var firstName = $('#modify_first_name').val();
        var lastName = $('#modify_last_name').val();
        var email = $('#modify_email').val();
        var addressId = $('#modify_address_id').val();
        var pageNum = $("#current_page").text();
        var pageSize = 10;

        var modify_data = {
            "customerId": parseInt(customerId),
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "addressId": parseInt(addressId),
            "pageNum": parseInt(pageNum),
            "pageSize": pageSize
        }

        $.ajax({
            url: "/doModify",
            data: modify_data,
            type: 'POST',
            dataType: "json",
            success: function (result) {
                page_data = {"pageNum": result.currentPage, "pageSize": 10};
                alert("成功");
                getCustomerList(page_data);
            }
        });

    })

});

// 清理模态框中除Address外的内容
function clearModal() {

}


/**
 * 点击编辑按钮, 把要修改的信息回显到模态框．
 */
function getModifyModel() {
    $(document).on("click", ".modify", function modifyCustomer() {
        // 获取custoerId
        var custoemr_id = $(this).parent().next().text();
        var firstname = $(this).parent().next().next().text();
        var lastname = $(this).parent().next().next().next().text();
        var email = $(this).parent().next().next().next().next().next().text();
        var addressId = $(this).parent().parent().children("td:last-child").text();

        // 将CusterID放入模态框
        $('#confirm_customer_id').html(custoemr_id);
        $('#modify_customer_id').val(custoemr_id);
        $('#modify_first_name').val(firstname);
        $('#modify_last_name').val(lastname);
        $('#modify_email').val(email);
        $('#modify_address_id').val(addressId);
    });
}


// 获取客户列表
function getCustomerList(page_data) {

    // 发送获取客户列表请求
    $.getJSON("/getCustomerList", page_data, function (result) {
        addUserLabel(result.currentUser);
        addCustomerTable(result.customerList, result.currentPage, result.totalPage);
    });

    // 展示当前登录用户名称
    function addUserLabel(currentUser) {
        $("#current_user").text(currentUser);
    }

    // 添加客户列表
    function addCustomerTable(customerList, currentPage, totalPage) {

        // 添加客户表格
        var table_context = '';
        table_context = table_context + '<tr>';
        table_context = table_context + '<td>' + '操作' + '</td>';
        table_context = table_context + '<td>' + 'Customer ID' + '</td>';
        table_context = table_context + '<td>' + 'First Name' + '</td>';
        table_context = table_context + '<td>' + 'Last Name' + '</td>';
        table_context = table_context + '<td>' + 'Address' + '</td>';
        table_context = table_context + '<td>' + 'Email' + '</td>';
        table_context = table_context + '<td>' + 'Last Update' + '</td>';
        table_context = table_context + '<td style="display: none;">' + 'Address ID' + '</td>';
        table_context = table_context + '</tr>';
        for (var i = 0; i < customerList.length; i++) {
            table_context = table_context + '<tr>';
            table_context = table_context + '<td>' +
                '<button class="modify btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" id="modify_">' + '编辑' + '</button>' +
                '<button class="delete" id="delete_">' + '删除' + '</button></td>';
            table_context = table_context + '<td>' + customerList[i].customerId + '</td>';
            table_context = table_context + '<td>' + customerList[i].firstName + '</td>';
            table_context = table_context + '<td>' + customerList[i].lastName + '</td>';
            table_context = table_context + '<td>' + customerList[i].address.address + '</td>';
            table_context = table_context + '<td>' + customerList[i].email + '</td>';
            table_context = table_context + '<td>' + customerList[i].lastUpdate + '</td>';
            table_context = table_context + '<td style="display: none">' + customerList[i].addressId + '</td>';
            table_context = table_context + '</tr>';
        }
        table_context = table_context + '<tr>';
        table_context = table_context + '<td colspan="8">' + '<button id="add" class="add btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">新增客户</button>' + '</tr>';
        $('#customer_table').html(table_context);

        // 添加页码
        $("#current_page").html(currentPage);
        $("#total_page").html(totalPage);

        // 向模态框中的地址下拉选项添加地址．
        var model = '';
        for (var j = 0; j < customerList.length; j++) {
            model = model + '<option>' + customerList[j].address.address + '</option>';
        }
        $('#address_select').html(model);
    }

}