package org.CloudNook.application.assembler;


import org.CloudNook.application.dto.McpServersDto;
import org.CloudNook.domain.model.McpServers;
import org.CloudNook.interfaces.dto.req.McpServerCreateRequest;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:47
 * @Description: McpServerAssembler
 */
public class McpServerAssembler {

    public static McpServers toEntity(McpServerCreateRequest req) {
        McpServers mcpServers = new McpServers();
        mcpServers.setMcpServers(req.getMcpServers());
        return mcpServers;
    }

    public static McpServersDto toDto(McpServers entity) {
        McpServersDto dto = new McpServersDto();
        dto.setServer(entity.getMcpServers());
        return dto;
    }
}
