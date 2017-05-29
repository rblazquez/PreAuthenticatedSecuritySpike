package com.treexor.spike.demoHateoasSec.security;

import org.springframework.data.repository.query.spi.EvaluationContextExtensionSupport;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityEvaluationContextExtensionImpl extends EvaluationContextExtensionSupport {
    @Override
    public String getExtensionId() {
        return "security";
    }

    @Override
    public Object getRootObject() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new SecurityExpressionRoot(authentication){};
    }
}