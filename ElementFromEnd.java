import java.util.*;

class ElementFromEnd{

	public static String elementFromEnd(List<String> list,int N){
		if (list == null || N <= 0 || N > list.size()) {
            return null;
        }

        
        var fastPointer = list.listIterator();
        var slowPointer = list.listIterator();

        
        for (int i = 0; i < N; i++) {
            if (!fastPointer.hasNext()) {
                return null;  
            }
            fastPointer.next();
        }

        
        while (fastPointer.hasNext()) {
            fastPointer.next();
            slowPointer.next();
        }

        return slowPointer.next();
    }

	

	public static void main(String []args){
		List<String> list = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
		int N = 2;
		
		//elementFromEnd(list,N);
		System.out.println("Nth Element from the End : "+elementFromEnd(list,N));
		
	
	}
}