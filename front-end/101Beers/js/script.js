$(document).ready(function () {
    var endPoint = 'https://api.punkapi.com/v2/';
    // var query = 'beers?page=1&per_page=5';
    var query = 'beers';
    var url = new URL(endPoint + query);

    var beers = [];
    var foodPair = 'This beer will go perfectly with:';
    $.getJSON(url, function (data) {
        beers.push(data);
        console.log('success');
        traverse(beers);
    }, "jsonp");

    function traverse(beers) {
        if (beers) {
            console.log(beers);
            for (var i = 0; i < beers[0].length; i++) {
                var beer = beers[0][i];
                console.log(beer.name);

                $("#beers-container").append(
                    $("<article></article>")
                    .addClass("beer-box")
                    .attr("id", beer.id)
                );

                var $article = $(".beer-box#" + beer.id);

                $article.append(
                    $("<h1></h1>")
                    .addClass("beer-name")
                    .html(beer.name)
                );
                $article.append($("<img />")
                    .attr("src", beer.image_url)
                    .attr("alt", beer.name)
                );

                $article.append($("<h2></h2>")
                    .html(beer.tagline)
                );

                $article.append(
                    $("<div></div>")
                    .addClass("beer-abv")
                    .html(beer.abv)
                );

                $article.append(
                    $("<button></button>")
                    .addClass("more-info")
                    .html("more info")
                );

                $article.append(
                    $("<div></div>")
                    .addClass("beer-details")
                );

                var $details = $("#" + beer.id + " .beer-details");
                $details.append(
                    $("<p></p>")
                    .addClass("beer-description")
                    .html(beer.description)
                );
            
                $details.append(
                    $("<p></p>")
                    .addClass("beer-tips")
                    .html(beer.description)
                );

                $details.append(
                    $("<p></p>")
                    .addClass("food-pair")
                    .html(foodPair)
                );

                $details.append(
                    $("<ul></ul>")
                    .addClass("food-pair")
                    .html(function(){
                        beer.food_pairing.forEach(element => {
                            $("<li></li>")
                            .html(element)
                            .appendTo("#" + beer.id + " .food-pair")
                        });
                    })
                );

            }
        }
    };

});