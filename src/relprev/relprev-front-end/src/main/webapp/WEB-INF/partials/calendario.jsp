<!-- Contém os componentes do jQuery UI, tais como o DatePicker. -->    
<script type="text/javascript">
			$(document).ready(function() {
				CrieCamposDeCalendario();
				ApliqueMascaraDeHora();
			});

			function CrieCamposDeCalendario() {
				$(".calendario").datepicker({
					inline: true
				});
			}

			function ApliqueMascaraDeHora() {
				$(".hora").setMask('time');
			}
</script>