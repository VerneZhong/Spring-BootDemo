package com.example.demo.util;

import com.google.common.collect.Lists;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.List;

public class GeneratorDisplay {

    public void generator() throws Exception {
        List<String> warnings = Lists.newArrayList();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File(System.getProperty("user.dir")+"/src/main/resources/generator/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {

        GeneratorDisplay generatorDisplay = new GeneratorDisplay();
        generatorDisplay.generator();
    }
}
