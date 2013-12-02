$('#navAbas').find('li').on('click', function() { exibaAba(this); });

function exibaAba(aba) {	
	escondaAbas();
	$('#navAbas').find('li').removeClass('active');
	$(aba).addClass('active');
	$('#'.concat(aba.id.replace('Aba', ''))).show();	
};

function escondaAbas() {
	$('.aba').each(function() {
		$(this).hide();
	});
};