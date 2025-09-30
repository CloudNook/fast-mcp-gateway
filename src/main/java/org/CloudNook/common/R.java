package org.CloudNook.common;

/**
 * 通用API响应结果
 *
 * @param <T> 数据类型
 */
public class R<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp;

    public R() {
        this.timestamp = System.currentTimeMillis();
    }

    public R(Integer code, String message) {
        this(code, message, null);
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功响应（无数据）
     *
     * @return 响应结果
     */
    public static <T> R<T> ok() {
        return new R<>(200, "操作成功");
    }

    /**
     * 成功响应（有数据）
     *
     * @param data 响应数据
     * @return 响应结果
     */
    public static <T> R<T> ok(T data) {
        return new R<>(200, "操作成功", data);
    }

    /**
     * 成功响应（自定义消息和数据）
     *
     * @param message 响应消息
     * @param data    响应数据
     * @return 响应结果
     */
    public static <T> R<T> ok(String message, T data) {
        return new R<>(200, message, data);
    }

    /**
     * 失败响应
     *
     * @param code    状态码
     * @param message 响应消息
     * @return 响应结果
     */
    public static <T> R<T> fail(Integer code, String message) {
        return new R<>(code, message);
    }

    /**
     * 服务器内部错误
     *
     * @param message 错误消息
     * @return 响应结果
     */
    public static <T> R<T> serverError(String message) {
        return fail(500, message);
    }

    /**
     * 参数错误
     *
     * @param message 错误消息
     * @return 响应结果
     */
    public static <T> R<T> badRequest(String message) {
        return fail(400, message);
    }

    /**
     * 未授权
     *
     * @param message 错误消息
     * @return 响应结果
     */
    public static <T> R<T> unauthorized(String message) {
        return fail(401, message);
    }

    /**
     * 禁止访问
     *
     * @param message 错误消息
     * @return 响应结果
     */
    public static <T> R<T> forbidden(String message) {
        return fail(403, message);
    }

    /**
     * 资源不存在
     *
     * @param message 错误消息
     * @return 响应结果
     */
    public static <T> R<T> notFound(String message) {
        return fail(404, message);
    }

    // Getter and Setter

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}