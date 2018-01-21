package com.kruthika.javalanguage.concepts.inheritance;

public class SubClassOfAnAbstractClass extends AbstractClass {
    @Override
    public void subClassesMustImplementMe() {
        System.out.println("Yay!!");
        System.out.println("This class extends the AbstractClass class.\n" +
                "Since AbstractClass class is abstract, the classes that inherit it " +
                "MUST Override the abstract methods of that class " +
                "and provide implementation to the abstract methods.");
    }
}
