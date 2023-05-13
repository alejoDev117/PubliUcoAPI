package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion;

import co.edu.uco.crosscutting.utils.UtilObject;
import co.edu.uco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common.NombreValidation;

public class RegistrarEstadoTipoRelacionInstitucionValidacion implements Validation<EstadoTipoRelacionInstitucionDTO>{

	private RegistrarEstadoTipoRelacionInstitucionValidacion() {
		super();
	}
	
	
	public static final Result validate(final EstadoTipoRelacionInstitucionDTO data) {
		return new RegistrarEstadoTipoRelacionInstitucionValidacion().execute(data);
	}
	
	@Override
	public Result execute(final EstadoTipoRelacionInstitucionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo estado tipo relacion institucion con los datos vacios");
		}else {
		result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
		result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
	}
		
		return result;

	}

}