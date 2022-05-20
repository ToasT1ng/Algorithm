import java.util.*;

class StringCounter{
	public static void main(String[] args) {
		Map<Character, Integer> map = countString("String a = 'welcome';\nlog.info(a);");
		System.out.println(map.toString());
	}

	public static Map<Character, Integer> countString(String sentence) {
		Map<Character, Integer> map = new HashMap<>();
		for (char each : sentence.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}
		return map;
	}
}
