var main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
    },
    checkNickNm: function () {
        const nickNm = $('#nickNm').val();

        $.ajax({
               type: 'GET',
               url: '/checkNm/' + nickNm,
               dataType: 'json',
               contentType: 'application/json; charset=utf-8',
               data: JSON.stringify(data)
           }).done(function () {
                alert("회원가입 되었습니다.");
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
    },
    save: function () {
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
       }).done(function () {
           alert("회원가입 되었습니다.");
       }).fail(function (error) {
           alert(JSON.stringify(error));
       });
    }
};

main.init();