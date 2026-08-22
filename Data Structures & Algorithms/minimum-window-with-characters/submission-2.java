// Jai Ganesh
 
 class Solution {
     public String minWindow(String s, String t) {
         int start =0,end=0;

         int sl=s.length();
         int tl=t.length();
         
         HashMap<Character, Integer> sm = new HashMap<>();
         HashMap<Character, Integer> tm = new HashMap<>();
         
         int have = 0, need = 0;
         
         for(int ind = 0; ind < tl; ind++) {
             char ch = t.charAt(ind);
             tm.put(ch, tm.getOrDefault(ch, 0)+1);
             sm.put(ch, 0);
         }
 
         int minimumWindow = Integer.MAX_VALUE;
 
         int minimumWindowStart = -1;
         int minimumWindowEnd = -1;
 
         need = tm.size();
         
         while(end < sl) {
            char ch = s.charAt(end);
            sm.put(ch, sm.getOrDefault(ch,0)+1);
            
            if(tm.containsKey(ch)) {
                if(sm.get(ch).intValue() == tm.get(ch).intValue()) {
                    have++;
                }
            }
 
            while(have == need) {
                if((end - start + 1) < minimumWindow) {
                    minimumWindow = (end - start + 1);
                    minimumWindowStart = start;
                    minimumWindowEnd = end;
                }

                if(start < sl) {
                    char startingCh = s.charAt(start);

                    sm.put(startingCh, sm.get(startingCh) - 1);
                    
                    if(sm.get(startingCh).intValue() < tm.getOrDefault(startingCh, 0).intValue()) {
                        have--;
                    }
                }
                start++;
            }

            end++;
         }
 
         return (minimumWindowStart != -1 && minimumWindowEnd != -1) ? s.substring(minimumWindowStart, minimumWindowEnd + 1) : "";
     }
 }