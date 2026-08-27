class Solution {

    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        String ans = buildSmallestGreater(cnt, target, 0);
        return ans == null ? "" : ans;
    }

    private String buildSmallestGreater(int[] cnt, String target, int pos) {
        if (pos == target.length()) {
            return null;
        }

        int targetCh = target.charAt(pos) - 'a';
        for (int ch = targetCh; ch < 26; ch++) {
            if (cnt[ch] == 0) {
                continue;
            }

            cnt[ch]--;

            if (ch > targetCh) {
                return (char) ('a' + ch) + getSmallestSuffix(cnt);
            }

            String suffix = buildSmallestGreater(cnt, target, pos + 1);
            if (suffix != null) {
                return (char) ('a' + ch) + suffix;
            }

            cnt[ch]++;
        }

        return null;
    }

    private String getSmallestSuffix(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int ch = 0; ch < 26; ch++) {
            while (cnt[ch] > 0) {
                sb.append((char) ('a' + ch));
                cnt[ch]--;
            }
        }
        return sb.toString();
    }
}