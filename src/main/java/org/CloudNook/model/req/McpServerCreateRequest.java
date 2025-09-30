package org.CloudNook.model.req;



import org.CloudNook.model.entity.McpServer;
import org.CloudNook.model.entity.McpServerConfig;
import org.CloudNook.model.enums.McpServerStatus;

import java.util.ArrayList;
import java.util.List;
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

    public List<McpServer> toMcpServers() {
        List<McpServer> servers = new ArrayList<>();
        mcpServers.forEach((k, v) -> {
            McpServer mcpServer = new McpServer();
            mcpServer.setServerName(k);
            mcpServer.setMcpServerConfig(v);
            mcpServer.setStatus(McpServerStatus.WAITING);

            servers.add(mcpServer);
        });

        return servers;
    }
}
