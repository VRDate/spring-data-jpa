/*
 * Copyright 2011-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository.support;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.repository.core.EntityInformation;

/**
 * Extension of {@link EntityInformation} to capture aditional JPA specific information about entities.
 * 
 * @author Oliver Gierke
 * @author Thomas Darimont
 */
public interface JpaEntityInformation<T, ID extends Serializable> extends EntityInformation<T, ID> {

	/**
	 * Returns the id attribute of the entity.
	 * 
	 * @return
	 */
	SingularAttribute<? super T, ?> getIdAttribute();

	/**
	 * Returns {@literal true} if the entity has a composite id
	 * 
	 * @return
	 */
	boolean hasCompositeId();

	/**
	 * Returns the attribute names of the id attributes. If the entity has a composite id, then all id attribute names are
	 * returned. If the entity has a single id attribute then this single attribute name is returned.
	 * 
	 * @return
	 */
	Iterable<String> getIdAttributeNames();

	/**
	 * Extracts the value for the given id attribute from a composite id
	 * 
	 * @param id
	 * @param idAttribute
	 * @return
	 */
	Object getCompositeIdAttributeValue(Serializable id, String idAttribute);

	/**
	 * Returns the JPA entity name.
	 * 
	 * @return
	 */
	String getEntityName();
}
