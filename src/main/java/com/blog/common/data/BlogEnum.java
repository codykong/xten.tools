package com.blog.common.data;


/**
 * 博客常量
 * @author kongqingyu
 * @date 2013-3-20 下午10:22:44
 */
public class BlogEnum {

    /**
     * 博客类型常量
     * @author kongqingyu
     * @date 2013-3-20 下午10:30:05
     */
    public static enum Type{
        TECH("技术分享", 1), PM("产品", 2),VISION("视觉、交互", 3),COE("COE", 4),PRACTICE("最佳实践", 5);

        private String name;
        private int value;

        private Type(String name, int value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public static Type fromName(String name) {
            if (name == null || name.length() == 0)
                return null;
            for (Type type : Type.values()) {
                if (type.name.equals(name))
                    return type;
            }
            return null;
        }

        public static Type fromValue(int value) {
            for (Type type : Type.values()) {
                if (type.value == value)
                    return type;
            }
            return null;
        }
    }

    public static enum Status{
        DELEDED("删除", -1), DRAFT("草稿", -2),VALID("有效", 0);

        private String name;
        private int value;

        private Status(String name, int value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        public static Status fromName(String name) {
            if (name == null || name.length() == 0)
                return null;
            for (Status status : Status.values()) {
                if (status.name.equals(name))
                    return status;
            }
            return null;
        }

        public static Status fromValue(int value) {
            for (Status status : Status.values()) {
                if (status.value == value)
                    return status;
            }
            return null;
        }
    }
	
}
