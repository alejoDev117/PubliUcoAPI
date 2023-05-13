package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import co.edu.uco.crosscutting.utils.UtilText;
import co.edu.uco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public final class DescripcionValidation implements Validation<String>{

	private DescripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	
	
	@Override
	public Result execute(String data) {

		var result = Result.create();
		
		if(UtilText.getUtilText().isEmpty(data)) {
			result.addMessage("No es posible continuar con el nombre del estado tipo identificador institucion vacio");
		}else {
			if(true) {// validar longitud de la cadena
		
			result.addMessage("No es posible tener el identificador por defecto del estado del tipo relacion institucion");
		}
			if(true) {// validar formato de la cadena
				
				result.addMessage("No es posible tener el identificador por defecto del estado del tipo relacion institucion");
			}
		}
		return null;
	}

	}
	

}
