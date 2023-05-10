package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	@GetMapping("/dummy")
	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.create();				
		
	}
	
	@GetMapping
	public List<EstadoTipoRelacionInstitucionDTO> list(@RequestParam EstadoTipoRelacionInstitucionDTO dto ){
		List<EstadoTipoRelacionInstitucionDTO> lista = new ArrayList<>();
		
		lista.add(EstadoTipoRelacionInstitucionDTO.create());
		lista.add(EstadoTipoRelacionInstitucionDTO.create());
		lista.add(EstadoTipoRelacionInstitucionDTO.create());
		lista.add(EstadoTipoRelacionInstitucionDTO.create());
		lista.add(EstadoTipoRelacionInstitucionDTO.create());
		
		return lista;
	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id){
		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(id);
	}
	@PostMapping("/register")
	public EstadoTipoRelacionInstitucionDTO create(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		return EstadoTipoRelacionInstitucionDTO.create().setIdentificador(dto.getIdentificador()).setNombre(dto.getNombre()).setDescripcion(dto.getDescripcion());
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

