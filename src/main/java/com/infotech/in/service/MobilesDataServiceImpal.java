package com.infotech.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.in.entity.MobilesData;
import com.infotech.in.repositorty.MobilesRepository;

@Service
public class MobilesDataServiceImpal implements MobilesDataService {

	@Autowired
	private MobilesRepository mobilesRepository;

	@Override
	public MobilesData saveData(MobilesData mobilesData) {

		MobilesData mobilesData2 = mobilesRepository.save(mobilesData);
		return mobilesData2;

		// new MobilesDataServiceImpalException("")

	}

	@Override
	public List<MobilesData> saveBulkData(List<MobilesData> mobilesData) {
		if (mobilesData != null) {
			List<MobilesData> saveAll = mobilesRepository.saveAll(mobilesData);
			return saveAll;
		}else {
			throw new MobilesDataServiceImpalException("no data is their to save");
		}
		
	}
	
	@Override
	public MobilesData retriveById(Integer id) {
		if (id != null) {
			MobilesData mobilesData2 = mobilesRepository.findById(id).get();

			return mobilesData2;
		} else {
			throw new MobilesDataServiceImpalException("no data is their to retrive");
		}
	}

	@Override
	public List<MobilesData> retriveTotalData() {
	 List<MobilesData> findAll = mobilesRepository.findAll();
		return findAll;
	}

	@Override
	public MobilesData updateData(MobilesData mobilesData) {
//		Optional<MobilesData> findById = mobilesRepository.findById(id);
//		System.out.println("mobiles :"+mobilesData);
//		MobilesData mobilesData2 = findById.get();
//		mobilesData2.setMobileRatings(mobilesData2.getMobileRatings());
//		mobilesData2.setMobileCost(mobilesData2.getMobileCost());
//		System.out.println("mobiles 2 :"+mobilesData2);
		Optional<MobilesData> findById = mobilesRepository.findById(mobilesData.getMobileId());
		if(findById.isPresent()) {
			return mobilesRepository.save(mobilesData);
		}
		return null;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		 MobilesData mobilesData = mobilesRepository.findById(id).get();
		 mobilesRepository.delete(mobilesData);
		return "data is deleted"+mobilesData;
		 
		/**if (findById.isPresent()) {
			 MobilesData mobilesData2 = findById.get();
			mobilesRepository.deleteById(mobilesData2);
			return "Data is going to be deleted";
		} else {
			return "SORRY DATA IS NOT THEIR TO DELETE";
		}*/
	}

	@Override
	public String deleteTotalData() {
		mobilesRepository.deleteAll();
		return "TOTAL DATA IS GOING TO BE DELETED";
	}

	public MobilesData findByMobileName(String mobileName) {
		MobilesData findByMobileName = mobilesRepository.findByMobileName(mobileName);
		if (findByMobileName != null) {
			return findByMobileName;
		}
		return null;
	}

	public MobilesData findByMobileRam(Integer mobileRam) {
		MobilesData findByMobileRam = mobilesRepository.findByMobileRam(mobileRam);
		if (findByMobileRam != null) {
			return findByMobileRam;
		}
		return null;
	}

	public MobilesData findByMobileCost(Double mobileCost) {
		MobilesData findByMobileCost = mobilesRepository.findByMobileCost(mobileCost);
		if (findByMobileCost != null) {
			return findByMobileCost;
		} else {
			return null;
		}

	}
}