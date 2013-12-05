<!-- Contém os componentes do jQuery UI, tais como o DatePicker. -->    
<script type="text/javascript">
			$(document).ready(function() {
				CrieCamposDeCalendario();
				ApliqueMascaraDeHora();
				apliqueMarcaraDeTelefone();
			});

			function CrieCamposDeCalendario() {
				$(".calendario").datepicker({
					inline: true,
					dateFormat:"dd/mm/yy"
				});
			}

			function ApliqueMascaraDeHora() {
				$(".hora").setMask('time');
			}
			
			function apliqueMarcaraDeTelefone() {
				$('.telefone').setMask("(99) 9999-99999");
				$('.telefone').on('change', function(event) {
				    var target, phone, element;
				    target = (event.currentTarget) ? event.currentTarget : event.srcElement;
				    phone = target.value.replace(/\D/g, '');
				    element = $(target);
				    element.unsetMask();
				    if(phone.length > 10) {
				        element.setMask("(99) 99999-9999");
				    } else {
				        element.setMask("(99) 9999-99999");
				    }
				});
			}
</script>