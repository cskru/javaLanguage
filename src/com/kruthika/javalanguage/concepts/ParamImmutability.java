package com.kruthika.javalanguage.concepts;

public class ParamImmutability {
    public int field1;

    public ParamImmutability (int x) {
        field1 = x;
    }

    @Override
    public String toString() {
        return "ParamImmutability{" +
                "field1=" + field1 +
                '}';
    }
}
