package dao.daoimpl;

import dao.StandardDao;
import emtity.Standard;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by 25397 on 2016/12/22.
 */
public class StandardDaoImpl implements StandardDao {
    @Override
    public int addStandard(Standard standard) {
        int count ;
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            count = standardDao.addStandard(standard);
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession();
        }
        return count;
    }

    @Override
    public int deleteStandard(int[] id) {

        int count ;
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            count = standardDao.deleteStandard(id);
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession();
        }
        return count;
    }

    @Override
    public List<Standard> getStandardByPage(Map<String, Object> map) {
            SqlSession sqlSession ;
            try {
                sqlSession = MyBatisUtil.getSqlSession();
                StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
                return standardDao.getStandardByPage(map);
            } finally {
                MyBatisUtil.closeSession();
            }

    }

    @Override
    public int getAllCount() {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getAllCount();
        } finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public Standard getStandardbyId(int id) {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getStandardbyId(id);
        } finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public int updateStandard(Standard standard) {
        int count ;
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            count = standardDao.updateStandard(standard);
            sqlSession.commit();
        } finally {
            MyBatisUtil.closeSession();
        }
        return count;
    }

    @Override
    public List<Standard> getStandardLikeZhanName(String zhanname) {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getStandardLikeZhanName(zhanname);
        } finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public List<Standard> getStandardLikeStd_num(String std_num) {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getStandardLikeStd_num(std_num);
        } finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public int getCount(Map<String ,Object> map) {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getCount(map);
        } finally {
            MyBatisUtil.closeSession();
        }
    }

    @Override
    public Standard getStandardByStd_num(String std_num) {
        SqlSession sqlSession ;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            StandardDao standardDao = sqlSession.getMapper(StandardDao.class);
            return standardDao.getStandardByStd_num(std_num);
        } finally {
            MyBatisUtil.closeSession();
        }
    }
}
