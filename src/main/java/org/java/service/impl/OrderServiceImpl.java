package org.java.service.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.java.dao.OrderMapper;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void createOrder(Map map) {
        /**启动流程实例**/

        //创建buniessKey,用于关联到业务表
        String businessKey = UUID.randomUUID().toString();
        //指定流程定义的key
        String processDefinitionKey = "myProcess";
        //启动流程实例
        ProcessInstance Instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);

        /**向采购表添加记录**/
        map.put("id",businessKey);//业务表主键
        map.put("createTime",new Date());//采购单创建时间
        map.put("processInstanceId",Instance.getProcessInstanceId());//采购单所属实例ID

        //新增
        orderMapper.createOrder(map);
    }

    /**
     *任务相关的服务是：TaskService
     * @param userId 用户名，查询的是当前用户的任务
     * @return
     */
    @Override
    public List<Map> queryPersonTask(String userId) {
        return null;
    }
}
