package org.CloudNook.model.entity;


import org.CloudNook.model.enums.McpServerStatus;
import org.CloudNook.model.res.McpServersDto;
import org.springframework.beans.BeanUtils;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:38
 * @Description: McpServer
 */
public class McpServer {

    /**
     * 服务名称
     */
    private String serverName;

    /**
     * 服务配置
     */
    private McpServerConfig mcpServerConfig;

    /**
     * 服务状态
     */
    private McpServerStatus status = McpServerStatus.WAITING;


    public McpServersDto toDto() {
        McpServersDto dto = new McpServersDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public McpServerConfig getMcpServerConfig() {
        return mcpServerConfig;
    }

    public void setMcpServerConfig(McpServerConfig mcpServerConfig) {
        this.mcpServerConfig = mcpServerConfig;
    }

    public McpServerStatus getStatus() {
        return status;
    }

    public void setStatus(McpServerStatus status) {
        this.status = status;
    }
}