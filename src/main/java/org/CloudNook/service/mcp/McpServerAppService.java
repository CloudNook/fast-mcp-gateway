package org.CloudNook.service.mcp;


import org.CloudNook.common.assembler.McpServerAssembler;
import org.CloudNook.core.ProcessManageService;
import org.CloudNook.model.enums.McpServerStatus;
import org.CloudNook.model.res.McpServersDto;
import org.CloudNook.model.entity.McpServer;
import org.CloudNook.repository.McpServerDomainService;
import org.CloudNook.model.req.McpServerCreateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:43
 * @Description: McpServer应用服务层
 */
@Service
public class McpServerAppService {

    private final McpServerDomainService mcpServerDomainService;
    private final ProcessManageService processManageService;

    public McpServerAppService(McpServerDomainService mcpServerDomainService, ProcessManageService processManageService) {
        this.mcpServerDomainService = mcpServerDomainService;
        this.processManageService = processManageService;
    }

    public List<McpServersDto> registryServer(McpServerCreateRequest req) {
        // 转换为server列表
        List<McpServer> servers = req.toMcpServers();
        // 注册新添加的服务, 返回需要启动的服务
        List<McpServer> mcpServers = mcpServerDomainService.registryMcpServer(servers);

        // todo the-way 启动程序
        processManageService.startProcess(mcpServers);

        // 更新mcp服务状态
        mcpServerDomainService.updateServerStatus(mcpServers, McpServerStatus.RUNNING);

        return McpServerAssembler.toDtos(mcpServers);
    }
}
