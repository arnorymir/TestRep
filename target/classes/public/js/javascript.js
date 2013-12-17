alert("afewa");
  $(document).ready(function() {
  $('#squareForm').hide();
      var form = $('form');
          var firstForm = 0;
      form.submit(function(e) {
        var marker = $("#marker").val();

        $.ajax({
          type: form.attr('method'),
          url: form.attr('action'),
          data: 'marker=' + marker
        }).done(function(setMarker) {
                  $('#results').html('You are  ' + setMarker);
                  $("form#firstForm")[0].reset();
        }).fail(function() {
          $('#results').html('What happened?');
        });
        e.preventDefault();
      });
          var squareForm = $('#squareForm');
    var bla  = $('.ticTacToeButton');

          bla.click(function(e) {
        
   var blonster = $(this).attr('name');
                $.ajax({

          type: squareForm.attr('method'),
          url: squareForm.attr('action'),
          data: 'square=' + blonster
        }).done(function(returnValue) {
        
                        $('#cell' + returnValue[0]).html('X').attr('class', 'alert alert-success');
                        $('#cell' + returnValue[1]).html('O').attr('class', 'alert alert-success');
                        if(returnValue[2] == 't'){
                                $('#gameResult').html("It's a TIE");
                        }
                        if(returnValue[2] == 'w'){
                                $('#gameResult').html("You have won!!!!");

                        }
                        if(returnValue[2] == 'l'){
                                $('#gameResult').html("You LOSE!");

                        }
        }).fail(function() {
          $('#results').html('Select X or O');
        });
        e.preventDefault();
      });
    });
 