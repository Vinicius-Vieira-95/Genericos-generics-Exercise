package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import services.CalculationService;

public class Program {

	
	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		List<Product>product = new ArrayList<>();
		
		String path = "list.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\"+path))){ //Criando arquivo
			
			System.out.print("Entre com a quantidade de produtos:");
			Integer n = sc.nextInt();
			for(int i = 1; i <= n; i++) {
				System.out.print("Coloque o nome do Produto:");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Preço:");
				Double preco = sc.nextDouble();
				
				bw.write(nome+","+ preco );
				bw.newLine();
			}
			
			System.out.println("Arquivo criado com sucesso");	
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		try(BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\"+path))){ // Ler o arquivo
			
			String line = br.readLine();
			while(line != null) {
				
				String[] vect = line.split(",");
				product.add(new Product(vect[0], Double.parseDouble(vect[1])));
				line = br.readLine();
				
			}
			
			Product x = CalculationService.max(product);
			System.out.print("Maior preço: " + x);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
