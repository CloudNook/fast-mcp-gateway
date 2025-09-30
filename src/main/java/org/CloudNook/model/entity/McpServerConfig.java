package org.CloudNook.model.entity;


import java.util.List;

/**
 * @Author: the-way
 * @Verson: v1.0
 * @Date: 2025-09-30 14:38
 * @Description: McpServerConfig
 */
public class McpServerConfig {

    /**
     * 命令
     */
    private String command;

    /**
     * 命令参数
     */
    private List<String> args;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
