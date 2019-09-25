package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        System.out.println("isPalindrome = " + new Solution().isPalindrome(0));
        System.out.println("romanToInt = " + new Solution().romanToInt("IV"));
        System.out.println("longestCommonPrefix = "
                + new Solution().longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println("longestCommonPrefix = " + new Solution().longestCommonPrefix(new String[] {}));
        System.out.println("longestCommonPrefix = " + new Solution().longestCommonPrefix(new String[] { "aa", "a" }));
        System.out.println("longestCommonPrefix = " + new Solution().longestCommonPrefix(new String[] { "a", "aa" }));
        System.out.println("isValid = " + new Solution().isValid(""));
        System.out.println("isValid = " + new Solution().isValid("("));
        System.out.println("isValid = " + new Solution().isValid("()"));
        System.out.println("isValid = " + new Solution().isValid("()[]{}"));
        System.out.println("isValid = " + new Solution().isValid("(]"));
        System.out.println("isValid = " + new Solution().isValid("([)]"));
        System.out.println("isValid = " + new Solution().isValid("{[]}"));
        System.out.println("isValid = " + new Solution().isValid(")("));
        System.out.println("isValid = " + new Solution().isValid(")}{({))[{{[}"));
        System.out.println("isValid = " + new Solution().isValid("[({(())}[()])]"));

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode answer = new Solution().mergeTwoLists(l1, l2);
        ListNode temp = answer;
        do {
            System.out.println("mergeTwoLists = " + temp.val);
            temp = temp.next;
        } while (temp != null);

        ListNode lDup = new ListNode(1);
        lDup.next = new ListNode(1);
        lDup.next.next = new ListNode(2);
        lDup.next.next.next = new ListNode(3);
        lDup.next.next.next.next = new ListNode(3);
        answer = new Solution().deleteDuplicates(lDup);
        temp = answer;
        do {
            System.out.println("deleteDuplicates = " + temp.val);
            temp = temp.next;
        } while (temp != null);

        int[] test = new int[] { 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8 };
        int len = new Solution().removeDuplicates(test);
        System.out.println("removeDuplicates = " + len);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(test[i] + " ");
        }
        System.out.println(sb.toString());

        int[] test2 = new int[] { 3, 2, 2, 3, 3, 4, 5 };
        len = new Solution().removeElement(test2, 3);
        System.out.println("removeElement = " + len);
        sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(test2[i] + " ");
        }
        System.out.println(sb.toString());

        System.out.println("strStr = " + new Solution().strStr("hello", "ll"));
        System.out.println("strStr = " + new Solution().strStr("aaaaa", "bba"));
        System.out.println("strStr = " + new Solution().strStr("aaaaabbaxxxbba", "bba"));
        System.out.println("searchInsert = " + new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        System.out.println("searchInsert = " + new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println("searchInsert = " + new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        System.out.println("searchInsert = " + new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 0));

        for (int i = 1; i <= 6; i++) {
            System.out.println("countAndSay = " + new Solution().countAndSay(i));
        }

        System.out.println("maxSubArray = " + new Solution().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println("maxSubArray = " + new Solution().maxSubArray(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
        System.out.println("lengthOfLastWord = " + new Solution().lengthOfLastWord("Hello World"));
        System.out.println("lengthOfLastWord = " + new Solution().lengthOfLastWord("Hello World 123"));
        System.out.println("lengthOfLastWord = " + new Solution().lengthOfLastWord("HelloWorld123"));
        System.out.println("lengthOfLastWord = " + new Solution().lengthOfLastWord("a"));
        System.out.println("lengthOfLastWord = " + new Solution().lengthOfLastWord("a "));

        int[] plusOne = new Solution().plusOne(new int[] { 1, 2, 3 });
        sb = new StringBuilder();
        for (int i = 0; i < plusOne.length; i++) {
            sb.append(plusOne[i] + " ");
        }
        System.out.println("plusOne = " + sb.toString());
        plusOne = new Solution().plusOne(new int[] { 4, 3, 2, 1 });
        sb = new StringBuilder();
        for (int i = 0; i < plusOne.length; i++) {
            sb.append(plusOne[i] + " ");
        }
        System.out.println("plusOne = " + sb.toString());
        plusOne = new Solution().plusOne(new int[] { 7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5,
                7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6 });
        sb = new StringBuilder();
        for (int i = 0; i < plusOne.length; i++) {
            sb.append(plusOne[i] + " ");
        }
        System.out.println("plusOne = " + sb.toString());

        System.out.println("addBinary = " + new Solution().addBinary("11", "1"));
        System.out.println("addBinary = " + new Solution().addBinary("1010", "1011"));
        System.out.println("mySqrt = " + new Solution().mySqrt(4));
        System.out.println("mySqrt = " + new Solution().mySqrt(8));
        System.out.println("mySqrt = " + new Solution().mySqrt(11));
        System.out.println("mySqrt = " + new Solution().mySqrt(2147483647));

        test = new int[] { 1, 2, 3, 0, 0, 0 };
        test2 = new int[] { 2, 5, 6 };
        new Solution().merge(test, 3, test2, 3);
        sb = new StringBuilder();
        for (int i = 0; i < test.length; i++) {
            sb.append(test[i] + " ");
        }
        System.out.println("merge = " + sb.toString());
    }
}