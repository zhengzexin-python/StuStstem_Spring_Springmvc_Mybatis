package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 25397 on 2016/12/20.
 */
public class MyBatisUtil {
    private final static String CONFIG_FILE = "mybatis-config.xml";
    private static ThreadLocal<SqlSession> sqlSession = new ThreadLocal<>();
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_FILE);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession session = sqlSession.get();
        if (null == session) {
            session = (null != factory) ? factory.openSession() : null;
            sqlSession.set(session);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession session=sqlSession.get();
        if(null!=session){
            session.close();
        }
        sqlSession.set(null);
    }
}
