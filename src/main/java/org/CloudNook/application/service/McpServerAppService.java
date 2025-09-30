package org.CloudNook.application.service;


import org.CloudNook.application.assembler.McpServerAssembler;
import org.CloudNook.application.dto.McpServersDto;
import org.CloudNook.domain.model.McpServers;
import org.CloudNook.interfaces.dto.req.McpServerCreateRequest;
import org.springframework.stereotype.Service;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:43
 * @Description: McpServer应用服务层
 */
@Service
public class McpServerAppService {

    public McpServersDto registryServer(McpServerCreateRequest req) {
        McpServers entity = McpServerAssembler.toEntity(req);
        // TODO

        return McpServerAssembler.toDto(entity);
    }
}
