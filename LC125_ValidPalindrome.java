public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() <= 1 || s.isBlank()) return true;

        int l = 0;
        int r = s.length() - 1;

        while (l < r){
            while (l < r && (s.charAt(l) < '0') || s.charAt(l) > 'z' || (s.charAt(l) > '9' && s.charAt(l) < 'a')){
                l++;
            }
            while (l < r && (s.charAt(r) < '0') || s.charAt(r) > 'z' || (s.charAt(r) > '9' && s.charAt(r) < 'a')){
                r--;
            }
            if (l > r) continue;

            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;


    }

    public static void main(String[] args){
        LC125_ValidPalindrome obj = new LC125_ValidPalindrome();

        System.out.print(obj.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
