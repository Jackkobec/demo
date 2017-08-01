package com.example.demo.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author E.Kobets <e.kobets@talantarium.com>
 */
@Data
@NoArgsConstructor
public class FioDTO {

    private String firstName;
    private String secondName;
    private String middleName;

    public FioDTO(String firstName, String secondName, String middleName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
