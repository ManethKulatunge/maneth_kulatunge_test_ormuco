package maneth_kulatunge_testOrmuco;

public class QuestionB {
	
	public static String compareVersions(String version1, String version2) {
		int result = comparison(version1, version2);
		String resultString = "";
		switch(result)	{
			case 0: 
				resultString = version1 + " and " + version2 +  " are equal";
				break;
			case 1:
				resultString = version1 + " is greater than " + version2;
				break;
			case -1:
				resultString = version1 + " is less than " + version2;
				break;
		}
		return resultString;
	}
	
	public static int comparison(String version1, String version2) {
		char[] v1Array = version1.toCharArray();
		char[] v2Array = version2.toCharArray();
		
		int v1Counter = 0;
		int v2Counter = 0;
		
		int v1Length = v1Array.length;
		int v2Length = v2Array.length;
		
		while (v1Counter < v1Array.length || v2Counter < v2Array.length) {
			int v1Number = 0;
			
			while (v1Counter < v1Length && v1Array[v1Counter]!= '.' ) {
				v1Number = 10 * v1Number + v1Array[v1Counter] - '0';
				++v1Counter;
			}
			
			int v2Number = 0;
			
			while (v2Counter < v2Length && v2Array[v2Counter] != '.') {
				v2Number = 10 * v2Number + v2Array[v2Counter] - '0';
				++v2Counter;
			}
			
			if (v1Number > v2Number) {
				return 1;
			}
			
			if (v1Number < v2Number) {
				return -1;
			}
			
			v1Number = 0;
			v2Number = 0;
			++v1Counter;
			++v2Counter;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "1.1";
		String version2 = "1.1";
		System.out.print(compareVersions(version1, version2));
	}

}
