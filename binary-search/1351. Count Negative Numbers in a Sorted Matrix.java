class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        
        for(int [] row : grid) {
            if(row[0] < 0) {
                answer += row.length;
            }
            else if(row[row.length - 1] >= 0) {
                answer += 0;
            }
            else {
                answer += getCount(row);
            }
        }
        
        return answer;
    }
    
    public int getCount(int[] row) {
        int count = 0;
        int low = 0, high = row.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(row[mid] < 0) {
                high = mid;
            } 
            else {
                low = mid + 1;
            }
        }
        return row.length - low;
        
    }
}
