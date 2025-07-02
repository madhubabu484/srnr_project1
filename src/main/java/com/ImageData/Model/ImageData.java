package com.ImageData.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it Genarated the All Setters And Getters.
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "imageData")
@Builder
public class ImageData {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "filename")
	private String filename;

	@Column(name = "type")
	private String type;

	 @Lob
	 @Column(name = "imagedata", columnDefinition = "LONGBLOB")
	private byte [] imagedata; // This field Convert image to Byte Stored inside the DataBase.

}
