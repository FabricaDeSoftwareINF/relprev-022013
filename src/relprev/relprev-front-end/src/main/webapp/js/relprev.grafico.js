relprev.grafico = (function(instancia){

		if(instancia){
			return instancia;
		};

		var getChart = function(id){
			var canvas = document.getElementById(id);
			var ctx = canvas.getContext("2d");
			return new Chart(ctx);
		};

		/* Módulo para gerar gráficos em barra. */
		var barra = (function(_self){

			if(_self){
				return _self;
			}

			var crie = function(id, data, options){
				getChart(id).Bar(data, options);
			};

			return{
				crie:crie
			};


		})(barra || undefined);

		/* Módulo para gerar gráficos em pizza. */
		var pizza = (function(_self){

			if(_self){
				return _self;
			}

			var crie = function(id, data, options){
				getChart(id).Pie(data, options);
			};

			return{
				crie:crie
			};

		})(pizza || undefined);

		var exporta = function(id){
			debugger;
			
			Canvas2Image.saveAsJPEG(document.getElementById(id));
		};

		return{
			barra:barra,
			pizza:pizza,
			exporta: exporta
		};

	})(relprev.grafico || undefined);