package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A18_Most_Frequent_IP_Address_In_A_Given_Vector {

	public static void main(String[] args) {
		
        System.out.println("Most Frequent IP!");
        
        getMostFrequentIp(new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24",});
    }
    
    public static void getMostFrequentIp(String[] logs){
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String log : logs){
            String[] arr = log.split(" ");
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
        }
        
        List<String> mostFrequent = new ArrayList<>();
        int freq = 0;
        
        for(String ip : map.keySet()){
            freq = Math.max(freq, map.get(ip)); 
        }
        
        for(String ip : map.keySet()){
            if(map.get(ip) == freq) mostFrequent.add(ip);
        }
        
        System.out.println(mostFrequent);
	}

}
