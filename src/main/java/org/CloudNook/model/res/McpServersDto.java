package org.CloudNook.model.res;


import org.CloudNook.model.entity.McpServerConfig;
import org.CloudNook.model.enums.McpServerStatus;

import java.util.Map;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:36
 * @Description: MCP服务返回
 */
public class McpServersDto {


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
    private McpServerStatus status;

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
