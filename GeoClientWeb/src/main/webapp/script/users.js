$(document).ready(function() {

    $.ajax({
        url: "UserController",
        data: { op:"load" },
        method: "POST",
        success: function(data) {
			console.dir(data);
            remplir(data);
        }
    });

	$("#add").click(function() {
		var birthdate = $("#birthdate").val();
		var email = $("#email").val();
		var name = $("#name").val();
		$.ajax({
			url: "UserController",
			data: {birthdate: birthdate, email: email, name: name},
			method: "POST",
			success: function(data) {
				remplir(data);
			}
		});
	});

	function remplir(data) {
		var ligne = "";
		data.forEach(e => {
			ligne += "<tr><td>" + e.birthDate + "</td><td>" + e.name + "</td><td>" + e.email + "</td>";
		});
		$("#content").html(ligne);
	}
	
});

