package com.suzhoukeleqi.entity;

import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 需要刷新的 fragment 名 (thymeleaf)
     */
    private String fragment;
    /**
     * 分类级别名
     */
    private String typeName;
    /**
     * 分类级别名
     */
    private String typeValue;

}