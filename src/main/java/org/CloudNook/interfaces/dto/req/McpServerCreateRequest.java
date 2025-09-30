package org.CloudNook.interfaces.dto.req;


import org.CloudNook.domain.model.McpServerConfig;
import org.CloudNook.domain.model.McpServers;

import java.util.Map;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:40
 * @Description: McpServerCreateReq
 */
public class McpServerCreateRequest {

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
