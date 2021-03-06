<#import "/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="首页">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<!-- DataTables Responsive CSS -->
    <link href="${basePath}/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
    
    <!-- DataTables JavaScript -->
    <script src="${basePath}/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="${basePath}/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    
    <script>
	    $(document).ready(function() {
	        $('#dataTables-example').DataTable({
	                responsive: true
	        });
	    });
    </script>
    
</head>

<body id="index">
	<div class="row">
		<div class="col-lg-12">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	用户列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th width="20%">ID</th>
                                            <th width="40%">姓名</th>
                                            <th width="40%">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<#list userList as list>
                                    	<tr class="odd gradeX">
                                            <td>${list.userId!!}</td>
                                            <td>${list.userName!!}</td>
                                            <td> 
                                            	
                                            </td>
                                        </tr>
                                    	</#list>
                                        
                                       
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            
            
            
            
            
	    </div>
	
	</div>
 
</body>
</html>
</@layout.page>
</#escape>