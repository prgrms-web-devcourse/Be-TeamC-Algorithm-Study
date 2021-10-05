class Solution {
    public int solution(String name) {
        int upDownCount = 0;
        int leftRightCount = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            upDownCount += Math.min(name.charAt(i) - 'A', 'Z' + 1 - name.charAt(i));

            int position = i + 1;
            while ((name.length() > position) && (name.charAt(position) == 'A')) {
                position++;
            }
            leftRightCount = Math.min(name.length() - position + (i * 2), leftRightCount);
        }

        return upDownCount + leftRightCount;
    }
}
