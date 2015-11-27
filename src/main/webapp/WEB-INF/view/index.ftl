<#import "/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="首页">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body id="index">
	<div class="row">
		<div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                Basic Tabs
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <!-- Nav tabs -->
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#home" data-toggle="tab">Home</a>
	                    </li>
	                    <li><a href="#profile" data-toggle="tab">Profile</a>
	                    </li>
	                    <li><a href="#messages" data-toggle="tab">Messages</a>
	                    </li>
	                    <li><a href="#settings" data-toggle="tab">Settings</a>
	                    </li>
	                </ul>
	
	                <!-- Tab panes -->
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="home">
	                        <h4>Home Tab</h4>
	                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	                    </div>
	                    <div class="tab-pane fade" id="profile">
	                        <h4>搜索</h4>
	                    	<p>
                                <button type="button" class="btn btn-primary">增量备份恢复</button>
                                <button type="button" class="btn btn-primary">全量备份恢复</button>
                          <#--  <button type="button" class="btn btn-success">Success</button>
                                <button type="button" class="btn btn-default">Default</button>
                                <button type="button" class="btn btn-info">Info</button>
                                <button type="button" class="btn btn-warning">Warning</button>
                                <button type="button" class="btn btn-danger">Danger</button>
                                <button type="button" class="btn btn-link">Link</button>-->
                            </p>
	                    </div>
	                    <div class="tab-pane fade" id="messages">
	                        <h4>Messages Tab</h4>
	                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	                    </div>
	                    <div class="tab-pane fade" id="settings">
	                        <h4>Settings Tab</h4>
	                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	                    </div>
	                </div>
	            </div>
	            <!-- /.panel-body -->
	        </div>
	        <!-- /.panel -->
	    </div>
	
	</div>
 
</body>
</html>
</@layout.page>
</#escape>