<%@ page import="net.sf.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%
    if(session.getAttribute("username")==null){
        session.setAttribute("name",request.getAttribute("name"));
        session.setAttribute("username",request.getAttribute("username"));
    }
    session.setAttribute("path",request.getAttribute("path"));
    session.setAttribute("folderList",request.getAttribute("folderList"));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href='<s:url value="/resources/css/dashboard.css"/>' rel="stylesheet" />
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
        <a class="navbar-brand" href="/dashboard/path?username=<%=session.getAttribute("username")%>&path=/"><b>CLOUDBOX</b></a>
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
                        <%=session.getAttribute("name")%> <span> <%=session.getAttribute("username")%></span>
                    </div>
                </a>
            </div>
            <!-- /user dropdown -->


            <!-- Main navigation -->
            <ul class="navigation">
                <li class="active">
                    <form action="/dashboard/createFile" method="get">
                        <div class="search">
                            <input type="text" class="form-control input-sm" maxlength="64" placeholder="Name" name="name" />
                            <input type="hidden" name="path" value="<%=session.getAttribute("path")%>">
                            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
                            <button type="submit" class="btn btn-primary btn-sm">Create File <i class="icon-file"></i></button>
                        </div>
                    </form>
                </li>
                <li class="active">
                    <form action="/dashboard/createDirectory" method="get">
                        <div class="search">
                            <input type="text" class="form-control input-sm" maxlength="64" placeholder="Name" name="name" />
                            <input type="hidden" name="path" value="<%=session.getAttribute("path")%>">
                            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
                            <button type="submit" class="btn btn-primary btn-sm">Create Directory  <i class="icon-folder"></i></button>
                        </div>
                    </form>
                </li>
                <li class="active">
                    <form action="#" method="get">
                        <div class="search">
                            <input type="file" class="form-control input-sm" maxlength="64" placeholder="Name" name="name" />
                            <input type="hidden" name="path" value="<%=session.getAttribute("path")%>">
                            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
                            <button type="submit" class="btn btn-primary btn-sm">Upload File <i class="icon-file"></i></button>
                        </div>
                    </form>
                </li>
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
                <h3>Dashboard <small>Merhaba <%=session.getAttribute("name")%></small></h3>
            </div>
        </div>
        <!-- /page header -->


        <!-- Breadcrumbs line -->
        <div class="breadcrumb-line">
            <ul class="breadcrumb">
                <li class="active"><%=session.getAttribute("path")%></li>
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
                        <th>AD</th>
                        <th class="task-priority">TÜR</th>
                        <th class="task-progress">PATH</th>
                        <th class="task-date-added">SON DEĞİŞTİRME</th>
                        <th class="task-progress">BOYUT</th>
                        <th class="task-tools text-center">İŞLEMLER</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        JSONObject tumJSON = JSONObject.fromObject(session.getAttribute("folderList"));
                        JSONObject dosya = null;

                        for(int i = 0; i < tumJSON.size(); i++){
                            dosya = (JSONObject) tumJSON.get(String.valueOf(i));
                    %>
                    <tr>
                        <td class="task-desc">
                            <a href="/dashboard/path?username=<%=session.getAttribute("username")%>&path=<%=session.getAttribute("path")+ "/" +dosya.get("ad")%>"><%out.print(dosya.get("ad"));%></a>
                        </td>
                        <td class="text-center"><span class="label label-danger"><%out.print(dosya.get("tur"));%></span></td>
                        <td class="text-center"><span class="label label-primary"><%out.print(request.getAttribute("path"));%></span></td>
                        <td><%out.print(dosya.get("sonDegisim"));%></td>
                        <td><%out.print(dosya.get("boyut"));%> KB (
                            <%
                                int boyut = (int) dosya.get("boyut");
                                Double mbboyut = Double.valueOf(boyut/1024);
                            out.print(mbboyut);
                            %> MB)
                        </td>
                        <td class="text-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-icon btn-success dropdown-toggle" data-toggle="dropdown"><i class="icon-cog4"></i></button>
                                <ul class="dropdown-menu icons-right dropdown-menu-right">

                                    <%
                                        if(dosya.get("tur").equals("dizin")){
                                    %>
                                        <li><a href="/dashboard/deleteDirectory?username=<%=session.getAttribute("username")%>&path=<%=session.getAttribute("path")%>&fileName=<%=dosya.get("ad")%>"><i class="icon-share2"></i>Sil</a></li>
                                        <li>
                                            <form method="get" action="/dashboard/renameDirectory">
                                                <input type="text" width="auto" placeholder="rename" name="newName">
                                                <input name="username" type="hidden" value="<%=session.getAttribute("username")%>">
                                                <input name="fileName" type="hidden" value="<%=dosya.get("ad")%>">
                                                <input name="path" type="hidden" value="<%=session.getAttribute("path")%>">
                                            </form>
                                        </li>
                                    <%
                                        }else{
                                    %>
                                        <li><a href="/dashboard/deleteFile?username=<%=session.getAttribute("username")%>&path=<%=session.getAttribute("path")%>&fileName=<%=dosya.get("ad")%>"><i class="icon-share2"></i>Sil</a></li>
                                    <li>
                                        <form method="get" action="/dashboard/renameFile">
                                            <input type="text" width="auto" placeholder="rename" name="newName">
                                            <input name="username" type="hidden" value="<%=session.getAttribute("username")%>">
                                            <input name="fileName" type="hidden" value="<%=dosya.get("ad")%>">
                                            <input name="path" type="hidden" value="<%=session.getAttribute("path")%>">
                                        </form>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    %>
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

