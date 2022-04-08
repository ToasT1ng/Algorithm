class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome("level"));
		System.out.println(isPalindrome("hello"));
		System.out.println(isPalindrome("hi"));
	} 

	public static boolean isPalindrome(String arg) {
		for (int i=0 ; i<arg.length()/2 ; i++) {
			if (arg.charAt(i) != arg.charAt(arg.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
