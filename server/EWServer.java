/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vn.coderest.server;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author siluk
 */
public class EWServer
{

    private String _ip;
    private int _port;
    private Server _jettyServer;

    public EWServer(String ip, int port)
    {
        this._ip = ip;
        this._port = port;
    }
    
    public void start() throws Exception
    {
        this._jettyServer.start();
    }

    public void Destroy()
    {
        this._jettyServer.destroy();
    }
}
