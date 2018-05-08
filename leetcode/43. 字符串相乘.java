class Solution {
    public String multiply(String num1, String num2) {
                StringBuilder result = new StringBuilder();
        int temp = 0;
        int c1, c2;
        int[] number = new int[num1.length()+num2.length()];
        for(int i = 0;i < num1.length(); i++){
            c1 = ((int)num1.charAt(num1.length() - 1 - i)) - 48;
            for(int j = 0; j < num2.length(); j++){
                c2 = ((int)num2.charAt(num2.length() - 1 - j)) - 48;
                temp = c1 * c2;
                number[i+j] += temp % 10;
                number[i+j+1] += temp / 10 + number[i+j] / 10; //进位操作
                number[i+j] %= 10; //保证不大于10

            }
        }
        for(int i = number.length - 1; i >= 0; i--){
            result.append(number[i]);
        }
        for(int i = 0; i < result.length(); i++){
            if(result.charAt(i) != '0'){
                return result.substring(i);
            }
        }
        return "0";
    }
}