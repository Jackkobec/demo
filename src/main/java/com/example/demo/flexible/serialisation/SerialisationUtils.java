package com.example.demo.flexible.serialisation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Jack <e.kobets>
 */
public class SerialisationUtils {

    /***
     * Gets map with only needed fields with values from object if they are present.
     * @param forSerialize - object for getting fields
     * @param neededFields - names list of the needed fields
     * @return Map<String ,   Object>, key - needed field name , value - needed field value
     */
    public static Map<String, Object> serializeNeededFields(final Object forSerialize, final List<String> neededFields) {

        if ((forSerialize == null) || (neededFields == null) || neededFields.isEmpty()) {
            return new HashMap<>();
        }

        final Set<Field> forSerializeFields = org.reflections.ReflectionUtils.getAllFields(forSerialize.getClass());
        return forSerializeFields.stream()
                .filter(forSerializeField -> neededFields.contains(forSerializeField.getName()))
                .peek(forSerializeField -> forSerializeField.setAccessible(true))
                .collect(Collectors.toMap(
                        Field::getName,
                        forSerializeField -> {
                            try {
                                return forSerializeField.get(forSerialize);
                            } catch (final IllegalAccessException e) {
                                System.out.println("LOG"); // Replace with LOGGER
                                return null;
                            }
                        })
                );
    }
}
