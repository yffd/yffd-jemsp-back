package com.yffd.jemsp.framework.ddd.infrastructure.repository;

import java.util.UUID;

/**
 * 领域厂库标记接口
 */
public interface IRepository {

    default String nextIdentity() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

}
