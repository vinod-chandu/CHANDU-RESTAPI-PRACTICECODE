package com.infotech.in.repositorty;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.in.entity.MobilesData;

public interface MobilesRepository extends JpaRepository<MobilesData, Serializable> {
	public  MobilesData findByMobileName(String mobileName);
   public MobilesData findByMobileRam(Integer mobileRam);
   public MobilesData findByMobileCost(Double mobileCost);
}
   