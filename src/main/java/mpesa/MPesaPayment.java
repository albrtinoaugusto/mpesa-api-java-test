package api.mpesa;

import api.models.Payment;
import api.models.Entity;
import static api.services.Constants.COUNTRY_MOBILE_PREFIX;
import java.util.Map;

/**
 *
 * @author Augusto Marrengula
 */
public class MPesaPayment
{

    private Payment payment;
    private Entity entity;

    public MPesaPayment(Payment payment, Entity entity)
    {
        this.payment = payment;

        if (entity == null) {
            this.entity = new Entity();
        }
        else {
            this.entity = entity;
        }
    }

    public String[] doPayment()
    {
        String[] results = new String[3];

        try {
            //Create API Context
            APIContext context = new APIContext();
            //Set API key that can be found in the user profile section
            context.setApiKey(this.entity.getApiKey());
            //Set Public key that can be found in the user profile section
            context.setPublicKey(this.entity.getPublicKey());
            //Set SSL true or false
            context.setSsl(true);
            //Set the method type of the HTTP Request (GET, POST, PUT)
            context.setMethodType(APIMethodType.POST);
            //Set the address of the API Server
            context.setAddress("api.sandbox.vm.co.mz");
            context.setAddress("api.vm.co.mz");
            //Set the TCP port of the API Server
            context.setPort(18352);
            //Set path for the API
            context.setPath("/ipg/v1x/c2bPayment/singleStage/");

            //Add Header
            context.addHeader("Origin", "*");

            //Set parameters used for the API
            context.addParameter("input_TransactionReference", this.payment.getTransactionReference());
            context.addParameter("input_CustomerMSISDN", COUNTRY_MOBILE_PREFIX + this.payment.getCustomerNumber());
            context.addParameter("input_Amount", this.payment.getAmount());
            context.addParameter("input_ThirdPartyReference", this.payment.getThirdPartyReference());
            context.addParameter("input_ServiceProviderCode", this.entity.getProviderCode());

            //Create API request and execute it.
            APIRequest request = new APIRequest(context);
            APIResponse response = request.execute();
     
            //Print results to the console
            if (response != null) {                
                results[0] = response.getStatusCode() + "";
                results[1] = response.getReason();
                results[2] = response.getResult();

                System.out.println(results[0] + " - " + results[1]);
                System.out.println(results[2]);

                for (Map.Entry<String, String> entry : response.getParameters().entrySet()) {
                    System.out.println(entry.getKey() + ":" + response.getParameter(entry.getKey()));
                }
            }
            else {
                results[0] = "";
                results[1] = "";
                results[2] = "";
            }
     
        }
        catch (Exception e) {
            results[0] = "";
            results[1] = "";
            results[2] = "";

            System.out.println("Error: " + e);
        }

        return results;
    }

    public static void main(String[] args)
    {
        Payment p = new Payment("DGDSRHRD", "20", "848131298");
        System.out.println(new MPesaPayment(p, null).doPayment()[0] + " - " + new MPesaPayment(p, null).doPayment()[0] + " - " + new MPesaPayment(p, null).doPayment()[0]);
    }

}
