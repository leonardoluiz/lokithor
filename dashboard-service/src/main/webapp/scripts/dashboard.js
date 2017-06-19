var map = null;

function addMarker(data) {
	$(data).each(function(index, location) {
		var coord = {
			lat : location.latitude,
			lng : location.longitude
		};
		var marker = new google.maps.Marker({
			position : coord,
			map : map,
			title : location.deviceId + ' ' + location.time
		});
		console.debug("Adding marker : " + coord.lat + " " + coord.lng)
		marker.addListener('click', function() {
			map.setZoom(8);
			map.setCenter(marker.getPosition());
		});
	});
}

function executeQuery() {
	google.maps.event.trigger(map, 'resize')
	$.ajax({
		url : 'api/devicelocation',
		success : function(data) {
			addMarker(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.error("Status: " + textStatus);
		},
		complete : function() {
			setTimeout(executeQuery, 5000);
		}
	});
}

function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : 53.39756,
			lng : 10.203786
		},
		scrollwheel : false,
		zoom : 2
	});
	setTimeout(executeQuery, 2500);
}
