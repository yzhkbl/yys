package com.jeethink.system.base.service;

import java.io.Serializable;
import java.util.List;

/**
 * tree接口基类
 * @param <T>
 */
public interface BaseTreeService<T> extends BaseService<T> {
    /**
     * <p>
     * 插入一条记录 需更新父节点信息
     * </p>
     *
     */
    boolean save(T entity);

    /**
     * <p>
     * 更新记录 需判断父节点是否改变
     * </p>
     *
     */
    boolean updateById(T entity);


    /**
     * <p>
     * 根据 ID 删除 需更新父节点信息
     * </p>
     *
     */
    boolean removeById(Serializable id);

    /**
     * 获取所有下级
     *
     * @param uuid
     * @return
     */
    List<String> getChildrenPk(Serializable uuid);

    /**
     * 获取所有父级节点
     *
     * @param uuid
     * @return
     */
    List<String> getParentPk(Serializable uuid);

    /**
     * 根据父节点获取下级节点
     * @param parentUuid
     * @return
     */
    List<T> selectChild(Serializable parentUuid);

    /**
     * 根据父节点获取下级节点
     * @param parentUuid
     * @return
     */
    int selectChildCount(Serializable parentUuid);
//
//    /**
//     * 查询树
//     *
//     * @param queryWrapper
//     * @return
//     */
//    List<T> selectTree(Wrapper<T> queryWrapper);
}
