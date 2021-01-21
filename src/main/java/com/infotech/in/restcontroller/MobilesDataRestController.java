package com.infotech.in.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.in.entity.MobilesData;
import com.infotech.in.service.MobilesDataServiceImpal;

import io.swagger.annotations.ApiOperation;

@RestController
public class MobilesDataRestController {

	@Autowired
	private MobilesDataServiceImpal serviceImpal;

	@PostMapping(value = "/savedata", consumes = "application/json")
	@ApiOperation(value = "saveData")
	public ResponseEntity<MobilesData> saveData(@RequestBody MobilesData mobilesData) {
		MobilesData saveData = serviceImpal.saveData(mobilesData);
		return new ResponseEntity<MobilesData>(saveData, HttpStatus.CREATED);
	}

	@PostMapping(value = "/savebulkdata", consumes = "application/json")
	@ApiOperation(value = "saveBulkData")
	public ResponseEntity<List<MobilesData>> saveBulkData(@RequestBody List<MobilesData> mobilesData) {
		List<MobilesData> saveBulkData = serviceImpal.saveBulkData(mobilesData);
		return new ResponseEntity<List<MobilesData>>(saveBulkData, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getbyid/{id}", produces = "application/json")
	@ApiOperation(value = "getDataById")
	public ResponseEntity<MobilesData> getById(@PathVariable("id") Integer id) {
		MobilesData retriveById = serviceImpal.retriveById(id);
		return new ResponseEntity<MobilesData>(retriveById, HttpStatus.OK);
	}

	@GetMapping(value = "/getotaldata", produces = "application/json")
	@ApiOperation(value = "getTotalData")
	public ResponseEntity<List<MobilesData>> getTotalData() {
		List<MobilesData> retriveTotalData = serviceImpal.retriveTotalData();
		return new ResponseEntity<List<MobilesData>>(retriveTotalData, HttpStatus.OK);

	}

	@PutMapping(value = "/update", consumes = "application/json")
	@ApiOperation(value = "updatedata")
	public ResponseEntity<MobilesData> updateDataById(@RequestBody MobilesData mobilesData) {
		MobilesData updateData = serviceImpal.updateData(mobilesData);
		return new ResponseEntity<MobilesData>(updateData, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/deletebyid/{id}", produces  = "application/json")
	@ApiOperation(value = "deletedataById")
	public String deleteById(@PathVariable("id") Integer id) {
	 String deleteById = serviceImpal.deleteById(id);
		return "data is ready for delete operation"+deleteById;

	}

	@GetMapping(value = "/getram/{id}", produces = "application/json")
	@ApiOperation(value = "getMobleRamById")
	public ResponseEntity<MobilesData> getByMobileRam(@PathVariable("id") Integer mobileRam) {
		MobilesData findByMobileRam = serviceImpal.findByMobileRam(mobileRam);
		return new ResponseEntity<MobilesData>(findByMobileRam, HttpStatus.OK);
	}

}
