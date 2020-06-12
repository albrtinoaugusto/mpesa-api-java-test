
package api.models;

import api.services.Constants;

/**
 *
 * @author Marrengula */

public class Entity
{
    // API Key
    public String apiKey; 
    //Prodiction Key
    public String publicKey;
    
    // O Próprio ShortCode da Empresa
    public String providerCode;

    public Entity(){}
    
    public Entity(String apiKey, String publicKey, String providerCode)
    {
        this.apiKey = apiKey;
        this.publicKey = publicKey;
        this.providerCode = providerCode;
    }

    public String getApiKey()
    {
        if (this.apiKey == null || this.apiKey.length() == 0)
        {
            return Constants.API_KEY;
        }
        
        return apiKey;
    }

    public String getPublicKey()
    {
        if (this.publicKey == null || this.publicKey.length() == 0)
        {
            return Constants.PUBLIC_KEY;
        }
        
        return publicKey;
    }
    
    public String getProviderCode()
    {
        if (this.providerCode == null || this.providerCode.length() == 0)
        {
            return Constants.SERVICE_PROVIDER_CODE;
        }
        
        return providerCode;
    } 
    
    
    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }
 
    
    
    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }

    public void setProviderCode(String providerCode)
    {
        this.providerCode = providerCode;
    }
    
}
