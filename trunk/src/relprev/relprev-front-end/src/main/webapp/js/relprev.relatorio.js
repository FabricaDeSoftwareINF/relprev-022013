var relprev = window.relprev || {};

relprev.relatorio = (function(instancia) {
	if (instancia) {
		return instancia;
	}
	
	$(window).ready(function() {
		$('#hora').on('change', function() {
			atualizeDataHora();
		});
		
		$('#dataSituacaoPerigosa').on('change', function() {
			atualizeDataHora();
		});
	});
	
	function atualizeDataHora() {
		var data = $('#dataSituacaoPerigosa').val();
		var hora = $('#hora').val().split(':')[0] == undefined ? "00" : $('#hora').val().split(':')[0];
		var minuto = $('#hora').val().split(':')[1] == undefined ? "00" : $('#hora').val().split(':')[1];
		var dataComHora = data + " " + hora + ":" + minuto + ":00";
		$('[name="relatorioPrevencao.dataSituacaoPerigosa"]').val(dataComHora);
	};
	
	return {
		atualizeDataHora: atualizeDataHora
	};
})(relprev.relatorio || undefined);