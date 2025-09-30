package org.CloudNook.model.enums;


/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 15:55
 * @Description: McpServer状态枚举
 */
public enum McpServerStatus {

    /**
     * 初始化等待中
     */
    WAITING,
    /**
     * 运行中
     */
    RUNNING,
    /**
     * 异常退出
     */
    EXIT,
    /**
     * 暂停
     */
    STOP;
}
