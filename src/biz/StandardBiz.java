package biz;

import emtity.Standard;

import java.util.List;
import java.util.Map;

/**
 * Created by 25397 on 2016/12/22.
 */
public interface StandardBiz {
    public int addStandard(Standard standard);
    public int deleteStandard(int[] id);
    public List<Standard> getStandardByPage(Map<String,Object> map);
    public int getAllCount();
    public Standard getStandardbyId(int id);
    public int updateStandard(Standard standard);
    public List<Standard> getStandardLikeZhanName(String zhanname);
    public List<Standard> getStandardLikeStd_num(String std_num);
    public int getCount(Map<String,Object> map);
    public Standard getStandardByStd_num(String std_num);


}
