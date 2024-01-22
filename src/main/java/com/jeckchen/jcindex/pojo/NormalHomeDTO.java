package com.jeckchen.jcindex.pojo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.jeckchen.jcindex.constant.ConfigConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className NormalHomeDTO.java
 * @description
 * @date 2024年01月22日 10:23
 */
@EqualsAndHashCode(callSuper = false)
@Component
@Data
public class NormalHomeDTO extends HomeDTO {

    private static HomeDTO instance = new NormalHomeDTO();

    private NormalHomeDTO() {
    }

    public static HomeDTO getInstance() {
        instance = initProperty(ConfigConstant.NORMAL_HOME_INFO_CONFIG_PATH);
        return instance;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public void updateProperty(String json) {
        // 判断是否为json
        if (!JSONUtil.isTypeJSON(json)) {
            // 不符合直接返回
            return;
        }
        FileUtil.writeUtf8String(json,ConfigConstant.NORMAL_HOME_INFO_CONFIG_PATH);
        instance = initProperty(ConfigConstant.NORMAL_HOME_INFO_CONFIG_PATH);
    }
}
