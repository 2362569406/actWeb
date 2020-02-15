package org.java.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderMapper {
    public void createOrder(Map map);
    /**
     * 根据流程实例id，找到对应的业务数据
     */

    public Map findMapByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
}
