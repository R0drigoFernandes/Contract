package model.service;



public class PaypalService implements OnlinePaymentService {
    

    public double paymentFee(Double amount){
        double taxa = 0.02;
        amount = amount * taxa;
        return amount;
       
    }

    public double interest(Double amount , Integer months){
        amount = (amount * 0.01) * months;
        return amount;

    }
}
