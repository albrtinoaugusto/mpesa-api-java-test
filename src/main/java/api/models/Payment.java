
package api.models;

/**
 *
 * @author Augusto Marrengula */

public class Payment
{
    
    private String transactionReference; // Código de Referência do produto ou descrição do mesmo. 
    private String thirdPartyReference ; //Muda sempre, chave única e que pode ser usado pra identificar/rastrear uma venda
    private String amount; 
    private String customerNumber;

    public Payment(String transactionReference, String amount, String customerNumber)
    {
        this.transactionReference = transactionReference;
        this.thirdPartyReference = new ThirdPartReference().generateReference();
        this.amount = amount;
        this.customerNumber = customerNumber;
    }

    public String getTransactionReference()
    {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference)
    {
        this.transactionReference = transactionReference;
    }

    public String getThirdPartyReference()
    {
        return thirdPartyReference;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }

    public String getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    

    
}
