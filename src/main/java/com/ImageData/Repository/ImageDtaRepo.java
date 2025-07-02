package com.ImageData.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ImageData.Model.ImageData;


@Repository
public interface ImageDtaRepo extends JpaRepository<ImageData, Long> {
	 
	Optional<ImageData> findByfilename(String filename);


}
