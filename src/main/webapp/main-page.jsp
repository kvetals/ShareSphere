<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html ng-app = "shareSphereApp">
	<head>
		<meta charset="utf-8">
		<title>ShareSphere</title>
		<link rel="icon" type="image/png" href="resources/img/favicon.png" />
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic&subset=latin,cyrillic-ext,cyrillic,latin-ext' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/login_styles.css" type="text/css">
		<link rel="stylesheet" href="resources/css/main_styles.css" type="text/css">
		<link rel="stylesheet" href="resources/fonts/font-awesome-4.5.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
		<script>
			var shareSphereApp = angular.module('shareSphereApp', []);
				shareSphereApp.controller('shareSphereCtrl', function($scope, $http){
					$scope.refresh = function(){
						$http.get('fsObjects/getRoot').success(function(data){
							$scope.jsonData = data;
						});
					}
					$scope.deleteFsObject = function(id){
						$http.get('fsObject/remove/' + id).success(function(data){
							$scope.jsonData = data;
						});
					}
					$scope.getChildredOfFsObject = function(id){
						$http.get('fsObject/getChildren/' + id).success(function(data){
							$scope.jsonData = data;
						});
					}
					$scope.oneLayerUp = function(){
						$http.get('fsObject/oneLayerUp').success(function(data){
							$scope.jsonData = data;
						});
					}
					$scope.getPreviewOfFsObject = function(id){
						$http.get('fsObject/getPreview/' + id).success(function(data){
							$scope.jsonData = data;
						});
					}
					
					$scope.sortField = 'name';
					$scope.reverse = true;
					$scope.refresh();
				});
			
		</script>

		
	</head>
	
	<body ng-controller = "shareSphereCtrl">
	
		<div class="b-page">
			<div class="b-page-wr">
				<div class="b-header">
					<div class="b-page-width">
						<div class="b-header__logo">
							<img class="b-header_image" src="resources/img/header/logo.png"/>
						</div>
						<div class="b-header__functionality">
							<div class="b-header__functionality__user-info">
								<div class="b-header__functionality__user-info_notification">
									<!--<span class="fa fa-bell"></span>-->
									<span class="b-header__functionality__user-info_notification-quantity" ng-class="jsonData.userNotifications.length > 0 ? 'active' : ''">{{jsonData.userNotifications.length}}</span>
								</div>
								<div class="b-header__functionality__user-info_photo">
									<img src="resources/img/header/userProfileImg.png" class="b-header__functionality__user-info_photo-image"/>
								</div>
								<div class="b-header__functionality__user-info_name">
									<span class="b-header__functionality__user-info_name-style">{{jsonData.userName}}</span>
									<div class="b-header__functionality__user-info_name-menu">
									</div>
								</div>
							</div>
							<div class="b-header__functionality__actions">
								<div class="b-header__functionality__actions__action-wraper">
									<div class="b-header__functionality__actions__action b-header__functionality__actions__upload">
										<span class="b-header__functionality__actions_hint">Загрузить</span>
									</div>
									<div class="b-header__functionality__actions__action b-header__functionality__actions__create-folder">
										<span class="b-header__functionality__actions_hint">Создать папку</span>
									</div>
									<div class="b-header__functionality__actions__action b-header__functionality__actions__share">
										<span class="b-header__functionality__actions_hint">Поделиться</span>
									</div>
									<div class="b-header__functionality__actions__action b-header__functionality__actions__delete">
										<span class="b-header__functionality__actions_hint">Удалить</span>
									</div>
								</div>
							
								<div class="b-header__functionality__search">
									<form action="logout" id="search-from-actual" class="b-header__functionality__search__searc-form">
										<input ng-model="filterQuery" type="text" id="searchFilterInput" placeholder="Поиск"  class="b-header__functionality__search__searc-form_text-input">
										<input type="submit" value="" class="b-header__functionality__search__searc-form_submit-input">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="b-body">
					<div class="b-page-width">
						<div class="b-body_content-wraper">
							<div class="b-body__navigation">
								<ul class="b-body__navigation__menu-list">
									<li class="b-body__navigation__menu-list-item">
										<a href="#">
											<div class="b-body__navigation__menu-list-item_picture b-body__navigation__menu-list-item_picture-files"></div>
											<div class="b-body__navigation__menu-list-item_text">Файлы</div>
										</a>
									</li>
									<li class="b-body__navigation__menu-list-item">
										<a href="#">
											<div class="b-body__navigation__menu-list-item_picture b-body__navigation__menu-list-item_picture-group"></div>
											<div class="b-body__navigation__menu-list-item_text">Группа</div>
										</a>
									</li>
									<li class="b-body__navigation__menu-list-item">
										<a href="#">
											<div class="b-body__navigation__menu-list-item_picture b-body__navigation__menu-list-item_picture-shared-access"></div>
											<div class="b-body__navigation__menu-list-item_text">Общий доступ</div>
										</a>
									</li>
									<li class="b-body__navigation__menu-list-item">
										<a href="#">
											<div class="b-body__navigation__menu-list-item_picture b-body__navigation__menu-list-item_picture-files-deleted"></div>
											<div class="b-body__navigation__menu-list-item_text">Файлы удалены</div>
										</a>
									</li>
								</ul>
							</div>
							<div class="b-body__content">
								<table class="sort" align="center">
									<thead>
										<tr>
											<td ng-click="refresh()">В корень</td>
											<td ng-click="oneLayerUp()">На уровень вверх</td>
										</tr>
										<tr>
											<td ng-click="sortField = 'name'; reverse = !reverse" width="240px">Имя</td>
											<td ng-click="sortField = 'changed'; reverse = !reverse" width="160px">Изменено</td>
											<td ng-click="sortField = 'extension'; reverse = !reverse" width="80px">Расш.</td>
											<td ng-click="sortField = 'size'; reverse = !reverse" width="70px">Размер</td>
											<td width="140px"> </td>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="file in jsonData | filter:filterQuery | orderBy:sortField:reverse" ng-class="file.objectTypeId > 1 ? 'file' : 'folder'">
											<td width="240px">
												<div class="table-file-icon-container">
													<div class="table-file-icon file"></div>
													<div class="table-file-icon folder"></div>
												</div>
												{{file.fsObjectName}}
											</td>
											<td>{{file.fsObjectPath}}</td>
											<td>{{file.extension}}</td>
											<td>{{file.fsObjectId}}</td>
											<td>
												<div class="cogwheel">
													<div class="cogwheel-menu file">
														<ul class="cogwheel-menu-list">
															<li class="cogwheel-menu-list-item">
																<a ng-click="getPreviewOfFsObject(file.fsObjectId)" href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-open"></div>
																	<div class="cogwheel-menu-list-item_text">Открыть</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-send"></div>
																	<div class="cogwheel-menu-list-item_text">Отправить</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a ng-click="deleteFsObject(file.fsObjectId)" href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-delete"></div>
																	<div class="cogwheel-menu-list-item_text">Удалить</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-rename"></div>
																	<div class="cogwheel-menu-list-item_text">Переименовать</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-move"></div>
																	<div class="cogwheel-menu-list-item_text">Переместить...</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-copy"></div>
																	<div class="cogwheel-menu-list-item_text">Копировать...</div>
																</a>
															</li>
														</ul>
													</div>
													<div class="cogwheel-menu folder">
														<ul class="cogwheel-menu-list">
															<li class="cogwheel-menu-list-item">
																<a ng-click = "getChildredOfFsObject(file.fsObjectId)" href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-open"></div>
																	<div class="cogwheel-menu-list-item_text">Открыть</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a ng-click="deleteFsObject(file.fsObjectId)" href="">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-delete"></div>
																	<div class="cogwheel-menu-list-item_text">Удалить</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-rename"></div>
																	<div class="cogwheel-menu-list-item_text">Переименовать</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-move"></div>
																	<div class="cogwheel-menu-list-item_text">Переместить...</div>
																</a>
															</li>
															<li class="cogwheel-menu-list-item">
																<a href="#">
																	<div class="cogwheel-menu-list-item_picture cogwheel-menu-list-item_picture-copy"></div>
																	<div class="cogwheel-menu-list-item_text">Копировать...</div>
																</a>
															</li>
														</ul>
													</div>
												</div>
												<div class="share-button file">Поделиться</div>
												<div onclick="shareButtonMenuActivator(this)" class="share-button folder">Поделиться
													<div class="share-button-menu-enter">
														<div class="share-button-menu">
															<div class="share-button-menu-item">
																<div class="share-button-menu-item_picture share-button-menu-item_picture-invite"></div>
																<div class="share-button-menu-item_text">
																	<div class="share-button-menu-item_text-header">Пригласить пользователей, чтобы работать вместе...</div>
																	<div class="share-button-menu-item_text-description">Пользователи смогут изменять и синхронизировать</div>
																</div>
															</div>
															<div class="share-button-menu-item">
																<div class="share-button-menu-item_picture share-button-menu-item_picture-send"></div>
																<div class="share-button-menu-item_text">
																	<div class="share-button-menu-item_text-header">Отправить ссылку...</div>
																	<div class="share-button-menu-item_text-description">Пользователи смогут просматривать</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												
											</td>
										</tr>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="resources/js/mainPage.js"></script>
		<script>
			var textInputElement = document.getElementById('searchFilterInput');

			textInputElement.addEventListener('keyup', function(){
				var text = textInputElement.value;
				console.log('New text is "' + text + '"');
			});
		</script>
	</body>
</html>