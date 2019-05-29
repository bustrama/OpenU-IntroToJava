
public class Ex14Question4Tester
{
	static final String PASS = "Very Good :)";
	static final String FAIL = "Oops, something is wrong :(";

	static final int[][] PATH_MAT_1 = {{0,0,1,0},{0,1,1,0},{0,1,0,0},{0,1,0,0}};
	static final int[][] MAT_1 = {{1,1,74,1},{1,60,120,1},{1,80,1,1},{1,240,1,1}};
	static final int SUM_MAT_1 = 574;

	static final int[][] PATH_MAT_2 = {{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
	static final int[][] MAT_2 = {{100,1,1,1},{100,1,1,1},{100,1,1,1},{100,1,1,1}};
	static final int SUM_MAT_2 = 400;

	static final int[][] PATH_MAT_3 = {{1,1,1,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
	static final int[][] MAT_3 = {{30,90,90,30},{2,2,2,30},{2,2,2,30},{2,2,2,30}};
	static final int SUM_MAT_3 = 330;

	static final int[][] PATH_MAT_4 = {{0,0,0,0},{0,0,0,0},{0,1,0,0},{0,1,1,0}};
	static final int[][] MAT_4 = {{54,22,43,33},{36,87,64,61},{92,5,78,26},{19,2,4,30}};
	static final int SUM_MAT_4 = 11;

	static final int[][] PATH_MAT_5 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
	static final int[][] MAT_5 = {{18,12,7,5},{15,21,30,3},{16,1,42,6},{1,16,1,2}};
	static final int SUM_MAT_5 = 2;

	static final int[][] PATH_MAT_6 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	static final int[][] MAT_6 = {{2,6,12,14},{72,10,22,20},{28,8,6,52},{4,2,4,16}};
	static final int SUM_MAT_6 = 83;

	static final int[][]PATH_MAT_7 =  {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	static final int[][]MAT_7 =  {{1,2,100,100},{2,2,100,100},{100,100,100,100},{100,100,100,100}};
	static final int SUM_MAT_7 = 8;

	public static void main(String[] args)
	{

		int[][]path = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(isValid(path,MAT_1,SUM_MAT_1,"Matrix1",PATH_MAT_1,true) 
		&& isValid(path,MAT_2,SUM_MAT_2,"Matrix2",PATH_MAT_2,true)
		&& isValid(path,MAT_3,SUM_MAT_3,"Matrix3",PATH_MAT_3,true)
		&& isValid(path,MAT_4,SUM_MAT_4,"Matrix4",PATH_MAT_4,true)
		&& isValid(path,MAT_5,SUM_MAT_5,"Matrix5",PATH_MAT_5,true)
		&& isValid(path,MAT_6,SUM_MAT_6,"Matrix6",PATH_MAT_6,false)
		&& isValid(path,MAT_7,SUM_MAT_7,"Matrix7",PATH_MAT_7,false))
		{
			System.out.println("*********************************");
			System.out.println("Very good, you passed the test :)");
			System.out.println("*********************************");
		}
		else
		{
			System.out.println("**********************************");
			System.out.println("         Test failed :(           ");
			System.out.println("**********************************");
		}
	}
	

	public static boolean isValid (int[][]path, int[][]mat, int sum, String name, int[][]realPath, boolean isPath)
	{
		if (Ex14.findSum(mat, sum, path) != isPath)
		{
			System.out.println(FAIL);
			System.out.println("There was a path in " +name + " it was:");
			printMat (realPath);
			return false;
		}
		else if (!equals(path,realPath))
		{
			System.out.println(FAIL);
			System.out.println("Your path is wrong in "+name+" it should be");
			printMat (realPath);
			System.out.println("Your path:");
			printMat(path);
			return false;
		}
		else
			System.out.println(name+"= " + PASS);
		initMat(path);
		return true;
	}


	public static void initMat (int[][] mat)
	{
		for (int i = 0 ; i< mat.length; i++)
			for (int j = 0; j < mat[0].length; j++)
				mat[i][j]=0;
	}

	public static boolean equals (int[][]mat1, int[][]mat2)
	{
		if (mat1.length!=mat2.length || mat1[0].length != mat2[0].length)
			return false;
		for (int i = 0; i< mat1.length; i++)
		{
			for (int j = 0; j<mat1[0].length; j++)
			{
				if (mat1[i][j]!=mat2[i][j])
					return false;
			}
		}
		return true;
	}

	public static void printMat (int[][] mat)
	{
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0 ; j< mat[0].length; j++)
				System.out.print(mat[i][j] + "\t");
			System.out.println("\n");
		}
		System.out.println("\n");
	}


}
