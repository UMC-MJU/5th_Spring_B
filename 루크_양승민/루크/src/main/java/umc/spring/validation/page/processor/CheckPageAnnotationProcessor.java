package umc.spring.validation.page.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.UtilHandler;
import umc.spring.validation.page.annotation.CheckPage;

import java.lang.reflect.Field;

@Component
public class CheckPageAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CheckPage.class)) {
                try{
                    field.setAccessible(true);
                    if (field.getType().equals(int.class)) {
                        int value = (int) field.get(bean);
                        field.set(bean, value + 1);
                    }
                } catch (IllegalAccessException e) {
                    throw new UtilHandler(ErrorStatus.TYPE_BAD_REQUEST);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
