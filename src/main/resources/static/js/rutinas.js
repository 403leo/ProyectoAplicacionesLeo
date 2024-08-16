// Carga un arhivo imagen en memoria y lo presenta en pantalla.
function readURL(input) {
    if (input.files && input.files[0]) {
        // Este atributo va a ser posible leer el arhivo y mostrarlo 
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }

}

// La siguiente funcion se utiliza para hacer un llamado javaScript
//La siguiente función, agrega en el carrito de compras un producto
//En la variable de sesión items, hace un llamado Ajax
function addCart(formulario) {
    var valor = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias > 0) {
        var url = "/carrito/agregar/" + valor;
        $("#resultsBlock").load(url);

    }
}