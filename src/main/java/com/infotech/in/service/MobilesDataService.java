package com.infotech.in.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infotech.in.entity.MobilesData;

@Repository
public interface MobilesDataService {

	public MobilesData saveData(MobilesData mobilesData);

	public List<MobilesData> saveBulkData(List<MobilesData> mobilesData);

	public MobilesData retriveById(Integer id);

	public List<MobilesData> retriveTotalData();

	public MobilesData updateData(MobilesData mobilesData);

	public String deleteById(Integer id);

	public String deleteTotalData();

	// MY CUSTOM METHODS
	public MobilesData findByMobileName(String mobileName);

	public MobilesData findByMobileRam(Integer mobileRam);

	public MobilesData findByMobileCost(Double mobileCost);
}
