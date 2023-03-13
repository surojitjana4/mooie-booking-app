$(document).ready(function() {

	$('#movie_table').DataTable({
		autoWidth: false,
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell',
			},
		],
	});

	$('#booking_table').DataTable({
		autoWidth: false,
		columnDefs: [
			{
				targets: ['_all'],
				className: 'mdc-data-table__cell',
			},
		],
	});


	$("#datepicker").datepicker({
		dateFormat: "dd-mm-yy"
	});

});

function _openmodal(cinema_id, username, movie_name) {

	$("#exampleModalLongTitle").text("Book " + movie_name);


	//$('#dropDownId').val();

	$('#cinema_id').val(cinema_id);
	$('#username').val(username);
	$('#movie_name').val(movie_name);
	$('#bookMovieModal').modal('show');
}



function _bookmovie() {
	if ($('#datepicker').val() === '' || $('#datepicker').val() === undefined || $('#datepicker').val() === null) {
		alert("Please select a date!");
	} else {
		$.post("/bookmovie", {
			'cinemaId': $('#cinema_id').val(),
			'username': $('#username').val(),
			'date': $('#datepicker').val(),
			'time': $('#timeslot').val()
		})
			.done(function(data) {
				alert("You have successfully booked the movie");
				location.reload();
			});
	}
}

function _opendeletemodal(cinema_id, user_id) {
	$('#delete_cinema_id').val(cinema_id);
	$('#delete_userid').val(user_id);
	$('#deleteModal').modal('show');
}

function _deletebooking() {

	console.log($('#delete_cinema_id').val() + " " + $('#delete_userid').val());


	$.ajax({
		url: '/delete_booking',
		type: 'DELETE',
		data: {
			'cinemaId': $('#delete_cinema_id').val(),
			'userId': $('#delete_userid').val()
		},
		success: function(result) {
			alert("Booking deleted successfully");
			location.reload();
		}
	});
}

