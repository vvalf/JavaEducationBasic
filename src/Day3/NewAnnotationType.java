package Day3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface NewAnnotationType {

    boolean value() default false;
}

@Retention(RetentionPolicy.SOURCE)
@Documented

@interface Todo {
}
