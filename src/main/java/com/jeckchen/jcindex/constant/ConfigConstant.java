package com.jeckchen.jcindex.constant;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className ConfigConstant.java
 * @description
 * @date 2024年01月22日 11:00
 */
@Data
@Component
public class ConfigConstant {

    public static final String NORMAL_HOME_INFO_CONFIG_PATH = "info_config/normalHomeConfig.json";

    public static final String ADMIN_HOME_INFO_CONFIG_PATH = "info_config/adminHomeConfig.json";
}
