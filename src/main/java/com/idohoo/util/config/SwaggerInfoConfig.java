package com.idohoo.util.config;

/**
 * 配置
 * created by yinian on 18-4-12.
 */
public interface SwaggerInfoConfig {

    /**
     * 需要扫描的包名，一般是controller
     * @return String
     */
    String getBasePackage();

    /**
     * 文档名
     * @return String
     */
    String getTitle();

    /**
     * 文档描述
     * @return String
     */
    String getDescription();

    /**
     * 服务地址
     * @return String
     */
    String getServiceUrl();

    /**
     * 版本号
     * @return String
     */
    String getVersion();
}
