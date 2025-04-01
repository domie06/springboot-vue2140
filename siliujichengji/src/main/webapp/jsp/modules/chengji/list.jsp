<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">


<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">
                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">成绩管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">成绩管理</li>
                        <li class="breadcrumb-item active">成绩列表</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">成绩列表</h3>
                        <div class="table-responsive mb-3">
                            <div class="col-sm-12">
                                                                                                                                 
                                            <label>
                                                考试类型
                                                <select name="kaoshiTypesSelectSearch" style="width: 100px;" id="kaoshiTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                成绩类型
                                                <select name="chengjiTypesSelectSearch" style="width: 100px;" id="chengjiTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                        <label>
                                            分数
                                            <input type="text" id="fractionStartSearch" style="width: 100px;" onchange="fractionChickValue(this)"   class="form-control " placeholder="开始" aria-controls="tableId">
                                        </label>
                                            -
                                        <label>
                                            <input type="text" id="fractionEndSearch"  style="width: 100px;" onchange="fractionChickValue(this)"     class="form-control" placeholder="结束" aria-controls="tableId">
                                        </label>
                                
                                                                                                                                                                                                 
                                            <label>
                                                考场名
                                                <input type="text" id="kaochangNameSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="考场名" aria-controls="tableId">
                                            </label>
                                                                                                 
                                            <label>
                                                考场地址
                                                <input type="text" id="kaochangAddressSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="考场地址" aria-controls="tableId">
                                            </label>
                                                                                                                                                                                                 
                                            <label>
                                                姓名
                                                <input type="text" id="nameSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="姓名" aria-controls="tableId">
                                            </label>
                                                                                                 
                                            <label>
                                                身份证号
                                                <input type="text" id="idNumberSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="身份证号" aria-controls="tableId">
                                            </label>
                                                 
                                            <label>
                                                手机号
                                                <input type="text" id="phoneSearch"  style="width: 120px;" class="form-control form-control-sm"
                                                       placeholder="手机号" aria-controls="tableId">
                                            </label>
                                                                                                                                                                                                
                                <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                <button onclick="add()" type="button" class="btn btn-success 新增">添加</button>
                                <button onclick="graph()" type="button" class="btn btn-success 报表">报表</button>
                                <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                            </div>
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>

                                    <th >考场名</th>
                                    <th >考场人数</th>
                                    <th >考场地址</th>
                                    <th >考生姓名</th>
                                    <th >考生身份证号</th>
                                    <th >考生手机号</th>
                                    <th >考试类型</th>
                                    <th >成绩类型</th>
                                    <th >分数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="thisTbody">
                                </tbody>
                            </table>
                            <div class="col-md-6 col-sm-3">
                                <div class="dataTables_length" id="tableId_length">

                                    <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                            onchange="changePageSize()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                    条 每页

                                </div>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                        <a class="page-link" href="#" tabindex="-1">上一页</a>
                                    </li>

                                    <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                        <a class="page-link" href="#">下一页</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->

    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "chengji";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var checkAll = false;


    var kaoshiTypesOptions = [];
    var chengjiTypesOptions = [];

    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }



    // 查询
    function search() {
        searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                                                                 
                        //考场名
        var kaochangNameSearchInput = $('#kaochangNameSearch');
        if( kaochangNameSearchInput != null){
            if (kaochangNameSearchInput.val() != null && kaochangNameSearchInput.val() != '') {
                searchForm.kaochangName = $('#kaochangNameSearch').val();
            }
        }
                                         
                        //考场地址
        var kaochangAddressSearchInput = $('#kaochangAddressSearch');
        if( kaochangAddressSearchInput != null){
            if (kaochangAddressSearchInput.val() != null && kaochangAddressSearchInput.val() != '') {
                searchForm.kaochangAddress = $('#kaochangAddressSearch').val();
            }
        }
                                                                                 
                        //姓名
        var nameSearchInput = $('#nameSearch');
        if( nameSearchInput != null){
            if (nameSearchInput.val() != null && nameSearchInput.val() != '') {
                searchForm.name = $('#nameSearch').val();
            }
        }
                                         
                        //身份证号
        var idNumberSearchInput = $('#idNumberSearch');
        if( idNumberSearchInput != null){
            if (idNumberSearchInput.val() != null && idNumberSearchInput.val() != '') {
                searchForm.idNumber = $('#idNumberSearch').val();
            }
        }
                     
                        //手机号
        var phoneSearchInput = $('#phoneSearch');
        if( phoneSearchInput != null){
            if (phoneSearchInput.val() != null && phoneSearchInput.val() != '') {
                searchForm.phone = $('#phoneSearch').val();
            }
        }
                                                                                    <!-- 本表的查询条件 -->

                 
            //考试类型
        var kaoshiTypesSelectSearchInput = document.getElementById("kaoshiTypesSelectSearch");
        if(kaoshiTypesSelectSearchInput != null){
            var kaoshiTypesIndex = kaoshiTypesSelectSearchInput.selectedIndex;
            if( kaoshiTypesIndex  != 0){
                searchForm.kaoshiTypes= document.getElementById("kaoshiTypesSelectSearch").options[kaoshiTypesIndex].value;
            }
        }
     
            //成绩类型
        var chengjiTypesSelectSearchInput = document.getElementById("chengjiTypesSelectSearch");
        if(chengjiTypesSelectSearchInput != null){
            var chengjiTypesIndex = chengjiTypesSelectSearchInput.selectedIndex;
            if( chengjiTypesIndex  != 0){
                searchForm.chengjiTypes= document.getElementById("chengjiTypesSelectSearch").options[chengjiTypesIndex].value;
            }
        }
     
        //分数
        var fractionStartSearchInput = $('#fractionStartSearch');
        if(fractionStartSearchInput != null){
            var fractionStartSearchValue = fractionStartSearchInput.val();
            if( fractionStartSearchValue  != 0){
                searchForm.fractionStart = fractionStartSearchValue;
            }
        }
        var fractionEndSearchInput = $('#fractionEndSearch');
        if(fractionEndSearchInput != null){
            var fractionEndSearchValue = fractionEndSearchInput.val();
            if( fractionEndSearchValue  != 0){
                searchForm.fractionEnd = fractionEndSearchValue;
            }
        }
            getDataList();
    }

    // 获取数据列表
    function getDataList() {
        http("chengji/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
            //本表的
            kaoshiTypes: searchForm.kaoshiTypes,
            chengjiTypes: searchForm.chengjiTypes,
            fractionStart: searchForm.fractionStart,
            fractionEnd: searchForm.fractionEnd,
            //级联表的
                        kaochangName: searchForm.kaochangName,
                        kaochangAddress: searchForm.kaochangAddress,

                        name: searchForm.name,
                        idNumber: searchForm.idNumber,
                        phone: searchForm.phone,


        }, (res) => {
            if(res.code == 0) {
                clear();
                $("#thisTbody").html("");
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('#thisTbody').append(trow);
                }
                pagination(); //渲染翻页组件
                getRoleButtons();// 权限按钮控制
            }
        });
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)


                //考场名
        var kaochangNameCell = document.createElement('td');
        kaochangNameCell.innerHTML = item.kaochangName;
        row.appendChild(kaochangNameCell);

                    //考场人数
        var kaoshiNumberCell = document.createElement('td');
        kaoshiNumberCell.innerHTML = item.kaoshiNumber;
        row.appendChild(kaoshiNumberCell);


                //考场地址
        var kaochangAddressCell = document.createElement('td');
        kaochangAddressCell.innerHTML = item.kaochangAddress;
        row.appendChild(kaochangAddressCell);



                //姓名
        var nameCell = document.createElement('td');
        nameCell.innerHTML = item.name;
        row.appendChild(nameCell);



                //身份证号
        var idNumberCell = document.createElement('td');
        idNumberCell.innerHTML = item.idNumber;
        row.appendChild(idNumberCell);


                //手机号
        var phoneCell = document.createElement('td');
        phoneCell.innerHTML = item.phone;
        row.appendChild(phoneCell);


        //考试类型
        var kaoshiTypesCell = document.createElement('td');
        kaoshiTypesCell.innerHTML = item.kaoshiValue;
        row.appendChild(kaoshiTypesCell);


        //成绩类型
        var chengjiTypesCell = document.createElement('td');
        chengjiTypesCell.innerHTML = item.chengjiValue;
        row.appendChild(chengjiTypesCell);


        //分数
        var fractionCell = document.createElement('td');
        fractionCell.innerHTML = item.fraction;
        row.appendChild(fractionCell);



        //每行按钮
        var btnGroup = document.createElement('td');

        //详情按钮
        var detailBtn = document.createElement('button');
        var detailAttr = "detail(" + item.id + ')';
        detailBtn.setAttribute("type", "button");
        detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
        detailBtn.setAttribute("onclick", detailAttr);
        detailBtn.innerHTML = "查看"
        btnGroup.appendChild(detailBtn)
        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'edit(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "修改"
        btnGroup.appendChild(editBtn)
        //删除按钮
        var deleteBtn = document.createElement('button');
        var deleteAttr = 'remove(' + item.id + ')';
        deleteBtn.setAttribute("type", "button");
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
        deleteBtn.setAttribute("onclick", deleteAttr);
        deleteBtn.innerHTML = "删除"
        btnGroup.appendChild(deleteBtn)

        row.appendChild(btnGroup)
        return row;
    }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        // 小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


        //小数
        function fractionChickValue(e){
            var this_val = e.value || 0;
            if(this_val == 0){
                e.value = "";
                alert("0不允许输入");
                return false;
            }
            var reg=/^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }


    // 翻页
    function pageNumChange(val) {
        if (val == 'pre') {
            pageIndex--;
        } else if (val == 'next') {
            pageIndex++;
        } else {
            pageIndex = val;
        }
        getDataList();
    }

    // 下载
    function download(url) {
        window.open(url);
    }

    // 渲染翻页组件
    function pagination() {
        var beginIndex = pageIndex;
        var endIndex = pageIndex;
        var point = 4;
        //计算页码
        for (var i = 0; i < 3; i++) {
            if (endIndex == totalPage) {
                break;
            }
            endIndex++;
            point--;
        }
        for (var i = 0; i < 3; i++) {
            if (beginIndex == 1) {
                break;
            }
            beginIndex--;
            point--;
        }
        if (point > 0) {
            while (point > 0) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            while (point > 0) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--
            }
        }
        // 是否显示 前一页 按钮
        if (pageIndex > 1) {
            $('#tableId_previous').show();
        } else {
            $('#tableId_previous').hide();
        }
        // 渲染页码按钮
        for (var i = beginIndex; i <= endIndex; i++) {
            var pageNum = document.createElement('li');
            pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
            if (pageIndex == i) {
                pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
            } else {
                pageNum.setAttribute('class', 'paginate_button page-item useOnce');
            }
            var pageHref = document.createElement('a');
            pageHref.setAttribute('class', 'page-link');
            pageHref.setAttribute('href', '#');
            pageHref.setAttribute('aria-controls', 'tableId');
            pageHref.setAttribute('data-dt-idx', i);
            pageHref.setAttribute('tabindex', 0);
            pageHref.innerHTML = i;
            pageNum.appendChild(pageHref);
            $('#tableId_next').before(pageNum);
        }
        // 是否显示 下一页 按钮
        if (pageIndex < totalPage) {
            $('#tableId_next').show();
            $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
        } else {
            $('#tableId_next').hide();
        }
        var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
        $('#tableId_info').html(pageNumInfo);
    }

    // 跳转到指定页
    function toThatPage() {
        //var index = document.getElementById('pageIndexInput').value;
        if (index < 0 || index > totalPage) {
            alert('请输入正确的页码');
        } else {
            pageNumChange(index);
        }
    }

    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function deleteMore() {
        ids = []
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                ids.push(boxs[i].value)
            }
        }
        if (ids.length == 0) {
            alert('请勾选要删除的记录');
        } else {
            remove(ids);
        }
    }

    // 删除
    function remove(id) {
        var mymessage = confirm("真的要删除吗？");
        if (mymessage == true) {
            var paramArray = [];
            if (id == ids) {
                paramArray = id;
            } else {
                paramArray.push(id);
            }
            httpJson("chengji/delete", "POST", paramArray, (res) => {
                if(res.code == 0){
                    getDataList();
                    alert('删除成功');
                }
            });
        } else {
            alert("已取消操作");
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>

    //修改
    function edit(id) {
        window.sessionStorage.setItem('updateId', id)
        window.location.href = "add-or-update.jsp"
    }

    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    //添加
    function add() {
        window.sessionStorage.setItem("addchengji", "addchengji");
        window.location.href = "add-or-update.jsp"
    }

    //报表
    function graph() {
        window.location.href = "graph.jsp"
    }

    // 查看详情
    function detail(id) {
        window.sessionStorage.setItem("updateId", id);
        window.location.href = "info.jsp";
    }

    //填充级联表搜索下拉框
                                                                                 
                                         
                                                                                 
                                         
                     
                                                                                
    //填充本表搜索下拉框
                 
        function kaoshiTypesSelectSearch() {
            var kaoshiTypesSelectSearch = document.getElementById('kaoshiTypesSelectSearch');
            if(kaoshiTypesSelectSearch != null) {
                kaoshiTypesSelectSearch.add(new Option('-请选择-',''));
                if (kaoshiTypesOptions != null && kaoshiTypesOptions.length > 0){
                    for (var i = 0; i < kaoshiTypesOptions.length; i++) {
                            kaoshiTypesSelectSearch.add(new Option(kaoshiTypesOptions[i].indexName,kaoshiTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
        function chengjiTypesSelectSearch() {
            var chengjiTypesSelectSearch = document.getElementById('chengjiTypesSelectSearch');
            if(chengjiTypesSelectSearch != null) {
                chengjiTypesSelectSearch.add(new Option('-请选择-',''));
                if (chengjiTypesOptions != null && chengjiTypesOptions.length > 0){
                    for (var i = 0; i < chengjiTypesOptions.length; i++) {
                            chengjiTypesSelectSearch.add(new Option(chengjiTypesOptions[i].indexName,chengjiTypesOptions[i].codeIndex));
                    }
                }
            }
        }
     
    
    //查询级联表搜索条件所有列表

    //查询当前表搜索条件所有列表
        function kaoshiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=kaoshi_types", "GET", {}, (res) => {
                if(res.code == 0){
                    kaoshiTypesOptions = res.data.list;
                }
            });
        }
        function chengjiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=chengji_types", "GET", {}, (res) => {
                if(res.code == 0){
                    chengjiTypesOptions = res.data.list;
                }
            });
        }


    $(document).ready(function () {
        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询级联表的搜索下拉框

        //查询当前表的搜索下拉框
        kaoshiTypesSelect();
        chengjiTypesSelect();
        getDataList();

        //级联表的下拉框赋值
                                                                                                 
                                                 
                                                                                                 
                                                 
                         
                                                                                                
        //当前表的下拉框赋值
                                                 
            kaoshiTypesSelectSearch();
             
            chengjiTypesSelectSearch();
             
            
    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>