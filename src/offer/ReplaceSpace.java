package offer;

public class ReplaceSpace {
    //length为字符数组string的总容量
    public static void replaceBlank(char string[], int length) {
        if (string == null || length == 0)
            return;
        int originLength = 0;
        int numberOfBlank= 0;
        int i = 0;
        while (string[i] != '\0') {
            ++originLength;
            if (string[i] == ' ')
                ++numberOfBlank;
            ++i;
        }

        int newLength = originLength + numberOfBlank * 2;
        if (newLength > length)
            return;

        int indexOfOriginal = originLength;
        int indexOfNew = newLength;

        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (string[indexOfOriginal] ==' '){
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            }
            else {
                string[indexOfNew--] = string[indexOfOriginal];
            }
            --indexOfOriginal;
        }
    }

}
