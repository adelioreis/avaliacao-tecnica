$(document).ready(function () {
    $(".menu-veiculos").addClass("active");

    /**
     * Ao clicar no botão de confirmação na janela modal,
     * será enviado ao back-end a requisição.
     * No final da requisição a tela será atualizada.
     */
    $("#confirmarApagarVeiculo").on("click", function () {
        $.ajax('/veiculos/apagar/' + $("#veiculo-id").val())
            .done(function () {
                $("#deleteModal").modal('hide');
                location.reload();
            });
    });

});

/**
 * Exibe o modal solicitando confirmação para apagar registro.
 * @param id do registro a ser apagado.
 * @param descricao do registro a ser apagado.
 */
function exibirModalDelete(id, descricao) {
    $("#veiculo-id").val(id);
    $("#veiculo-descricao").html(descricao);
    $("#deleteModal").modal('show');
}