var main = {
    checkNickNmYn: false,
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save(_this);
        });
        $('#btn-check-nickNm').on('click', function () {
            _this.checkNickNm(_this);
        });
    },
    checkNickNm: function (_this) {
        const nickNm = $('#nickNm').val();

        $.ajax({
               type: 'GET',
               url: '/checkNm/' + nickNm,
               dataType: 'json',
               contentType: 'application/json; charset=utf-8',
           }).done(function (res) {
               console.log(res);
               if (res == false) {
                   _this.checkNickNmYn = false;
                   alert("이미 존재하는 닉네임 입니다.");;
               } else {
                   _this.checkNickNmYn = true;
                   alert("사용할 수 있는 닉네임 입니다.");
               }
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
    },
    save: function (_this) {
        if (_this.checkNickNmYn == false) {
            alert("닉네임 중복 체크 해주세요.");
            return;
        }
        const data = {
            nickNm: $('#nickNm').val(),
            pwd: $('#pwd').val(),
            email: $('#email').val()
        };

        $.ajax({
           type: 'POST',
           url: '/signup',
           dataType: 'json',
           contentType: 'application/json; charset=utf-8',
           data: JSON.stringify(data)
       }).done(function (res) {
           alert("회원가입 되었습니다.");
           location.href = "/"
       }).fail(function (error) {
           alert(JSON.stringify(error));
       });
    }
};

main.init();