package com.example.demo.domain.dto;

import java.util.Objects;

/**
 * @Author Jack <e.kobets>
 */
public class Parent {
    private String parent = "Parent field";

    public Parent() {
    }

    public Parent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent1 = (Parent) o;
        return Objects.equals(parent, parent1.parent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(parent);
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parent='" + parent + '\'' +
                '}';
    }
}
