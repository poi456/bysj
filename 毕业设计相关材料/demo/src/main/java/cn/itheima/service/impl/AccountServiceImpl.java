package cn.itheima.service.impl;

import cn.itheima.dao.AccountDao;
import cn.itheima.pojo.GYSUser;
import cn.itheima.pojo.HwUser;
import cn.itheima.pojo.CkUser;
import cn.itheima.pojo.account;
import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;


    @Override
    public List<account> findAll() {
        System.out.println("来了Service层");
        return accountDao.findAll();
    }
    @Override
    public List<account> FuzzyQuery(String FuzzyQuery) {
        System.out.println("来了Service层");
        System.out.println(accountDao.FuzzyQuery(FuzzyQuery));
        return accountDao.FuzzyQuery(FuzzyQuery);
    }


    @Override
    public void saveAccount(account account) {
        accountDao.saveAcccount(account);
    }

    @Override
    public void delete(String uname) {
            System.out.println("来了Service层");
//        System.out.println(accountDao. delete(id));
            accountDao.deleteWork(uname);
        }

    @Override
    public void updata(String password, String uname) {
        System.out.println("来了Service层");
        accountDao.updata(password,uname);
    }

    @Override
    public account IdfindAll(String username,String uname) {
        System.out.println("来了Service层");

        return accountDao.IdfindAll(username,uname);
    }

    @Override
    public List<GYSUser> GysfindAll() {
        return accountDao.GysfindAll();
    }

    @Override
    public GYSUser IdGYSadd(int gysid) {
        return accountDao.IdGYSadd(gysid);
    }

    @Override
    public void GYSadd(GYSUser gysUser) {
        accountDao.GYSadd(gysUser);
    }

    @Override
    public void delGYS(int gysid) {
        accountDao.delGYS(gysid);
    }

    @Override
    public void updaGYS(GYSUser gysUser) {
        accountDao.updaGYS(gysUser);
    }

    @Override
    public List<GYSUser> FuzzyQueryGYS(String FuzzyQuery) {
        return accountDao.FuzzyQueryGYS(FuzzyQuery);
    }

    @Override
    public List<HwUser> HWfindAll() {
        return accountDao.HWfindAll();
    }

    @Override
    public HwUser IdHWfindAll(String uname) {
        return accountDao.IdHWfindAll(uname);
    }

    @Override
    public void updaHW(int huowushuliang, String uname) {
        accountDao.updaHW(huowushuliang,uname);
    }

    @Override
    public List<CkUser> CKfindAll() {
        return accountDao.CKfindAll();
    }

    @Override
    public CkUser IdCKfindAll(String uname) {
        return accountDao.IdCKfindAll(uname);
    }

    @Override
    public void CKupdata(int shuliang, String uname) {
        accountDao.CKupdata(shuliang,uname);
    }

    @Override
    public void CKAdd(CkUser ckUser) {
        accountDao.CKAdd(ckUser);
    }

    @Override
    public void CKdel(int id) {
        accountDao.CKdel(id);
    }

    @Override
    public List<HwUser> HWFuzzy(String uname) {
        return accountDao.HWFuzzy(uname);
    }


}

