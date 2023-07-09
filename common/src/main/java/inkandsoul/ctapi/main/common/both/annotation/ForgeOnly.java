package inkandsoul.ctapi.main.common.both.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 用于注明一个处于common中的方法、类、字段的运行环境为Forge
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface ForgeOnly {
    
}
