package org.CloudNook.application.dto;


import org.CloudNook.domain.model.McpServerConfig;

import java.util.Map;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:36
 * @Description: MCP服务返回
 */
public class McpServersDto {

    /**
     * 服务
     */
    private Map<String, McpServerConfig> server;

    public Map<String, McpServerConfig> getServer() {
        return server;
    }

    public void setServer(Map<String, McpServerConfig> server) {
        this.server = server;
    }
}
