$(function() {

    $('a').on('click', function(){

        var $this = $(this),
            hash = $this.attr('href');

        if ( hash !== '#' ) {
            console.log(hash);
        }

    });

});
