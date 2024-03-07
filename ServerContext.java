/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vn.coderest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vn.coderest.server.EWServer;

/**
 *
 * @author siluk
 */
public class ServerContext
{

    private static final Logger logger = LoggerFactory.getLogger(ServerContext.class);
    private static ServerContext _sCtx;
    private static EWServer _server;

    public static void Create()
    {
        _sCtx = new ServerContext();
    }

    public static ServerContext This()
    {
        return _sCtx;
    }

    public void init() throws Exception
    {
        logger.info("initializing EW server");
        _server = new EWServer(AppConst.ip, AppConst.port);
//        _server.start();
        logger.info("ew server started");
    }

    public void Destroy()
    {
        this._server.Destroy();
    }
}
