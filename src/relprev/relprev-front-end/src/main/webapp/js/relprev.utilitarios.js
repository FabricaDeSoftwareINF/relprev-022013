relprev.utilitarios = (function(instancia) {
	if (instancia) {
		return instancia;
	}
	
	function limpeCampos() {
		$('input').val('');
	};
	
	return {
		limpeCampos: limpeCampos
	};
})(relprev.utilitarios || undefined);

var relprev = window.relprev || {};