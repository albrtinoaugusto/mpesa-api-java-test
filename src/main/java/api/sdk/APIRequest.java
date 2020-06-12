package api.sdk;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class APIRequest
{

    private APIContext context;

    public APIRequest(APIContext context)
    {
        this.context = context;
        createDefaultHeaders();
    }

    public APIResponse execute()
    {
        switch (this.context.getMethodType())
        {
            case GET:
                return get();
            case POST:
                return post();
            case PUT:
                return put();
        }
        return null;
    }

    private APIResponse get()
    {
        try (CloseableHttpClient client = HttpClientBuilder.create().build())
        {
            String url = this.context.getUrl() + this.context.genenrateGetParameters();
            HttpGet request = new HttpGet(url);
            Map<String, String> headers = this.context.getHeaders();
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private APIResponse post()
    {
        try (CloseableHttpClient client = HttpClientBuilder.create().build())
        {
            String url = this.context.getUrl();
            HttpPost request = new HttpPost(url);
            Map<String, String> headers = this.context.getHeaders();
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                request.addHeader(entry.getKey(), entry.getValue());
            }
            StringEntity entity = new StringEntity(this.context.generateJSON());
            request.setEntity((HttpEntity) entity);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private APIResponse put()
    {
        try (CloseableHttpClient client = HttpClientBuilder.create().build())
        {
            String url = this.context.getUrl();
            HttpPut request = new HttpPut(url);
            Map<String, String> headers = this.context.getHeaders();
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                request.addHeader(entry.getKey(), entry.getValue());
            }
            StringEntity entity = new StringEntity(this.context.generateJSON());
            request.setEntity((HttpEntity) entity);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String getBearerToken(String apiKey, String publicKey)
    {
        try
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Cipher cipher = Cipher.getInstance("RSA");
            byte[] encodedPublicKey = Base64.decodeBase64(publicKey);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
            PublicKey pk = keyFactory.generatePublic(publicKeySpec);
            cipher.init(1, pk);
            byte[] encryptedApiKey = Base64.encodeBase64(cipher.doFinal(apiKey.getBytes("UTF-8")));
            return new String(encryptedApiKey, "UTF-8");
        }
        catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void createDefaultHeaders()
    {
        this.context.addHeader("Host", this.context.getAddress());
        this.context.addHeader("Content-Type", "application/json");
        this.context.addHeader("Authorization", "Bearer " + getBearerToken(this.context.getApiKey(), this.context.getPublicKey()));
    }
}
