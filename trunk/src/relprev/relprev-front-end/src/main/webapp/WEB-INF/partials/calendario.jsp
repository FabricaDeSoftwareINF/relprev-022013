<!-- Contém os componentes do jQuery UI, tais como o DatePicker. -->    
<script type="text/javascript">
			$(document).ready(function() {
				CrieCamposDeCalendario();
			});

			function CrieCamposDeCalendario() {
				$(".calendario").datepicker({
					inline: true
				});
			}
</script>