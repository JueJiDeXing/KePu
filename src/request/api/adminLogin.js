import service from "@/request";

/**
 * 登录
 */
export function adminLogin(data) {
    return service.post("/admin/login", data);
}

