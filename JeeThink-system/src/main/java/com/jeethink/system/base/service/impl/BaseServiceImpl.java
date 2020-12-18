package com.jeethink.system.base.service.impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jeethink.system.base.mapper.BaseMapper;
import com.jeethink.system.base.model.BaseModel;
import com.jeethink.system.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 接口实现基类
 *
 * @param <M>
 * @param <T>
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseModel> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> implements BaseService<T>, IService<T> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


}
