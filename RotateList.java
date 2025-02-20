import java.util.*;

class RotateList{
	
	public static List<Integer> rotateList(List<Integer> list , int rotateBy){
		int size = list.size();
		
		rotateBy = rotateBy%size;
		
		List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(rotateBy, size)); 
        rotatedList.addAll(list.subList(0, rotateBy));   

        return rotatedList; 
	}

	public static void main(String []args){
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		int rotateBy = 2;
		
		System.out.println("Original List: " + list);
		
		List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println("Rotated List (New List): " + rotatedList);
	}
}