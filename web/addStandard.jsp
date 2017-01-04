<%--
  Created by IntelliJ IDEA.
  User: 25397
  Date: 2016/12/22
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        function check_std_num() {
            var $std_num = $("#std_num").val();
            var tipStd_num = $("#tipStd_num");
            tipStd_num.html("");
            if ("" == $std_num) {
                tipStd_num.html("标准号不能为空");
                return false;
            }
            return true;
        }
        function check_zhname() {
            var $zhname = $("#zhname").val();
            var tipZhname = $("#tipZhname");
            tipZhname.html("");
            if ("" == $zhname) {
                tipZhname.html("中文名称不能为空");
                return false;
            }
            return true;
        }
        function check_version() {
            var $version = $("#version").val();
            var tipVersion = $("#tipVersion");
            tipVersion.html("");
            if ("" == $version) {
                tipVersion.html("版本不能为空");
                return false;
            }
            return true;
        }
        function check_skeys() {
            var $skeys = $("#skeys").val();
            var tipSkeys = $("#tipSkeys");
            tipSkeys.html("");
            if ("" == $skeys) {
                tipSkeys.html("关键字不能为空");
                return false;
            }
            return true;
        }
        function check_release_date() {
            var $release_date = $("#release_date").val();
            var tipRelease_date = $("#tipRelease_date");
            tipRelease_date.html("");
            if ("" == $release_date) {
                tipRelease_date.html("发布日期不能为空");
                return false;
            }
            return true;
        }
        function check_impl_date() {
            var $impl_date = $("#impl_date").val();
            var tipimpl_date = $("#tipimpl_date");
            tipimpl_date.html("");
            if ("" == $impl_date) {
                tipimpl_date.html("实施日期不能为空");
                return false;
            }
            return true;
        }
        function check_package_path() {
            var $package_path = $("#package_path").val();
            var tipPackage_path = $("#tipPackage_path");
            tipPackage_path.html("");
            if ("" == $package_path) {
                tipPackage_path.html("附件不能为空");
                return false;
            }
            return true;
        }
        $(this).ready(function () {
            $("#std_num").blur(check_std_num);
            $("#zhname").blur(check_zhname);
            $("#version").blur(check_version);
            $("#skeys").blur(check_skeys);
            $("#release_date").blur(check_release_date);
            $("#impl_date").blur(check_impl_date);
            $("#package_path").blur(check_package_path);
            $("#form1").submit(function () {
                var flag = false;
                if (check_std_num() & check_zhname() & check_version() & check_skeys() & check_release_date() & check_impl_date() & check_package_path()) {
                   flag=true;
                }
                return flag;
            });

        })
    </script>
</head>
<body>
<form action="AddStandardServlet" method="post" enctype="multipart/form-data" id="form1">
    标准号：<input type="text" id="std_num" name="std_num"/>
    <div style="display: inline" id="tipStd_num"></div>
    <br/>
    中文名称：<input type="text" id="zhname" name="zhname"/>
    <div style="display: inline" id="tipZhname"></div>
    <br/>
    版本：<input type="text" id="version" name="version"/>
    <div style="display: inline" id="tipVersion"></div>
    <br/>
    关键字：<input type="text" id="skeys" name="skeys"/>
    <div style="display: inline" id="tipSkeys"></div>
    <br/>
    发布日期(yyyy-MM-dd)： <input type="text" class="Wdate" id="release_date" name="release_date"
                             onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                             value=""/>
    <div style="display: inline" id="tipRelease_date"></div>
    <br/>
    实施日期(yyyy-MM-dd)：<input type="text" class="Wdate" id="impl_date" name="impl_date"
                            onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                            value=""/>
    <div style="display: inline" id="tipImpl_date"></div>
    <br/>
    附件：<input type="file" name="package_path" id="package_path"/>
    <div style="display: inline" id="tipPackage_path"></div>
    <br/>
    <input type="submit" value="保存"/>&nbsp;
    <input type="reset" value="取消"/>
</form>
</body>
</html>
