package maneth_kulatunge_testOrmuco;

public class QuestionA {
	public static Boolean Overlap(int[][] lines) {
	
		//checking if first line is completely bigger than the second
		Boolean isLineBigger = (lines[0][0] >= lines[1][0] &&
				 lines[0][1] >= lines[1][1] 
				);
		//checking if there is an overlap in the starting points
		Boolean overlapOfStarting = (lines[0][0] < lines[0][1] && lines[0][1] > lines [1][0]);
		
		//checking if there is an overlap in final points
		Boolean overlapOfEnding = (lines[0][1] < lines[1][1] && lines[0][1] > lines [1][0]);
		
		Boolean result = isLineBigger || overlapOfStarting || overlapOfEnding ;
		
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//example
		//int [][] lines = new int[][] { {1,3}, {1,4} };
	}
}
