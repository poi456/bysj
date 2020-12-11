package cn.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HwUser {
    private int gysid;
    private String uname;
    private String zhuangtai;
    private int huowushuliang;
    private int huowujiage;
}
