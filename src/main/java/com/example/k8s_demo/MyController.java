package com.example.k8s_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {
    @RequestMapping(value = "/getserverinfo", method = RequestMethod.GET)
    public String getUserInfoWithRequestParam(){
        return String.format("server : %s, time : %s", getIPAddr(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 获取本机IP地址
     * @return
     */
    private static String getIPAddr(){
        String hostAddress = null;
        try{
            InetAddress address = InetAddress.getLocalHost();
            hostAddress = address.getHostAddress();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        return hostAddress;
    }
}
