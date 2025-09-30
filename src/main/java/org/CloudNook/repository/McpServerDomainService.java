package org.CloudNook.repository;


import org.CloudNook.model.entity.McpServer;
import org.CloudNook.model.entity.McpServerConfig;
import org.CloudNook.model.enums.McpServerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 15:14
 * @Description: Mcp服务领域
 */
@Service
public class McpServerDomainService {
    private static final Logger logger = LoggerFactory.getLogger(McpServerDomainService.class);
    // 健康MCP服务
    private static final Map<String, McpServer> MCP_HEALTH_SERVERS = new ConcurrentHashMap<>();
    // 需要重试的MCP服务（异常退出）
    private static final Queue<McpServer> MCP_RETRY_SERVERS_QUEUE = new ConcurrentLinkedQueue<>();

    /**
     * 注册mcp服务
     */
    public List<McpServer> registryMcpServer(List<McpServer> servers) {
        List<McpServer> mcpServers = new ArrayList<>();
        servers.forEach(each -> {
            if (MCP_HEALTH_SERVERS.containsKey(each.getServerName())) {
                logger.info("已存在服务 {}，跳过注册", each.getServerName());
            } else {
                // 记录获取注册的工具，避免重复注册和重复启动
                mcpServers.add(each);
                MCP_HEALTH_SERVERS.put(each.getServerName(), each);
            }
        });
        return mcpServers;
    }

    /**
     * 更新服务状态
     */
    public void updateServerStatus(List<McpServer> servers, McpServerStatus status) {
        for (McpServer server : servers) {
            McpServer mcpServer = MCP_HEALTH_SERVERS.get(server.getServerName());
            if (mcpServer != null) {
                mcpServer.setStatus(status);
            }
        }
    }

    /**
     * 添加服务到重试队列
     * @param mcpServer
     */
    public void removeServerToRetry(McpServer mcpServer) {
        MCP_HEALTH_SERVERS.remove(mcpServer.getServerName());
        MCP_RETRY_SERVERS_QUEUE.add(mcpServer);
    }
}
