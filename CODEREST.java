/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.vn.coderest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author siluk
 */
public class CODEREST
{

    /**
     * @param args the command line arguments
     */
    private static final Logger logger = LoggerFactory.getLogger(ServerContext.class);

    public static void main(String[] args) throws Exception
    {
        ServerContext.Create();
        ServerContext.This().init();
   }
}
