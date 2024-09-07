package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.Model.*;
import com.javaweb.Model.ErrorReponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.BuildingService;

import customException.FieldRequiredException;
@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	private BuildingRepository buildingRepository;
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
										@RequestParam(name = "districtId" , required = false) Long districtId,
										@RequestParam(name = "typeCode" , required = false) List<String> typecode){
		List<BuildingDTO> result = buildingService.findAll(name, districtId);

		return result;
	}
	
	@DeleteMapping(value="/api/building/")
	public void deleleBuilding(@RequestParam (name = "id", required = false) Long id){
		buildingRepository.DeleteByID(id);
	}
	
}

