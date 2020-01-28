package com.baseSetup.BaseProjectMySQL.models.entity;

import ma.glasnost.orika.MapperFacade;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "created_date")
	private Date createdTimeStamp;

	@Column(name = "updated_date")
	private Date updatedTimeStamp;

	@Column(name = "deleted_date")
	private Date deletedDate;

	@Column(name = "is_active")
	private Boolean isActive=true;

	public <S> S toDTO(Class<S> clazz, MapperFacade mapper) throws RuntimeException {
		try {
			return mapper.map(this, clazz);
		} catch (Exception e) {
			throw new RuntimeException(
					String.format(
							"Error converting to class %s, message %s",
							clazz.getTypeName(),
							e.getLocalizedMessage()));
		}
	}

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Boolean getActive()
	{
		if(isActive==null)
			return true;
		return isActive;
	}

	public Date getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}
}
