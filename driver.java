class MyString{
	private char[] chars;

	public MyString(char[] chars){
		this.chars = new char[chars.length];

		for(int i = 0; i < chars.length; i++){
			this.chars[i] = chars[i];
		}
	}

	public char charAt(int index){
		return this.chars[index];
	}

	public int length(){
		return this.chars.length;
	}

	public MyString substring(int begin, int end){
		char[] sub = new char[end - begin];

		for(int i = begin, j = 0; i < end; i++, j++){
			sub[j] = this.chars[i];
		}

		return new MyString(sub);
	}

	public MyString toLowerCase(){
		char [] lower = new char[this.length()];
		for(int i = 0; i < this.length(); i++){
			lower[i] = this.chars[i];
			if(lower[i] >= 'A' && lower[i] <= 'Z'){
				lower[i] += 32;
			}
		}
		return new MyString(lower);
	}

	public MyString toUpperCase(){
		char [] upper = new char[this.length()];

		for(int i = 0; i < this.length(); i++){
			upper[i] = this.chars[i];
			if(upper[i] >= 'a' && upper[i] <= 'z'){
				upper[i] -= 32;
			}
		}
		return new MyString(upper);
	}

	public boolean equals(MyString s){
		if(this.length() != s.length()){
			return false;
		}

		for(int i = 0; i < s.length(); i++){
			if(this.charAt(i) != s.charAt(i)){
				return false;
			}		
		}
		return true;
	}

	public MyString getMyString(){
		char [] str = new char[this.length()];
		for(int i = 0; i < this.length(); i++){
			str[i] = this.chars[i];
		}
		return new MyString(str);
	}

	public String toString(){

		return new String(this.chars);
	}

	public static MyString valueOf(int i){
		int number = i;
		int length = 0;
		int k = number;

		if (number <= 0){
			length = 1;
			number = -number;
		}
		while (k != 0){
			k /= 10;
			length++;
		}

		char [] num = new char[length];
		for(int j = length-1; j >= 0; j--){
			num[j] = (char)(number % 10 + 48);
			number /= 10;
		}
		
		if(i < 0){
			num[0] = '-';
		}

		return new MyString(num);
	}
}

public class driver{
	public static void main(String [] args){
		char[] chars = {'h', 'a', 'P', 'p', 'Y', 'w', 'e', 'E', 'k'};
		char[] temp = {'h', 'a', 'P', 'p', 'Y', 'w', 'e', 'E', 'k'};
		char[] test = {'h', 'A', 'o', 'p', 'Y', 'w', 'e', 'E'};
		int i = 1029;
		int k = -19382;

		MyString str = new MyString(chars);
		MyString str1 = new MyString(temp);
		MyString str2 = new MyString(test);

		System.out.println("charAt[2] at chars is " + str.charAt(2));
		System.out.println("charAt[1] at test is " + str2.charAt(1));
		System.out.println("length of chars is " + str.length());
		System.out.println("length of test is " + str2.length());
		System.out.println("substring(2,5) of chars is " + str.substring(2,5));
		System.out.println("lowercase of chars: " + str.toLowerCase());
		System.out.println("uppercase of test: " + str2.toUpperCase());
		System.out.println("Is chars equal to temp? : " + str.equals(str1));
		System.out.println("Is chars equal to test? : " + str.equals(str2));
		System.out.println("getMyString of temp is " + str1.getMyString());
		System.out.println("Integer to value of 1029: " + MyString.valueOf(i));
		System.out.println("Integer to value of -19382: " + MyString.valueOf(k));
	}
}
