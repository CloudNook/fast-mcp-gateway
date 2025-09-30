package org.CloudNook.domain.model;


import java.util.Map;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:38
 * @Description: McpServer
 */
public class McpServers {

    /**
     * 服务
     */
    private Map<String, McpServerConfig> mcpServers;

    public Map<String, McpServerConfig> getMcpServers() {
        return mcpServers;
    }

    public void setMcpServers(Map<String, McpServerConfig> mcpServers) {
        this.mcpServers = mcpServers;
    }
}