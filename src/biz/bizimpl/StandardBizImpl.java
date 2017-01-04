package biz.bizimpl;

import biz.StandardBiz;
import dao.StandardDao;
import dao.daoimpl.StandardDaoImpl;
import emtity.Standard;

import java.util.List;
import java.util.Map;

/**
 * Created by 25397 on 2016/12/22.
 */
public class StandardBizImpl implements StandardBiz {
    private StandardDao standardDao=new StandardDaoImpl();
    @Override
    public int addStandard(Standard standard) {
        return standardDao.addStandard(standard);
    }

    @Override
    public int deleteStandard(int[] id) {
        return standardDao.deleteStandard(id);
    }

    @Override
    public List<Standard> getStandardByPage(Map<String, Object> map) {
        return standardDao.getStandardByPage(map);
    }

    @Override
    public int getAllCount() {
        return standardDao.getAllCount();
    }

    @Override
    public Standard getStandardbyId(int id) {
        return standardDao.getStandardbyId(id);
    }

    @Override
    public int updateStandard(Standard standard) {
        return standardDao.updateStandard(standard);
    }

    @Override
    public List<Standard> getStandardLikeZhanName(String zhanname) {
        return standardDao.getStandardLikeZhanName(zhanname);
    }

    @Override
    public List<Standard> getStandardLikeStd_num(String std_num) {
        return standardDao.getStandardLikeStd_num(std_num);
    }

    @Override
    public int getCount(Map<String, Object> map) {
        return standardDao.getCount(map);
    }

    @Override
    public Standard getStandardByStd_num(String std_num) {
        return standardDao.getStandardByStd_num(std_num);
    }
}
