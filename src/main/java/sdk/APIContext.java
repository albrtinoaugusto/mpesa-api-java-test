package api.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class APIContext
{

    private APIMethodType methodType = APIMethodType.GET;
    private boolean ssl = false;
    private String address = "localhost";
    private int port = 80;
    private String path = "/";
    private String apiKey = "";
    private String publicKey = "";
    private Map<String, String> headers = new LinkedHashMap<>();
    private Map<String, String> parameters = new LinkedHashMap<>();
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";

    public String toString()
    {
        StringBuilder getUrl, request = new StringBuilder();
        switch (this.methodType) {
            case GET:
                getUrl = new StringBuilder(String.format("%s%s", new Object[]{
                    getUrl(), genenrateGetParameters()
                }));
                request.append(String.format("%s %s HTTP/1.1%n", new Object[]{
                    "GET", getUrl.toString()
                }));
                break;
            case POST:
                request.append(String.format("%s %s HTTP/1.1%n", new Object[]{
                    "POST", getUrl()
                }));
                break;
            case PUT:
                request.append(String.format("%s %s HTTP/1.1%n", new Object[]{
                    "PUT", getUrl()
                }));
                break;
        }
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            request.append(String.format("%s: %s%n", new Object[]{
                entry.getKey(), entry.getValue()
            }));
        }
        return request.toString();
    }

    public String generateJSON()
    {
        StringBuilder p = new StringBuilder("{");
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            p.append(String.format("\"%s\": \"%s\",", new Object[]{
                entry.getKey(), entry.getValue()
            }));
        }
        return p.toString().substring(0, p.length() - 1) + "}";
    }

    public String genenrateGetParameters()
    {
        StringBuilder p = new StringBuilder("?");
        for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
            try {
                p.append(String.format("%s=%s&", new Object[]{
                    entry.getKey(), URLEncoder.encode(entry.getValue(), "UTF-8")
                }));
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return p.toString().substring(0, p.length() - 1);
    }

    public String getUrl()
    {
        String url;
        if (this.ssl) {
            url = String.format("https://%s:%d%s", new Object[]{
                this.address, Integer.valueOf(this.port), this.path
            });
        }
        else {
            url = String.format("http://%s:%d%s", new Object[]{
                this.address, Integer.valueOf(this.port), this.path
            });
        }
        return url;
    }

    public void addParameter(String key, String value)
    {
        this.parameters.put(key, value);
    }

    public void addHeader(String key, String value)
    {
        this.headers.put(key, value);
    }

    public Map getHeaders()
    {
        return this.headers;
    }

    public APIMethodType getMethodType()
    {
        return this.methodType;
    }

    public void setMethodType(APIMethodType methodType)
    {
        this.methodType = methodType;
    }

    public boolean isSsl()
    {
        return this.ssl;
    }

    public void setSsl(boolean ssl)
    {
        this.ssl = ssl;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getPort()
    {
        return this.port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getApiKey()
    {
        return this.apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getPublicKey()
    {
        return this.publicKey;
    }

    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }
}
