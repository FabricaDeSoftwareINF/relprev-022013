var inputCategoria = $(".inputNome").clone().removeClass("hidden");
var adicionarCategoria = $(".adicionarCategoria").clone().removeClass("hidden");
var iconeAdicionarCategoria = $("#iconeAdicionar").clone();
var botaoModalExclusao = $("#botaoModalExclusao").clone().removeClass("hidden");
var itemCategoria = $("#itemCategoria").clone().removeClass("hidden");

var subCategorias = false;
var categoriaSelecionada;
var subCategoriaSelecionada;
var elementoSelecionado;
var categorias = [];

function Categoria(nome) {
	this.nome = nome;
	this.subCategorias = [];
	this.acrescentarSubCategoria = function(subCategoria) {
		this.subCategorias.push(subCategoria);
	};
	this.removerSubCategoria = function(indice) {
		this.subCategorias.splice(indice, 1);
	};
}

$(function() {

	// Exemplo
	var categoriaFabricante = new Categoria("Fabricante");
	categoriaFabricante.acrescentarSubCategoria("Embraer");
	categoriaFabricante.acrescentarSubCategoria("Boeing");
	categorias.push(categoriaFabricante);

	inicializar();

	$('#listaCategorias, #listaSubCategorias').selectable();
	

	/** Eventos */

	/*
	 * Evita que múltiplos elementos sejam selecionados
	 */
	$("#listaCategorias, #listaSubCategorias").on("click", function(event) {
		$(this).siblings().removeClass("selected");
		$(this).addClass("selected");
	});

	/*
	 * Evento de clique do botão de exclusão
	 */
	$(".list-group").on("selectableunselected", function(event, ui) {
		$(ui.unselected).children("#botaoModalExclusao").remove();
	});

	/*
	 * Evente de seleção de um selectable
	 */
	$(".list-group").on("selectableselected", function(event, ui) {
		if (elementoSelecionado !== undefined) {
			elementoSelecionado.children("#botaoModalExclusao").remove();
		}
		elementoSelecionado = $(ui.selected);
		if (elementoSelecionado.hasClass('adicionarCategoria')) {
			iniciarEntrada(ui);
		} else {
			if (elementoSelecionado.find('#botaoModalExclusao').length === 0) {
				elementoSelecionado.append(botaoModalExclusaoFactory());
			}

			var index;
			if (!isSubCategoria($(ui.selected))) {
				index = $("#listaCategorias a").index(ui.selected);
				categoriaSelecionada = categorias[index];
			} else {
				index = $("#listaSubCategorias a").index(ui.selected);
				subCategoriaSelecionada = index;
			}
			if (subCategorias && !isSubCategoria($(ui.selected))) {
				mostrarSubCategorias();
			}
		}
	});

	/*
	 * Evento de tratamento de entradas do usuário
	 */
	$("#listaCategorias, #listaSubCategorias").on('keyup', '.inputNome',
			function(e) {
				if (e.keyCode === 13) { // Esc
					finalizarEntrada(e.target);
				} else if (e.keyCode === 27) { // Enter
					cancelarEntrada(e.target);
				}
			});

	/*
	 * Cancela a entrada caso o usuário tire o foco do input
	 */
	$("#listaCategorias, #listaSubCategorias").on('focusout', '.inputNome',
			function(e) {
				cancelarEntrada(e.target);
			});

	/*
	 * Evento de clique no botão exclusão de categoria
	 */
	$('.list-group').on('click', '#botaoModalExclusao', function(e) {
		$('#modalConfirmacaoExclusao').modal();
	});

	/*
	 * Evento de confirmação de exclusão de categoria
	 */
	$('#modalConfirmacaoExclusao').on('click', '#botaoExcluirCategoria',
			function(e) {
				excluirCategoria(elementoSelecionado);
				$('#modalConfirmacaoExclusao').modal('hide');
			});

	/*
	 * Evento de mudança no valor do checkbox de sub-categorias
	 */
	$("#checkboxSubCategorias").change(function(e) {
		subCategorias = $(e.target).prop('checked');
		if (subCategorias) {
			mostrarSubCategorias();
		} else {
			esconderSubCategorias();
		}
	});

});

/*
 * Retorna se um elemento pertence à lista de categorias ou de sub-categorias
 * @param {type} @returns {Boolean}
 */
function isSubCategoria(elemento) {
	return $(elemento).parents('#listaSubCategorias').length !== 0;
}

/*
 * Preenche a lista de categorias com o conteúdo do array.
 */
function inicializar() {
	preencherLista($('#listaCategorias'), categorias);
}

/*
 * Preenche a lista (categorias ou sub-categorias) com os elementos @param
 * {Array} lista @param {Array} elementos
 */
function preencherLista(lista, elementos) {
	if (elementos !== undefined) {
		for (var i = 0; i < elementos.length; i++) {
			lista.append(itemCategoriaFactory(elementos[i]));
		}
	}

	lista.append(adicionarCategoriaFactory());
}

/*
 * Modifica o elemento da lista para a entrada do usuário @param {ui} Elemento
 * selecionado (jQuery UI) @returns {undefined}
 */
function iniciarEntrada(ui) {
	var inputCategoria = inputCategoriaFactory();
	$(ui.selected).html(inputCategoria);
	inputCategoria.focus();
}

/*
 * Insere a entrada do usuário na lista e no array adequado @param {} Input de
 * entrada do usuário @returns {undefined}
 */
function finalizarEntrada(input) {
	var entrada = $(input).val();
	if (entrada === "") {
		cancelarEntrada(input);
	}
	var subCategoria = isSubCategoria(input);
	$(input).parent().parent().append(adicionarCategoriaFactory());
	$(input).parent().removeClass("text-center adicionarCategoria").html(
			entrada);
	if (subCategoria) {
		categoriaSelecionada.acrescentarSubCategoria(entrada);
	} else {
		var categoria = new Categoria(entrada);
		categorias.push(categoria);
		categoriaSelecionada = categoria;
		mostrarSubCategorias();
	}
}

/*
 * 
 * @param {type} Input de entrada do usuário @returns {undefined}
 */
function cancelarEntrada(input) {
	$(input).replaceWith(iconeAdicionarCategoriaFactory());
}

/*
 * Exclui um categoria ou sub-categoria @param {} categoria a ser excluída
 */
function excluirCategoria(categoria) {
	if (isSubCategoria(categoria)) {
		categoriaSelecionada.removerSubCategoria(subCategoriaSelecionada);
	} else {
		var index = categorias.indexOf(categoriaSelecionada);
		categorias.splice(index, 1);
	}
	elementoSelecionado = undefined;
	$(categoria).remove();
	mostrarSubCategorias();
}

/*
 * Exibe o painel das sub-categorias. @returns {undefined}
 */
function mostrarSubCategorias() {

	if (subCategorias) {
		$('#listaSubCategorias').empty();
		if (categoriaSelecionada.subCategorias !== undefined) {
			preencherLista($('#listaSubCategorias'),
					categoriaSelecionada.subCategorias);
		} else {
			preencherLista($('#listaSubCategorias'), []);
		}
		$("#subcategorias").removeClass("hidden");
		$("#subcategorias").effect("slide", 300);
	}
}

function esconderSubCategorias() {
	$("#subcategorias").hide("slide", 300);
}

function iconeAdicionarCategoriaFactory() {
	return iconeAdicionarCategoria.clone();
}

function botaoModalExclusaoFactory() {
	return botaoModalExclusao.clone();
}

function itemCategoriaFactory(categoria) {
	if (categoria.nome !== undefined) {
		categoria = categoria.nome;
	}
	return itemCategoria.clone().html(categoria);
}

function adicionarCategoriaFactory() {
	return adicionarCategoria.clone();
}

function inputCategoriaFactory() {
	return inputCategoria.clone();
}