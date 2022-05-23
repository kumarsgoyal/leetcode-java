class Solution {
    class Key{
        int index, freq;
        Key(int i, int fr) {
            index = i;
            freq = fr;
        }
    }
    
    class KeyCompare implements Comparator<Key> {
        public int compare(Key k1, Key k2) {
            if(k1.freq > k2.freq) {
                return 1;
            }
            else if(k1.freq < k2.freq) {
                return -1;
            }
            else {
                if(k1.index < k2.index)
                    return -1;
                else 
                    return 1;
            }
        }
    }
    
    private int getSoliders(int[] mat) {
        int l = 0, h = mat.length - 1;
        
        while(l <= h) {
            int m = l + (h - l) / 2;
            if(mat[m] == 1) {
                l = m + 1;
            }
            else {
                h = m - 1;
            }
        }
        return l;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Key> que = new PriorityQueue<>(new KeyCompare());
        int i = 0;
        for(int[] row : mat) {
            que.add(new Key(i, getSoliders(row)));
            i++;
        }
        
        int[] res = new int[k];
        int index = 0;
        
        while( (k > 0) == true) {
            k--;
            res[index++] = que.remove().index;
        }
        
        return res;
    
    }
}
