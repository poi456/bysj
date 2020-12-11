package cn.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CkUser {
    private Integer id;
    private String uname;
    private Integer shuliang;
    private int danjia;
}
