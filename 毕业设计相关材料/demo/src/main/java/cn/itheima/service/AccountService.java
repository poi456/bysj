package cn.itheima.service;

import cn.itheima.pojo.GYSUser;
import cn.itheima.pojo.HwUser;
import cn.itheima.pojo.account;
import cn.itheima.pojo.CkUser;
import java.util.List;

public interface AccountService {

    //查询所有
    public List<account> findAll();
    //模糊查询
    public List<account> FuzzyQuery(String FuzzyQuery);
    //添加
    public void saveAccount(account account);
    //删除
    public void delete(String uname);

    //删除
    public void updata(String password,String uname);
    //id查询
    public account IdfindAll(String username,String uname);

    //供应商查询
    public List<GYSUser> GysfindAll();

    //通过id查询供应商
    public  GYSUser IdGYSadd(int gysid);

    //增加供应商
    public  void GYSadd(GYSUser gysUser);

    //删除供应商
    public  void delGYS(int gysid);

    //修改供应商电话和地址
    void updaGYS(GYSUser gysUser);

    //模糊查询
    List<GYSUser> FuzzyQueryGYS(String FuzzyQuery);

    //查询商品
    List<HwUser> HWfindAll();

    //通过商品名称查询商品
    HwUser IdHWfindAll(String uname);

    //修改商品表
    void updaHW(int huowushuliang,String uname);
    //查看仓库数量
    List<CkUser> CKfindAll();

    //通过商品名称查询仓库
    CkUser  IdCKfindAll(String uname);


    //通过商品名称修改商品数量
    void CKupdata( int shuliang,String uname);



    //添加
    void CKAdd(CkUser ckUser);

    //添加
    void CKdel(int id);


    //货物模糊查询
    List<HwUser> HWFuzzy(String uname);
}
