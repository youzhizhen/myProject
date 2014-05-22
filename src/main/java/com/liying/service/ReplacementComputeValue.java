package com.liying.service;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Service;

@Service
public class ReplacementComputeValue implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args)
            throws Throwable {
        return args[0];
    }

}
