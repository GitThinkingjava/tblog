package com.tao.blog.s.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisToken {

    @Autowired
    private RedisUtil redisUtil;
    // token 过期时间
    public static final long TOKEN_TIMEOUT = 60 * 60;

    /**
     *  设置 token
     * @return
     */
    public String setToken() {
        //生成token 临时唯一
        String token = "TOKEN" + UUIDUtil.getUUID32();
        //存入缓存中，设置过期时间
        redisUtil.set(token, token, TOKEN_TIMEOUT);
        return token;
    }

    /**
     * 获取token
     * @param tokenKey
     * @return tokenValue
     */
    public String getToken(String tokenKey) {
        String tokenValue = RedisUtil.DEFAULT_VALUE;
        if (StringUtils.isNotBlank(tokenKey)) {
            tokenValue = redisUtil.get(tokenKey).toString();
        }
        return tokenValue;
    }

    /**
     * 查找token
     * @param token
     * @return
     */
    public boolean findToken(String tokenKey){
        boolean flag =false;
        Object  token= redisUtil.get(tokenKey);
        if (token !=null) {
             //删除token 保障唯一性
             redisUtil.del(tokenKey);
             flag =true;
        }
        return flag;
    }

}
