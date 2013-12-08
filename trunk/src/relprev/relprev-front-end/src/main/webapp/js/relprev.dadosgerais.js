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
		$('[name="relatorioPrevencao.classificacaoRisco.avaliacaoInicial"]').val(avaliacao);
		var reavaliacao = $('[name="reavalicaoPrimeiroNivel"]').val() + $('[name="reavalicaoSegundoNivel"]').val();
		$('[name="relatorioPrevencao.classificacaoRisco.avaliacaoFinal"]').val(reavaliacao);
	};
	
	return {
	};
})(relprev.dadosgerais || undefined);