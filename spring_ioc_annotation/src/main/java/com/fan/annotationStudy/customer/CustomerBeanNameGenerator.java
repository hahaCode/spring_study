package com.fan.annotationStudy.customer;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.Map;
import java.util.Set;

/**
 * 自定义一个BeanNameGenerator实现自己需要的Bean的命名规则
 *
 *
 */

public class CustomerBeanNameGenerator implements BeanNameGenerator {

    private static final String COMPONENT_ANNOTATION_CLASSNAME = "org.springframework.stereotype.Component";


    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        String beanName = null;

        //1.判断当前bean的定义信息是否是注解的
        if(beanDefinition instanceof AnnotatedBeanDefinition) {
            //2.把definition转成注解的bean定义信息
            AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition)beanDefinition;
            //3.获取注解bean定义的元信息
            AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
            //4.获取定义信息的中所有注解
            Set<String> annotationTypes = metadata.getAnnotationTypes();
            //5.遍历集合
            for (String type : annotationTypes) {
                //6.获取注解属性值
                AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(type, false));
                //7.判断attributes是否为null, 同时必须是@Component及其衍生注解
                if(annotationAttributes != null && isStereotypeWithNameValue(type, annotationTypes, annotationAttributes)) {
                    Object value = annotationAttributes.get("value");
                    if(value instanceof String) {
                       String strValue = (String) value;
                        if (StringUtils.hasLength(strValue)) {
                            if (beanName != null && !strValue.equals(beanName)) {
                                throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
                                        "component names: '" + beanName + "' versus '" + strValue + "'");
                            }
                            beanName = strValue;
                        }
                    }
                }
            }
        }
        //返回自定义的bean名称
        return beanName != null ? "my"+beanName : "my"+buildDefaultBeanName(beanDefinition);
    }

    private boolean isStereotypeWithNameValue(String annotationType,
                                                Set<String> metaAnnotationTypes, @Nullable Map<String, Object> attributes) {

        boolean isStereotype = annotationType.equals(COMPONENT_ANNOTATION_CLASSNAME) ||
                metaAnnotationTypes.contains(COMPONENT_ANNOTATION_CLASSNAME) ||
                annotationType.equals("javax.annotation.ManagedBean") ||
                annotationType.equals("javax.inject.Named");

        return (isStereotype && attributes != null && attributes.containsKey("value"));
    }

    private String buildDefaultBeanName(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        Assert.state(beanClassName != null, "No bean class name set");
        String shortClassName = ClassUtils.getShortName(beanClassName);
        return Introspector.decapitalize(shortClassName);
    }
}
