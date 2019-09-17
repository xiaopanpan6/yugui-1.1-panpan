import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 数据库密码加密
 *
 * @Author: XiaoPanPan
 * @Date: 2019/8/6 10:27
 */
public class TestDruidEncryptPassword {

    public static void main(String[] args) throws Exception {
        String password = ConfigTools.encrypt("123456");
        System.out.println("password = " + password);


        String requireSettingPressure = "1Mpa";
        Double requireSettingPressureNum = Double.valueOf(requireSettingPressure.substring(0, requireSettingPressure.length() - 3));

        String thirdSettingPressure = "1.029999999999999999999999Mpa";
        Double thirdSettingPressureNum = Double.valueOf(thirdSettingPressure.substring(0, thirdSettingPressure.length() - 3));

        Double different = requireSettingPressureNum - thirdSettingPressureNum;
        System.out.println(different);

        if (requireSettingPressureNum <= 0.5) {
            if (different >= -0.015 && different <= 0.015) {
                System.out.println("合格");
            } else {
                System.out.println("不合格");
            }
        } else {
            if (different / requireSettingPressureNum >= -0.03 && different / requireSettingPressureNum <= 0.03) {
                System.out.println("合格");
            } else {
                System.out.println("不合格");
            }
        }
    }

}