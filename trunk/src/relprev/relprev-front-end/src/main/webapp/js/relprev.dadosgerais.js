var relprev = window.relprev || {};

relprev.dadosgerais = (function(instancia) {
	if (instancia) {
		return instancia;
	}

	$(window).ready(function() {
		ajusteAvaliacao();
		$('[name="avalicaoPrimeiroNivel"]').on('change', function() {
			atualizeAvaliacao();
		});

		$('[name="avalicaoSegundoNivel"]').on('change', function() {
			atualizeAvaliacao();
		});

		$('[name="reavalicaoPrimeiroNivel"]').on('change', function() {
			atualizeAvaliacao();
		});

		$('[name="reavalicaoSegundoNivel"]').on('change', function() {
			atualizeAvaliacao();
		});
	});

	function atualizeAvaliacao() {
		var avaliacao = $('[name="avalicaoPrimeiroNivel"]').val() + $('[name="avalicaoSegundoNivel"]').val();
		$('[name="classificacaoRisco.avaliacaoInicial"]').val(avaliacao);
		var reavaliacao = $('[name="reavalicaoPrimeiroNivel"]').val() + $('[name="reavalicaoSegundoNivel"]').val();
		$('[name="classificacaoRisco.avaliacaoFinal"]').val(reavaliacao);
	};

	function ajusteAvaliacao() {
		var avaliacao = $('[name="classificacaoRisco.avaliacaoInicial"]').val();
		$('[name="avalicaoPrimeiroNivel"]').val(avaliacao[0]);
		$('[name="avalicaoSegundoNivel"]').val(avaliacao[1]);
		
		var reavaliacao = $('[name="classificacaoRisco.avaliacaoFinal"]').val();
		$('[name="reavalicaoPrimeiroNivel"]').val(reavaliacao[0]);
		$('[name="reavalicaoSegundoNivel"]').val(reavaliacao[1]);
	};
	
	$('.botaoEncaminhar').on('click', function() {
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../realizeEncaminhamento",
			data : {
				remetente : $('#encaminhamentoDo').val(),
				destinatario : $('#encaminhamentoPara').val(),
				data : $('#encaminhamentoData').val(),
				descricao : $('#descricaoEncaminhamento').val(),
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {			
			alert("Erro ao realizar a encaminhamento!");
		});
	});
	
	$('.botaoParecerDoSetor').on('click', function() {
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../realizeParecerDoSetor",
			data : {
				setor: $('#setor').val(),
				data : $('#dataParecer').val(),
				descricao : $('#descricaoParecerDoSetor').val(),
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {			
			alert("Erro ao registrar o parecer do setor!");
		});
	});
	
	$('.botaoResposta').on('click', function() {
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../registreResposta",
			data : {
				remetente: $('#respostaDo').val(),
				destinatario: $('#respostaAo').val(),
				data : $('#dataResposta').val(),
				descricao : $('#descricaoResposta').val(),
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {			
			alert("Erro ao registrar a resposta!");
		});
	});
	
	$('.botaoObservacao').on('click', function() {
		if ($('#textoObservacoes').val() == '') {
			alert('A descri\u00e7\u00e3o da observa\u00e7\u00e3o deve ser informada!');
			return;
		}
		
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../registreObservacoes",
			data : {
				observacoes: $('#textoObservacoes').val(),
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {			
			alert("Erro ao registrar observa\u00e7\u00e3o!");
		});
	});
	
	$('.botaoAcaoRecomendada').on('click', function() {
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../registreAcaoRecomendada",
			data : {
				remetente: $('#acaoDo').val(),
				destinatario: $('#acaoAo').val(),
				data : $('#acaoData').val(),
				descricao : $('#descricaoAcoesRecomendadas').val(),
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {			
			alert("Erro ao registrar a a\u00e7\u00e3o recomendada!");
		});
	});
	
	$('.botaoAvaliar').on('click', function() {
		var avaliacao = $('[name="classificacaoRisco.avaliacaoInicial"]').val();
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../realizeAvaliacao",
			data : {
				avaliacao : avaliacao,
				idRelatorio : $('[name="relprev.id"]').val()
				}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {
			alert("Erro ao realizar avalia\u00e7\u00e3o!");
		});
	});

	$('.botaoReavaliar').on('click', function() {
		var reavaliacao = $('[name="classificacaoRisco.avaliacaoFinal"]').val();
		$.ajax({
			type : "GET",
			dataType : "text",
			contentType : "application/text;",
			url : "../realizeReavaliacao",
			data : {
				reavaliacao : reavaliacao,
				idRelatorio : $('[name="relprev.id"]').val()
			}
		}).success(function(data) {
			exibaMensagem(data);
		}).fail(function(data) {
			alert("Erro ao realizar a reavalia\u00e7\u00e3o!");
		});
	});

	
	function exibaMensagem(data) {
		var mensagens = JSON.parse(data).resultado.split('|');
		var texto = ''; 
		for (var i = 0; i < mensagens.length; i++) {
			texto+= mensagens[i].trim() + '\n'; 
		}
		alert(texto);
	};
	
	return {};
})(relprev.dadosgerais || undefined);