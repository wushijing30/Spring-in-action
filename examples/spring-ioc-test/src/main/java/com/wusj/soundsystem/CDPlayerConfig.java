package com.wusj.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan 默认会扫描与配置类相同的包。
 * 因为CDPlayerConfig类位于soundsystem包中，
 * 因此Spring将会扫描这个包以及这个包下的所有子包，查找带
 * 有@Component注解的类。这样的话，就能发现CompactDisc，
 * 并且会在Spring中自动为其创建一个bean
 * Created by wusj on 2017/10/31.
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {
}
