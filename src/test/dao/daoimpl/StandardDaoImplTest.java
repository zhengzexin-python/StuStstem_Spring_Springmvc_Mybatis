package test.dao.daoimpl;

import dao.StandardDao;
import dao.daoimpl.StandardDaoImpl;
import emtity.Standard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StandardDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十二月 23, 2016</pre>
 */
public class StandardDaoImplTest {

    private StandardDao standardDao = new StandardDaoImpl();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addStandard(Standard standard)
     */
    @Test
    public void testAddStandard() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteStandard(int[] id)
     */
    @Test
    public void testDeleteStandard() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getStandardByPage(Map<String, Object> map)
     */
    @Test
    public void testGetStandardByPage() throws Exception {
//TODO: Test goes here...
        Map<String, Object> map = new HashMap<>();
        map.put("start", 0);
        map.put("pageSize", 2);
        map.put("zhname", "玩具");
        map.put("std_num", "GB");
        List<Standard> standardList = standardDao.getStandardByPage(map);
        System.out.println(standardList);

    }

    /**
     * Method: getCount()
     */
    @Test
    public void testGetAllCount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getStandardbyId(int id)
     */
    @Test
    public void testGetStandardbyId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateStandard(Standard standard)
     */
    @Test
    public void testUpdateStandard() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getStandardLikeZhanName(String zhanname)
     */
    @Test
    public void testGetStandardLikeZhanName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getStandardLikeStd_num(String std_num)
     */
    @Test
    public void testGetStandardLikeStd_num() throws Exception {
//TODO: Test goes here... 
    }


    @Test
    public void testGetCount() throws Exception {
//TODO: Test goes here...
     Map<String,Object> map=new HashMap<>();
     map.put("zhname","第2部分");
        System.out.println(standardDao.getCount(map));
    }
} 
