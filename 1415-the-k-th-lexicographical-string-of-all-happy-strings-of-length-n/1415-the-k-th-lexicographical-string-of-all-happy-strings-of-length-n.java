class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        sequence(n, sb, list);
        if(list.size() < k){
            return "";
        }
        return list.get(k - 1);
    }

    private void sequence(int n, StringBuilder sb, ArrayList<String> list){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) continue;
            sb.append(ch);
            sequence(n, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}