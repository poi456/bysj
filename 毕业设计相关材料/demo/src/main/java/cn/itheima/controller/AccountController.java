package cn.itheima.controller;

import cn.itheima.pojo.GYSUser;
import cn.itheima.pojo.CkUser;
import cn.itheima.pojo.HwUser;
import cn.itheima.pojo.account;
import cn.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    //依赖注入一下子通过注解
    @Autowired
    private AccountService accountService;
    @RequestMapping("/main")
    public String login(String uname, String password, Model model, HttpSession session){
        session.setAttribute("asd",uname);
        System.out.println("账号"+uname+" 密码"+password);
        account account = accountService.IdfindAll(null, uname);
        System.out.println(account);

        if (account.getUname().equals(uname)&&account.getPassword().equals(password)&&account.getLevel().equals("管理员")){
            model.addAttribute("error", "管理员");
            return "redirect:/pages/index.jsp";
        }
        if (account.getUname().equals(uname)&&account.getPassword().equals(password)&&account.getLevel().equals("员工")){
            model.addAttribute("error", "员工");
            return "redirect:/pages/index.jsp";
        }
        model.addAttribute("error", "账号或密码错误");
        return "../login";
    }

//    管理员权限管理 查询全部
    @RequestMapping("/hueyuanj")
    public String hueyuan1(Model model){
        System.out.println("来了管理员层Controller");
        List<account> all = accountService.findAll();
        System.out.println(all);
        model.addAttribute("findAll",all);
        return "member-list";
    }
    //    会员列表(动态态表格)
    @RequestMapping("/hueyuand")
    public String hueyuan2(){
        return "member-list1";
    }

//    添加表单admin-add.jsp
@RequestMapping("/add")
public String add(account account,Model model){
    account name = accountService.IdfindAll(account.getUsername(),null);
    account name1 = accountService.IdfindAll(null,account.getUname());
    System.out.println(name==null);
    System.out.println(name1==null);
    if (name==null&&name1==null&&account!=null){
        accountService.saveAccount(account);
    }else{
        System.out.println("给弹框");
        model.addAttribute("error", "已有该员工添加失败");
        return "admin-add";
    }
    model.addAttribute("error", "添加成功");
    return "admin-add";

}

    //   模糊查询
    @RequestMapping("/FuzzyQuery")
    public String FuzzyQuery(String FuzzyQuery,Model model){
        System.out.println("模糊查询");
        System.out.println(FuzzyQuery);
            List<account> accounts = accountService.FuzzyQuery("%"+FuzzyQuery+"%");
            System.out.println(accounts);
            model.addAttribute("findAll",accounts);

//        return "redirect:/account/hueyuanj";
        return "member-list";
    }

    //   删除员工
    @RequestMapping("/delete")
    public String delete(String uname){
        System.out.println("删除");
        accountService.delete(uname);
        return "redirect:/account/hueyuanj";
    }

    //修改
    @RequestMapping("/upfata")
    public String upfata(String username,String uname,String password,String newpassword,String repassword,Model model){
        System.out.println("修改");
        System.out.println("用户名"+username+" 账号"+uname+"  旧密码"+password+"  新密码"+newpassword+"  确认密码"+repassword);
        account account = accountService.IdfindAll(username,uname);
        System.out.println(account);
        //如果旧密码等于数据库中的密码  并且 账号等于数据库中的账号 并且 新密码等于确认密码
        if(password.equals(account.getPassword())&&uname.equals(account.getUname())&&newpassword.equals(repassword)){
            accountService.updata(newpassword,uname);
            System.out.println("修改成功");
            model.addAttribute("error","修改成功");
            return "redirect:/account/hueyuanj";
        } else{
            System.out.println("修改失败");
            model.addAttribute("error","修改失败");
            return "member-password";
        }
    }


    //查看供应商
    @RequestMapping("/selectGYS")
    public String selectGYS(Model model){
        System.out.println("查询全部供应商");
        List<GYSUser> all = accountService.GysfindAll();
        System.out.println(all);
        model.addAttribute("findAll",all);
        return "cate";
    }
    //增加供应商
    @RequestMapping("/addGYS")
    public String addGYS(GYSUser gysUser,Model model){
        System.out.println("增加供应商");

        GYSUser gysUser1 = accountService.IdGYSadd(gysUser.getGysid());
        System.out.println(gysUser1);
        System.out.println("查询");
        if (gysUser1!=null){
            System.out.println("龟儿子");
            model.addAttribute("error","已有该老板");
            return "Gysadd";
        }else{
           gysUser.setUsername("小王");

            System.out.println(gysUser);
            accountService.GYSadd(gysUser);
            model.addAttribute("error","添加成功");
            return "Gysadd";
        }
    }

    //删除供应商
    @RequestMapping("/delGYS")
    public String addGYS(int id,Model model){
        System.out.println("删除"+id);
        if (id==1){
            model.addAttribute("error","老板说了这是最重要的供应商不能删");
            System.out.println("查询全部供应商");
            List<GYSUser> all = accountService.GysfindAll();
            System.out.println(all);
            model.addAttribute("findAll",all);
            return "cate";
        }
        accountService.delGYS(id);
        return "redirect:/account/selectGYS";
    }

    //修改供应商
    @RequestMapping("/updaGYS")
    public String updaGYS(GYSUser gysUser,Model model){
        System.out.println(gysUser.getGysid());
        GYSUser gysUser1 = accountService.IdGYSadd(gysUser.getGysid());
        System.out.println(gysUser1);
        if (gysUser1!=null){
            accountService.updaGYS(gysUser);
            return "redirect:/account/selectGYS";
        }else{
            model.addAttribute("error","没有这位老板的信息重新输入id");
            return "GysUpda";
        }
    }

    //模糊查询
    @RequestMapping("/FuzzyQueryGYS")
    public String FuzzyQueryGYS(String uname,Model model){
        System.out.println("供应商模糊查询");
        System.out.println(uname);
        List<GYSUser> accounts = accountService.FuzzyQueryGYS("%"+uname+"%");
        System.out.println(accounts);
        model.addAttribute("findAll",accounts);

        return "cate";
    }


    //查看货物
    @RequestMapping("/selectHW")
    public String selectHW(Model model){
        System.out.println("查询全部货物");
        List<HwUser> hwUsers = accountService.HWfindAll();
        System.out.println(hwUsers);
        model.addAttribute("findAll",hwUsers);
        return "order-list";
    }
    //货物模糊查询
    @RequestMapping("/Fuzzy")
    public String HWFuzzy(String uname,Model model){
        System.out.println(uname);
        List<HwUser> hwUsers = accountService.HWFuzzy("%"+uname+"%");
        System.out.println(hwUsers);
        model.addAttribute("findAll",hwUsers);
        return "order-list";
    }
    private int asd=0;
    private String usname=null;
    //进货数量
    @RequestMapping("/jinhuo")
    public String jinhuoadd(String uname,int username,Model model){
        System.out.println("进货数量"+username+"商品名称"+uname);
        HwUser hwUser = accountService.IdHWfindAll(uname);
        CkUser ckUsers = accountService.IdCKfindAll(uname);
        System.out.println(uname);
        System.out.println(hwUser);
        int d=hwUser.getHuowushuliang()-username;
        if (hwUser.getHuowushuliang()==0||d<0){
            model.addAttribute("error","货源不足，请购买其他商品");
            return "jinhuo";
        }
        accountService.updaHW(d,uname);
        if(ckUsers==null){
            CkUser ck=new CkUser(null,uname,username,5);
            System.out.println(ck);
            accountService.CKAdd(ck);
            return "jinhuo";
        }

        int c=username+ckUsers.getShuliang();
        accountService.CKupdata(c,uname);
        System.out.println(c);


        System.out.println("修改成功");
        model.addAttribute("error","进货成功");
        return "jinhuo";
    }


    //查看仓库全部
    @RequestMapping("/selectCK")
    public String selectCK(Model model){
        System.out.println("查询仓库全部");
        List<CkUser> ckUsers = accountService.CKfindAll();
        model.addAttribute("findAll",ckUsers);
        return "admin-list";
    }

    //通过uname查看仓库
    @RequestMapping("/idselectCK")
    public String idselectCK(Model model){
        if (this.asd==0&&this.usname==null){
            return "redirect:/account/selectCK";
        }
        return "forward:/account/selectCK";
    }
    @RequestMapping("/delCK")
    public String delCK(int id){
        accountService.CKdel(id);
        return "forward:/account/selectCK";
    }
}
