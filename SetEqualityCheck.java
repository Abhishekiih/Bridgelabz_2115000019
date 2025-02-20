import java.util.*;

public class SetEqualityCheck {
   
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2); 
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4));

        System.out.println("Set1 and Set2 are equal: " + areSetsEqual(set1, set2)); 
        System.out.println("Set1 and Set3 are equal: " + areSetsEqual(set1, set3)); 
    }
}
