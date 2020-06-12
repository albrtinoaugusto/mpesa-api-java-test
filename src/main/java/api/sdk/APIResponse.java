package api.sdk;

import java.util.LinkedHashMap;
import java.util.Map;

public class APIResponse
{
    private int statusCode;
    private String reason;
    private String statusLine;
    private String result;
    private Map<String, String> parameters = new LinkedHashMap<>();

    public String getParameter(String key)
    {
        return this.parameters.get(key);
    }

    public String getResult()
    {
        return this.result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getStatusLine()
    {
        return this.statusLine;
    }

    public void setStatusLine(String statusLine)
    {
        this.statusLine = statusLine;
    }

    public int getStatusCode()
    {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getReason()
    {
        return this.reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public Map<String, String> getParameters()
    {
        return this.parameters;
    }

    public void setParameters(Map<String, String> parameters)
    {
        this.parameters = parameters;
    }
}
