		$(document).ready(
				function() {
					$('#login').submit(
							function() {
								//자동으로 submit 막기
								event.preventDefault();
								var id = $('#Id').val();
								console.log(id);

								//서버로 post 전송 - ajax
								$.post("http://httpbin.org/post", {
									"id" : id
								}, function(data) {
									var mymodal = $('#mymodal');
									mymodal.modal();
									mymodal.find('.modal-body').text(
											data.form.id + "님 로그인 되셨습니다.");
								});
							});
				});
		$(document).ready(
				function() {
					$('#s').submit(
							function() {
								//자동으로 submit 막기
								event.preventDefault();
								var id = $('#Id1').val();
								console.log(id);

								//서버로 post 전송 - ajax
								$.post("http://httpbin.org/post", {
									"id" : id
								}, function(data) {
									var mymodal = $('#mymodal');
									mymodal.modal();
									mymodal.find('.modal-body').text(
											data.form.id + "님 회원가입 되셨습니다.");
								});
							});
				});
