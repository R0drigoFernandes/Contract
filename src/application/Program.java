package application;

import entities.Contract;
import entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double amount = sc.nextDouble();
        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();

        Contract contract = new Contract(number, date, amount);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, parcelas);
       
        System.out.println("Parcelas: ");
        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }


        sc.close();
    }
}
