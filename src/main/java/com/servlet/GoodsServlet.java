package com.servlet;

import com.alibaba.fastjson.JSON;
import com.bean.Goods;
import com.service.GoodsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet{

    private GoodsService goodsService = new GoodsService();
    /**
     *管理员采购商品
     *@param req
     * @param res
     * @throws Exception
     */
    public void addGoods(HttpServletRequest req, HttpServletResponse res) throws Exception{
        // 解决乱码问题 GET
        String username = req.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String number = req.getParameter("number");
        String image = req.getParameter("image");
        String price = req.getParameter("price");
        goodsService.addGoods(username,number,image,price);

        res.setContentType("text/json;charset=utf-8");
    }

    /**
     * 房间查询
     * @param req
     * @param res
     * @throws Exception
     */

    public void getGoodsList(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<Goods> goods = goodsService.selectAll();
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(goods);
        System.out.println(jsonString);
        res.getWriter().write(jsonString);
    }

}
