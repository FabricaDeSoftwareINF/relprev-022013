$('.botaoAba').on('click', function() { exibaAba(this); });
		
function exibaAba(botao) {			
	escondaAbas();
	$('#'.concat(botao.id.replace('Botao', ''))).show();
	$('.botaoAba').each(function() {
		$(this).css('background-color', '');
	});
	$(botao).css('background-color', '#EBEBEB');
};

function escondaAbas() {
	$('.aba').each(function() {
		$(this).hide();
	});
};