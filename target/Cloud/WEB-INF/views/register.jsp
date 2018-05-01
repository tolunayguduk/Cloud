<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href='<s:url value="/resources/css/anasayfa.css"/>' rel="stylesheet" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">
    <title>Londinium - premium responsive admin template by Eugene Kopyov</title>


    <link href='<s:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<s:url value="/resources/css/londinium-theme.css"/>' rel="stylesheet" />
    <link href='<s:url value="/resources/css/styles.css"/>' rel="stylesheet" />
    <link href='<s:url value="/resources/css/icons.css"/>' rel="stylesheet" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">





    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

    <script type="text/javascript" src="/resources/js/plugins/charts/sparkline.min.js"></script>

    <script type="text/javascript" src="/resources/js/plugins/forms/uniform.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/select2.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/inputmask.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/autosize.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/inputlimit.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/listbox.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/multiselect.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/validate.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/tags.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/switch.min.js"></script>

    <script type="text/javascript" src="/resources/js/plugins/forms/uploader/plupload.full.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/uploader/plupload.queue.min.js"></script>

    <script type="text/javascript" src="/resources/js/plugins/forms/wysihtml5/wysihtml5.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/forms/wysihtml5/toolbar.js"></script>

    <script type="text/javascript" src="/resources/js/plugins/interface/daterangepicker.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/fancybox.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/moment.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/jgrowl.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/datatables.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/colorpicker.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/fullcalendar.min.js"></script>
    <script type="text/javascript" src="/resources/js/plugins/interface/timepicker.min.js"></script>

    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/application.js"></script>

</head>

<body class="full-width page-condensed">
<!-- Login wrapper -->
<div class="login-wrapper" style="width: 40%;">
    <form action="register.ajax" method="post">
        <div class="popup-header">
            <span class="text-semibold">User Register</span>
        </div>
        <div class="well">

            <div class="pull-left">

                <div class="form-group has-feedback">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Name">
                    <i class="icon-users form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <label>Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Username">
                    <i class="icon-users form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <label>Password</label>
                    <input type="text" class="form-control" name="password" placeholder="Password">
                    <i class="icon-users form-control-feedback"></i>
                </div>
            </div>
            <div class="pull-right">


                <div class="form-group has-feedback">
                    <label>Surname</label>
                    <input type="text" class="form-control" name="surname" placeholder="Surname">
                    <i class="icon-users form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <label>E-mail</label>
                    <input type="text" class="form-control" name="email" placeholder="Email">
                    <i class="icon-users form-control-feedback"></i>
                </div>
                <div class="form-group has-feedback">
                    <label>Password Again</label>
                    <input type="text" class="form-control" placeholder="Password-Again">
                    <i class="icon-users form-control-feedback"></i>
                </div>
            </div>









            <div class="row form-actions">
                <div class="col-xs-6">
                    <a type="button" href="/login" class="btn btn-primary pull-left"><i class="icon-menu2"></i> SIGN IN</a>
                </div>

                <div class="col-xs-6">
                    <button type="submit" class="btn btn-warning pull-right"><i class="icon-menu2"></i> SIGN UP</button>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- /login wrapper -->




</body>
</html>