import entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /*Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.
Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.*/
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();



        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Funcionario> list =new ArrayList<>();
            String line = br.readLine();
            while(line != null){
               String[] fields = line.split(",");
               list.add(new Funcionario(fields[0], fields[1], Double.parseDouble(fields[2])));
               line = br.readLine();
            }
            System.out.println("Enter salary: ");
            Double salary = sc.nextDouble();

            List<String> emails=list.stream()
                    .filter(x -> x.getSalario()>salary)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println("Email of people whose salary is more than "+ salary + ": ");
            emails.forEach(System.out::println);
            Double sum = list.stream()
                    .filter(x -> x.getNome().startsWith("M"))
                    .map(x -> x.getSalario())
                    .reduce(0.0, (x,y) -> x + y);
            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sum)
            );



        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}