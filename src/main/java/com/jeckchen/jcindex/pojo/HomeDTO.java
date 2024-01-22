package com.jeckchen.jcindex.pojo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className HomeDTO.java
 * @description
 * @date 2024年01月22日 10:03
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomeDTO implements Serializable {
    private String avatarPath;
    private String nickname;
    private String selfIntroduction;
    private List<ButtonVO> buttons;

    protected static HomeDTO initProperty(String path) {
        // 示例path "src/main/resources/example.json"
        // 判断文件是否存在
        if (!FileUtil.exist(path)) {
            // 不存在则创建文件
            FileUtil.touch(path);
            FileUtil.writeUtf8String("{}",path);
        }
        String jsonStr = FileUtil.readUtf8String(path);
        return JSONUtil.toBean(jsonStr, HomeDTO.class);
    }
}