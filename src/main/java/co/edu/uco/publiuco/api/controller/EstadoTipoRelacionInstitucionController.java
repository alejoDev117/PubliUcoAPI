package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.business.facade.EstadoTipoRelacionInstitucionFacade;
import co.edu.uco.business.facade.imp.EstadoTipoRelacionInstitucionFacadeImp;
import co.edu.uco.crosscutting.exceptions.PubliucoException;
import co.edu.uco.dto.EstadoTipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.RegistrarEstadoTipoRelacionInstitucionValidacion;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {
	
	
	private EstadoTipoRelacionInstitucionFacade facade;
	
	
	public EstadoTipoRelacionInstitucionController() {
		facade = new EstadoTipoRelacionInstitucionFacadeImp();
	}

	@GetMapping("/dummy")
	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.create();				
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> list(@RequestParam EstadoTipoRelacionInstitucionDTO dto ){
		List<EstadoTipoRelacionInstitucionDTO> lista = new ArrayList<>();
		
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoTipoRelacionInstitucionDTO>();
		try {
		
		var result = RegistrarEstadoTipoRelacionInstitucionValidacion.validate(dto);
		if(result.getMessages().isEmpty()) {
			facade.register(dto);
			response.getMessages().add("El nuevo estado tipo relacionInstitucion se ha creado exitosamente");
		}else {
			statusCode = HttpStatus.BAD_REQUEST;
			response.setMessages(result.getMessages());
		}
		}catch(final PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch(final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado, por favor intentar de nuevo y si el sistema persiste contacte al soporte");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
		
		
		Response<EstadoTipoRelacionInstitucionDTO> response = new Response<>(lista,message);
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id){
		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(id);
	}
	@PostMapping("/register")
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> create(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoTipoRelacionInstitucionDTO>();
		try {
		
		var result = RegistrarEstadoTipoRelacionInstitucionValidacion.validate(dto);
		if(result.getMessages().isEmpty()) {
			facade.register(dto);
			response.getMessages().add("El nuevo estado tipo relacionInstitucion se ha creado exitosamente");
		}else {
			statusCode = HttpStatus.BAD_REQUEST;
			response.setMessages(result.getMessages());
		}
		}catch(final PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch(final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado, por favor intentar de nuevo y si el sistema persiste contacte al soporte");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
		
	}
	@PutMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id, @RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		return dto.setIdentificador(id);
	}
	
	@DeleteMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO delete(@PathVariable UUID id) {
		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(id);
	}
	
	//Se tiene la base el coco de la api SpringBoot, pal viernes venir con cada metodo probado en postman y asegure que el responde
	
}

