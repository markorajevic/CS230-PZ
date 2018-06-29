$(document).ready(function(){
  $('table').each(function() {
        $(this).addClass('table');	
        $(this).find("thead").addClass('thead-dark');
        $(this).find("a:contains('Vidi')").addClass('btn btn-outline-success btn-sm');
        $(this).find("a:contains('Izmeni')").addClass('btn btn-outline-info btn-sm');
        $(this).find("a:contains('Izbrisi')").addClass('btn btn-outline-danger btn-sm');
        $(this).find("a:contains('Sacuvaj')").addClass('btn btn-outline-danger btn-sm');
  });
});