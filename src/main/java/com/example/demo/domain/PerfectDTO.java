package com.example.demo.domain;

import java.util.function.Consumer;

/**
 *
 */
public class PerfectDTO {

    private String name;
    private String secondName;
    private String middleName;

    private PerfectDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public PerfectDTO smartSetName(String name) {
        this.name = name;
        return this;
    }

    public PerfectDTO smartSetSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public PerfectDTO smartSetMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public static PerfectDTO build(Consumer<PerfectDTO> block) {
        PerfectDTO perfectDTO = new PerfectDTO(); // constructor may be private :)
        block.accept(perfectDTO);
        return perfectDTO;
    }

    @Override
    public String toString() {
        return "PerfectDTO{" +
            "name='" + name + '\'' +
            ", secondName='" + secondName + '\'' +
            ", middleName='" + middleName + '\'' +
            '}';
    }
}
