package application;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class Produto {
    public static void main(String[]args){
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> listaProduto = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int contador = resp.nextInt();

        for (int k = 1; k <= contador; k++){
            System.out.printf("Product #%d data: \n", k);
            System.out.print("Common, used of imported (c/u/i)? ");
            char ch = resp.next().charAt(0);

            resp.nextLine();

            System.out.print("Name: ");
            String nome = resp.nextLine();

            System.out.print("Price: ");
            double preco = resp.nextDouble();

            if(ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String data = resp.next();
                LocalDate dt01 = LocalDate.parse(data, fmt1);
                Product produto = new UsedProduct(nome, preco, dt01);
                listaProduto.add(produto);

            }else if(ch == 'i'){
                System.out.print("Customs fee: ");
                double taxa = resp.nextDouble();
                Product produto = new ImportedProduct(nome, preco, taxa);
                listaProduto.add(produto);

            }else if(ch == 'c'){
                Product produto = new Product(nome, preco);
                listaProduto.add(produto);
            }
        }//fim do for
        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product pro : listaProduto){
            System.out.println(pro.priceTag());
        }
        resp.close();

    }
}
