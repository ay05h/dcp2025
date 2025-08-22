package Day8;

public class ReverseWord {
    public static String revString(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (word.length() > 0) {
                    if (ans.length() > 0)
                        ans.insert(0, " ");
                    ans.insert(0, word);
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            if (ans.length() > 0)
                ans.insert(0, " ");
            ans.insert(0, word);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        // Some test cases
        String[] testCases = { "the sky is blue", "  hello world  ", "a good   example", "    ", "word" };

        for (String test : testCases) {
            String rev = revString(test);
            System.out.println(test + " -> " + rev);
        }
    }

}
