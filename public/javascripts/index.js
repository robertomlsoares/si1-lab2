$(function () {
    $("#busca").on("input", function (data) {
        var instrumentos = $("#checkInstrumentos").is(":checked");
        var estilos = $("#checkEstilos").is(":checked");
        var interesse = $("#checkInteresse").is(":checked");
        var anuncios = $(".anuncio");
        var buscaInput = $("#busca").val().toLowerCase();
        var anuncio;
        var resultado;

        for (var i = 0; i < anuncios.length; i++) {
            anuncio = $(anuncios[i]); // Wrap em jQuery
            resultado = true;

            if (instrumentos) {
                if (anuncio.find(".anuncioInstrumentos").text().toLowerCase().indexOf(buscaInput) == -1) {
                    resultado = false;
                }
            } else if (estilos) {
                if (anuncio.find(".anuncioEstilos").text().toLowerCase().indexOf(buscaInput) == -1) {
                    resultado = false;
                }
            } else if (interesse) {
                if (anuncio.find(".anuncioInteresse").text().toLowerCase().indexOf(buscaInput) == -1) {
                    resultado = false;
                }
            } else {
                if (anuncio.text().toLowerCase().indexOf(buscaInput) == -1) {
                    resultado = false;
                }
            }

            if (resultado) {
                anuncio.show();
            } else {
                anuncio.hide();
            }
        }
    })
});