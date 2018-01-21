package com.kruthika.javalanguage;

import com.kruthika.javalanguage.concepts.ParamImmutability;
import com.kruthika.javalanguage.concepts.inheritance.AbstractClass;
import com.kruthika.javalanguage.concepts.inheritance.BaseClass;
import com.kruthika.javalanguage.concepts.inheritance.SubClass;
import com.kruthika.javalanguage.concepts.inheritance.SubClassOfAnAbstractClass;
import com.kruthika.javalanguage.music_library.AudioTrack;
import com.kruthika.javalanguage.music_library.Category;
import com.kruthika.javalanguage.music_library.TrackType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Java Language");

        //music_library
        //Create some categories, add them to a Set
        Category bollywood = new Category("bollywood", new StringBuilder("Bollywood songs"));
        Category telugu = new Category("telugu", new StringBuilder("Bollywood songs"));
        Category carnatic = new Category("carnatic", new StringBuilder("Carnatic classical music"));
        Category workout = new Category("workout");
        Category.categorySet.forEach(category -> System.out.println(category));
        // Replacing lambda with method reference
        // Category.categorySet.forEach(System.out::println);

        AudioTrack t1 = new AudioTrack("Unnattundi",new URL("https://gaana.com/song/unnatundi-gundey"));
        t1.addTrack(telugu.getId());

        System.out.println(AudioTrack.audioTrackList);

        telugu.getTracks(TrackType.AUDIO).forEach(System.out::println);



        //Parameter Immutability
        ParamImmutability o1 = new ParamImmutability(100);
        ParamImmutability o2 = new ParamImmutability(200);
        System.out.println(o1.field1+" "+o2.field1);//100 200
        swap(o1, o2);
        System.out.println(o1.field1+" "+o2.field1);//100 200 -> Coz, params are passed by value
        //A copy of the passsed params are created and
        // the changes on the value/ pointer/reference of the param itself isn't visible outside the method
        // (Object has its reference)


        //Changing the inner members of the object is visible even outside the method
        o1 = new ParamImmutability(100);
        o2 = new ParamImmutability(200);
        System.out.println(o1.field1+" "+o2.field1);//100 200
        swapInnerMembers(o1, o2);
        System.out.println(o1.field1+" "+o2.field1);//200 100

        //Overloading - normal

        //Inheritance
        inheritance();
    }

    private static void swap(ParamImmutability object1, ParamImmutability object2) {
        ParamImmutability temp;
        temp = object1;
        object1 = object2;
        object2 = temp;
        System.out.println(object1.field1+" "+object2.field1);
    }

    private static void swapInnerMembers(ParamImmutability object1, ParamImmutability object2) {
        int temp;
        temp = object1.field1;
        object1.field1 = object2.field1;
        object2.field1 = temp;
        System.out.println(object1.field1+" "+object2.field1);
        //Or use getters and setters
    }

    private static void inheritance() {
        BaseClass b = new BaseClass();
        System.out.println(b.commonNamedField);
        b.baseClassMethod();
        b.commonNamedMethod();

        SubClass s = new SubClass();
        System.out.println(s.baseClassInt); //Note that base class field is accessible by sub class
        s.baseClassMethod(); //Note that base class method is accessible by sub class
        s.subClassMethod();
        System.out.println(s.commonNamedField); //Note that fields with same name are overridden by sub class
        s.commonNamedMethod(); //Note that methods with same name are overridden by sub class

        //Object class is the base class for all classes
        //This is really useful when we wanna pass objects as params and aren't sure abt the type.
        //The handler can handle respective types of objects however we want
        Object o = new SubClass();
        if(o instanceof SubClass) {
            ((SubClass) o).subClassMethod();
        }

        //Some useful methods from Object class (We can override 'em)
        SubClass s1 = new SubClass(100);
        SubClass s2 = new SubClass(100);

        System.out.println(s1 == s2); //false. == -> compares reference equality test
        //.equals also does the same by default..

        System.out.println(s1.equals(s2)); //true. Look at the overridden implementation of equals in SubClass

        //Final - Makes sure that the class can't be inherited
        /*public final class Passenger {
            //...
        }
        OR
        final public class Passenger {
            //...
        }

        This makes sure that the class can't be inherited!

        If you wanna class to be inherited but wanna put some restrictions on some methods and make sure those methods are not inherited,

        public class Passenger {
            public final void app1Package() {
                //.....
            }
            //...
        }*/

        //Abstract class
        SubClassOfAnAbstractClass soa = new SubClassOfAnAbstractClass();
        soa.subClassesMustImplementMe();

        //Constructors cant be inherited
        //By default, BaseClass' NO ARGUEMENT CONSTRUCTOR is called by sub class constructor.
        //We can call a custom/overloaded constructor by using super keyword.
        //It must be the first line in the constructor
        //super keyword has more uses. It can be used to access baseclass fields/methods that are overridden at the subclass



    }
}
