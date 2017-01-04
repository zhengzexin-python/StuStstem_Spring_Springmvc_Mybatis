package controller;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 25397 on 2017/1/4.
 */
@Controller
public class StandardController {
    @Autowired
    private StandardBiz standardBiz;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/GetStandardByPage")
    public String GetStandardByPage(String select, String pageIndex, ModelMap modelMap) {
        Map<String, Object> map = new HashMap<>();
        if ("".equals(select) || null == select) {

        } else {

            Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]");
            Matcher matcher = pattern.matcher(select);
            if (matcher.find()) {
                map.put("zhname", select);
            } else {
                map.put("std_num", select);
            }
        }

        if (null == pageIndex) {
            pageIndex = "1";
        }
        int currentPage = Integer.parseInt(pageIndex);
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setTotal(standardBiz.getCount(map));

        map.put("start", (page.getCurrentPage() - 1) * page.getPageSize());
        map.put("pageSize", page.getPageSize());
        List<Standard> standardList = standardBiz.getStandardByPage(map);
        modelMap.addAttribute("standardList", standardList);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("select", select);
        return "index";
    }
}
