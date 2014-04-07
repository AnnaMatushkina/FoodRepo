package com.epam.feel.server.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Utility helper methods.
 * 
 * @author Anna_Gavrilina
 */
public class HelperUtil {

    private HelperUtil() {}

    /**
     * Set object property even if it private.
     * 
     * @param object
     *            object to set property
     * @param fieldName
     *            property to set
     * @param value
     *            value of property
     * @throws IllegalAccessException
     *             if it is impossible to set property
     */
    public static void setObjectProperty(Object object, String fieldName, Object value) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        java.lang.reflect.Field field = getClassField(clazz, fieldName);
        if (field != null) {
            field.setAccessible(true);
            field.set(object, value);
        }
    }

    public static void setClassProperty(Class<?> clazz, String fieldName, Object value) throws IllegalAccessException,
        SecurityException, NoSuchFieldException {
        Field field = getClassField(clazz, fieldName);

        if (field != null) {
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, value);

        }
    }

    private static java.lang.reflect.Field getClassField(Class<?> clazz, String fieldName) {
        Field field = null;
        do {
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException nsfe) {
                clazz = clazz.getSuperclass();
                if (clazz == Object.class) {
                    break;
                }
            }
        } while (field == null);
        return field;
    }
}
