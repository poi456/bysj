import cn.itheima.dao.AccountDao;
import cn.itheima.pojo.GYSUser;
import cn.itheima.pojo.HwUser;
import cn.itheima.pojo.CkUser;
import cn.itheima.pojo.account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public  void select() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
//        List<account> all = mapper.findAll();
        List<account> all = mapper.findAll();
        for (account account : all) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public  void insert() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        account a=new account("小黑","女","123456","456456@qq.com","湖南长沙","员工","123","root");
         mapper.saveAcccount(a);
        session.commit();
        session.close();
        in.close();
    }

    //模糊查询
    @Test
    public  void de() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<account> accounts = mapper.FuzzyQuery("%小%");
        System.out.println(accounts);
        session.close();
        in.close();
    }

    //删除
    @Test
    public  void deta() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.deleteWork("root");
        session.commit();
        session.close();
        in.close();
    }
    //修改
    @Test
    public  void updata() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.updata("12","root");
        session.commit();
        session.close();
        in.close();
    }
//通过name进行查询
    @Test
    public  void idFindAll() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        account admin = mapper.IdfindAll("小王",null);

        System.out.println(admin);
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void GYSUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<GYSUser> gysUsers = mapper.GysfindAll();
        System.out.println(gysUsers);
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public  void gysadd() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        GYSUser gysUser=new GYSUser(3,"小王","132","湖南","李总");
        mapper.GYSadd(gysUser);
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public  void gysdel() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.delGYS(3);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void gysupdata() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        GYSUser gysUser=new GYSUser(2,"小王","1123","湖南邵阳","李总");
        mapper.updaGYS(gysUser);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void gysMoHuChaXun() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<GYSUser> gysUsers = mapper.FuzzyQueryGYS("%李%");
        System.out.println(gysUsers);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void HWselect() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<HwUser> hwUsers = mapper.HWfindAll();
        System.out.println(hwUsers);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public  void HWidselect() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        HwUser a = mapper.IdHWfindAll("薯片");

        System.out.println(a);
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public  void HWupdata() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.updaHW(123,"薯片");
        session.commit();
        session.close();
        in.close();
    }

    //查询仓库全部
    @Test
    public  void selectAll() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<CkUser> ckUsers =  mapper.CKfindAll();
        System.out.println(ckUsers);
        session.commit();
        session.close();
        in.close();
    }


    //通过名称查找仓库
    @Test
    public void a() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        CkUser  asd= mapper.IdCKfindAll("巧克力");
        System.out.println(asd);
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void updataCK() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.CKupdata(316+1,"薯片");
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void insCK() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        CkUser ckUser=new CkUser(null,"巧克力",12,12);
        System.out.println(ckUser);
       mapper.CKAdd(ckUser);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void delCK() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.CKdel(8);
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void asd() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        mapper.HWFuzzy("%123%");
        session.close();
        in.close();
    }
}
