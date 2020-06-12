package api.sdk;


import mpesa.MPesaPayment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;

public class SimpleRequest
{

    public String[] doPayment()
    {

        try {
            URL url = new URL("http://api.sandbox.vm.co.mz:18352" + "/ipg/v1x/c2bPayment/singleStage/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");

            //Added parameters
            con.setRequestProperty("Authorization", "Bearer GGXJwmGFn+YrMIRvysfDyqATMLAWf9fyY09oKVuJu3M4Nj3MPLrW7SHTvYQqlxYwdy/4/QWXaQ373q1lO6uyAFbYV+QPvFsYTSfqUMFR1buEsSudG9ASkdfbo52vga9EicgOCW41Hjvavf9TXRH1VyaMQALp3Wq+fAMDpB10nwoStXoCS+IZ1sG8ub388oiW9llRjhBTNfAiD12TtFkL32HXnj6sPeZyt6EqMdGJXV0O2xmMUY1xPPIqx+JmkEsorsGCLA4JsOO0j9eA7SyHl2sWWTmAfiRlQIucDwnNdHEWEEllqNCk9j17hFGEb59YGENu3UUu2/RsruzIi0dylhF5RdDUIu1d3+P+UTQy1WN0HDFEz7absxZw7XZvB8/As4diPtVQ7S3svudiFu9u3KbygRhizpWPYSTcinG57p4MZGWbSoyudMLpHr7Xk/b/o/mcY+Whee2DxQI2k+j1ev3bW2g3cRNmddMk5tXtOMeb08zkY6lV0SIKB0boKX0BfnGVT9J1C+XqP6XjJ9UIEqXFCo64QcSLfMkz/p8jJTGy6IN8RTEH21WkfvIgrb1qypAkKqkoiswkkwzEoZk5YWvy7gMMWXEWlAtK7LzctyEEsPlgKxFnVVOGnjOrZ4MVaQD9rjaVRpfzj4Q7rQprp4FUJatANjaa3JGmNCCKhjU=");
            con.setRequestProperty("Origin", "developer.mpesa.vm.co.mz");

            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            JSONObject js = new JSONObject();
            js.put("input_TransactionReference", "T12344C");
            js.put("input_CustomerMSISDN", "258848131298");
            js.put("input_Amount", "10");
            js.put("input_ThirdPartyReference", "Z5HFVJ");
            js.put("input_ServiceProviderCode", "171717");

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = js.toJSONString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            return null;
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

        return null;
    }

    
    public static void main(String[] args)
    {
        new MPesaPayment(null, null).doPayment();
    }
}
