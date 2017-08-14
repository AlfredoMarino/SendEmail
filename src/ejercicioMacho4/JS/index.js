$(document).ready(function () {
    refreshTable();

    //llena combo de pais
    $.ajax({
        url: "queryJson.php?qry=2",
        type: "Get",
        success: function (data) { 
            try{
                var content = JSON.parse(data);
                        
                $("#country").empty();
                for (var i = content.length - 1; i >= 0; i--) {
                    
                    $("#country").append("<option value=" + content[i].id_pais + ">" + content[i].nombre_pais + "</option>");
                }
            }catch(err){

            }
            
        },
        error: function (msg) { alert(msg); }
    });
     
    //carga el combo ciudad dependiendo del pais
    $('#country').change(function(){
        var id= $('#country').val();
        $.ajax({
            url: "queryJson.php?qry=1&c=" + id,
            type: "Get",
            success: function (data) { 
              
                var content = JSON.parse(data);
               
                $("#cities").empty();
                for (var i = content.length - 1; i >= 0; i--) {
                   
                    $("#cities").append("<option value=" + content[i].id_ciudad + ">" + content[i].nombre_ciudad + "</option>");
                }
            },
            error: function (msg) { alert(msg); }
        });
    });  
    
    $('#rut').keyup(function(){
        var str= $('#rut').val();
        $.ajax({
            url: "queryJson.php?qry=3&c=" + str,
            type: "Get",
            success: function (data) { 

                try{
                    var content = JSON.parse(data);

                    $("#name").val(content[0].nombre);
                    $("#email").val(content[0].email);
                    $("#phone_number").val(content[0].telefono);
                    $("select#country").prop('value', content[0].id_pais);
                    //$("#country").append("<option value=" + content[i].id_pais + ">" + content[i].nombre_pais + "</option>");
                    //$("#cities").append("<option value=" + content[i].id_ciudad + ">" + content[i].nombre_ciudad + "</option>");
                    $("#button").val("Modificar");

                }catch(err){
                    $("#name").val("");
                    $("#email").val("");
                    $("#phone_number").val("");
                    $("#country").val("");
                    $("#cities").val("");
                    $("#button").val("Insertar");
                }
            },
            error: function (msg) { alert(msg); }
        });
    }); 

    $('#button').click(function(e){
        
        e.preventDefault();

        var dataString = $('#form1').serialize();

        alert('Datos serializados: '+dataString);

        $.ajax({
            type: "POST",
            url: "action_controller.php",
            data: dataString,
            success: function(data) {
                refreshTable();
            }
        });
    });
    

    function refreshTable(){
        $.ajax({
            url: "queryJson.php?qry=4",
            type: "Get",
            success: function (data) { 
              
                var content = JSON.parse(data);
                
                for (var i = content.length - 1; i >= 0; i--) {
                   
                    $("#master_table").append("<tr><td>" + content[i].rut + "</td><td>" + content[i].nombre + "<td>" + content[i].email + "</td><td>" + content[i].telefono + "<td>" + content[i].nombre_pais + "<td>" + content[i].nombre_ciudad + "</td></tr>");

                }
            },
            error: function (msg) { alert(msg); }
        });

    }
    	
}); 