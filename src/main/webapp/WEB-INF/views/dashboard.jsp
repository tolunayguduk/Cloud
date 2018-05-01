<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
<body>

<!-- Navbar -->
<div class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#"><b>CLOUDBOX</b></a>
        <a class="sidebar-toggle"><i class="icon-paragraph-justify2"></i></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-icons">
            <span class="sr-only">Toggle navbar</span>
            <i class="icon-grid3"></i>
        </button>
        <button type="button" class="navbar-toggle offcanvas">
            <span class="sr-only">Toggle navigation</span>
            <i class="icon-paragraph-justify2"></i>
        </button>
    </div>
</div>
<!-- /navbar -->


<!-- Page container -->
<div class="page-container">


    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-content">

            <!-- User dropdown -->
            <div class="user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="http://placehold.it/300">
                    <div class="user-info">
                        ${name} <span>${username}</span>
                    </div>
                </a>
            </div>
            <!-- /user dropdown -->


            <!-- Main navigation -->
            <ul class="navigation">
                <li class="active"><a href="index.html"><span>Dashboard</span> <i class="icon-screen2"></i></a></li>
            </ul>
            <!-- /main navigation -->

        </div>
    </div>
    <!-- /sidebar -->


    <!-- Page content -->
    <div class="page-content">


        <!-- Page header -->
        <div class="page-header">
            <div class="page-title">
                <h3>Dashboard <small>Merhaba ${name}</small></h3>
            </div>
        </div>
        <!-- /page header -->


        <!-- Breadcrumbs line -->
        <div class="breadcrumb-line">
            <ul class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li class="active">Dashboard</li>
            </ul>
        </div>
        <!-- /breadcrumbs line -->











        <!-- Tasks table -->
        <div class="block">
            <h6 class="heading-hr"><i class="icon-grid"></i> Recent tasks</h6>
            <div class="datatable-tasks">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Task Description</th>
                        <th class="task-priority">Priority</th>
                        <th class="task-date-added">Date Added</th>
                        <th class="task-progress">Progress</th>
                        <th class="task-deadline">Deadline</th>
                        <th class="task-tools text-center">Tools</th>
                    </tr>
                    </thead>
                    <tbody>


                    <%


                        int i=0;
                        i++;

                        out.println(i);


                    %>



                    <tr>
                        <td class="task-desc">
                            <a href="task_detailed.html">Donec suscipit ultrices commodo. Suspendisse potenti</a>
                            <span>General layout additions</span>
                        </td>
                        <td class="text-center"><span class="label label-danger">High</span></td>
                        <td>September 20, 2013</td>
                        <td>
                            <div class="progress progress-micro">
                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                                    <span class="sr-only">90% Complete</span>
                                </div>
                            </div>
                        </td>
                        <td><i class="icon-clock"></i> <strong class="text-danger">14</strong> hours left</td>
                        <td class="text-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-icon btn-success dropdown-toggle" data-toggle="dropdown"><i class="icon-cog4"></i></button>
                                <ul class="dropdown-menu icons-right dropdown-menu-right">
                                    <li><a href="#"><i class="icon-quill2"></i> Edit task</a></li>
                                    <li><a href="#"><i class="icon-share2"></i> Reassign</a></li>
                                    <li><a href="#"><i class="icon-checkmark3"></i> Complete</a></li>
                                    <li><a href="#"><i class="icon-stack"></i> Archive</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /tasks table -->















    </div>
    <!-- /page content -->
</div>
<!-- /page container -->
</body>
</html>

