function processador(bruta) { 
var linhas = bruta.split(' ');
var resultado = '';
linhas = removeEspacosVaziosDeArray(linhas);
var inicio = 0;
var fim = null;

//Teste

for (var i = 0; i < linhas.length; i++) {
	
	if(linhas[i].length > 6){
		
	   while(!isNumeric(linhas[i])){
		   
		  for(var j = 0; j<linhas[i].length; j++){
			  if(!isNumeric(linhas[i].charAt(j))){
				  if (null == fim){
					fim = j-1;
				  }
				  break;
			    }

		  }
		  
		  if(null != fim){
			  break;			  
		  }		
	    }
       
	  if(fim - inicio >0){
		  
	     if(isNumeric(linhas[i].substr(inicio, fim))){
			
	         linhas[i] = linhas[i].substr(inicio, fim-5)	    
             resultado = resultado.concat(linhas[i].concat(','));  
         }
	   }
    }
}
return resultado;
}
