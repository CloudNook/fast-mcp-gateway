package org.CloudNook.common.assembler;


import org.CloudNook.model.entity.McpServer;
import org.CloudNook.model.res.McpServersDto;

import java.util.List;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 16:21
 * @Description: McpServerAssembler
 */
public class McpServerAssembler {

    public static List<McpServersDto> toDtos(List<McpServer> mcpServers) {
        return mcpServers.stream()
                .map(McpServer::toDto)
                .toList();
    }
}
