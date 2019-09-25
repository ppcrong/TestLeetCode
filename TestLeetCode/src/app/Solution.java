package app;

import java.util.Arrays;

public class Solution {

    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            switch (chars[i]) {
            case 'I':
                if (i < chars.length - 1 && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    sum -= 1;
                } else {
                    sum += 1;
                }
                break;
            case 'V':
                sum += 5;
                break;
            case 'X':
                if (i < chars.length - 1 && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    sum -= 10;
                } else {
                    sum += 10;
                }
                break;
            case 'L':
                sum += 50;
                break;
            case 'C':
                if (i < chars.length - 1 && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    sum -= 100;
                } else {
                    sum += 100;
                }
                break;
            case 'D':
                sum += 500;
                break;
            case 'M':
                sum += 1000;
                break;
            }
        }
        return sum;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        int temp = x;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return rev == x;
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty())
                return "";
        }

        char[][] charsArray = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            charsArray[i] = strs[i].toCharArray();
        }
        int cpLen = 0;
        boolean stopCompare = false;
        for (int i = 0; i < charsArray[0].length; i++) {
            for (int j = 1; j < strs.length; j++) {

                if (i < charsArray[j].length && charsArray[0][i] == charsArray[j][i]) {
                    if (j == strs.length - 1) {
                        cpLen = i + 1;
                    }
                    continue;
                } else {
                    stopCompare = true;
                    break;
                }
            }

            if (stopCompare || i == charsArray[0].length - 1) {
                if (cpLen == 0) {
                    return "";
                } else {
                    return strs[0].substring(0, cpLen);
                }
            }
        }
        return "";
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        boolean pairedBracketExist = false;
        do {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            pairedBracketExist = s.contains("()") || s.contains("[]") || s.contains("{}");
        } while (pairedBracketExist);

        return s.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if (l1 != null)
            pre.next = l1;
        if (l2 != null)
            pre.next = l2;

        return dummy.next;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                len++;
                nums[len] = nums[i];
            }
        }
        return len + 1;
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }

        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                if (i == nums.length - 1) {
                    index = i + 1;
                    break;
                } else {
                    continue;
                }
            } else if (target == nums[i]) {
                index = i;
                break;
            } else {
                index = i;
                break;
            }
        }
        return index;
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String say = "1";
        for (int i = 0; i < n - 1; i++) {
            say = countAndSay(say);
        }
        return say;
    }

    String countAndSay(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char base = chars[i];
            int num = 1;
            while (i < chars.length - 1 && base == chars[i + 1]) {
                num++;
                i++;
            }
            sb.append(String.valueOf(num) + base);
        }

        return sb.toString();
    }

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
        // int maxSum = nums[0];
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // maxSum = Math.max(sum, maxSum);
        // if (sum > maxSum) {
        // maxSum = sum;
        // }
        // }
        // }
        // return maxSum;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(" ");
        if (index == -1) {
            return s.length();
        }
        return s.length() - index - 1;
    }

    public int[] plusOne(int[] digits) {

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9) {
                if (i == digits.length - 1) {
                    int[] newDigits = new int[digits.length + 1];
                    Arrays.fill(newDigits, 0);
                    newDigits[0] = 1;
                    return newDigits;
                }
                continue;
            } else
                break;
        }

        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                digits[i - 1] += digits[i] / 10;
            }
            digits[i] %= 10;
        }

        return digits;

        // long value = 0;
        // for (int i = digits.length - 1; i >= 0; i--) {
        // value += digits[i] * (long) Math.pow(10, digits.length - i - 1);
        // }
        // String digitsString = String.valueOf(value + 1);
        // char[] chars = digitsString.toCharArray();
        // int[] newDigits = new int[chars.length];
        // for (int i = 0; i < chars.length; i++) {
        // newDigits[i] = Integer.parseInt(Character.toString(chars[i]));
        // }
        // return newDigits;
    }

    public String addBinary(String a, String b) {
        int lenA = a.length() - 1, lenB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while (lenA >= 0 || lenB >= 0) {
            if (lenA >= 0) {
                temp += a.charAt(lenA--) - '0';
            }
            if (lenB >= 0) {
                temp += b.charAt(lenB--) - '0';
            }
            sb.append(temp % 2);
            temp /= 2;
        }
        if (temp == 1)
            sb.append("1");
        return sb.reverse().toString();
    }

    public int mySqrt(int x) {
        int start = 0, end = x;
        while (start < end) {
            int mid = (end + start) / 2 + 1;
            if (mid > x / mid) {
                end = mid - 1;
            } else if (mid < x / mid) {
                start = mid;
            } else
                return mid;
        }
        return start;
        // int lastRoot = 0;
        // int root = 0;
        // int square = 0;
        // do {
        // lastRoot = root;
        // root++;
        // square = (int) Math.pow(root, 2);

        // if (square > x) {
        // root = lastRoot;
        // break;
        // } else if (square == x) {
        // break;
        // } else continue;

        // } while (true);
        // return (root > 46340) ? 46340 : root;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // System.arraycopy(nums2, 0, nums1, m, n);
        // Arrays.sort(nums1);
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2])
                nums1[p--] = nums2[p2--];
            else
                nums1[p--] = nums1[p1--];

        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}