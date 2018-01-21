package com.kruthika.javalanguage.concepts.inheritance;

final public class SubClass extends BaseClass {
    public int oorkeOkkaField = 10;
    public String commonNamedField = "This is SubClass";

    public SubClass () {}
    public SubClass(int x) {
        oorkeOkkaField = x;
    }

    public void subClassMethod() {
        System.out.println("In sub class");
    }

    @Override
    public void commonNamedMethod() {
        System.out.println("A common named method in sub class");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //References are the same (An object is equal to itself)
        if (!(o instanceof SubClass))
            return false;

        SubClass subClass = (SubClass) o;
        return oorkeOkkaField == subClass.oorkeOkkaField;
    }

}
