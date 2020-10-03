package Week6;

import java.util.*;

public class ¿ÀÇÂÃ¤ÆÃ¹æ {
	static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
	public static void main(String args[]) {
		String[] answer = {};
		
		Map<String, String> map = new LinkedHashMap<>();
		ArrayList<String[]> message = new ArrayList<String[]>();
		for(int i=0; i<record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String command = st.nextToken();
			if(command.equals("Enter")){
				
				String id = st.nextToken();
				String name = st.nextToken();
				if(map.containsKey(id)) {
					map.replace(id, name);
				} else {
					map.put(id, name);
				}				
				String[] in = {"In",id};
				message.add(in);
			} else if(command.equals("Leave")){
				String id = st.nextToken();
				String[] in = {"Out",id};
				message.add(in);
			} else {
				String id = st.nextToken();
				String name = st.nextToken();
				if(map.containsKey(id)) {
					map.replace(id, name);
				} else {
					map.put(id, name);
				}		
			}
		}
		
		answer = new String[message.size()];
		
		for(int i=0; i<answer.length; i++) {
			if(message.get(i)[0].equals("In")) {
				answer[i] = map.get(message.get(i)[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			} else {
				answer[i] = map.get(message.get(i)[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";				
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}