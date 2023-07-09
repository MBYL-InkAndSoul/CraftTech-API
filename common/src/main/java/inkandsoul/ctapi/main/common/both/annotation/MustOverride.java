package inkandsoul.ctapi.main.common.both.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>表示其修飾的方法必須被實作</p>
 * <br>
 * <p>The interface described, the method must be overridden.</p>
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface MustOverride {
    
}
