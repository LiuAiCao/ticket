package com.company.utils.FileUtils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

/*
*  添加 读取yml 工具类  读取自定义配置
*  之后 将用@value 注解统一设置
* */
public class YmlUtil {

    //获取yml 属性
    public static Map<String,Object> getYmlAttribute(String ymlFilePathAndName){
        Yaml yaml = new Yaml();
        //MailConfig 这个是这个主函数所在的类的类名
        InputStream resourceAsStream = YmlUtil.class.getClassLoader().getResourceAsStream(ymlFilePathAndName);
        //加载流,获取yaml文件中的配置数据，然后转换为Map，
        Map<String,Object> obj = (Map<String,Object>) yaml.load(resourceAsStream);
        return obj;
    }
}
