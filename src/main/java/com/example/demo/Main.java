package com.example.demo;

import com.example.demo.domain.dto.PerfectDTO;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Jack <e.kobets>
 */
public class Main {
    public static void main(String[] args) {

//        final HashMap<String, Object> fieldsWithValues = new HashMap<String, Object>() {{
//            put("name", "Vasa");
//            put("secondName", "Kran");
//            put("middleName", "Pavlovich");
//        }};

        final PerfectDTO perfectDTO = new PerfectDTO("Vasa", "Kran", "Petrovich");

        final List<String> neededFields = Arrays.asList("name", "secondName");
        final List<String> neededFields2 = Arrays.asList("secondName");

        System.out.println(serializeNeededFields(perfectDTO, neededFields));
        System.out.println(serializeNeededFields(perfectDTO, neededFields2));
    }

//    public static LinkedHashMap<String, Object> serializeNeededFields(final Map<String, Object> fieldsWithValues, final List<String> neededFields) {
//
//        final Field[] allDtoFields = PerfectDTO.class.getDeclaredFields();
//        List<String> fieldNames = Arrays.stream(allDtoFields).map(field ->
//        {
//            field.setAccessible(true);
//            return field.getName();
//        })
//                .collect(Collectors.toList());
//
//        return neededFields.stream()
//                .filter(fieldNames::contains)
//                .collect(Collectors.toMap(neededField -> neededField, fieldsWithValues::get,
//                        (u, v) -> {
//                            throw new IllegalStateException(String.format("Duplicate key %s", u));
//                        },
//                        LinkedHashMap::new)
//                );
//    }

    /*public static Map<String, Object> serializeNeededFields(final Object forSerialize, final List<String> neededFields) {

        if(forSerialize == null || neededFields == null || neededFields.isEmpty()) {
            return new LinkedHashMap<>();
        }

        final Field[] forSerializeFields = forSerialize.getClass().getDeclaredFields();
        final List<String> forSerializeFieldsNames = Arrays.stream(forSerializeFields).map(field -> {
            field.setAccessible(true);
            return field.getName();
        }).collect(Collectors.toList());

        return neededFields.stream()
                .filter(forSerializeFieldsNames::contains)
                .collect(Collectors.toMap(
                        neededField -> neededField,
                        neededField -> {
                            try {
                                return Arrays.stream(forSerializeFields)
                                        .filter(forSerializeField -> forSerializeField.getName().equals(neededField)).findFirst().orElseGet(null).get(forSerialize);
                            } catch (final IllegalAccessException e) {
                                System.out.println("LOG");
                                return new LinkedHashMap<>();
                            }
                        },
                        (key, value) -> { throw new IllegalStateException(String.format("Duplicate key %s", key)); },
                        LinkedHashMap::new)
                );
    }*/

    public static Map<String, Object> serializeNeededFields(final Object forSerialize, final List<String> neededFields) {

        if(forSerialize == null || neededFields == null || neededFields.isEmpty()) {
            return new LinkedHashMap<>();
        }

        final Field[] forSerializeFields = forSerialize.getClass().getDeclaredFields();
        final Map<String, Object> forSerializeFieldsNamesAndValues = Arrays.stream(forSerializeFields)
                .peek(field -> field.setAccessible(true))
                .collect(Collectors.toMap(
                        Field::getName,
                        field -> {
                            try {
                                return field.get(forSerialize);
                            } catch (final IllegalAccessException e) {
                                System.out.println("LOG");
                                return null;
                            }
                        })
                );

        return neededFields.stream()
                .filter(forSerializeFieldsNamesAndValues.keySet()::contains)
                .collect(Collectors.toMap(
                        neededField -> neededField,
                        neededField ->  forSerializeFieldsNamesAndValues.getOrDefault(neededField, null),
                        (key, value) -> { throw new IllegalStateException(String.format("Duplicate key %s", key)); },
                        LinkedHashMap::new)
                );
    }
}
