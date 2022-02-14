package lambdaExpressions;

public class AnotherClass {

    public String doSomethings() {
        return Main.doStringStuff(((s1, s2) -> {
            System.out.println(" class's name is: " + getClass().getSimpleName());
            return s1.toUpperCase() + " " + s2.toUpperCase();
        }), "String1", "String2");
        /*
        System.out.println("The Anotherclass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println(" class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");

         */
    }
}
