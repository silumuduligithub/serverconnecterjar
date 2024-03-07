/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vn.coderest.client;

/**
 *
 * @author siluk
 */
public class RestParam
{

    private String[] queryParametes;
    private String[] pathVariables;
    private String authorization;

    public String[] getQueryParametes()
    {
        return queryParametes;
    }

    public void setQueryParametes(String[] queryParametes)
    {
        this.queryParametes = queryParametes;
    }

    public String[] getPathVariables()
    {
        return pathVariables;
    }

    public void setPathVariables(String[] pathVariables)
    {
        this.pathVariables = pathVariables;
    }

    public String getAuthorization()
    {
        return authorization;
    }

    public void setAuthorization(String authorization)
    {
        this.authorization = authorization;
    }

    public RestParam()
    {
    }
}
