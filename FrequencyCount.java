import java.util.*;

class FrequencyCount{

	public static void frequencyCount(List<String> list,Map<String,Integer> map){
		for(String word : list){
			map.put(word,map.getOrDefault(word, 0) + 1);
		}
	}
	
	public static void main(String []args){
		List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));
		
		Map<String,Integer> map = new HashMap<>();
		frequencyCount(list,map);
		
		//for (Map.Entry<String, Integer> entry : map.entrySet()) {
          //  System.out.println(entry.getKey() + "=" + entry.getValue());
        //}
		
		System.out.println(map);
		
		
	}
}