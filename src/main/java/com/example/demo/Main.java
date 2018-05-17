package com.example.demo;

import com.example.demo.domain.dto.PerfectDTO;
import com.example.demo.flexible.serialisation.SerialisationUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author Jack <e.kobets>
 */
public class Main {
    public static void main(String[] args) {

        final PerfectDTO perfectDTO = new PerfectDTO("Vasa", "Kran", "Petrovich");

        final List<String> neededFields = Arrays.asList("name", "secondName");
        final List<String> neededFields2 = Arrays.asList("secondName");
        final List<String> neededFields3 = Arrays.asList("secondName", "parent");

        System.out.println(SerialisationUtils.serializeNeededFields(perfectDTO, neededFields));
        System.out.println(SerialisationUtils.serializeNeededFields(perfectDTO, neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(new Boolean(true), neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields("", neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(2, neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(new Character('c'), neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(true, neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(LocalDateTime.now(), neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(new Date(), neededFields2));
        System.out.println(SerialisationUtils.serializeNeededFields(perfectDTO, neededFields3));
    }
}
