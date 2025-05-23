package model.service;

import java.time.LocalDate;


import entities.Contract;

import entities.Installment;
public class ContractService {
   
    private final OnlinePaymentService onlinePaymentService;;
    public ContractService( OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
        
    }


    public void processContract(Contract contract, Integer months){
        double basicQuota = contract.getTotalValue() / months;
       for(int i = 1; i <= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuota, i);
            double paymentFee = onlinePaymentService.paymentFee(basicQuota + interest);
            double totalQuota = basicQuota + interest + paymentFee;
            contract.getInstallments().add(new Installment(dueDate, totalQuota));
            
        }
        

       

    }
}
