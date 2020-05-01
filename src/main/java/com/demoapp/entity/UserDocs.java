package com.demoapp.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.demoapp.constant.UserDocType;

@Entity
@Table(name = "user_docs")
public class UserDocs extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 3124049448101965635L;

	@Enumerated(EnumType.STRING)
	@Column(name = "doc_type")
	private UserDocType docType;
	
    @Lob
    @Column(name = "front_image")
    private byte[] frontImage;
    
    @Lob
    @Column(name = "back_image")
    private byte[] backImage;

	public UserDocType getDocType() {
		return docType;
	}

	public void setDocType(UserDocType docType) {
		this.docType = docType;
	}

	public byte[] getFrontImage() {
		return frontImage;
	}

	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
	}

	public byte[] getBackImage() {
		return backImage;
	}

	public void setBackImage(byte[] backImage) {
		this.backImage = backImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDocs [docType=").append(docType).append(", frontImage=").append(Arrays.toString(frontImage))
				.append(", backImage=").append(Arrays.toString(backImage)).append("]");
		return builder.toString();
	}
    
}
