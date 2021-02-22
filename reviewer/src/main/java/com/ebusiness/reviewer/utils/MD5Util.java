package com.ebusiness.reviewer.utils;


import cn.hutool.Hutool;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;


/**
 * MD5工具类
 *
 * @author pibigstar
 */
public class MD5Util {

    @Autowired
    Hutool hutool;
    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";

    public static String getMD5(String str) {
        String base = str + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    public static String getMD51(String str){

        String md5 = SecureUtil.md5(str);
        return md5;
    }
}
