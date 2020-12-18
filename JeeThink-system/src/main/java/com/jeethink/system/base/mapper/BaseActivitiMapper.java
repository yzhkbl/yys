package com.jeethink.system.base.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @description: 工作流表mapper基类
 * @author: li baojian
 * @create: 2019/12/18 17:07
 */
public interface BaseActivitiMapper<T> extends BaseMapper<T> {

    @Select("select * from view_process_state where BUSINESS_KEY_=#{uuid} AND START_USER_ID_=#{startUserId}")
    Map<String, Object> listProcessState(@Param("uuid") String uuid, @Param("startUserId") String startUserId);

    @Select("select * from view_process_task_todo where KEY_=#{uuid} and ASSIGNEE_=#{assignee}")
    List<Map<String, Object>> listProcessTaskToDo(@Param("uuid") String uuid, @Param("assignee") String assignee);

    @Select("select * from view_process_task_done where KEY_=#{uuid} and ASSIGNEE_=#{assignee}")
    List<Map<String, Object>> listProcessTaskDone(@Param("uuid") String uuid, @Param("assignee") String assignee);

    @Select("select * from view_process_task_all where KEY_=#{uuid} and ASSIGNEE_=#{assignee}")
    List<Map<String, Object>> listProcessTask(@Param("uuid") String uuid, @Param("assignee") String assignee);

    @Select("select * from view_process_task_all where KEY_=#{uuid} and ASSIGNEE_=#{assignee} and state=#{state}")
    List<Map<String, Object>> listProcessTaskByState(@Param("uuid") String uuid, @Param("assignee") String assignee, @Param("state") String state);
}
