
      $(document).ready(function () {
        $('#Form').submit(function (event) {
          event.preventDefault();
          var id = $('#id').val();
          var pwd = $('#pwd	').val();
          $.post("http://httpbin.org/post",
          {id: id, pwd: pwd},
          function(data) {
            var mm = $('#mymodal');
            mm.modal();
            mm.find(".modal-body").text(data.form.id + "님 로그인되었습니다.");
          });
        });
      });
      

      $(document).ready(function () {
        $('#For').submit(function (event) {
          event.preventDefault();
          var id = $('#name').val();
          $.post("http://httpbin.org/post",
          {"id": id},
          function(data) {
            var mm = $('#mmodal');
            mm.modal();
            mm.find(".modal-body").text(data.form.id + "님 회원가입되었습니다.");
          });
        });
      });