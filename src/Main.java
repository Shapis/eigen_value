import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Jama.Matrix;


public class Main {

	public static void main(String[] args) {
		int numberOfParticles = 200;
		double[][] myMatrix = new double[numberOfParticles][numberOfParticles];
		double mySpringConstants[] = new double[numberOfParticles+1];
		double[] eigenValues = new double[numberOfParticles];
		ArrayList<Particle> myParticles = new ArrayList<Particle>();
		ArrayList<Double> returnList = new ArrayList<Double>();
		
		
		for (int i = 0 ; i < numberOfParticles+1 ; i++) {
			mySpringConstants[i] = 1;
		}
		
		for (int i = 0 ; i < numberOfParticles ; i++) {
			Particle temp = new Particle(i,1,0,1);
			myParticles.add(temp);
		}
		
		/*//Sistema de molas
		for (int i = 0 ; i < numberOfParticles ; i++) {
			for (int j = 0 ; j < numberOfParticles ; j++) {
				
				if (i==j) {
					myMatrix[i][j]=(mySpringConstants[i]+mySpringConstants[i+1])/myParticles.get(i).getMass();
				}else 
					if
				 (i==(j+1)) {
					myMatrix[i][j]=(-mySpringConstants[i+1])/myParticles.get(i).getMass();
				}else	
					if
					 (i==(j-1)) {
						myMatrix[i][j]=(-mySpringConstants[i])/myParticles.get(i).getMass();
					}else	
				 {
					myMatrix[i][j]=0;
				}
			}
		}
		
		
		
		
		//myMatrix[0][numberOfParticles-1] = -1; 
		//myMatrix[numberOfParticles-1][0] = -1;
		//condicao periodica 
		
		
		//myMatrix[0][0] = 1; 
		//myMatrix[numberOfParticles-1][numberOfParticles-1] = 1;
		//bordas livres 
		*/
		double abc = 0;
		double abcIncrement = 0.0001;
		// ESIT
		for (int i = 0 ; i < numberOfParticles ; i++) {
		for (int j = 0 ; j < numberOfParticles ; j++) {
			
			if (i==j) {
				myMatrix[i][j]=2;
			}else 
				if
			 (i==(j+1)) {
				myMatrix[i][j]=(-mySpringConstants[i+1]);
			}else	
				if
				 (i==(j-1)) {
					myMatrix[i][j]=(-mySpringConstants[i]);
				}else	
			 {
				myMatrix[i][j]=0;
			}
			abc += abcIncrement;
		}
	}
		
		Matrix m = new Matrix(myMatrix);
		
		
		eigenValues	= m.eig().getRealEigenvalues();
		m = m.eig().getV();
		
		
	for (int i = 0 ; i < numberOfParticles ; i++) {
			for (int j = 0 ; j < numberOfParticles ; j++) {
				//System.out.print(m.get(i,j)+ "\t");
				System.out.print(myMatrix[i][j] + "\t");
				
			}
			System.out.println();
			}
		
		int jj = 0;
		for (double i = 0 ; i < numberOfParticles ; i++) {
			
			returnList.add(i-(numberOfParticles/2));
			returnList.add(m.get(jj,1));
			
			jj++;
		}
		
		salvarArquivo(returnList, "F:\\dataoutput\\meusmodosnormais.txt");
	}
	
	
	private static int salvarArquivo(ArrayList<Double> meusPontos, String localArquivoSaida) {

		String stringTemp = "Inicialização de variável.";
		String stringFinal = "Inicialização de variável.";
		StringBuilder stringBuilder = new StringBuilder();
		int k = 0;

		for (Double i: meusPontos){
		stringTemp = i.toString() + "\t";
		stringBuilder.append(stringTemp);
		k++;

		if (k==2) {
			stringBuilder.append(System.getProperty("line.separator"));
			k = 0;
		}

		}


		stringFinal = stringBuilder.toString();
		//System.out.println(stringFinal);



		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					localArquivoSaida));

			writer.write(stringFinal);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("O arquivo não foi salvo!");
		}

		return 0;

	}
	
}