package com.example.demo;

import com.example.demo.domain.dto.PerfectDTO;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Jack <e.kobets>
 * 5/17/18
 */
public class Main {
    public static void main(String[] args) {

//        final HashMap<String, Object> fieldsWithValues = new HashMap<String, Object>() {{
//            put("name", "Vasa");
//            put("secondName", "Kran");
//            put("middleName", "Pavlovich");
//        }};

        PerfectDTO perfectDTO = new PerfectDTO("Vasa", "Kran", "Petrovich");

        final List<String> neededFileds = Arrays.asList("name", "secondName");
        final List<String> neededFileds2 = Arrays.asList("secondName");

        System.out.println(serialize(perfectDTO, neededFileds));
        System.out.println(serialize(perfectDTO, neededFileds2));
    }

//    public static LinkedHashMap<String, Object> serialize(final Map<String, Object> fieldsWithValues, final List<String> neededFields) {
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

    public static LinkedHashMap<String, Object> serialize(final Object forSerialize, final List<String> neededFields) {

        final Field[] forSerializeFields = forSerialize.getClass().getDeclaredFields();
        List<String> fieldNames = Arrays.stream(forSerializeFields).map(field ->
        {
            field.setAccessible(true);
            return field.getName();
        })
                .collect(Collectors.toList());

        return neededFields.stream()
                .filter(fieldNames::contains)
                .collect(Collectors.toMap(
                        neededField -> neededField,
                        neededField -> {
                            try {
                                return Arrays.stream(forSerializeFields)
                                        .filter(forSerializeField -> forSerializeField.getName().equals(neededField)).findFirst().orElseGet(null).get(forSerialize);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                            return null;
                        },
                        (u, v) -> { throw new IllegalStateException(String.format("Duplicate key %s", u)); },
                        LinkedHashMap::new)
                );
    }
}
