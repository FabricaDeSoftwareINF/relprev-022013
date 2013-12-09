var relprev = window.relprev || {};

relprev.dadosgerais = (function(instancia) {
	if (instancia) {
		return instancia;
	}
	
	$(window).ready(function() {
		atualizeAvaliacao();
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
	
	$('.botaoAvaliar').on('click', function() {
		var avaliacao = $('[name="classificacaoRisco.avaliacaoInicial"]').val();
		$.ajax({
		  type: "GET",  
		  dataType: "text",
		  contentType: "application/text;",
		  url: "../realizeAvaliacao",  
		  data: {
			avaliacao: avaliacao,
			idRelatorio: $('[name="classificacaoRisco.relprev.id"]').val()
		  }
		}).success(function(data) {			
			alert("Avaliação realizada com sucesso!");
		}).fail(function(data) {			
			alert("Erro ao realizar avaliação!");
		});
	});
	
	$('.botaoReavaliar').on('click', function() {
		var reavaliacao = $('[name="classificacaoRisco.avaliacaoFinal"]').val();
		$.ajax({
		  type: "GET",  
		  dataType: "text",
		  contentType: "application/text;",
		  url: "../realizeReavaliacao",  
		  data: {
			reavaliacao: reavaliacao,
			idRelatorio: $('[name="classificacaoRisco.relprev.id"]').val()
		  }
		}).success(function(data) {			
			alert("Reavaliação realizada com sucesso!");
		}).fail(function(data) {			
			alert("Erro ao realizar a reavaliação!");
		});
	});
	
	return {
	};
})(relprev.dadosgerais || undefined);