package org.CloudNook.core;


import org.CloudNook.model.entity.McpServer;
import org.CloudNook.model.entity.McpServerConfig;
import org.CloudNook.repository.McpServerDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 15:29
 * @Description: 进程控制服务
 */
@Component
public class ProcessManageService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessManageService.class);

    private final McpServerDomainService mcpServerDomainService;

    public ProcessManageService(McpServerDomainService mcpServerDomainService) {
        this.mcpServerDomainService = mcpServerDomainService;
    }

    /**
     * 启动程序
     */
    public void startProcess(List<McpServer> servers) {

        servers.forEach(server -> {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder();
                McpServerConfig config = server.getMcpServerConfig();
                // 在 Windows 上使用 cmd /c 包装命令
                processBuilder.command().add("cmd");
                processBuilder.command().add("/c");
                processBuilder.command().add(config.getCommand());
                processBuilder.command().addAll(config.getArgs());

                // todo the-way 设置环境变量

                // 启动进程
                processBuilder.start();
                logger.info("服务{}启动成功", server.getServerName());
            } catch (IOException e) {
                logger.error("服务{}启动失败，异常原因:{}",  server.getServerName(), e.getMessage());
                // todo the-way 使用异步事件监听,不要硬编码
                mcpServerDomainService.removeServerToRetry(server);
            }
        });
    }


}
