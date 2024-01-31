import service from "@/request";

/**
 * 获取首页轮播图
 */
export function getBanner() {
    return service({
        method: "GET",
        url: "banner?type=2",
    });
}

