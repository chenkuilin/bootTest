package com.rsc.ckl.boottest.event;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */
public class RoadshowFindBean<T> implements FactoryBean<T> {

    @Override
    public T getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

}
