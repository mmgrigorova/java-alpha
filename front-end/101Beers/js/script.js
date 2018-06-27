$(document).ready(function () {
    var endPoint = 'https://api.punkapi.com/v2/';
    var query = 'beers?page=1&per_page=20';
    var url = new URL(endPoint + query);

    var beers = [];
    $.getJSON(url, function (data) {
        beers.push(data);
        console.log('success');
        traverse(beers);
    }, "jsonp");

    var traverse = function (beers) {
        if (beers) {
            console.log(beers);
            for (var i = 0; i < beers[0].length; i++) {
                var beer = beers[0][i];
                console.log(beer.name);
                $('#beers-container').append(
                    '<article>' +
                    '<img src="' + beer.image_url + '" class="beerImg">' +
                    '<h2>' +
                    beer.name +
                    '</h2>' +
                    '<p>' +
                    beer.description +
                    '</p>' +
                    '</article>'
                );
            }
        }
    };
});