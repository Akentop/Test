import java.util.*;
import java.lang.*;

public class Tool
{
	public static String ConvertBase(String nombreD,int baseD,int baseF)
	{
		//initialize a la mano
		int reste = 0, divi = 0;
		int maxBaseF = 1;
		String nombreF = "";
		int length = nombreD.length();
		String[] splitString = nombreD.split("");
		int l, m, val, exposant;
		int nombreDe = 0;
		// convert en base 10

		for (l = 0;l < length ;l++ ) 
		{
			switch (splitString[l])
			{
				case "A":
				val = 10;
				break; 
				case "B":
				val = 11;
				break;
				case "C":
				val = 12;
				break;
				case "D":
				val = 13 ;
				break;
				case "E":
				val = 14 ;
				break;
				case "F":
				val = 15 ;
				break;
				default:
				val = Integer.parseInt(splitString[l]);
			}

			if (l<(length-1))
			{
				exposant = 1;
				for (m = length-1;m != l ; m--) 
				{
				exposant = exposant * baseD;
				}
			}
			else
			{
				exposant = 1;
			}
			nombreDe = nombreDe + (val * exposant);
		}

		//entre nombreDe (=nombreD base 10) et sort String nombreF basF
		while (nombreDe > maxBaseF)
		{
			maxBaseF = maxBaseF*baseF;
		}
		if (maxBaseF != nombreDe) 
		{
			maxBaseF = maxBaseF/baseF;
		}
		while (maxBaseF != 1)
		{
			if (nombreDe >= maxBaseF) 
			{
				reste = nombreDe % maxBaseF;
				divi = (nombreDe - reste)/maxBaseF;
				nombreDe = reste;
				switch (divi)
				{
					case 10:
					nombreF = nombreF + "A";
					break; 
					case 11:
					nombreF = nombreF + "B";
					break;
					case 12:
					nombreF = nombreF + "C";
					break;
					case 13:
					nombreF = nombreF + "D";
					break;
					case 14:
					nombreF = nombreF + "E";
					break;
					case 15:
					nombreF = nombreF + "F";
					break;
					default:
					nombreF = nombreF + Integer.toString(divi);
				}
			}
			else
			{
				nombreF = nombreF + "0";
			}
			maxBaseF = maxBaseF/baseF;
			if (maxBaseF == 1)
			{
				nombreF = nombreF + Integer.toString(nombreDe);
			}
		}
		return(nombreF);
	}

	public static void afficherMatInt(int[][] mat) 
	{
		int nbL = mat.length;
		int nbC = mat[0].length;
		int i, j;
		for(i = 0; i < nbL; i++) 
		{
			for(j = 0; j < nbC; j++) 
			{
				System.out.printf("% 5d",mat[i][j]);
			}
			System.out.println("");
		}
	}
	public static void afficherMatDouble(Double[][] mat) 
	{
		int nbL = mat.length;
		int nbC = mat[0].length;
		int i, j;
		for(i = 0; i < nbL; i++) 
		{
			for(j = 0; j < nbC; j++) 
			{
				System.out.printf("% 5d",mat[i][j]);
			}
			System.out.println("");
		}
	}
	public static int[][] additionMatInt(int[][] mat1, int[][] mat2) 
	{
		int nbL = mat1.length;
		int nbC = mat1[0].length;
		int i, j;
		int[][] res = new int[nbL][nbC];
		for(i = 0; i < nbL; i++) {
			for(j = 0; j < nbC; j++) {
				res[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return res;
	}
	public static Double[][] additionMatDouble(Double[][] mat1, Double[][] mat2) 
	{
		int nbL = mat1.length;
		int nbC = mat1[0].length;
		int i, j;
		Double[][] res = new Double[nbL][nbC];
		for(i = 0; i < nbL; i++) 
		{
			for(j = 0; j < nbC; j++) 
			{
				res[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return res;
	}
	/*public static int[][] matSpirale(int n) 
	{
		int i=0, j=0, maxi = n-1, maxj = n-1,centeri,centerj;
		if (n%2==0)
		{
			centeri = n/2;
			centerj = centeri-1;
		}
		else
		{
			centeri = (n-1)/2;
			centerj = centeri;
		}
		while ((i!=centeri)&&(j!=centerj)) 
		{
			for (j=0; ; ) 
			{
							
			}			
		}
	}*/
	public static int randomMinMax(int min, int max) 
	{
		Random rand = new Random();
		int res = rand.nextInt(max - min + 1) + min;
		assert min <= res && res <= max : "tirage aleatoire hors des bornes";
		return res;
    }
    public static boolean estBissextile (int year)
    {
    	boolean test = false;
    	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			test = true;
		}
		return test;
	}

    public static void main(String[] args)
    {
    	/*int[][] mata = { {1,2,3,244,5},{1,2,3456,4,5},{124,2,423,4,5},{1,2,3,442,5},{1,2,123,4,542} };
    	afficherMatInt(additionMatInt(mata,mata));*/
    	int jkl,roww;
    	Scanner clavier=new Scanner(System.in);
		String s = clavier.nextLine();
		String jk = clavier.nextLine();
		jkl = Integer.parseInt(jk);
		String row = clavier.nextLine();
		roww = Integer.parseInt(row);
    	System.out.println(ConvertBase("ABCDEF",jkl,roww));
    }

}