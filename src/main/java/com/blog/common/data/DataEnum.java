package com.blog.common.data;


/**
 * 常用常量
 * @author kongqingyu
 * @date 2013-3-20 下午10:22:44
 */
public class DataEnum {

	/**
     * 登录状态
     * @author kongqingyu
     * @date 2013-3-20 下午10:30:05
     */
    public static enum LoginResEnum{
        ERROR("系统错误",0), NOUSER("用户不存在", 1), PWDWRONG("密码错误", 2),USER("登陆成功", 3);

        private String name;
        private int value;

        private LoginResEnum(String name, int value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public static LoginResEnum fromName(String name) {
            if (name == null || name.length() == 0)
                return null;
            for (LoginResEnum mt : LoginResEnum.values()) {
                if (mt.name.equals(name))
                    return mt;
            }
            return null;
        }

        public static LoginResEnum fromValue(int value) {
            for (LoginResEnum mt : LoginResEnum.values()) {
                if (mt.value == value)
                    return mt;
            }
            return null;
        }
    }


	
}
