package com.baseSetup.BaseProjectMySQL.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.glasnost.orika.MapperFacade;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO {
	/**
	 * converts to Model entity object
	 *
	 * @param clazz
	 * @return
	 * @throws RuntimeException
	 * @note beanUtils look for exact name during model conversion
	 */
	public <T> T toModel(Class<T> clazz, MapperFacade mapper) throws RuntimeException {
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

}
