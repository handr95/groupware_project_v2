var main= {
    checkNickNmYn: false,
    init: function () {
        const _this = this;
        $('#btn-add-project').on('click', function () {
            _this.addProject();
        });
    },
    addProject: function (_this) {
        const param = {
            projectTitle: $('#projectTitle').val(),
            projectDesc: $('#projectDesc').val(),
            openYn: $('#openYn').is(':checked') == true ? 1 : 0
        };

        $.ajax({
                   type: 'POST',
                   url: '/project',
                   dataType: 'json',
                   contentType: 'application/json; charset=utf-8',
                   data:JSON.stringify(param)
               }).done(function (res) {
            alert("프로젝트 추가 완료되었습니다.");
            location.href = "/"
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();