package cn.itheima.dao;

import cn.itheima.pojo.GYSUser;
import cn.itheima.pojo.CkUser;
import cn.itheima.pojo.HwUser;
import cn.itheima.pojo.account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    //    写两个方法查询跟添加

    //查询所有
     List<account> findAll();
    //模糊查询
    List<account> FuzzyQuery(String FuzzyQuery);
    //添加
    void saveAcccount(account account);
//    删除
    void deleteWork(String uname);
    //修改
    void updata(@Param("password") String password,@Param("uname") String uname);

    //通过name进行查询
    account IdfindAll(@Param("username") String username,@Param("uname") String uname);

    //查询供应商id
    List<GYSUser> GysfindAll();

    //添加供应商
    void GYSadd(GYSUser gysUser);

    //通过id查询供应商
    GYSUser IdGYSadd(int gysid);

    //删除供应商
    void delGYS(int gysid);

    //修改供应商电话地址
    void updaGYS(GYSUser gysUser);

    //模糊查询
    List<GYSUser> FuzzyQueryGYS(String FuzzyQuery);

    //查询商品
    List<HwUser> HWfindAll();
    //通过商品名称查询商品
    HwUser IdHWfindAll(String uname);
    //修改商品
    void updaHW(@Param("huowushuliang") int huowushuliang,@Param("uname") String uname);

    //查看全部仓库数量
    List<CkUser> CKfindAll();

    //通过商品名称查询仓库
    CkUser  IdCKfindAll(String uname);


    //修改
    void CKupdata(@Param("shuliang") int shuliang,@Param("uname") String uname);


    //添加
    void CKAdd(CkUser ckUser);
    //添加
    void CKdel(int id);

    //货物模糊查询
    List<HwUser> HWFuzzy(String uname);
}

