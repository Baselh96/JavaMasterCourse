import java.util.*;






public class Main{
    private static Scanner in ;
    public static void main(String[] args){
        Set<Integer> zahlen = new HashSet<>();
        Set<Integer> zahlen2 = new HashSet<>();

        for(int i = 1; i <= 100; i++){
            zahlen.add(i * i);
            zahlen2.add(i * i *i);
        }


        Set<Integer> union = new HashSet<Integer>(zahlen);
        union.addAll(zahlen2);
        System.out.println("Union: "+ union.size());

        Set<Integer> intersection = new HashSet<Integer>(zahlen);
        intersection.retainAll(zahlen2);
        System.out.println("Intersaction: "+ intersection.size());

        Set<String > wordSet = new HashSet<>();
        String satzSet = "Hallo ich bin ein Satz, Hallo";
        String[] wordArray = satzSet.split(" ");
        wordSet.addAll(Arrays.asList(wordArray));
        wordSet.forEach(n -> System.out.println(n));
        wordSet.removeAll(Arrays.asList(wordArray));
        System.out.println(wordSet.size());

        List<String > wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(wordArray));
        wordList.forEach(n -> System.out.println(n));

    }

}
