package com.baizhi.config;

import com.baizhi.cache.MyCache;
import com.baizhi.cache.MyCacheManager;
import com.baizhi.realm.MyRealm2;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

/**
 * shiro的配置类
 */
@Configuration
public class ShiroConfig {

    @Value("${my.host}")
    private String host;

    @Value("${my.port}")
    private int port;

    /**
     * 需要将spring工厂中的配置逆化成@Bean标识的java代码
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.jsp");
        // 定义拦截规则
        HashMap<String, String> map = new HashMap<>();
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/picture/**","anon");
        map.put("/user/**","anon");
        map.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        // 安全管理器对象
        shiroFilterFactoryBean.setSecurityManager(createDefaultWebSecurityManager());
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager createDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(Arrays.asList(creatMyRealm2()));
        // 安全管理器 初始化缓存管理器
        // 使用JVM的内存管理缓存数据或自定义缓存管理器
        securityManager.setCacheManager(createCacheManager());
        return securityManager;
    }

//    @Bean
//    public MemoryConstrainedCacheManager createCacheManager(){
//        return new MemoryConstrainedCacheManager();
//    }

    @Bean
    public MyCacheManager createCacheManager(){
        return new MyCacheManager(creatMyCache());
    }

    @Bean
    public MyCache creatMyCache(){
        return new MyCache(host,port);
    }

    @Bean
    public MyRealm2 creatMyRealm2(){
        MyRealm2 realm2 = new MyRealm2();
        realm2.setCredentialsMatcher(createHashedCredentialsMatcher());
        return realm2;
    }

    @Bean
    public HashedCredentialsMatcher createHashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        return credentialsMatcher;
    }
}
