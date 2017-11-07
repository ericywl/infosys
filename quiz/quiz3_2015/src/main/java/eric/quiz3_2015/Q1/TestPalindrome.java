package eric.quiz3_2015.Q1;


public class TestPalindrome {
    public static void main(String[] args) {
        String[] wordlist = {"civic", "Singapore", "deified", "Technology", "Design"};

        for (int i = 0; i < wordlist.length; i++) {
            System.out.println("RecurPalinCheck: " + Palindrome.recurPalindrome(wordlist[i]));
        }
    }
}

