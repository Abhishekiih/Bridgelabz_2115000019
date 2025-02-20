import java.util.*;

public class SetOperations {
    
    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1); // Copy set1
        unionSet.addAll(set2); // Add all elements of set2
        return unionSet;
    }

    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersectionSet = new HashSet<>(set1); // Copy set1
        intersectionSet.retainAll(set2); // Keep only common elements
        return intersectionSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> unionResult = findUnion(set1, set2);
        Set<Integer> intersectionResult = findIntersection(set1, set2);

        System.out.println("Union: " + unionResult);          // Output: [1, 2, 3, 4, 5]
        System.out.println("Intersection: " + intersectionResult); // Output: [3]
    }
}
