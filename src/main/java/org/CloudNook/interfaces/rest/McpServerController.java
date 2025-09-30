package org.CloudNook.interfaces.rest;


import org.CloudNook.application.dto.McpServersDto;
import org.CloudNook.application.service.McpServerAppService;
import org.CloudNook.infrastructure.common.R;
import org.CloudNook.interfaces.dto.req.McpServerCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:31
 * @Description: McpGatewayController
 */
@RestController
@RequestMapping("/server")
public class McpServerController {

    private final McpServerAppService mcpServerAppService;

    public McpServerController(McpServerAppService mcpServerAppService) {
        this.mcpServerAppService = mcpServerAppService;
    }


    /**
     * 注册服务
     */
    @PostMapping
    public R<McpServersDto> registryServer(@RequestBody McpServerCreateRequest req) {
        return R.ok(mcpServerAppService.registryServer(req));
    }
}
