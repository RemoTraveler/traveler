import java.util.Random;

/** 随机密码生成器 **/
public class RandomPwd {

    /** 密码字符组成原材料 **/
    private static final String CHARREPOSITORY = "01V8Gyz!@5TU%^E9ABCefsW2OPtuvwx#$QFhio67XHIJSpjklmRDbcdnqr4KLYZa&3gMN/+=";
    /** 生成密码长度 **/
    private static final int length = 20;

    public static void main(String[] args) {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = CHARREPOSITORY.charAt(random.nextInt(CHARREPOSITORY.length()));
        }
        System.out.println(new String(text));
    }
}