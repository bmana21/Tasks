import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tasks {

    // Task 1
    public int evaluateExpression(String expression) {
        int currentNumber = 0, finalResult = 0;
        int operation = 1;
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + Character.getNumericValue(c);
                continue;
            }
            finalResult += operation * currentNumber;
            currentNumber = 0;
            operation = (c == '-') ? -1 : 1;
        }
        finalResult += operation * currentNumber;
        return finalResult;
    }
    
    // Task 2
    public int numberOfHappyStrings(List<String> strings) {
        int count = 0;
        for (String string : strings)
            if (string.indexOf("aa") + string.indexOf("bb") + string.indexOf("cc") == -3)
                count++;
        return count;
    }
    
    // Task 3
    public static class ListNode {
        public ListNode next;
        public int value;
    }

    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null, currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = reversedHead;
            reversedHead = currentNode;
            currentNode = nextNode;
        }

        return reversedHead;
    }
    
    // Task 4
    public int[] findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for (int num : nums1)
            numbers.add(num);
        for (int num : nums2)
            if (numbers.contains(num)) {
                answer.add(num);
                numbers.remove(num);
            }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // Task 5
    public int lenOfLongSubarr(int[] array, int k) {
        int[][] dp = new int[k + 1][array.length];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j > 0)
                    dp[i][j] = dp[i][j - 1];
                if (i == array[j])
                    dp[i][j] = Math.max(1, dp[i][j]);
                if (j > 0 && i - array[j] > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i - array[j]][j - 1] + 1);

            }
        }
        return dp[k][array.length - 1];
    }
    
    // Task 6
    public boolean isValidSequence(int[] array, int[] sequence) {
        if (sequence.length == 0)
            return true;
        int index = 0;
        for (int num : array) {
            if (num == sequence[index])
                index++;
            if (index == sequence.length)
                return true;
        }
        return false;
    }
}
