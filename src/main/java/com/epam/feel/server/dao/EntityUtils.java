package com.epam.feel.server.dao;

import com.epam.feel.server.model.BaseEntity;
import org.apache.commons.lang.StringUtils;
import javax.persistence.Entity;

/**
 * Provides utility methods to work with persistence entities.
 * 
 * @author Maxim Tulupov (maxim_tulupov@epam.com)
 */
public class EntityUtils {

    /**
     * 
     * @param entityClass
     *            - class that name is determine
     * @param <T>
     *            - class type
     * @return - entity name
     */
    public static <T extends BaseEntity> String getEntityName(Class<T> entityClass) {
        Entity annotation = entityClass.getAnnotation(Entity.class);
        if (annotation == null || StringUtils.isEmpty(annotation.name())) {
            return entityClass.getSimpleName();
        }
        return annotation.name();
    }

    /**
     * Checks if entity in persistent state or not
     * 
     * @param entity
     *            to check
     * @param <T>
     *            entity type
     * @return true if entity is new state
     */
    public static <T extends BaseEntity> boolean isNew(T entity) {
        return entity.getId() == null;
    }
}
