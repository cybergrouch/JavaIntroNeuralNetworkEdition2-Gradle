package com.heatonresearch.book.introneuralnet.neural.matrix;

import junit.framework.TestCase;

public class TestBiPolarUtil extends TestCase {

	public void testBipolar2double() throws Throwable
	{
		// test a 1x4
		boolean[] booleanData1 = { true, false, true, false };
		double[] checkData1 = {1,-1,1,-1};
		Matrix matrix1 = Matrix.createRowMatrix(BiPolarUtil.bipolar2double(booleanData1));
		Matrix checkMatrix1 = Matrix.createRowMatrix(checkData1);
		TestCase.assertTrue( matrix1.equals(checkMatrix1));
		
		// test a 2x2
		boolean booleanData2[][] = {{true,false},{false,true}};
		double checkData2[][] = { {1,-1}, {-1,1} };
		Matrix matrix2 = new Matrix(BiPolarUtil.bipolar2double(booleanData2));
		Matrix checkMatrix2 = new Matrix(checkData2);
		TestCase.assertTrue(matrix2.equals(checkMatrix2));
	}
	
	public void testDouble2bipolar() throws Throwable
	{
		// test a 1x4
		double doubleData1[] = { 1, -1, 1, -1 };
		boolean checkData1[] = { true,false, true, false };
		boolean result1[] = BiPolarUtil.double2bipolar(doubleData1);
		for(int i=0;i<checkData1.length;i++)
		{
			TestCase.assertEquals(checkData1[i], result1[i]);
		}
		
		// test a 2x2
		double doubleData2[][] = { {1,-1}, {-1,1} };
		boolean checkData2[][] = { {true,false}, {false,true} };
		boolean result2[][] = BiPolarUtil.double2bipolar(doubleData2);
		
		for(int r = 0; r< doubleData2.length; r++ )
		{
			for(int c = 0; c<doubleData2[0].length;c ++)
			{
				TestCase.assertEquals(result2[r][c], checkData2[r][c]);
			}
		}
		
	}
	
	public void testBinary() throws Throwable
	{
		TestCase.assertEquals(0.0,BiPolarUtil.normalizeBinary(-1));
		TestCase.assertEquals(1.0,BiPolarUtil.normalizeBinary(2));
		TestCase.assertEquals(1.0,BiPolarUtil.toBinary(1));
		TestCase.assertEquals(-1.0,BiPolarUtil.toBiPolar(0));
		TestCase.assertEquals(1.0,BiPolarUtil.toNormalizedBinary(10));
	}
}
