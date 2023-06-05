import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(zad1(List.of(1, 2, 3, 4, 5), Integer::compareTo));
        System.out.println(zad2(List.of(1,2,5),List.of(1,1,3,3,6,7)));
        System.out.println(zad4(List.of(2,2,2,1,6,8)));
    }

    public static <T> T zad1(List<T> list, Comparator<T> comp){
        return list.stream().max(comp).orElseThrow(NieMoznaException::new);
    }

    public static Integer zad2(List<Integer> list1, List<Integer> list2){
        if(list1 == null || list2 == null){
            throw new IllegalArgumentException();
        }
        if(list1.isEmpty() || list2.isEmpty()){
            return null;
        }
        return list1.stream()
                .max(Integer::compareTo)
                .flatMap(max -> list2.stream()
                        .filter(e -> e > max)
                        .findFirst())
                .orElseThrow(MaxNotFoundException::new);
    }
    public static Pair zad4(List<Integer> list) {
        if(list == null || list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return list.stream()
                .min(Integer::compareTo)
                .flatMap(min -> list.stream()
                        .max(Integer::compareTo)
                        .map(max -> new Pair(min, max)))
                .orElse(new Pair(1,-1));
    }
}